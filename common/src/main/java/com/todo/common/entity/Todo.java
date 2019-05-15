package com.todo.common.entity;

import com.todo.common.dto.UpdateTodoDTO;
import com.todo.common.status.TodoStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Setter
@Getter
@ToString(callSuper = true)
@Accessors(chain = true)
public class Todo extends BaseEntity {
    private String title;
    private String content;
    private LocalDateTime deadline;
    @Enumerated(EnumType.STRING)
    private TodoStatus status;

    public void update(UpdateTodoDTO dto) {
        if (!Strings.isEmpty(dto.getTitle()))
            this.title = dto.getTitle();

        if (!Strings.isEmpty(dto.getContent()))
            this.content = dto.getContent();

        /* 데드라인 설정 */
        if (!Strings.isEmpty(dto.getDeadline()))
            this.deadline = LocalDateTime.parse(dto.getDeadline(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        /* 상태 변경 */
        if (!Strings.isEmpty(dto.getStatus())) {
            TodoStatus[] array = TodoStatus.values();
            for (TodoStatus todoStatus : array) {
                if (todoStatus.getMessage().equals(dto.getStatus())) {
                    this.status = todoStatus;
                    break;
                }
            }
        }
    }
}
