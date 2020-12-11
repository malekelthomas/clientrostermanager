package com.clientrostermanager.app.controller;

import java.util.ArrayList;
import java.util.Map;

import com.clientrostermanager.app.models.Client;
import com.clientrostermanager.app.models.ClientDTO;
import com.clientrostermanager.app.models.Room;
import com.clientrostermanager.app.models.RoomDTO;
import com.clientrostermanager.app.service.ClientRoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClientRoomController {

    @Autowired
    private ClientRoomService clientRoomService;

    @GetMapping("/rooms")
    public Map<String, ArrayList<Room>> getAllRooms(){
        return this.clientRoomService.getAllRooms();
    }
    @GetMapping("/clients")
    public Map<String, ArrayList<Client>> getAllClients(){
        return this.clientRoomService.getAllClients();
    }

    @PostMapping("/rooms")
    public void addRoom(@RequestBody RoomDTO room){
        Room persistentRoom = new Room();
        persistentRoom.setRoomNum(room.getRoomNum());
        this.clientRoomService.addRoom(persistentRoom);
    }

    @PostMapping("/clients")
    public void addClient(@RequestBody ClientDTO client){
        Client persistentClient = new Client();
        persistentClient.setFirstName(client.getFirstName());
        persistentClient.setLastName(client.getLastName());
        persistentClient.setCaresId(client.getCaresId());
        persistentClient.setRoomNum(client.getRoomNum());
        persistentClient.setBed(client.getBed());
        this.clientRoomService.addClient(persistentClient);
    }
    
}
