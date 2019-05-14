package com.todo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class SearchDTO {
    private String title;
    private String content;
    @Pattern(regexp = "^[0-9]{4}+-[0-9]{2}+-[0-9]{2}+T[0-9]{2}+:[0-9]{2}+:[0-9]{2}",message = "올바르지 않은 형식입니다.")
    private String afterDate;
    @Pattern(regexp = "^[0-9]{4}+-[0-9]{2}+-[0-9]{2}+T[0-9]{2}+:[0-9]{2}+:[0-9]{2}",message = "올바르지 않은 형식입니다.")
    private String beforeDate;
    @Pattern(regexp = "^(대기중|완료)")
    private String status;
}
