package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Booking;
import com.kodilla.carrental.domain.BookingDto;
import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookingMapper extends EntityMapper<Booking, BookingDto> {

    private final EquipmentRepository equipmentRepository;

    @Override
    public Booking toEntity(BookingDto bookingDto) {
        return new Booking(
                bookingDto.getId(),
                bookingDto.getBookSince(),
                bookingDto.getBookTo(),
                bookingDto.getEquipmentId().stream()
                        .map(equipmentRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public BookingDto toDto(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getBookSince(),
                booking.getBookTo(),
                booking.getEquipment().stream()
                        .map(Equipment::getId)
                        .collect(Collectors.toList())
        );
    }
}
