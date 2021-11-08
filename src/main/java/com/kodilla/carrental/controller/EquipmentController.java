package com.kodilla.carrental.controller;

import com.kodilla.carrental.domain.Booking;
import com.kodilla.carrental.domain.EquipmentDto;
import com.kodilla.carrental.service.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService service;

    @GetMapping
    public List<EquipmentDto> get(){
        return new ArrayList<>();
    }

    @PostMapping
    public void create(){}

    @PutMapping
    public EquipmentDto update(){
        return new EquipmentDto(1l, "", new Booking().getId());
    }

    @DeleteMapping
    public void delete(){}
}

