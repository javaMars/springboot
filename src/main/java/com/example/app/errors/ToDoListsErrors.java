package com.example.app.errors;

import com.fasterxml.jackson.annotation.*;
import org.springframework.http.*;

import java.time.*;

public class ToDoListsErrors {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    private ToDoListsErrors() {
        timestamp = LocalDateTime.now();
    }

    ToDoListsErrors(HttpStatus status) {
        this();
        this.status = status;
    }

    ToDoListsErrors(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    ToDoListsErrors(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
