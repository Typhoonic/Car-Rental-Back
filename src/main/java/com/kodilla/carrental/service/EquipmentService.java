package com.kodilla.carrental.service;

import com.kodilla.carrental.domain.Equipment;
import com.kodilla.carrental.domain.EquipmentDto;
import com.kodilla.carrental.domain.EquipmentType;
import com.kodilla.carrental.exception.EntityNotFoundException;
import com.kodilla.carrental.mapper.EquipmentMapper;
import com.kodilla.carrental.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentMapper mapper;
    private final EquipmentRepository repository;

    public List<EquipmentType> getTypes() {
        return Arrays.asList(EquipmentType.values());
    }

    public EquipmentDto add(final EquipmentDto equipmentDto) {
        return saveAndMapToDto(equipmentDto);
    }

    public EquipmentDto update(final EquipmentDto equipmentDto) throws EntityNotFoundException {
        repository.findById(equipmentDto.getId()).orElseThrow(() -> new EntityNotFoundException(Equipment.class, equipmentDto.getId()));
        return saveAndMapToDto(equipmentDto);
    }

    public void delete(final Long equipmentId) throws EntityNotFoundException {
        repository.findById(equipmentId).orElseThrow(() -> new EntityNotFoundException(Equipment.class, equipmentId));
        repository.deleteById(equipmentId);
    }

    private EquipmentDto saveAndMapToDto(final EquipmentDto equipmentDto) {
        Equipment equipment = repository.save(mapper.toEntity(equipmentDto));
        return mapper.toDto(equipment);
    }
}
