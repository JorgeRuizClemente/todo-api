package com.example.todoapi;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;


@RestController 
@RequestMapping("/api/tasks")
@Validated 
public class TaskController {
  
  private final TaskService service;

  public TaskController(TaskService service) {
    this.service = service;
  }

  @GetMapping 
  public List<Task> getTask() {
    return service.getAllTasks();
  }

  @GetMapping("/{id}")
  public Task getTaskById(@PathVariable @Positive (message = "El id debe ser mayor a 0") Long id) {
    return service.getTaskById(id);
  }

  @PostMapping 
  public Task createTask(@Valid @RequestBody TaskRequest request) {
    return service.createTask(request.title());
  }

  @PutMapping("/{id}/toggle")
  public Task toggleTask(@PathVariable @Positive (message = "El id debe ser mayor a 0") Long id) {
    return service.tonggleTaskStatus(id);
  }

  @PatchMapping ("/{id}/setTitle")
  public Task setTaskName(
    @PathVariable @Positive (message = "El id debe ser mayor a 0") Long id, 
    @Valid @RequestParam(value = "title") String title
    ) {
    return service.setTaskName(id, title);
  }

  @DeleteMapping("/{id}")
  public String deleteTask(@PathVariable @Positive (message = "El id debe ser mayor a 0") Long id) {
    return service.deleteTask(id);
  }

  @GetMapping("/filter")
  public List<Task> getByCompleted (@RequestParam (value = "completed") boolean completed) {
    return service.getByCompleted(completed);
  }

  @GetMapping("/search")
  public List<Task> getLike (@RequestParam (value = "keyword") String keyword) {
    return service.getLike(keyword);
  }
}