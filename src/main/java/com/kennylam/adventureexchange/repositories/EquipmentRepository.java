package com.kennylam.adventureexchange.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.kennylam.adventureexchange.models.Equipment;

public interface EquipmentRepository extends CrudRepository <Equipment, Long> {
	ArrayList<Equipment> findAll();
}
