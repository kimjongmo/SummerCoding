package com.todo.common.service;

import com.todo.common.dto.CommonHeader;
import com.todo.common.dto.internal.get.TodoGetResponseDTO;
import com.todo.common.dto.internal.input.TodoInputRequestDTO;
import com.todo.common.dto.internal.update.TodoUpdateRequestDTO;
import com.todo.common.entity.Todo;
import com.todo.common.error.ValidCustomException;
import com.todo.common.repo.TodoRepository;
import com.todo.common.status.TodoStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@Slf4j
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public CommonHeader save(TodoInputRequestDTO todoDTO) {
        Todo todo = todoDTO.toEntity();
        todoRepository.save(todo);
        if (todo.getId() != null)
            return new CommonHeader().setMessage("추가되었습니다.");
        else
            return new CommonHeader().setMessage("실패하였습니다.");
    }

    public CommonHeader<TodoGetResponseDTO> get(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) {
            return new CommonHeader().setMessage("존재하지 않는 항목입니다.");
        }
        Todo todo = optionalTodo.get();
        if (todo.getStatus() == TodoStatus.FINISHED) {
            return new CommonHeader().setMessage("완료된 항목입니다.");
        }
        TodoGetResponseDTO data = new TodoGetResponseDTO()
                .setTitle(todo.getTitle())
                .setContent(todo.getContent())
                .setDeadline(todo.getDeadline() == null ? null : todo.getDeadline().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .setId(todo.getId());
        return new CommonHeader<TodoGetResponseDTO>().setMessage("OK").setData(data);
    }

    @Transactional
    public CommonHeader update(TodoUpdateRequestDTO dto) {
        Optional<Todo> optional = todoRepository.findById(dto.getId());
        if (!optional.isPresent())
            return new CommonHeader().setMessage("존재하지 않은 항목입니다.");

        Todo todoBefore = optional.get();
        if(todoBefore.getStatus()==TodoStatus.FINISHED)
            return new CommonHeader().setMessage("이미 완료된 항목은 수정할 수 없습니다.");

        todoBefore.update(dto);
        todoRepository.save(todoBefore);

        return new CommonHeader().setMessage("수정되었습니다");
    }

    // TODO: 2019-05-17 CommonHeader용으로 바꾸기
    public CommonHeader delete(Long id) {
        if (!todoRepository.findById(id).isPresent())
            return new CommonHeader().setMessage("존재하지 않은 항목입니다.");

        todoRepository.deleteById(id);
        return new CommonHeader().setMessage("삭제되었습니다.");
    }

    public CommonHeader finish(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (!optionalTodo.isPresent()) {
            return new CommonHeader().setMessage("존재하지 않는 ID입니다.");
        } else {
            Todo todo = optionalTodo.get();
            if (todo.getStatus() == TodoStatus.FINISHED) {
                return new CommonHeader().setMessage("이미 완료된 상태입니다.");
            }
            todo.setStatus(TodoStatus.FINISHED);
            todoRepository.save(todo);
            return new CommonHeader().setMessage("완료되었습니다.");
        }
    }

}
