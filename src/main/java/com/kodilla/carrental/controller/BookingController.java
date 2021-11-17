package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.BookingDto;
import com.kodilla.carrental.exception.EntityNotFoundException;
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

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/book")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService service;

    @GetMapping(value = "/schedule/{carId}")
    public List<BookingDto> getSchedule(@PathVariable Long carId) throws EntityNotFoundException {
        return service.getSchedule(carId);
    }

    @PostMapping( consumes = APPLICATION_JSON_VALUE)
    public BookingDto create(@RequestBody BookingDto bookingDto) {
        return service.create(bookingDto);
    }

    @PutMapping
    public BookingDto update(@RequestBody BookingDto bookingDto) throws EntityNotFoundException {
        return service.update(bookingDto);
    }

    @DeleteMapping(value = "/{bookId}")
    public void delete(@PathVariable Long bookId) throws EntityNotFoundException {
        service.delete(bookId);
    }
}
