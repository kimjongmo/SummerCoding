package com.todo.front.controller;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.finish.TodoFinishRequestDTO;
import com.todo.common.dto.internal.get.TodoGetRequestDTO;
import com.todo.common.dto.internal.get.TodoGetResponseDTO;
import com.todo.common.dto.internal.input.TodoInputRequestDTO;
import com.todo.common.dto.internal.update.TodoUpdateRequestDTO;
import com.todo.front.service.FrontTodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@RequestMapping("/todo")
public class FrontTodoController {

    private FrontTodoService todoService;

    public FrontTodoController(FrontTodoService frontTodoService){
        this.todoService = frontTodoService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addTodo(@RequestBody @Valid TodoInputRequestDTO todoDTO){
        log.info("[FrontTodoController] todoDTO : {}",todoDTO);
        String result = todoService.addTodo(todoDTO).getMessage();
        log.info("result={}",result);
        return result;
    }

    @RequestMapping(value ="/finish",method = RequestMethod.POST)
    public String finishTodo(@RequestBody @Valid TodoFinishRequestDTO dto){
        log.info("[FrontTodoController] finishTodo id = {}",dto.getId());
        return todoService.finishTodo(dto).getMessage();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public CommonHeader<TodoGetResponseDTO> get(@PathVariable Long id){
        log.info("[FrontTodoController] get id = {}",id);
        return todoService.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String updateTodo(@RequestBody @Valid TodoUpdateRequestDTO dto){
        log.info("[FrontTodoController] updateTodo dto = {}",dto);
        CommonHeader header = todoService.update(dto);
        log.info("result = {}",header.getMessage());
        return header.getMessage();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteTodo(@PathVariable Long id){
        log.info("[FrontTodoController] deleteTodo id = {}",id);
        CommonHeader header = todoService.delete(id);
        log.info("result = {}",header.getMessage());
        return header.getMessage();
    }
}
