package com.dnapass.training.entity;


public class EquipmentDetails extends Equipment{
	private Integer bookingId;
	private Integer id;
    private String name;
    private String contactPerson;
    private String emobileNumber;
    private Integer count;
	public Integer getBookingId()
	{
		return bookingId;
	}
	public void setBookingId(Integer bookingId)
	{
		this.bookingId = bookingId;
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getContactPerson()
	{
		return contactPerson;
	}
	public void setContactPerson(String contactPerson)
	{
		this.contactPerson = contactPerson;
	}
	public String getEmobileNumber()
	{
		return emobileNumber;
	}
	public void setEmobileNumber(String emobileNumber)
	{
		this.emobileNumber = emobileNumber;
	}
	public Integer getCount()
	{
		return count;
	}
	public void setCount(Integer count)
	{
		this.count = count;
	}

	public Integer getQuantityCount()
	{
		return count;
	}
	public EquipmentDetails(Integer bookingId, Integer id, String name, String contactPerson, String emobileNumber, Integer count)
	{
		super();
		this.bookingId = bookingId;
		this.id = id;
		this.name = name;
		this.contactPerson = contactPerson;
		this.emobileNumber = emobileNumber;
		this.count = count;
	}
	public EquipmentDetails(Integer id, String name, String contactPerson, String emobileNumber, Integer count)
	{
		super();
		this.id = id;
		this.name = name;
		this.contactPerson = contactPerson;
		this.emobileNumber = emobileNumber;
		this.count = count;
	}
	public EquipmentDetails()
	{
		super();
	}
} 
