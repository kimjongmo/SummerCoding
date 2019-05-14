package com.todo.common.repo;

import com.todo.common.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>,TodoRepositoryCustom {

}
