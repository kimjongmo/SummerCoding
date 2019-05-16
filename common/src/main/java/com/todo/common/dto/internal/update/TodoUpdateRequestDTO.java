package com.todo.common.dto.internal.update;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class TodoUpdateRequestDTO {
    @NotNull(message = "ID 값은 필수입니다.")
    private Long id;

    @NotEmpty
    @Length(max = 100, message = "제목은 최대 100자까지만 가능합니다.")
    private String title;

    @NotEmpty
    @Length(max = 300, message = "본문은 최대 300자까지만 가능합니다.")
    private String content;

    @Pattern(regexp = "^[0-9]{4}+-[0-9]{2}+-[0-9]{2}+T[0-9]{2}+:[0-9]{2}",message = "올바르지 않은 형식입니다.")
    private String deadline;


}
