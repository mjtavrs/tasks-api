package dev.marcostavares.tasks_api.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.marcostavares.tasks_api.infrastructure.persistence.TaskRepository;

@Service
public class DeleteTask {

    @Autowired
    private TaskRepository taskRepository;

    public ResponseEntity<String> execute(UUID id) {
        taskRepository.deleteById(id);
        return ResponseEntity.ok().body("Task successfully deleted.");
    }

}
