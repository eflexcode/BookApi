package com.larrex.bookapi.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookModel {

    private Long id;

    private String name;

    private String imageUrl;

    private String about;

    private BigDecimal price;

    private String language;

    private String publisher;

    private String publishedAt;

    private String pageCount;

    private String category;

    private Long AuthorId;
}
