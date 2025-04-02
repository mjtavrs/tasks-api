package dev.marcostavares.tasks_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.marcostavares.tasks_api.domain.exceptions.CreateTaskExceptions.TitleAlreadyExistsException;
import dev.marcostavares.tasks_api.domain.model.Task;
import dev.marcostavares.tasks_api.dtos.request.CreateTaskRequest;
import dev.marcostavares.tasks_api.dtos.response.TaskResponse;
import dev.marcostavares.tasks_api.infrastructure.persistence.TaskEntity;
import dev.marcostavares.tasks_api.infrastructure.persistence.TaskRepository;
import dev.marcostavares.tasks_api.mapper.TaskMapper;

@Service
public class CreateTask {

    @Autowired
    private TaskRepository taskRepository;

    public TaskResponse execute(CreateTaskRequest request) {
        Task task = new Task(request.getTitle(), request.getDescription(), request.getDueDate());

        if (taskRepository.existsByTitle(task.getTitle())) {
            throw new TitleAlreadyExistsException();
        }

        TaskEntity entity = TaskMapper.toEntity(task);
        TaskEntity saved = taskRepository.save(entity);
        return TaskMapper.toResponse(saved);
    }

}
