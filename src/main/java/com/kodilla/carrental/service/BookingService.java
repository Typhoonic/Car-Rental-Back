package com.kodilla.carrental.service;

import com.kodilla.carrental.mapper.BookingMapper;
import com.kodilla.carrental.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingMapper mapper;
    private final BookingRepository repository;
}
