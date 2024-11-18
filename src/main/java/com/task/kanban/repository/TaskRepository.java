package com.task.kanban.repository;

import com.task.kanban.model.KanbanStatus;
import com.task.kanban.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.status = :status")
    List<Task> findTasksToDo(KanbanStatus status);
}
