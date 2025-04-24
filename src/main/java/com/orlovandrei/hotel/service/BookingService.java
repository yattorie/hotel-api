package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.entity.booking.Booking;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookingService {
    @Transactional(readOnly = true)
    Booking getById(Long id);

    @Transactional(readOnly = true)
    List<Booking> getAll();

    @Transactional
    void delete(Long id);

    @Transactional
    Booking create(Booking booking);
}
