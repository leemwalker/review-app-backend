package com.reviewapp.controller;

import com.reviewapp.exception.ReviewNotFoundException;
import com.reviewapp.model.Review;
import com.reviewapp.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ReviewController {

@Autowired
  ReviewRepository reviewRepository;

// Get All Reviews
  @GetMapping("/reviews")
  public List<Review> getAllReviews() {
    return reviewRepository.findAll();
  }

// Create a new Review
  @PostMapping("/reviews")
  public Review createReview(@Valid @RequestBody Review review) {
    return reviewRepository.save(review);
  }

// Get a Single Review
  @GetMapping("/reviews/{id}")
  public Review getReviewById(@PathVariable(value = "id") Long reviewId) throws ReviewNotFoundException {
    return reviewRepository.findById(reviewId)
      .orElseThrow(() -> new ReviewNotFoundException(reviewId));
  }

// Update a Review
  @PutMapping("/reviews/{id}")
  public Review updateReview(@PathVariable(value = "id") Long reviewId,
    @Valid @RequestBody Review reviewDetails) throws ReviewNotFoundException {

    Review review = reviewRepository.findById(reviewId)
    .orElseThrow(() -> new ReviewNotFoundException(reviewId));

    review.setRestaurantName(reviewDetails.getRestaurantName());
    review.setLocation(reviewDetails.getLocation());
    review.setRating(reviewDetails.getRating());
    review.setVisited(reviewDetails.getVisited());
    review.setBestItem(reviewDetails.getBestItem());
    review.setNotes(reviewDetails.getNotes());

    Review updatedReview = reviewRepository.save(review);

    return updatedReview;
  }

// Delete a Review
  @DeleteMapping("/reviews/{id}")
  public ResponseEntity<?> deleteReview(@PathVariable(value = "id") Long reviewId) throws ReviewNotFoundException {
    Review review = reviewRepository.findById(reviewId)
      .orElseThrow(() -> new ReviewNotFoundException(reviewId));

reviewRepository.delete(review);

return ResponseEntity.ok().build();
  }
}