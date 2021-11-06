package com.kodilla.carrental.service;

import com.kodilla.carrental.mapper.EquipmentMapper;
import com.kodilla.carrental.repository.EquipmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EquipmentService {

    private final EquipmentMapper mapper;
    private final EquipmentRepository repository;
}
