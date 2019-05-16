package com.todo.api.controller;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.finish.TodoFinishRequestDTO;
import com.todo.common.dto.internal.get.TodoGetResponseDTO;
import com.todo.common.dto.internal.input.TodoInputRequestDTO;
import com.todo.common.dto.internal.update.TodoUpdateRequestDTO;
import com.todo.common.service.TodoService;
import lombok.extern.slf4j.Slf4j;
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
    public CommonHeader add(@RequestBody @Valid TodoInputRequestDTO dto){
        log.info("[TodoController] add = {}",dto);
        return todoService.save(dto);
    }

    @RequestMapping(value = "/finish",method = RequestMethod.POST)
    public CommonHeader finish(@RequestBody @Valid TodoFinishRequestDTO dto){
        log.info("[TodoController] finish id = {}",dto.getId());
        return todoService.finish(dto.getId());
    }

    @RequestMapping(method= RequestMethod.PUT)
    public CommonHeader update(@RequestBody @Valid TodoUpdateRequestDTO todoDTO){
        log.info("[TodoController] updatedTodoDTO = {}",todoDTO);
        return todoService.update(todoDTO);
    }

    @RequestMapping(value="/{id}",method= RequestMethod.GET)
    public CommonHeader<TodoGetResponseDTO> get(@PathVariable Long id){
        log.info("[TodoController] GET id = {}",id);
        return todoService.get(id);
    }

    @RequestMapping(value="/{id}",method = RequestMethod.DELETE)
    public CommonHeader delete(@NotNull @PathVariable Long id){
        log.info("[TodoController] DELETE id = {}",id);
        return todoService.delete(id);
    }

}
