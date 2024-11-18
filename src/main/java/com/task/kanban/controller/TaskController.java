package com.task.kanban.controller;

import com.task.kanban.model.KanbanStatus;
import com.task.kanban.model.Task;
import com.task.kanban.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.listAllTasks();
    }

    @GetMapping("/{status}")
    public List<Task> getTask(@PathVariable KanbanStatus status) {
        return taskService.getTaskToDo(status);
    }

    @PostMapping
    public Task createTask( @Validated @RequestBody Task task) {
        //task.setStatus(KanbanStatus.toDo);
        return taskService.insertTask(task);
    }

    @PutMapping("/{id}/move")
    public Task moveTask(@PathVariable int id) {
        return taskService.moveTask(id);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id , @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable int id) {
        return taskService.deleteTask(id);
    }

}
