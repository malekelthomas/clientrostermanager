package com.clientrostermanager.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Room {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private int roomNum;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "client_id_a", referencedColumnName = "id", columnDefinition = "int default null")
    private Client bedA = null;
    
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "client_id_b", referencedColumnName = "id", columnDefinition = "int default null")
    private Client bedB = null;

    
    public Room() {
    }

    public Room(Integer id, int roomNum, Client bedA, Client bedB) {
        this.id = id;
        this.roomNum = roomNum;
        this.bedA = bedA;
        this.bedB = bedB;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public Client getBedA() {
        return this.bedA;
    }

    public void setBedA(Client bedA) {
        this.bedA = bedA;
    }

    public Client getBedB() {
        return this.bedB;
    }

    public void setBedB(Client bedB) {
        this.bedB = bedB;
    }

}
