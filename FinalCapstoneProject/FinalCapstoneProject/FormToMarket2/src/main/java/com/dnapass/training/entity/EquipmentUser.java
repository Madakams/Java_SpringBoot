package com.dnapass.training.entity;

import javax.persistence.*;

@Entity
@Table(name="equipment_users")
public class EquipmentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name="equipment_id")
    private Equipment equipment;
    private Integer quantity;

    public EquipmentUser()
    {

    }

    public EquipmentUser(User user, Equipment equipment, Integer quantity)
    {
        this.user = user;
        this.equipment = equipment;
        this.quantity = quantity;
    }


    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id = id;
    }
    public User getUser()
    {
        return user;
    }
    public void setUser(User user)
    {
        this.user = user;
    }
    public Equipment getEquipment()
    {
        return equipment;
    }
    public void setEquipment(Equipment equipment)
    {
        this.equipment = equipment;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }
}
