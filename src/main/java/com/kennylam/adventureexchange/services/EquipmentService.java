package com.kennylam.adventureexchange.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennylam.adventureexchange.models.Equipment;
import com.kennylam.adventureexchange.repositories.EquipmentRepository;

@Service
public class EquipmentService {
	@Autowired
	private EquipmentRepository equipmentRepo;
	
	public ArrayList<Equipment> allGear(){
		return equipmentRepo.findAll();
	}
	
	public Equipment findGearId(Long id) {
		Optional<Equipment>optionalEquipment= equipmentRepo.findById(id);
		if(optionalEquipment.isPresent()) {
			return optionalEquipment.get();
		}
		else {
			return null;
		}
	}
	
	public Equipment addGear(Equipment equipment) {
		return equipmentRepo.save(equipment);
	}
	
	public Equipment updateGear(Equipment equipment) {
		return equipmentRepo.save(equipment);
	}
	
	public void deleteGear(Equipment equipment) {
		equipmentRepo.delete(equipment);
	}
}
