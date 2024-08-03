package com.dnapass.training.entity;

import javax.persistence.*;

@Entity
@Table(name="equipments")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer bookingId;
    private String name;
    private Integer count;
    private Double rentPerDay;
    private String estate;
    private String ecity;
    private String village;
    private String epinCode;
    private String contactPerson;
    private String emobileNumber;
    private String estatus;
    
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne
    @JoinColumn(name = "equipmentUserId")
    private EquipmentUser equipmentUser;

    public Equipment(Integer id, Integer bookingId, String name, Integer count, Double rentPerDay, String estate, String ecity, String village, String epinCode, String contactPerson, String emobileNumber, String estatus, User user, EquipmentUser equipmentUser) {
        this.id = id;
        this.bookingId = bookingId;
        this.name = name;
        this.count = count;
        this.rentPerDay = rentPerDay;
        this.estate = estate;
        this.ecity = ecity;
        this.village = village;
        this.epinCode = epinCode;
        this.contactPerson = contactPerson;
        this.emobileNumber = emobileNumber;
        this.estatus = estatus;
        this.user = user;
        this.equipmentUser = equipmentUser;
    }

    public Equipment(Integer id, String name, Integer count, Double rentPerDay, String estate, String ecity,
                     String village, String epinCode, String contactPerson, String emobileNumber, User user) {
        
        this.id = id;
        this.name = name;
        this.count = count;
        this.rentPerDay = rentPerDay;
        this.estate = estate;
        this.ecity = ecity;
        this.village = village;
        this.epinCode = epinCode;
        this.contactPerson = contactPerson;
        this.emobileNumber = emobileNumber;
        this.user = user;
    }

    public Equipment(Integer id, String name, Integer count, Double rentPerDay, String estate, String ecity,
            String village, String epinCode, String contactPerson, String emobileNumber,String estatus, User user) {
        
        this.id = id;
        this.name = name;
        this.count = count;
        this.rentPerDay = rentPerDay;
        this.estate = estate;
        this.ecity = ecity;
        this.village = village;
        this.epinCode = epinCode;
        this.contactPerson = contactPerson;
        this.emobileNumber = emobileNumber;
        this.estatus = estatus;
        this.user = user;
    }

    public Equipment(String name, Integer count, Double rentPerDay, String estate, String ecity,
            String village, String epinCode, String contactPerson, String emobileNumber, User user) {

        this.name = name;
        this.count = count;
        this.rentPerDay = rentPerDay;
        this.estate = estate;
        this.ecity = ecity;
        this.village = village;
        this.epinCode = epinCode;
        this.contactPerson = contactPerson;
        this.emobileNumber = emobileNumber;
        this.user = user;
    }

    public Equipment() {
    }
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

    public String getEstatus()
    {
        return estatus;
    }

    public void setEstatus(String estatus)
    {
        this.estatus = estatus;
    }

    public EquipmentUser getEquipmentUser()
    {
        return equipmentUser;
    }

    public void setEquipmentUser(EquipmentUser equipmentUser)
    {
        this.equipmentUser = equipmentUser;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

    public Double getRentPerDay()
    {
        return rentPerDay;
    }

    public void setRentPerDay(Double rentPerDay)
    {
        this.rentPerDay = rentPerDay;
    }

    public String getEstate()
    {
        return estate;
    }

    public void setEstate(String estate)
    {
        this.estate = estate;
    }

    public String getEcity()
    {
        return ecity;
    }

    public void setEcity(String ecity)
    {
        this.ecity = ecity;
    }

    public String getVillage()
    {
        return village;
    }

    public void setVillage(String village)
    {
        this.village = village;
    }

    public String getEpinCode()
    {
        return epinCode;
    }

    public void setEpinCode(String epinCode)
    {
        this.epinCode = epinCode;
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

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    
}
