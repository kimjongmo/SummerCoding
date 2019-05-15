package com.todo.front.service;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.TodoDTO;
import com.todo.common.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class FrontTodoService {

    private RestTemplateService restTemplateService;

    public FrontTodoService(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    public CommonHeader addTodo(TodoDTO todoDTO) {
        URI uri = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host("localhost")
                .port(9090)
                .path("/todo")
                .build()
                .toUri();
        ParameterizedTypeReference<CommonHeader> type = new ParameterizedTypeReference<CommonHeader>() {};
        try {
            return restTemplateService.exchange(uri, HttpMethod.POST, todoDTO, type);
        } catch (Exception e) {
            log.error("[FrontTodoService] error : {}", e);
            return new CommonHeader().setMessage("오류가 발생했습니다.");
        }
    }
}
