package dev.marcostavares.tasks_api.dtos.response;

import java.time.LocalDateTime;
import java.util.UUID;

import dev.marcostavares.tasks_api.domain.model.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TaskResponse {

    private UUID id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;

}
