package com.dnapass.training.service;

import java.util.List;
import java.util.Optional;

import com.dnapass.training.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dnapass.training.entity.Item;
import com.dnapass.training.entity.ItemDetails;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	//To add new item 
	 public Item addNewItem(Item item)
	 {
	        return itemRepository.save(item);
	 }
	 
	 //To display all item details and its associated user for the trader 
	 public List<ItemDetails> getAllItems()
	 {
		 return itemRepository.findAllItems();
	 }
	 
	 //To delete the item based on id
	 public void deleteItemDetails(Integer itemId)
	 {
		 ItemDetails itemDetails = itemRepository.findByItemId(itemId);

		 if (itemDetails != null) {
		 	itemRepository.deleteById(itemId);
		 }
	 }
	 
	 //To fetch single item based on their id
	 public Item getItemById(Integer itemId)
	 {
		 Optional<Item> item = itemRepository.findById(itemId);
		 if (item.isEmpty())
		 {
			 return null;
		 }
		 return item.get();
	 }

	 public ItemDetails getItemDetailsById(Integer itemId)
	 {
		 return itemRepository.findByItemId(itemId);
	 }

    //To display all item details when searching based on their name
	public List<ItemDetails> searchItem(String city)
	{
		 if (itemRepository.getItemDetailsBasedCity(city).isEmpty())
		 {
			 return null;
		 }
		return itemRepository.getItemDetailsBasedCity(city);
	}
	
	//To display all items for a particular user 
	public List<Item> getAllItemById(Integer id)
	{
	   return itemRepository.findAllItem(id);
	}

	public Item updateItemDetails(Item itemDetails)
	{
		 return itemRepository.save(itemDetails);
	}
}