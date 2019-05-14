package com.todo.common.service;

import com.todo.common.dto.TodoDTO;
import com.todo.common.dto.UpdateTodoDTO;
import com.todo.common.entity.Todo;
import com.todo.common.error.ValidCustomException;
import com.todo.common.repo.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void save(TodoDTO todoDTO) {
        Todo todo = todoDTO.toEntity();
        this.todoRepository.save(todo);
    }

    public Todo get(Long id) {
        return todoRepository.findById(id).orElse(new Todo());
    }

    public void update(UpdateTodoDTO dto) {
        Optional<Todo> optional = todoRepository.findById(dto.getId());
        if (!optional.isPresent())
            throw new ValidCustomException("해당하는 TODO를 찾을 수 없습니다.","id");

        Todo todoBefore = optional.get();
        log.debug("before = {}",todoBefore);
        todoBefore.update(dto);

        Todo todoAfter = todoRepository.save(todoBefore);
        log.debug("after ={}",todoAfter);
    }

    public void delete(Long id){
        if(!todoRepository.findById(id).isPresent())
            throw new ValidCustomException("해당하는 TODO를 찾을 수 없습니다","");
        todoRepository.deleteById(id);
    }

}
