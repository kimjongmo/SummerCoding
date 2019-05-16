package com.todo.common.dto.internal.finish;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
public class TodoFinishRequestDTO {

    @NotNull
    private Long id;
}
