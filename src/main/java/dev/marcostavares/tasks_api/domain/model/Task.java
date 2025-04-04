package dev.marcostavares.tasks_api.domain.model;

import java.time.LocalDateTime;

public class Task {

    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime dueDate;

    public Task(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.status = TaskStatus.PENDING;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
