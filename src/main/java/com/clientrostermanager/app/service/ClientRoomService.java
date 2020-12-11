package com.clientrostermanager.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.clientrostermanager.app.models.Client;
import com.clientrostermanager.app.models.Room;
import com.clientrostermanager.app.repository.ClientRepository;
import com.clientrostermanager.app.repository.RoomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientRoomService {

    private static final String DATA = "data";
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private RoomRepository roomRepository;

    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Client> clients = new ArrayList<>();

    private static Map<String, ArrayList<Room>> roomData;
    static {
        roomData = new HashMap<String, ArrayList<Room>>();
        roomData.put(DATA, rooms);
    }
    private static Map<String, ArrayList<Client>> clientData;
    static {
        clientData = new HashMap<String, ArrayList<Client>>();
        clientData.put(DATA, clients);
    }

    public Map<String, ArrayList<Room>> getAllRooms(){

        ArrayList<Room> rooms = new ArrayList<>();
        roomRepository.findAll()
        .forEach(rooms::add);
        Map<String, ArrayList<Room>> roomsData = new HashMap<>();
        {   
            roomsData = new HashMap<>();
            roomsData.put(DATA, rooms);
        }
        return roomsData;

    }

    public Room getRoom(Integer id){
        Room room = roomRepository.findById(id)
        .orElse(null);

        return room;
    }

    public void addRoom(Room room){
        roomData.computeIfAbsent(DATA, k -> new ArrayList<>()).add(room);
        roomRepository.save(room);
    }

    public Map<String, ArrayList<Client>> getAllClients(){

        ArrayList<Client> clients = new ArrayList<>();
        clientRepository.findAll()
        .forEach(clients::add);
        Map<String, ArrayList<Client>> clientData = new HashMap<>();
        {   
            clientData = new HashMap<>();
            clientData.put(DATA, clients);
        }
        return clientData;

    }

    public void addClient(Client client){
        clientData.computeIfAbsent(DATA, k -> new ArrayList<>()).add(client);
        Room clientRoom = roomRepository.findByRoomNum(client.getRoomNum()).get(0);
        String clientBed = Character.toString(client.getBed());
        if(clientBed.equals("A") || clientBed.equals("a")){
            clientRoom.setBedA(client);
        }
        if(clientBed.equals("B") || clientBed.equals("b")){
            clientRoom.setBedB(client);
        }
        clientRepository.save(client);
        roomRepository.save(clientRoom);
    }
    
}
