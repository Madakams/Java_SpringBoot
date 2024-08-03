package com.dnapass.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dnapass.training.entity.Equipment;
import com.dnapass.training.entity.EquipmentDetails;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer>{
    //Query to get all equipment based on city and count
    @Query(value = "SELECT * FROM equipments WHERE ecity like %:city%", nativeQuery = true)
	List<Equipment> findByCity(@Param("city")String code);
    
    //Query to get all equipment based on particular userid
    @Query(value = "SELECT * FROM equipments WHERE user_id = :userId", nativeQuery = true)
    List<Equipment> findAllEquipment(@Param("userId") Integer id);
   
   //Query to select all equipment if their count is more than 0
    @Query(value = "SELECT * FROM equipments WHERE count > 0", nativeQuery = true)
   List<Equipment> findEquipmentByCount();
   
   //Query to display hired equipment details based on particular user id
    @Query(value = "SELECT e.*, u.* FROM equipments e JOIN users u ON e.user_id = u.id WHERE e.user_id = :uid", nativeQuery = true)
   List<EquipmentDetails> findHiredEquipment(@Param("uid")Integer id);
   
}
