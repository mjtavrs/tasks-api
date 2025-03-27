package dev.marcostavares.tasks_api.mapper;

import dev.marcostavares.tasks_api.domain.model.Task;
import dev.marcostavares.tasks_api.dtos.response.TaskResponse;
import dev.marcostavares.tasks_api.infrastructure.persistence.TaskEntity;

public class TaskMapper {

    public static TaskEntity toEntity(Task task) {
        return new TaskEntity(
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getDueDate());
    }

    public static TaskResponse toResponse(TaskEntity entity) {
        return new TaskResponse(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getDueDate(),
                entity.getCreatedAt());
    }

}
