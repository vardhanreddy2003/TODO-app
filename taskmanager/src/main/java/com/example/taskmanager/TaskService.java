package com.example.taskmanager;

import java.util.List;

public interface TaskService {
    List<Task> readAllTasks();
    String deleteTask(Long id);
    String insertTask(Task task);
    String updateTask(Task task);
}
