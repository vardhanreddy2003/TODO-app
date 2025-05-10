package com.example.taskmanager;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("tasks")
@CrossOrigin(origins ="http://localhost:3000")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping("view")
    public List<Task> getAllTasks() {
        return taskService.readAllTasks();
    }

    @DeleteMapping("delete")
    public String deleteTask(@RequestParam Long id)
    {
        return taskService.deleteTask(id);
    }
    @PostMapping("insert")
    public String insertTask(@RequestBody Task task)
    {
        return taskService.insertTask(task);
    }
    @PutMapping("update")
    public String updateTask(@RequestBody Task task)
    {
        System.out.println("1");
       return taskService.updateTask(task);
    }
    
    
}
