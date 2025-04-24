package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.entity.room.Room;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomService {

    Room getById(Long id);

    @Transactional(readOnly = true)
    List<Room> getAll();

    @Transactional
    Room create(Room room);

    @Transactional
    Room update(Long id, Room room);

    @Transactional
    void delete(Long id);
}