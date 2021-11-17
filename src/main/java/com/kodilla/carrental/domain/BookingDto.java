package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@ToString
public class BookingDto {
    private Long id;
    private LocalDate bookSince;
    private LocalDate bookTo;
    private List<Long> equipmentId;
    private Long carId;
}
