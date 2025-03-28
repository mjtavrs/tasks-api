package dev.marcostavares.tasks_api.interfaces.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.marcostavares.tasks_api.dtos.request.CreateTaskRequest;
import dev.marcostavares.tasks_api.dtos.request.UpdateTaskRequest;
import dev.marcostavares.tasks_api.dtos.request.UpdateTaskStatusRequest;
import dev.marcostavares.tasks_api.dtos.response.TaskResponse;
import dev.marcostavares.tasks_api.services.CreateTask;
import dev.marcostavares.tasks_api.services.DeleteTask;
import dev.marcostavares.tasks_api.services.ListTasks;
import dev.marcostavares.tasks_api.services.UpdateTask;
import dev.marcostavares.tasks_api.services.UpdateTaskStatus;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private CreateTask createTask;

    @Autowired
    private ListTasks listTasks;

    @Autowired
    private UpdateTask updateTask;

    @Autowired
    private UpdateTaskStatus updateTaskStatus;

    @Autowired
    private DeleteTask deleteTask;

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(@RequestBody @Valid CreateTaskRequest request) {
        TaskResponse response = createTask.execute(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        var tasksList = listTasks.execute();
        return ResponseEntity.ok().body(tasksList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable UUID id,
            @Valid @RequestBody UpdateTaskRequest request) {
        TaskResponse response = updateTask.execute(id, request);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<TaskResponse> updateTaskStatus(@PathVariable UUID id,
            @Valid @RequestBody UpdateTaskStatusRequest request) {
        TaskResponse response = updateTaskStatus.execute(id, request);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable UUID id) {
        return deleteTask.execute(id);
    }
}
