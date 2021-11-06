package com.kodilla.carrental.service;

import com.kodilla.carrental.mapper.CarMapper;
import com.kodilla.carrental.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CarService {

    private final CarMapper mapper;
    private final CarRepository repository;
}