package org.akusher.personalai_interviewprep.exception;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExMessage> handleException(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExMessage(
                        "Entity Not Found",
                        e.getMessage(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<ExMessage> handleMethodException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExMessage(
                        "Bad Request",
                        ex.getMessage(),
                        LocalDateTime.now()
                ));
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ExMessage> handleEntityExists(EntityExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ExMessage(
                        "Entity Already Exists",
                        ex.getMessage(),
                        LocalDateTime.now()
                ));
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExMessage> handleGeneric(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExMessage(
                        "Internal Server Error",
                        "Something went wrong",
                        LocalDateTime.now()
                ));
    }
}

