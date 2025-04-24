package com.orlovandrei.hotel.mapper;

import com.orlovandrei.hotel.entity.booking.Booking;
import com.orlovandrei.hotel.dto.booking.BookingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper extends Mappable<Booking, BookingDto> {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "room.id", target = "roomId")
    BookingDto toDto(Booking entity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roomId", target = "room.id")
    Booking toEntity(BookingDto dto);
}
