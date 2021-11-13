package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.CarDto;
import com.kodilla.carrental.exception.EntityNotFoundException;
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

    public List<CarDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public CarDto getById(final Long carId) throws EntityNotFoundException {
        return repository.findById(carId).map(mapper::toDto).orElseThrow(() -> new EntityNotFoundException(Car.class, carId));
    }

    public CarDto create(final CarDto carDto) {
        return saveAndMapToDto(carDto);
    }

    public CarDto update(final CarDto carDto) throws EntityNotFoundException {
        repository.findById(carDto.getId()).orElseThrow(() -> new EntityNotFoundException(Car.class, carDto.getId()));
        return saveAndMapToDto(carDto);
    }

    public void block(final Long carId) throws EntityNotFoundException {
        Car car = repository.findById(carId).orElseThrow(() -> new EntityNotFoundException(Car.class, carId));
        car.setBlock(true);
        repository.save(car);
    }

    public void unblock(final Long carId) throws EntityNotFoundException {
        Car car = repository.findById(carId).orElseThrow(() -> new EntityNotFoundException(Car.class, carId));
        car.setBlock(false);
        repository.save(car);
    }

    public void delete(final Long carId) throws EntityNotFoundException {
        repository.findById(carId).orElseThrow(() -> new EntityNotFoundException(Car.class, carId));
        repository.deleteById(carId);
    }

    public String getContact() {
        return "Contact";
    }

    private CarDto saveAndMapToDto(final CarDto carDto) {
        Car car = repository.save(mapper.toEntity(carDto));
        return mapper.toDto(car);
    }
}