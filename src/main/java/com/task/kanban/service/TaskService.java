package com.task.kanban.service;


import com.task.kanban.model.KanbanStatus;
import com.task.kanban.model.Task;
import com.task.kanban.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }

    public Task insertTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTaskToDo(KanbanStatus status){
        return taskRepository.findTasksToDo(status);
    }

    public Task updateTask(long id, Task task) {
        Task currentTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found ID: " + id));

        // Atualiza os campos desejados
        currentTask.setTitle(task.getTitle());
        currentTask.setDescription(task.getDescription());
        currentTask.setStatus(task.getStatus());
        currentTask.setPriority(task.getPriority());

        // Salva a tarefa atualizada
        return taskRepository.save(currentTask);
    }

    public Task moveTask(long id) {
        Task currentTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found ID: " + id));
        if(currentTask.getStatus() == KanbanStatus.toDo){
            currentTask.setStatus(KanbanStatus.inProgress);
        } else if (currentTask.getStatus() == KanbanStatus.inProgress) {
            currentTask.setStatus(KanbanStatus.completed);
        }else {
             currentTask.setStatus(KanbanStatus.completed);
        }

        return taskRepository.save(currentTask);
    }

    public Task deleteTask(long id) {
        Task currentTask = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task was not found" + id));
        taskRepository.delete(currentTask);
        return currentTask;
    }


}
