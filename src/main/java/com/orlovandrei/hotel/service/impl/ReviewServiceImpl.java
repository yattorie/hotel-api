package com.orlovandrei.hotel.service.impl;

import com.orlovandrei.hotel.entity.exception.ResourceNotFoundException;
import com.orlovandrei.hotel.entity.review.Review;
import com.orlovandrei.hotel.repository.ReviewRepository;
import com.orlovandrei.hotel.service.ReviewService;
import com.orlovandrei.hotel.utils.ServiceMessages;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @PostConstruct
    public void postConstruct() {
        System.out.println(ServiceMessages.REVIEW_CONSTRUCTED.getMessage());
    }

    @Override
    @Transactional(readOnly = true)
    public Review getById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ServiceMessages.REVIEW_NOT_FOUND.getMessage() + id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    @Transactional
    public Review create(Review review) {
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new ResourceNotFoundException(ServiceMessages.REVIEW_NOT_FOUND.getMessage() + id);
        }
        reviewRepository.deleteById(id);
    }
}