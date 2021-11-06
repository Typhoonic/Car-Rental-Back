package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.CarDto;
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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService service;

    @GetMapping()
    public List<CarDto> get() {
        return new ArrayList<CarDto>();
    }

    @GetMapping(value = "/{carId}")
    public CarDto get(@PathVariable Long carId){
        return new CarDto(1L, "", "", "", false);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody CarDto carDto){

    }

    @PutMapping(value = "/update")
    public CarDto update(@RequestBody CarDto carDto){
        return new CarDto(1L, "", "", "", false);
    }

    @PutMapping(value = "/block")
    public CarDto block(@PathVariable Long carId){
        return new CarDto(1L, "", "", "", false);
    }

    @DeleteMapping(value = "{carId}")
    public void delete(@PathVariable Long carId){}

    @GetMapping(value = "/contact")
    public String getContact(){
        return "";
    }
}
