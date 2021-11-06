package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class BookingDto {
    private Long id;
    private LocalDate bookSince;
    private LocalDate bookTo;
    private List<Equipment> equipment;
}
