package com.example.todoapi;

import java.util.List;
import org.springframework.stereotype.Service;

@Service 
public class TaskService {

  private final TaskRepository repository;

  public TaskService(TaskRepository repository) {
    this.repository = repository;
  }

  public List<Task> getAllTasks() {
    return repository.findAll();
  }

  public Task getTaskById(Long id) {
    return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontro la tarea con ID: "+id));
  }

  public Task createTask(String title) {
    Task task = new Task(title);
    return repository.save(task);
  }

  public Task tonggleTaskStatus(Long id) {
    Task task = getTaskById(id);
    task.setCompleted(!task.isCompleted());
    return repository.save(task);
  }

  public Task setTaskName(Long id, String title) {
    Task task = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("El titulo no debe estar vacio"));
    task.setTitle(title);
    return repository.save(task);
  }

  public String deleteTask(Long id) {
    if(!repository.existsById(id)) {
      throw new ResourceNotFoundException("No se encontro la tarea con ID: "+id);
    }
    repository.deleteById(id);
    return "Tarea eliminada";
  }

  public List<Task> getByCompleted(boolean completed) {
    return repository.findByCompleted(completed);
  }

  public List<Task> getLike(String keyword) {
    return repository.findByTitleContainingIgnoreCase(keyword);
  }
}
