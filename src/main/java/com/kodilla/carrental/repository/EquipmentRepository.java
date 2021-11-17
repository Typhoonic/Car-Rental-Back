package com.kodilla.carrental.repository;

import com.kodilla.carrental.domain.Equipment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {
    @Override
    List<Equipment> findAll();
}
