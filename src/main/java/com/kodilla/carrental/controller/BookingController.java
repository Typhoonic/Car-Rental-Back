package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.BookingDto;
import com.kodilla.carrental.domain.CarDto;
import com.kodilla.carrental.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @GetMapping(value = "/schedule/{carId}")
    public String getSchedule(@PathVariable Long carId) {
        return new CarDto(1L, "", "", "", false).getPrice();
    }

    @PostMapping( consumes = APPLICATION_JSON_VALUE)
    public BookingDto create(@RequestBody LocalDate localDate) {
        return new BookingDto(1L, LocalDate.now(), LocalDate.now(), new ArrayList<>());
    }

    @PutMapping
    public BookingDto update(@RequestBody LocalDate localDate) {
        return new BookingDto(1L, LocalDate.now(), LocalDate.now(), new ArrayList<>());
    }

    @DeleteMapping(value = "{bookId}")
    public BookingDto delete(PathVariable bookId) {
        return new BookingDto(1L, LocalDate.now(), LocalDate.now(), new ArrayList<>());
    }
}
