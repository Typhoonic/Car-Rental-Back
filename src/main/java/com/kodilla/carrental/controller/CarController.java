package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.CarDto;
import com.kodilla.carrental.exception.EntityNotFoundException;
import com.kodilla.carrental.service.CarService;
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
@RequestMapping("/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping()
    public List<CarDto> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{carId}")
    public CarDto getById(@PathVariable Long carId) throws EntityNotFoundException {
        return service.getById(carId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public CarDto create(@RequestBody CarDto carDto) {
        return service.create(carDto);
    }

    @PutMapping(value = "/update")
    public CarDto update(@RequestBody CarDto carDto) throws EntityNotFoundException {
        return service.update(carDto);
    }

    @PutMapping(value = "/block/{carId}")
    public void block(@PathVariable Long carId) throws EntityNotFoundException {
        service.block(carId);
    }

    @PutMapping(value = "/unblock/{carId}")
    public void unblock(@PathVariable Long carId) throws EntityNotFoundException {
        service.unblock(carId);
    }

    @DeleteMapping(value = "{carId}")
    public void delete(@PathVariable Long carId) throws EntityNotFoundException {
        service.delete(carId);
    }

    @GetMapping(value = "/contact")
    public String getContact(){
        return service.getContact();
    }
}
