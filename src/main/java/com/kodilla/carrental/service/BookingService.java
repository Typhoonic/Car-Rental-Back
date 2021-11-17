package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Booking;
import com.kodilla.carrental.domain.BookingDto;
import com.kodilla.carrental.domain.Car;
import com.kodilla.carrental.exception.EntityNotFoundException;
import com.kodilla.carrental.mapper.BookingMapper;
import com.kodilla.carrental.repository.BookingRepository;
import com.kodilla.carrental.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingMapper mapper;
    private final BookingRepository repository;
    private final CarRepository carRepository;

    public List<BookingDto> getSchedule(final Long carId) throws EntityNotFoundException {
        Car car = carRepository.findById(carId).orElseThrow(() -> new EntityNotFoundException(Car.class, carId));
        return mapper.toDtoList(car.getBookings());
    }

    public BookingDto create(final BookingDto bookingDto) {
        return saveAndMapToDto(bookingDto);
    }

    public BookingDto update(final BookingDto bookingDto) throws EntityNotFoundException {
        repository.findById(bookingDto.getId()).orElseThrow(() -> new EntityNotFoundException(Booking.class, bookingDto.getId()));
        return saveAndMapToDto(bookingDto);
    }

    public void delete(final Long bookId) throws EntityNotFoundException {
        repository.findById(bookId).orElseThrow(() -> new EntityNotFoundException(Booking.class, bookId));
        repository.deleteById(bookId);
    }

    private BookingDto saveAndMapToDto(final BookingDto bookingDto) {
        Booking booking = repository.save(mapper.toEntity(bookingDto));
        return mapper.toDto(booking);
    }
}
