package com.reviewapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.*;
@Entity
@Table(name = "reviews")
public class Review {
  @Id
  @GeneratedValue
  private Long id;
  @NotBlank
  private String restaurantName;
  @NotBlank
  private String location;
  @NotBlank
  private Integer rating;
  @NotBlank
  private Date visited;
  @NotBlank
  private String bestItem;
  @NotBlank
  private String notes;
  public Review(){
    super();
  }
  public Review(Long id, String restaurantName, String location, Integer rating, Date visited, String bestItem, String notes) {
    super();
    this.id = id;
    this.restaurantName = restaurantName;
    this.rating = rating;
    this.visited = visited;
    this.bestItem = bestItem;
    this.notes = notes;
    this.location = location;
  }
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getRestaurantName() {
    return restaurantName;
  }
  public void setRestaurantName(String restaurantName) {
    this.restaurantName = restaurantName;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public Integer getRating() {
    return rating;
  }
  public void setRating(Integer rating) {
    this.rating = rating;
  }
  public Date getVisited() {
    return visited;
  }
  public void setVisited(Date visited) {
    this.visited = visited;
  }
  public String getBestItem() {
    return bestItem;
  }
  public void setBestItem(String bestItem) {
    this.bestItem = bestItem;
  }
  public String getNotes() {
    return notes;
  }
  public void setNotes(String notes) {
    this.notes = notes;
  }
}