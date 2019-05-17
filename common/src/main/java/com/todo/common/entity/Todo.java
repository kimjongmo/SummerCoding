package com.todo.common.entity;

import com.todo.common.dto.internal.update.TodoUpdateRequestDTO;
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
    private int priority;

    public void update(TodoUpdateRequestDTO dto) {
        if (!Strings.isEmpty(dto.getTitle()))
            this.title = dto.getTitle();

        if (!Strings.isEmpty(dto.getContent()))
            this.content = dto.getContent();

        /* 데드라인 설정 */
        this.deadline = dto.getDeadline()==null?null:LocalDateTime.parse(dto.getDeadline(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        this.priority = dto.getPriority();
    }
}
