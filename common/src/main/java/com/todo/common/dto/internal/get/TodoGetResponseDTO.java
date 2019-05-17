package com.todo.common.dto.internal.get;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Setter
@Getter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TodoGetResponseDTO implements Serializable {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

    @JsonProperty("deadline")
    private String deadline;

    @JsonProperty("priority")
    private int priority;
}
