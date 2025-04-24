package com.orlovandrei.hotel.entity.room;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "room_number", nullable = false)
    String roomNumber;

    @Column(name = "room_type", nullable = false)
    String roomType;

    @Column(name = "amount", nullable = false)
    int amount;

    @Column(name = "price", nullable = false)
    BigDecimal price;

    @Column(name = "description", nullable = false)
    String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    RoomStatus status = RoomStatus.AVAILABLE;
}