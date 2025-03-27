package dev.marcostavares.tasks_api.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.tasks_api.dtos.request.UpdateTaskRequest;
import dev.marcostavares.tasks_api.dtos.response.TaskResponse;
import dev.marcostavares.tasks_api.infrastructure.persistence.TaskRepository;
import dev.marcostavares.tasks_api.mapper.TaskMapper;

@Service
public class UpdateTask {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse execute(UUID id, UpdateTaskRequest request) {
        return taskRepository.findById(id)
                .map(task -> {
                    if (request.getTitle() != null && !request.getTitle().isBlank()) {
                        task.setTitle(request.getTitle());
                    }

                    if (request.getDescription() != null && !request.getDescription().isBlank()) {
                        task.setDescription(request.getDescription());
                    }

                    if (request.getDueDate() != null && !request.getDueDate().isBefore(LocalDateTime.now())) {
                        task.setDueDate(request.getDueDate());
                    }

                    return TaskMapper.toResponse(taskRepository.save(task));
                }).orElseThrow(IllegalArgumentException::new);
    }

}
