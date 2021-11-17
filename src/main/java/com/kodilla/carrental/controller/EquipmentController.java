package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.EquipmentDto;
import com.kodilla.carrental.domain.EquipmentType;
import com.kodilla.carrental.exception.EntityNotFoundException;
import com.kodilla.carrental.service.EquipmentService;
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

@RestController
@RequestMapping("/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService service;

    @GetMapping
    public List<EquipmentType> get() {
        return service.getTypes();
    }

    @PostMapping
    public EquipmentDto add(@RequestBody EquipmentDto equipmentDto) {
        return service.add(equipmentDto);
    }

    @PutMapping
    public EquipmentDto update(@RequestBody EquipmentDto equipmentDto) throws EntityNotFoundException {
        return service.update(equipmentDto);
    }

    @DeleteMapping("/{equipmentId}")
    public void delete(@PathVariable Long equipmentId) throws EntityNotFoundException {
        service.delete(equipmentId);
    }
}

