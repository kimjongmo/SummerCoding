package com.todo.api;

import com.todo.common.entity.Todo;
import com.todo.common.repo.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JpaTEST {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void test() {
        //when
        LocalDateTime time = LocalDateTime.of(2019,5,15,23,0,0);
        //jpa
        List<Todo> jpa = todoRepository.findAllByDeadlineBefore(time);
        log.info("list.size = {}", jpa.size());
        jpa.stream().forEach(a -> log.info("{}", a));

        //querydsl
        List<Todo> querydsl = todoRepository.findDynamicQuery(null, null, null, time, null);
        log.info("result.size={}", querydsl.size());
        querydsl.stream().forEach(a -> log.info("{}", a));
    }

}

