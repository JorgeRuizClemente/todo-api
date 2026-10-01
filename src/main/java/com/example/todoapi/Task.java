package com.example.todoapi;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

@Entity
public class Task {

  @Id 
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private boolean completed;

  protected Task() {}

  public Task(String title) {
    this.title = title;
    this.completed = false;
  }

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }
}
