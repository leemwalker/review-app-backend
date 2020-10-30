package com.reviewapp.exception;

public class ReviewNotFoundException extends Exception {
  private long reviewId;
  public ReviewNotFoundException(long reviewId) {
    super(String.format("Review is not found with id : '%s'", reviewId));
  }
}