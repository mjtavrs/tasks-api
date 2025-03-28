package dev.marcostavares.tasks_api.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.tasks_api.dtos.request.UpdateTaskStatusRequest;
import dev.marcostavares.tasks_api.dtos.response.TaskResponse;
import dev.marcostavares.tasks_api.infrastructure.persistence.TaskRepository;
import dev.marcostavares.tasks_api.mapper.TaskMapper;

@Service
public class UpdateTaskStatus {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse execute(UUID id, UpdateTaskStatusRequest request) {
        return taskRepository.findById(id)
                .map(task -> {
                    if (request.getStatus() == null) {
                        throw new IllegalArgumentException("Status must be provided.");
                    }

                    task.setStatus(request.getStatus());

                    return TaskMapper.toResponse(taskRepository.save(task));
                }).orElseThrow(IllegalArgumentException::new);
    }

}
