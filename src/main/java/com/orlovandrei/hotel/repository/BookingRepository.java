package com.orlovandrei.hotel.repository;

import com.orlovandrei.hotel.entity.booking.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
