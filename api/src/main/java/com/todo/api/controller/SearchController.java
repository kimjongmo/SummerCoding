package com.todo.api.controller;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.search.SearchRequestDTO;
import com.todo.common.dto.internal.search.SearchResponseDTO;
import com.todo.common.entity.Todo;
import com.todo.common.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public CommonHeader<SearchResponseDTO> search(@Valid SearchRequestDTO dto){
        log.info("[SearchController] searchDTO = {}",dto);
        return searchService.search(dto==null?new SearchRequestDTO():dto);
    }

    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public CommonHeader search(){
        return searchService.notice();
    }
}
