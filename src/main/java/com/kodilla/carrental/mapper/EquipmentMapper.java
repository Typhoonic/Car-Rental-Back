package com.kodilla.carrental.mapper;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.domain.EquipmentDto;
import com.kodilla.carrental.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EquipmentMapper extends EntityMapper<Equipment, EquipmentDto> {

    private final BookingRepository bookingRepository;

    @Override
    Equipment toEntity(EquipmentDto equipmentDto) {
        return new Equipment(
                equipmentDto.getId(),
                equipmentDto.getEquipment(),
                bookingRepository.findById(equipmentDto.getBookingId()).orElse(null)
        );
    }

    @Override
    EquipmentDto toDto(Equipment equipment) {
        return new EquipmentDto(
                equipment.getId(),
                equipment.getEquipment(),
                equipment.getBooking().getId()
        );
    }
}
