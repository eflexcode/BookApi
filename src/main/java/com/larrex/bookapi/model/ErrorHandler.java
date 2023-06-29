package com.larrex.bookapi.model;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorHandler {

    private int statusCode;
    private String message;
    private Date timestamp;

}
