package com.todo.common.dto.internal.search;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class SearchRequestDTO {
    private String title;
    private String content;
    @Pattern(regexp = "^([0-9]{4}+-[0-9]{2}+-[0-9]{2}+T[0-9]{2}+:[0-9]{2}|)",message = "올바르지 않은 형식입니다.")
    private String afterDate;
    @Pattern(regexp = "^([0-9]{4}+-[0-9]{2}+-[0-9]{2}+T[0-9]{2}+:[0-9]{2}|)",message = "올바르지 않은 형식입니다.")
    private String beforeDate;
    private String status;
}
