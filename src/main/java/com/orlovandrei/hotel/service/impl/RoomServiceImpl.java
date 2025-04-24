package com.orlovandrei.hotel.service.impl;

import com.orlovandrei.hotel.entity.exception.ResourceNotFoundException;
import com.orlovandrei.hotel.entity.room.Room;
import com.orlovandrei.hotel.entity.room.RoomStatus;
import com.orlovandrei.hotel.repository.RoomRepository;
import com.orlovandrei.hotel.service.RoomService;
import com.orlovandrei.hotel.utils.ServiceMessages;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println(ServiceMessages.ROOM_CONSTRUCTED.getMessage());
    }

    @Override
    @Transactional(readOnly = true)
    public Room getById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.ROOM_NOT_FOUND.getMessage() + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> getAll() {
        return roomRepository.findAll();
    }

    @Override
    @Transactional
    public Room create(Room room) {
        if (room.getStatus() == null) {
            room.setStatus(RoomStatus.AVAILABLE);
        }
        return roomRepository.save(room);
    }

    @Override
    @Transactional
    public Room update(Long id, Room room) {
        Room existingRoom = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.ROOM_NOT_FOUND.getMessage() + id));
        existingRoom.setRoomNumber(room.getRoomNumber());
        existingRoom.setRoomType(room.getRoomType());
        existingRoom.setAmount(room.getAmount());
        existingRoom.setPrice(room.getPrice());
        existingRoom.setDescription(room.getDescription());
        existingRoom.setStatus(room.getStatus());
        return roomRepository.save(existingRoom);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!roomRepository.existsById(id)) {
            throw new ResourceNotFoundException(ServiceMessages.ROOM_NOT_FOUND.getMessage() + id);
        }
        roomRepository.deleteById(id);
    }


}