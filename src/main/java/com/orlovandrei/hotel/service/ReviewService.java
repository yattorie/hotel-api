package com.orlovandrei.hotel.service;

import com.orlovandrei.hotel.entity.review.Review;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReviewService {

    @Transactional(readOnly = true)
    Review getById(Long id);

    @Transactional(readOnly = true)
    List<Review> getAll();

    @Transactional
    Review create(Review review);

    @Transactional
    void delete(Long id);
}