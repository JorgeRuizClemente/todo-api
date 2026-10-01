package com.example.todoapi;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface TaskRepository extends JpaRepository<Task, Long> {
  List<Task> findByCompleted(boolean completed);
  List<Task> findByTitleContainingIgnoreCase(String keyword);
}
