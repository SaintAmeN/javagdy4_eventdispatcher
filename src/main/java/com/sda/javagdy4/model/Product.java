package com.sda.javagdy4.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Product {

    private Long id;

    private String name;
    private double price;
    private String description;
    private LocalDate releaseDate;

    public Product(Long id) {
        this.id = id;
    }
}
