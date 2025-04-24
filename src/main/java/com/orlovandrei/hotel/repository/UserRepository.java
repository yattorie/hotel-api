package com.orlovandrei.hotel.repository;

import com.orlovandrei.hotel.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.username = :username")
    Optional<User> findByUsername(String username);

    @Query(value = "select u from User u where u.email = :email")
    Optional<User> findByEmail(String email);

}
