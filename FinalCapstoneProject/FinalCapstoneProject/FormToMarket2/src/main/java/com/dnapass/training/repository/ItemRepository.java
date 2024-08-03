package com.dnapass.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dnapass.training.entity.Item;
import com.dnapass.training.entity.ItemDetails;


@Repository
public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	//Query to display all item details based on their city for all user
	@Query(value = "SELECT new com.dnapass.training.entity.ItemDetails(i.itemId,i.itemName,i.itemQuantity,u.username,u.mobileNumber,u.id) FROM Item i, User u WHERE u.pinCode = :code")
	List<ItemDetails> getItemDetailsBasedCity(@Param("code")String code);
	
	//Query to display all items for particular user
	@Query(value = "SELECT * FROM items WHERE user_id = :userId ", nativeQuery = true)
	List<Item> findAllItem(@Param("userId") Integer id);


	//Query to display all item details with user details for the trader to order
	@Query("select new com.dnapass.training.entity.ItemDetails(i.itemId,i.itemName,i.itemQuantity,u.username,u.mobileNumber,u.id) from Item i,User u where i.user.id=u.id and i.itemQuantity>0")
	List<ItemDetails> findAllItems();

	@Query(value = "SELECT * FROM items WHERE item_id = :itemId", nativeQuery = true)
	ItemDetails findByItemId(@Param("itemId") Integer itemId);
}
