package com.lostin.users.exception;

import com.lostin.users.request_response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceResponseException.class)
    public ResponseEntity<@NonNull ErrorResponse> handleServerException(ServiceResponseException e){
        return ResponseEntity.status(e.statusCode).body(e.toErrorResponse());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<@NonNull ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex
    ) {

        String message = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");

        return ResponseEntity.badRequest().body(new ErrorResponse("VALIDATION_ERROR",message));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<@NonNull ErrorResponse> handleBadRequest(BadRequestException e){
        return ResponseEntity.badRequest().body(e.toErrorResponse());
    }

    @ExceptionHandler(ServerError.class)
    public ResponseEntity<@NonNull ErrorResponse> handleServerError(ServerError e){
        log.error("Internal Server Error",e);
        return ResponseEntity.status(500).body(e.toErrorResponse());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<@NonNull ErrorResponse> handleException(Exception e){
        log.error("UNEXPECTED SERVER ERROR",e);
        return ResponseEntity.internalServerError().body(
                new ErrorResponse("UNEXPECTED SERVER ERROR","Smth get wrong")
        );
    }
}
