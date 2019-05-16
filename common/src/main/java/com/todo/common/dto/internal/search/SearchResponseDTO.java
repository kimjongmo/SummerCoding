package com.todo.common.dto.internal.search;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SearchResponseDTO implements Serializable {

    @JsonProperty("todos")
    private List<SearchResponse> todos;

    @Getter
    @Setter
    @Accessors(chain = true)
    public static class SearchResponse implements Serializable{

        @JsonProperty("id")
        private Long id;

        @JsonProperty("title")
        private String title;

        @JsonProperty("content")
        private String content;

        @JsonProperty("deadline")
        private String deadline;

        @JsonProperty("status")
        private String status;
    }
}
