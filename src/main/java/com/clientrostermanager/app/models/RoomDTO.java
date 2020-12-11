package com.clientrostermanager.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

public class RoomDTO {
    private Integer id;
    private int roomNum;
    private Client bedA;

    private Client bedB;

    
    public RoomDTO() {
    }

    public RoomDTO(Integer id, int roomNum, Client bedA, Client bedB) {
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
