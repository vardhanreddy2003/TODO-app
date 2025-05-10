package com.example.taskmanager;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;


    @Override
    public List<Task> readAllTasks()
    {
        List<TaskEntity> tasks=taskRepository.findAll();
        List<Task> taskList=new ArrayList<>();

        for(TaskEntity task: tasks)
        {
        
            Task currTask=new Task();
            currTask.setId(task.getId());
            currTask.setDate(task.getDate());
            currTask.setStatus(task.getStatus());
            currTask.setTaskName(task.getTaskName());
            taskList.add(currTask);
        }
        return taskList;
    }
    @Override
    public String deleteTask(Long id)
    {
        Optional<TaskEntity> task=taskRepository.findById(id);
        taskRepository.delete(task.get());
        return "deleted";
    }
     @Override
    public String insertTask(Task task)
    {
        TaskEntity currTask=new TaskEntity();
        currTask.setDate(task.getDate());
        currTask.setStatus(task.getStatus());
        currTask.setTaskName(task.getTaskName());
        taskRepository.save(currTask);

        return "inserted";
    }
   @Override
    public String updateTask(Task task)
    {
        Long id=task.getId();
        System.out.println("2");
        System.out.println(id);
         Optional<TaskEntity> optionalTask=taskRepository.findById(id);
          if(!optionalTask.isPresent())
        {
           return "no student found";
        }
        optionalTask.get().setStatus("completed");
        taskRepository.save(optionalTask.get());
        return "updated";
    }
    
}
