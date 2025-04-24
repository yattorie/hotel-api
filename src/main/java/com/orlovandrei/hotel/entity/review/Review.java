package com.orlovandrei.hotel.entity.review;

import com.orlovandrei.hotel.entity.room.Room;
import com.orlovandrei.hotel.entity.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "comment", nullable = false)
    String comment;

    @Column(name = "rating", nullable = false)
    int rating;

    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    User user;

    @OneToOne
    @JoinColumn(name = "room_id", nullable = false, unique = true)
    Room room;
}