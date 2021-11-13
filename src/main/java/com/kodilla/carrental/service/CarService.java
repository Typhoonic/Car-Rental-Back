package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.CarDto;
import com.kodilla.carrental.mapper.CarMapper;
import com.kodilla.carrental.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private final CarMapper mapper;
    private final CarRepository repository;

    public List<CarDto> get() {
        return mapper.toDtoList(repository.findAll());
    }


    public CarDto getById(Long carId) {
        return repository.findById(carId).map(mapper::toDto).orElseThrow(); // -> implementacja wyjątków
    }


    public CarDto create(final CarDto carDto){
        //rzucić wyjątek gdy carDto o danym id nie istnieje
        return saveAndMapToDto(carDto);
    }


    public CarDto update(final CarDto carDto){
        //wyjątek
        return saveAndMapToDto(carDto);
    }


    public void block(final Long carId){
        Car car = repository.findById(carId).orElseThrow(); // dorzucić wyjątek
        car.setBlock(true);
        repository.save(car);
    }


    public void delete(final Long carId){
        repository.findById(carId).orElseThrow(); //wyjątek
        repository.deleteById(carId);
    }


    public String getContact(){
        return "";
    }

    private CarDto saveAndMapToDto(final CarDto carDto){
        Car car = repository.save(mapper.toEntity(carDto));
        return mapper.toDto(car);
    }
}