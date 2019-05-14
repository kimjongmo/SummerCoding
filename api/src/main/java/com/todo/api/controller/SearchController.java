package com.todo.api.controller;

import com.todo.common.dto.SearchDTO;
import com.todo.common.entity.Todo;
import com.todo.common.repo.TodoRepository;
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
    public List<Todo> search(@Valid SearchDTO searchDTO){
        log.debug("[SearchController] searchDTO = {}",searchDTO);
        return searchService.search(searchDTO);
    }
}
