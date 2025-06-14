package com.todoapp.todo_app.service;

import com.todoapp.todo_app.model.Task;
import com.todoapp.todo_app.repo.TaskRepo;
import org.hibernate.engine.internal.ManagedTypeHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepo taskRepo;
    Task task;

    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public List<Task> getAllTask() {
        return taskRepo.findAll();
    }

    public void createTask(String title) {//var name should be same as a filed name in html page
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }

        Task task = new Task();
        task.setTitle(title.trim());
        task.setCompleted(false); // default

        taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.getCompleted());
        taskRepo.save(task);
    }
}
