package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.entity.booking.Booking;
import com.orlovandrei.hotel.service.BookingService;
import com.orlovandrei.hotel.dto.booking.BookingDto;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.mapper.BookingMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Booking Controller", description = "Booking API")
public class BookingController {

    private final BookingService bookingService;

    private final BookingMapper bookingMapper;

    public static final String FIND_BY_ID = "/api/v1/bookings/{id}";
    public static final String FIND_ALL = "/api/v1/bookings";
    public static final String CREATE = "/api/v1/bookings";
    public static final String UPDATE = "/api/v1/bookings";
    public static final String DELETE = "/api/v1/bookings/{id}";

    @GetMapping(FIND_BY_ID)
    @Operation(summary = "Get BookingDto by id")
    public BookingDto getById(@PathVariable Long id) {
        Booking booking = bookingService.getById(id);
        return bookingMapper.toDto(booking);
    }

    @GetMapping(FIND_ALL)
    @Operation(summary = "Get all bookings")
    public List<BookingDto> getAll() {
        List<Booking> bookings = bookingService.getAll();
        return bookingMapper.toDto(bookings);
    }

    @PostMapping(CREATE)
    @Operation(summary = "Create a new booking")
    public BookingDto create(@Validated(OnCreate.class) @RequestBody BookingDto bookingDto) {
        Booking booking = bookingMapper.toEntity(bookingDto);
        Booking createdBooking = bookingService.create(booking);
        return bookingMapper.toDto(createdBooking);
    }

    @DeleteMapping(DELETE)
    @Operation(summary = "Delete booking")
    public void deleteById(@PathVariable Long id) {
        bookingService.delete(id);
    }

}
