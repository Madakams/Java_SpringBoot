package com.dnapass.training.controller;

import java.util.List;
import java.util.Map;

import com.dnapass.training.entity.*;
import com.dnapass.training.service.EquipmentService;
import com.dnapass.training.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dnapass.training.service.UserService;


@RestController
@RequestMapping(path = "/farmmarket")
public class FarmMarketController
{
    @Autowired
    private UserService userService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private EquipmentService equipmentService;


	//Mapping with /login with requestbody login
	@PostMapping("/login")
	public ResponseEntity<Object> checkLogin(@RequestBody Map<String, String> body)
	{
		User user = userService.login(body.get("userid"), body.get("password"), body.get("role"));
        System.out.println(user);
        if (user != null)
		{
            if (user.getUserId() != null)
			{
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//Mapping with "/newuser"
	@PostMapping("/newuser")
    public ResponseEntity<User> createUser(@RequestBody User user)
	{
        userService.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    

	@GetMapping("/search")
	//Mapping with "/search" based on city parameter
	public ResponseEntity<List<Equipment>> farmerSearchEquipment(@RequestParam("city") String city)
	{
		List<Equipment> equipment = equipmentService.searchEquipment(city);
		if(equipment.isEmpty())
		{
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(equipment, HttpStatus.OK);
	}

	@GetMapping("/getAllEquipment")
	//Mapping with "/getAllEquipment"
	public ResponseEntity<List<Equipment>> getAllEquipment()
	{
	    List<Equipment> equipment = equipmentService.getAllEquipment();
		if (equipment.isEmpty())
		{
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(equipment, HttpStatus.OK);
	}

	@GetMapping("/getAllEquipmentById/{id}")
	//Mapping with "/getAllEquipmentById/{id} based on user id 
	public ResponseEntity<List<Equipment>> getAllEquipmentById(@PathVariable("id")Integer id)
	{
		List<Equipment> equipment = equipmentService.getAllEquipmentById(id);
		if (equipment.isEmpty())
		{
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(equipment, HttpStatus.OK);
	}

	@GetMapping("/getAllItemById/{id}")
	//Mapping with "/getAllItemById/{id}" based on user id
	public ResponseEntity<List<Item>> getAllItemById(@PathVariable("id")Integer id)
	{
	    List<Item> items = itemService.getAllItemById(id);
		if(items.isEmpty())
		{
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Item>>(itemService.getAllItemById(id), HttpStatus.OK);
	}


	@PutMapping("/book/{equipId}/{userid}/{quantitycount}")
	// Mapping wih "/book/{equipId}/{userid}/{quantitycount}" to book an equipment based on equipment id, user id and number of quantity
	public ResponseEntity<Equipment> bookEquipment(@PathVariable("equipId") Integer id,@PathVariable("quantitycount") Integer ecount,@PathVariable("userid")Integer uid)
	{
		Equipment equipment = equipmentService.getEquipmentById(id);
		User user = userService.findUser(uid);
		Equipment updatedEquipment = equipmentService.getEquipmentById(id);
		return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
	}

	@PostMapping("/addNewItem/{id}")
	//Mapping with "/addNewItem/{id}" based on particular userid with Item body
	public ResponseEntity<Item> addNewItem(@RequestBody Item item, @PathVariable("id") Integer userId)
	{
	    itemService.addNewItem(item);
		return new ResponseEntity<Item>(item, HttpStatus.CREATED);
	} 

	@GetMapping("/getAllItems")
	// Mapping with "/getAllItems" to return all items for traders to view
	public ResponseEntity<List<ItemDetails>> getAllItems()
	{
		if (itemService.getAllItems().isEmpty())
		{
		 	return null;
		}
		return ResponseEntity.ok(itemService.getAllItems());
	}

	@DeleteMapping("/deleteItemDetails/{itemId}")
	// Mapping with "/deleteItemDetails/{itemId}" to delete item based on itemId
	public ResponseEntity<HttpStatus> deleteItemDetails(@PathVariable("itemId") Integer itemId)
	{
		itemService.deleteItemDetails(itemId);
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/itemDetails/{uid}")
	//Mapping with "/itemDetails/{uid}" to update the items based on particular user with body Item
	public ResponseEntity<Object> updateItemDetails(@PathVariable("uid") Integer userId, @RequestBody Item item)
	{
		List<Item> itemDetails = itemService.getAllItemById(userId);
		System.out.println(itemDetails);
		if (itemDetails != null)
		{
			itemService.updateItemDetails(item);
			List<Item> updatedItem = itemService.getAllItemById(userId);
			return new ResponseEntity<>(itemDetails, HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/addNewEquipment/{id}")
	//Mapping with "/addNewEquipment/{id}" to add new equipment for particular userid with equipment body
	public ResponseEntity<Equipment> addNewEquipment(@RequestBody Equipment equipment, @PathVariable("id") Integer userId)
	{
		 equipmentService.addEquipment(equipment);
		 return new ResponseEntity<>(equipment, HttpStatus.CREATED);
	}

	@GetMapping("/getAllEquipments")
	//Mapping with "/getAllEquipments" to display all equipment for farmer based on count
	public ResponseEntity<List<Equipment>> getAllEquipments()
	{
		List<Equipment> equipments = equipmentService.getAllEquipment();
		if (equipments.isEmpty())
		{
			return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Equipment>>(equipments, HttpStatus.OK);
	}

	@DeleteMapping("/deleteEquipmentDetails/{equipId}")
	//Mapping with "/deleteEquipmentDetails/{equipId}" to delete particular equipment based on equipment id
	public ResponseEntity<HttpStatus> deleteEquipmentDetails(@PathVariable("equipId") Integer equipId)
	{
		equipmentService.deleteEquipmentDetail(equipId);
		if (equipmentService.getEquipmentById(equipId) == null)
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//Mapping with "/equipmentDetails/{uid}" to update equipment detail based on particular user with equipment body 
	public ResponseEntity<Equipment> updateEquipmentDetails(
			@PathVariable("uid") Integer userId, @RequestBody Equipment equipment)
	{
	      return null;
	}

	//Mapping with "/returnEquipment" to return an equipment and update the count
	public ResponseEntity<Equipment> returnEquipment(@RequestBody EquipmentDetails edetails)
	{
	      return null;
	}
	
	//Mapping with "/getHiredEquipment/{id}" to view hired equipment based on user id
	public ResponseEntity<List<EquipmentDetails>> getHiredEquipment(@PathVariable("id")Integer id)
	{
		 return null;
	}

	//Mapping with "/searchItem" to search the item by trader based on city
	public ResponseEntity<List<ItemDetails>> traderSearchItem(@RequestParam("city") String city)
	{
	      return null;
	}

	@GetMapping("/getFarmer/{id}")
	// Mapping with "/getFarmer/{id}" to display all items for that farmer based on userid
	public ResponseEntity<User> getFarmerDetails(@PathVariable("id") Integer id)
	{
	        User user = userService.findUser(id);
			if (user == null)
			{
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@GetMapping("/orderItem/{itemId}")
	//Mapping with "/orderItem/{itemId}" by trader based on itemid and update the count of items
	public ResponseEntity<ItemDetails> orderItem(@PathVariable("itemId") Integer id)
	{
		    ItemDetails itemDetails = itemService.getItemDetailsById(id);
			if (itemDetails == null)
			{
				return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(itemDetails, HttpStatus.OK);
	}
}
