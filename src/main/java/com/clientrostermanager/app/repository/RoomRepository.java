package com.clientrostermanager.app.repository;

import java.util.List;

import com.clientrostermanager.app.models.Room;

import org.springframework.data.repository.CrudRepository;

public interface RoomRepository extends CrudRepository <Room, Integer> {
    List<Room> findByRoomNum(Integer roomNum);
}
