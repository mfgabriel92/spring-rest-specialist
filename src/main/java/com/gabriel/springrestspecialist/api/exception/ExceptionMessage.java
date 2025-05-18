package com.gabriel.springrestspecialist.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@Builder
public class ExceptionMessage {
    private int status;
    private String type;
    private String title;
    private String detail;
    private String url;
    private LocalDateTime timestamp;
}
