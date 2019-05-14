package com.todo.common.repo;


import com.todo.common.entity.Todo;
import com.todo.common.status.TodoStatus;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepositoryCustom {
    List<Todo> findDynamicQuery(String title, String content, LocalDateTime afterDate, LocalDateTime beforeDate, TodoStatus status);
}
