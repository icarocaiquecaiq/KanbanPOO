package com.task.kanban.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.lang.NonNull;

import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_task;

    @Nonnull
    private String title;


    private String description;


    @Enumerated(EnumType.STRING)
    @NonNull
    private KanbanStatus status;


    @Enumerated(EnumType.STRING)
    @NonNull
    private KanbanPriority priority;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;




    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public KanbanStatus getStatus() {
        return status;
    }

    public void setStatus(KanbanStatus status) {
        this.status = status;
    }

    public KanbanPriority getPriority() {
        return priority;
    }

    public void setPriority(KanbanPriority priority) {
        this.priority = priority;
    }
}
