package com.todo.front.service;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.search.SearchRequestDTO;
import com.todo.common.dto.internal.search.SearchResponseDTO;
import com.todo.common.service.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
@Slf4j
public class FrontSearchService {

    @Value("${api.server.ip}")
    private String apiServerIp;

    private RestTemplateService restTemplateService;

    public FrontSearchService(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    public CommonHeader<SearchResponseDTO> search(SearchRequestDTO dto) {
        log.info("[FrontSearchService] dto = {}",dto);

        URI uri = UriComponentsBuilder.fromHttpUrl(apiServerIp)
                .path("search")
                .queryParam("title", dto.getTitle())
                .queryParam("content", dto.getContent())
                .queryParam("afterDate", dto.getAfterDate())
                .queryParam("beforeDate", dto.getBeforeDate())
                .queryParam("status", dto.getStatus())
                .build()
                .toUri();

        ParameterizedTypeReference<CommonHeader<SearchResponseDTO>> type
                = new ParameterizedTypeReference<CommonHeader<SearchResponseDTO>>() {
        };

        return restTemplateService.exchange(uri, HttpMethod.GET,null,type);
    }

}
