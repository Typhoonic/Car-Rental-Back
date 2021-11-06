package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.CarDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarMapper extends EntityMapper<Car, CarDto>{

    @Override
    Car toEntity(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getName(),
                carDto.getPrice(),
                carDto.getDescription(),
                carDto.isBlock()
        );
    }

    @Override
    CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getName(),
                car.getPrice(),
                car.getDescription(),
                car.isBlock()
        );
    }
}
