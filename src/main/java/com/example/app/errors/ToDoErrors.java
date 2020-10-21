package com.example.app.errors;

import com.fasterxml.jackson.annotation.*;
import org.springframework.http.*;

import java.time.*;

public class ToDoErrors {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    private ToDoErrors() {
        timestamp = LocalDateTime.now();
    }

    ToDoErrors(HttpStatus status) {
        this();
        this.status = status;
    }

    ToDoErrors(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ToDoErrors(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
