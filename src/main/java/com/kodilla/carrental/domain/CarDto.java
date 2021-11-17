package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CarDto {
    private Long id;
    private String name;
    private String price;
    private String description;
    private boolean block;
    private List<Long> bookingIds;
}
