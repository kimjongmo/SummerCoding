package com.todo.api.controller;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.TodoDTO;
import com.todo.common.dto.UpdateTodoDTO;
import com.todo.common.dto.internal.TodoResponseDTO;
import com.todo.common.entity.Todo;
import com.todo.common.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Slf4j
@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }


    @RequestMapping(method = RequestMethod.POST)
    public CommonHeader put(@RequestBody @Valid TodoDTO todoDTO){
        log.info("[TodoController] todoDto = {}",todoDTO);
        return todoService.save(todoDTO);
    }

    @RequestMapping(method= RequestMethod.PUT)
    public void update(@RequestBody @Valid UpdateTodoDTO todoDTO){
        log.info("[TodoController] updatedTodoDTO = {}",todoDTO);
        todoService.update(todoDTO);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public Todo get(@NotNull @PathVariable Long id){
        log.info("[TodoController] GET id = {}",id);
        return todoService.get(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public void delete(@NotNull @PathVariable Long id){
        log.info("[TodoController] DELETE id = {}",id);
        todoService.delete(id);
    }

}
