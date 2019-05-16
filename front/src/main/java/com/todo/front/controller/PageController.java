package com.todo.front.controller;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.search.SearchRequestDTO;
import com.todo.common.dto.internal.search.SearchResponseDTO;
import com.todo.front.service.FrontSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class PageController {

    private FrontSearchService frontSearchService;

    public PageController(FrontSearchService frontSearchService) {
        this.frontSearchService = frontSearchService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        CommonHeader<SearchResponseDTO> result = frontSearchService.search(new SearchRequestDTO());
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todos",result.getData());
        return modelAndView;
    }

}
