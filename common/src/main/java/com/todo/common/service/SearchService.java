package com.todo.common.service;

import com.todo.common.dto.SearchDTO;
import com.todo.common.entity.Todo;
import com.todo.common.repo.TodoRepository;
import com.todo.common.status.TodoStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Slf4j
public class SearchService {

    private TodoRepository todoRepository;

    public SearchService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> search(SearchDTO dto) {
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

        return todoRepository.findDynamicQuery(dto.getTitle(), dto.getContent(), afterDate, beforeDate, status);
    }

}
