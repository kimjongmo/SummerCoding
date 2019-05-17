package com.todo.common.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TodoStatus implements BaseEnum{

    WAITING(1,"대기중"),
    FINISHED(2,"완료"),
    OVER(3,"마감");

    int id;
    String message;
}
