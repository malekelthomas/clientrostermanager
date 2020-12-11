package com.clientrostermanager.app.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Client {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String caresId;


    private int roomNum;

    private char bed;

    public Client(){

    }

    public Client(Integer id, String firstName, String lastName, String caresId, int roomNum, char bed){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.caresId = caresId;
        this.roomNum = roomNum;
        this.bed = bed;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCaresId() {
        return this.caresId;
    }

    public void setCaresId(String caresId) {
        this.caresId = caresId;
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public char getBed() {
        return this.bed;
    }

    public void setBed(char bed) {
        this.bed = bed;
    }
    
}
