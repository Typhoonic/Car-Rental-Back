package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Booking;
import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.domain.CarDto;
import com.kodilla.carrental.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CarMapper extends EntityMapper<Car, CarDto>{

    private final BookingRepository bookingRepository;

    @Override
    public Car toEntity(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getName(),
                carDto.getPrice(),
                carDto.getDescription(),
                carDto.isBlock(),
                carDto.getBookingIds().stream()
                        .map(bookingRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getName(),
                car.getPrice(),
                car.getDescription(),
                car.isBlock(),
                car.getBookings().stream()
                        .map(Booking::getId)
                        .collect(Collectors.toList())
        );
    }
}
