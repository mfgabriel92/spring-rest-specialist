package com.gabriel.springrestspecialist.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@Builder
public class ExceptionMessage {
    private int status;
    private String type;
    private String title;
    private String detail;
    private List<Error> errors;
    private String url;
    private OffsetDateTime timestamp;

    @Getter
    @Builder
    public static class Error {
        private String name;
        private String error;
    }
}
