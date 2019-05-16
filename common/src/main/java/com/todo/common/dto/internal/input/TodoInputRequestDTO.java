package com.todo.common.dto.internal.input;
import com.todo.common.entity.Todo;
import com.todo.common.status.TodoStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.logging.log4j.util.Strings;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
@ToString
public class TodoInputRequestDTO {
    @NotEmpty(message = "제목을 입력해주세요")
    @Length(max = 100,message = "제목은 최대 100자까지만 가능합니다.")
    private String title;

    @NotEmpty(message = "내용을 입력해주세요.")
    @NotBlank(message = "내용을 입력해주세요.")
    @Length(max = 300,message = "본문은 최대 300자까지만 가능합니다.")
    private String content;

    @Pattern(regexp = "^([0-9]{4}+-[0-9]{2}+-[0-9]{2}+T[0-9]{2}+:[0-9]{2})",message = "올바르지 않은 형식입니다.")
    private String deadline;

    public Todo toEntity(){
        Todo todo = new Todo()
                .setTitle(this.title)
                .setContent(this.content)
                .setStatus(TodoStatus.WAITING)
                ;
        if(!Strings.isEmpty(deadline))
            todo.setDeadline(LocalDateTime.parse(this.deadline, DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        return todo;
    }

}
