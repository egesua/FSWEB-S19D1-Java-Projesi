package com.workintech.S19D1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private Integer status;
    private LocalDateTime dateTime;
}
