package com.kodilla.carrental.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EquipmentDto {
    private Long id;
    private String equipment;
    private Booking booking;
}
