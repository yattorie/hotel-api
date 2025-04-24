package com.orlovandrei.hotel.repository;

import com.orlovandrei.hotel.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}