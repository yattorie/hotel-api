package com.orlovandrei.hotel.service.impl;

import com.orlovandrei.hotel.entity.booking.Booking;
import com.orlovandrei.hotel.entity.exception.ResourceNotFoundException;
import com.orlovandrei.hotel.entity.room.Room;
import com.orlovandrei.hotel.entity.room.RoomStatus;
import com.orlovandrei.hotel.repository.BookingRepository;
import com.orlovandrei.hotel.repository.RoomRepository;
import com.orlovandrei.hotel.service.BookingService;
import com.orlovandrei.hotel.utils.ServiceMessages;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    private final RoomRepository roomRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println(ServiceMessages.BOOKING_CONSTRUCTED.getMessage());
    }

    @Override
    @Transactional(readOnly = true)
    public Booking getById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.BOOKING_NOT_FOUND.getMessage() + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.BOOKING_NOT_FOUND.getMessage() + id));
        Room room = booking.getRoom();
        bookingRepository.deleteById(id);
        boolean hasOtherBookings = bookingRepository.findAll().stream()
                .anyMatch(b -> b.getRoom().getId().equals(room.getId()) && !b.getId().equals(id));
        if (!hasOtherBookings) {
            room.setStatus(RoomStatus.AVAILABLE);
            roomRepository.save(room);
        }
    }

    @Override
    @Transactional
    public Booking create(Booking booking) {
        Room room = roomRepository.findById(booking.getRoom().getId())
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.ROOM_NOT_FOUND.getMessage() + booking.getRoom().getId()));
        if (room.getStatus() == RoomStatus.OCCUPIED) {
            throw new IllegalStateException(ServiceMessages.ROOM_OCCUPIED.getMessage());
        }
        room.setStatus(RoomStatus.OCCUPIED);
        roomRepository.save(room);
        return bookingRepository.save(booking);
    }
}
