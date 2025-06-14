package com.todoapp.todo_app.repo;

import com.todoapp.todo_app.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository <Task,Long>{
}
