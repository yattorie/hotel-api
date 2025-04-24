package com.orlovandrei.hotel.mapper;

import com.orlovandrei.hotel.entity.room.Room;
import com.orlovandrei.hotel.dto.room.RoomDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends Mappable<Room, RoomDto>{
}
