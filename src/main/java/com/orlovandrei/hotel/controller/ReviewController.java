package com.orlovandrei.hotel.controller;

import com.orlovandrei.hotel.entity.review.Review;
import com.orlovandrei.hotel.service.ReviewService;
import com.orlovandrei.hotel.dto.review.ReviewDto;
import com.orlovandrei.hotel.dto.validation.OnCreate;
import com.orlovandrei.hotel.mapper.ReviewMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
@Validated
@Tag(name = "Review Controller", description = "Review API")
public class ReviewController {

    private final ReviewService reviewService;

    private final ReviewMapper reviewMapper;

    @GetMapping("/{id}")
    @Operation(summary = "Get ReviewDto by id")
    public ReviewDto getById(@PathVariable Long id) {
        Review review = reviewService.getById(id);
        return reviewMapper.toDto(review);
    }

    @GetMapping
    @Operation(summary = "Get all reviews")
    public List<ReviewDto> getAll() {
        List<Review> reviews = reviewService.getAll();
        return reviewMapper.toDto(reviews);
    }

    @PostMapping
    @Operation(summary = "Create a new review")
    public ReviewDto create(@Validated(OnCreate.class) @RequestBody ReviewDto reviewDto) {
        Review review = reviewMapper.toEntity(reviewDto);
        Review createdReview = reviewService.create(review);
        return reviewMapper.toDto(createdReview);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete review")
    public void deleteById(@PathVariable Long id) {
        reviewService.delete(id);
    }
}