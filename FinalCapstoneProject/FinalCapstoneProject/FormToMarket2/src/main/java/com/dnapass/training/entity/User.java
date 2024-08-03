package com.dnapass.training.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    // @Column(unique = true)
    private String username;
    private String password;
    // @Enumerated(EnumType.STRING)
    private String role;
    private String mobileNumber;
    private String state;
    private String city;
    private String pinCode;
    private LocalDate createdAt;

    @OneToMany(mappedBy = "user")
    private List<Item> items;

    @OneToOne(mappedBy = "user")
    private EquipmentUser equipmentUser;

    @OneToMany(mappedBy = "user")
    private List<Equipment> equipments;
    
    public User() {
    }

    public User(Integer id, String mobileNumber, String state, String city, String pinCode, String role, String username, String password) {
        this.id = id;
        this.mobileNumber = mobileNumber;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
        this.role = role;
        this.username = username;
        this.password = password;
    }


    public User(String mobileNumber, String state, String city, String pinCode, String role, String username, String password)
    {
        this.mobileNumber = mobileNumber;
        this.state = state;
        this.city = city;
        this.pinCode = pinCode;
        this.role = role;
        this.username = username;
        this.password = password;
    }




    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }

    public EquipmentUser getEquipmentUser()
    {
        return equipmentUser;
    }

    public void setEquipmentUser(EquipmentUser equipmentUser)
    {
        this.equipmentUser = equipmentUser;
    }

    public List<Equipment> getEquipments()
    {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments)
    {
        this.equipments = equipments;
    }
    
    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getPinCode()
    {
        return pinCode;
    }

    public void setPinCode(String pinCode)
    {
        this.pinCode = pinCode;
    }

    public Integer getUserId()
    {
        return id;
    }

    public void setUserId(Integer id)
    {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public LocalDate getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt)
    {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "{id: " + id + ", username: " + username + ", role: " + role + ", city: " + city + "}";
    }
}
