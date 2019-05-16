package com.todo.common.service;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.search.SearchRequestDTO;
import com.todo.common.dto.internal.search.SearchResponseDTO;
import com.todo.common.entity.Todo;
import com.todo.common.repo.TodoRepository;
import com.todo.common.status.TodoStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SearchService {

    private TodoRepository todoRepository;

    public SearchService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public CommonHeader<SearchResponseDTO> search(SearchRequestDTO dto) {
        LocalDateTime afterDate = null;
        LocalDateTime beforeDate = null;
        TodoStatus status = null;

        if (!Strings.isEmpty(dto.getAfterDate()))
            afterDate = LocalDateTime.parse(dto.getAfterDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        if (!Strings.isEmpty(dto.getBeforeDate()))
            beforeDate = LocalDateTime.parse(dto.getBeforeDate(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        if (!Strings.isEmpty(dto.getStatus())) {
            TodoStatus[] todoStatuses = TodoStatus.values();
            for (TodoStatus s : todoStatuses) {
                if (s.getMessage().equals(dto.getStatus())) {
                    status = s;
                    break;
                }
            }
        }
        List<Todo> data = todoRepository.findDynamicQuery(dto.getTitle(), dto.getContent(), afterDate, beforeDate, status);

        List<SearchResponseDTO.SearchResponse> mappingData = data.stream()
                .map(todo -> {
                    SearchResponseDTO.SearchResponse res = new SearchResponseDTO.SearchResponse()
                            .setId(todo.getId())
                            .setContent(todo.getContent())
                            .setTitle(todo.getTitle())
                            .setStatus(todo.getStatus().getMessage());
                    if(todo.getDeadline()!=null){
                        res.setDeadline(todo.getDeadline().format(DateTimeFormatter.ofPattern("yy년 MM월 dd일 HH시 mm분")));
                    }else{
                        res.setDeadline("마감 기한 없음");
                    }
                    return res;
                }).collect(Collectors.toList());

        SearchResponseDTO result = new SearchResponseDTO();
        result.setTodos(mappingData);

        return new CommonHeader<SearchResponseDTO>().setMessage("검색 완료").setData(result);
    }


}
