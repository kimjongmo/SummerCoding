package com.todo.front.controller;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.TodoDTO;
import com.todo.front.service.FrontTodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class FrontTodoController {

    private FrontTodoService todoService;

    public FrontTodoController(FrontTodoService frontTodoService){
        this.todoService = frontTodoService;
    }

    @RequestMapping(value = "/addTodo",method = RequestMethod.POST)
    public String addTodo(@RequestBody @Valid TodoDTO todoDTO){
        log.info("[FrontTodoController] todoDTO : {}",todoDTO);
        return todoService.addTodo(todoDTO).getMessage();
    }

}
