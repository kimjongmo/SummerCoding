package com.todo.front.service;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.finish.TodoFinishRequestDTO;
import com.todo.common.dto.internal.get.TodoGetRequestDTO;
import com.todo.common.dto.internal.get.TodoGetResponseDTO;
import com.todo.common.dto.internal.input.TodoInputRequestDTO;
import com.todo.common.dto.internal.update.TodoUpdateRequestDTO;
import com.todo.common.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
@Service
public class FrontTodoService {

    @Value("${api.server.ip}")
    private String apiServerIp;
    private RestTemplateService restTemplateService;

    public FrontTodoService(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    public CommonHeader addTodo(TodoInputRequestDTO todoDTO) {
        URI uri = UriComponentsBuilder
                .fromHttpUrl(apiServerIp)
                .path("/todo")
                .build()
                .toUri();
        ParameterizedTypeReference<CommonHeader> type = new ParameterizedTypeReference<CommonHeader>() {
        };
        try {
            return restTemplateService.exchange(uri, HttpMethod.POST, todoDTO, type);
        } catch (Exception e) {
            log.error("[FrontTodoService] error : {}", e);
            return new CommonHeader().setMessage("오류가 발생했습니다.");
        }
    }

    public CommonHeader finishTodo(TodoFinishRequestDTO dto) {
        URI uri = UriComponentsBuilder.fromHttpUrl(apiServerIp)
                .path("/todo/finish")
                .build()
                .toUri();

        ParameterizedTypeReference<CommonHeader> type =
                new ParameterizedTypeReference<CommonHeader>() {};

        return restTemplateService.exchange(uri,HttpMethod.POST,dto.getId(),type);
    }

    public CommonHeader<TodoGetResponseDTO> get(Long id){
        URI uri = UriComponentsBuilder.fromHttpUrl(apiServerIp)
                .path("/todo/"+id)
                .build()
                .toUri();

        ParameterizedTypeReference<CommonHeader<TodoGetResponseDTO>> type
                = new ParameterizedTypeReference<CommonHeader<TodoGetResponseDTO>>() {};

        return restTemplateService.exchange(uri,HttpMethod.GET,null,type);
    }

    public CommonHeader update(TodoUpdateRequestDTO todoUpdateRequestDTO){
        URI uri = UriComponentsBuilder.fromHttpUrl(apiServerIp)
                .path("/todo")
                .build()
                .toUri();

        ParameterizedTypeReference<CommonHeader> type
                = new ParameterizedTypeReference<CommonHeader>() {};

        return restTemplateService.exchange(uri,HttpMethod.PUT,todoUpdateRequestDTO,type);
    }

    public CommonHeader delete(Long id){
        URI uri = UriComponentsBuilder.fromHttpUrl(apiServerIp)
                .path("/todo/"+id)
                .build()
                .toUri();

        ParameterizedTypeReference<CommonHeader> type
                = new ParameterizedTypeReference<CommonHeader>() {};

        return restTemplateService.exchange(uri,HttpMethod.DELETE,null,type);
    }
}
