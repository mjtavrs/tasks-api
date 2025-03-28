package dev.marcostavares.tasks_api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.tasks_api.domain.model.TaskStatus;
import dev.marcostavares.tasks_api.dtos.response.TaskResponse;
import dev.marcostavares.tasks_api.infrastructure.persistence.TaskRepository;
import dev.marcostavares.tasks_api.mapper.TaskMapper;

@Service
public class ListTasksByStatus {

    @Autowired
    private TaskRepository taskRepository;

    public List<TaskResponse> execute(TaskStatus status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());

    }

}
