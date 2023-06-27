package com.larrex.bookapi.model;

import lombok.Data;

@Data
public class Author {

    private Long id;

    private String name;

    private String imageUrl;

    private String biography;

}
