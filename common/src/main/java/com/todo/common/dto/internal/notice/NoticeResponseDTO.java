package com.todo.common.dto.internal.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class NoticeResponseDTO {
    @JsonProperty("count")
    private Integer count;
}
