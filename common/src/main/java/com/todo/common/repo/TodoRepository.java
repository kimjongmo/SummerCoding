package com.todo.common.repo;

import com.todo.common.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>,TodoRepositoryCustom {

    List<Todo> findAllByDeadlineBefore(LocalDateTime dateTime);
    List<Todo> findAllByDeadlineGreaterThanEqual(LocalDateTime dateTime);
    List<Todo> findAllByDeadlineLessThanEqual(LocalDateTime dateTime);

}
