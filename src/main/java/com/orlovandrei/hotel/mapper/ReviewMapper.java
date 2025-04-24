package com.orlovandrei.hotel.mapper;

import com.orlovandrei.hotel.entity.review.Review;
import com.orlovandrei.hotel.dto.review.ReviewDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper extends Mappable<Review, ReviewDto> {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "room.id", target = "roomId")
    ReviewDto toDto(Review entity);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "roomId", target = "room.id")
    Review toEntity(ReviewDto dto);
}