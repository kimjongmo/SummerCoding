package com.todo.common.service;

import com.todo.common.dto.TodoDTO;
import com.todo.common.entity.Todo;
import com.todo.common.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public void put(TodoDTO todoDTO){
        Todo todo = todoDTO.toEntity();
        this.todoRepository.save(todo);
    }

    public Todo get(Long id){
        return todoRepository.findById(id).orElse(new Todo());
    }
}
