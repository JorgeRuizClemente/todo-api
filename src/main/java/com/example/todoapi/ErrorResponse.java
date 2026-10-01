package com.example.todoapi;

import java.time.LocalDateTime;

public record ErrorResponse(
  int status,
  String message,
  LocalDateTime timestap
  ){
  public ErrorResponse(int status, String message) {
    this(status, message, LocalDateTime.now());
  }
}
