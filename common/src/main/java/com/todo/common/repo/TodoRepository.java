package com.todo.common.repo;

import com.todo.common.entity.Todo;
import com.todo.common.status.TodoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>,TodoRepositoryCustom {

    List<Todo> findAllByDeadlineBeforeAndStatus(LocalDateTime dateTime, TodoStatus status);

}
