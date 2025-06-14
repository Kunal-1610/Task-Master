package com.todoapp.todo_app.controller;

import com.todoapp.todo_app.model.Task;
import com.todoapp.todo_app.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    public  TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String getTask(Model model){
       List<Task> tasks = service.getAllTask();
//        for (Task task : tasks) {
//            System.out.println(">> Task Title: " + task.getTitle());
//        }
       model.addAttribute("tasks",tasks);
       return "tasks";//name of the view or template
    }

    @PostMapping
    public String createTask(@RequestParam String title){
       service.createTask(title);
        return "redirect:/tasks";//name of the view or template
    }


    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id){
        service.deleteTask(id);
        return "redirect:/tasks";//name of the view or template
    }

    @PostMapping("/toggle/{id}")
    public String toggleTask(@PathVariable Long id){
        service.toggleTask(id);
        return "redirect:/tasks";//name of the view or template
    }
}
