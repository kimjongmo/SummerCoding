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
import org.springframework.web.client.RestClientException;
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
    public CommonHeader searchNotified(){
        URI uri = UriComponentsBuilder.fromHttpUrl(apiServerIp)
                .path("search/notice")
                .build()
                .toUri();
        ParameterizedTypeReference<CommonHeader> type
                = new ParameterizedTypeReference<CommonHeader>() {};
        try {
            return restTemplateService.exchange(uri, HttpMethod.GET, null, type);
        }catch (RestClientException restClientException) {
            log.error("[FrontSearchService] searchNotified() : RestClientException : {}",restClientException);
            return new CommonHeader().setMessage("오류가 발생했습니다.");
        } catch (Exception e) {
            log.error("[FrontSearchService] searchNotified() : Exception : {}", e);
            return new CommonHeader().setMessage("오류가 발생했습니다.");
        }
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
        try {
            return restTemplateService.exchange(uri, HttpMethod.GET, null, type);
        }catch (RestClientException restClientException) {
            log.error("[FrontSearchService] search({}) : RestClientException : {}", dto, restClientException);
            return new CommonHeader().setMessage("오류가 발생했습니다.");
        } catch (Exception e) {
            log.error("[FrontSearchService] search({}) : Exception : {}", dto, e);
            return new CommonHeader().setMessage("오류가 발생했습니다.");
        }
    }

}
