package com.orlovandrei.hotel.repository;

import com.orlovandrei.hotel.entity.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
