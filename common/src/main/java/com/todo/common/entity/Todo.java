package com.todo.common.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Todo extends BaseEntity{
    private String title;
    private String content;
}
