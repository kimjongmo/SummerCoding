package com.todo.api.controller;

import com.todo.common.dto.TodoDTO;
import com.todo.common.entity.Todo;
import com.todo.common.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }


    @RequestMapping(method = RequestMethod.PUT)
    public void put(TodoDTO todoDTO){
        log.info("todoDto = {}",todoDTO);
        todoService.put(todoDTO);
    }

    @RequestMapping(method= RequestMethod.GET)
    public Todo get(@RequestParam Long id){
        log.info("id = {}",id);
        return todoService.get(id);
    }

}
