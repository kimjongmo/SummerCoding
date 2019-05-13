package com.todo.common.dto;


import com.todo.common.entity.Todo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
@Valid
@Accessors(chain = true)
public class TodoDTO {
    @NotNull(message = "제목을 입력해주세요")
    @NotBlank(message = "제목을 입력해주세요")
    @Length(max = 100,message = "제목은 최대 100자까지만 가능합니다.")
    private String title;

    @NotNull(message = "내용을 입력해주세요.")
    @NotBlank(message = "내용을 입력해주세요.")
    @Length(max = 300,message = "본문은 최대 300자까지만 가능합니다.")
    private String content;

    public Todo toEntity(){
        Todo todo = new Todo()
                .setTitle(this.title)
                .setContent(this.content);
        return todo;
    }

}
