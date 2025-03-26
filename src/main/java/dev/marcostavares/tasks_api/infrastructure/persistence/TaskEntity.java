package dev.marcostavares.tasks_api.infrastructure.persistence;

import java.time.LocalDateTime;
import java.util.UUID;

import dev.marcostavares.tasks_api.domain.model.TaskStatus;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity(name = "task")
public class TaskEntity {

    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;

}
