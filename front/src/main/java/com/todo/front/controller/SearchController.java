package com.todo.front.controller;

import com.todo.common.dto.CommonHeader;
import com.todo.front.service.FrontSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/search")
public class SearchController {

    private FrontSearchService frontSearchService;

    public SearchController(FrontSearchService frontSearchService){
        this.frontSearchService = frontSearchService;
    }

    @RequestMapping(value = "/notice",method = RequestMethod.GET)
    public CommonHeader notified(){
        return frontSearchService.searchNotified();
    }
}
