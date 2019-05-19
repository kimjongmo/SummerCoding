package com.todo.batch.processor;

import com.todo.common.entity.Todo;
import com.todo.common.repo.TodoRepository;
import com.todo.common.status.TodoStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Component
public class BatchProccessor {

    @Autowired
    private TodoRepository todoRepository;



    @Scheduled(fixedRate = 15 * 60000)
    public void handle() {
        LocalDateTime now = LocalDateTime.now();
        TodoStatus status = TodoStatus.WAITING;
        List<Todo> list = todoRepository.findAllByDeadlineBeforeAndStatus(now, status);
        if (list.size() != 0)
            list.stream().forEach(todo -> {
                todo.setStatus(TodoStatus.OVER);
                todoRepository.save(todo);
            });
    }

}
