package com.dnapass.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnapass.training.entity.Equipment;
import com.dnapass.training.entity.EquipmentDetails;
import com.dnapass.training.entity.EquipmentUser;
import com.dnapass.training.repository.EquipmentRepository;

@Service
public class EquipmentService{

	@Autowired
	EquipmentRepository equipmentRepository;
	
	//To search all equipment based on their city 
	public List<Equipment> searchEquipment(String city)
	{
	   return equipmentRepository.findByCity(city);
	}

	//To fetch all equipmnet for the farmers to book it 
	public List<Equipment> getAllEquipment() {
		if(equipmentRepository.findAll().isEmpty())
		{
			return null;
		}
		return equipmentRepository.findAll();
	}

	//To add new equipment 
	public Equipment addEquipment(Equipment e)
	{
		return equipmentRepository.save(e);
	}

    //To delete particular equipment based on equipment id 
	public void deleteEquipmentDetail(Integer equipId)
	{
		equipmentRepository.deleteById(equipId);
	}

   //To get an equipment based on id 
	public Equipment getEquipmentById(Integer id)
	{
		return equipmentRepository.findById(id).get();
	}

    //To fetch all equipment for that particular user 
	public List<Equipment> getAllEquipmentById(Integer id)
	{
		return equipmentRepository.findAllEquipment(id);
	}
	
	//To fetch all hired equipment for particular user 
	public List<EquipmentDetails> getHiredEquipment(Integer uid)
	{
		return equipmentRepository.findHiredEquipment(uid);
	}
	
	//To add new equipmentuser which contains both equipment details and user details 
	public EquipmentUser addEquipmentUser(EquipmentUser euser)
	{
		return null;
	}
	
	//To delete equipment based on bookingid while returning the equipment
	public void deleteEquipmentUser(Integer bookingId) {
		
	}
}
