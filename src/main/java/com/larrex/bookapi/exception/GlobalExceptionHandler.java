package com.larrex.bookapi.exception;

import com.larrex.bookapi.model.ErrorHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorHandler> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception, WebRequest webRequest) {

        ErrorHandler errorHandler = new ErrorHandler();
        errorHandler.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorHandler.setMessage(exception.getMessage());
        errorHandler.setTimestamp(new Date());

        return new ResponseEntity<>(errorHandler, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorHandler> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {

        ErrorHandler errorHandler = new ErrorHandler();
        errorHandler.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorHandler.setMessage(exception.getMessage());
        errorHandler.setTimestamp(new Date());

        return new ResponseEntity<>(errorHandler, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorHandler> handleGeneralException(Exception exception, WebRequest webRequest) {

        ErrorHandler errorHandler = new ErrorHandler();
        errorHandler.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorHandler.setMessage(exception.getMessage());
        errorHandler.setTimestamp(new Date());

        return new ResponseEntity<>(errorHandler, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,Object> map = new HashMap<>();
        map.put("timestamp",new Date());
        map.put("statusCode",HttpStatus.BAD_REQUEST);
        List<String> messages =ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        map.put("messages",messages);

        return new ResponseEntity<>(map,HttpStatus.BAD_REQUEST);
    }
}
