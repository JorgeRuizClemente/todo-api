package com.example.todoapi;

import jakarta.validation.constraints.*;

public record TaskRequest(
  @NotBlank(message = "El titulo es obligatorio y no debe estar vacio")
  @Size(min=3, max=100, message = "El titulo debe estar entre 3 y 100 caracteres")
  String title
  ){
  
}
