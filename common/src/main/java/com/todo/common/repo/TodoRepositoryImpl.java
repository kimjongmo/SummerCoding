package com.todo.common.repo;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.todo.common.entity.Todo;
import com.todo.common.status.TodoStatus;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.time.LocalDateTime;
import java.util.List;

import static com.todo.common.entity.QTodo.todo;

public class TodoRepositoryImpl extends QuerydslRepositorySupport implements TodoRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    public TodoRepositoryImpl(JPAQueryFactory queryFactory){
        super(Todo.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Todo> findDynamicQuery(String title,String content,LocalDateTime afterDate, LocalDateTime beforeDate,TodoStatus status) {
        return queryFactory
                .selectFrom(todo)
                .where(
                        containsContent(content),
                        containsTitle(title),
                        beforeDeadline(beforeDate),
                        afterDeadline(afterDate),
                        eqStatus(status))
                .fetch();
    }


    private BooleanExpression containsTitle(String title){
        if(Strings.isEmpty(title)){
            return null;
        }
        return todo.title.contains(title);
    }

    private BooleanExpression containsContent(String content){
        if(Strings.isEmpty(content)){
            return null;
        }
        return todo.content.contains(content);
    }

    private BooleanExpression afterDeadline(LocalDateTime afterDate){
        if(afterDate==null){
            return null;
        }
        return todo.deadline.after(afterDate);
    }

    private BooleanExpression beforeDeadline(LocalDateTime beforeDate){
        if(beforeDate==null){
            return null;
        }
        return todo.deadline.before(beforeDate);
    }

    private BooleanExpression eqStatus(TodoStatus status){
        if(status==null){
            return null;
        }
        return todo.status.eq(status);
    }
}
