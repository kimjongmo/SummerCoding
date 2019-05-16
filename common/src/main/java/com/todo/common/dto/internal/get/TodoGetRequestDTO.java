package com.todo.common.dto.internal.get;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TodoGetRequestDTO {
    @NotNull
    private Long id;
}
