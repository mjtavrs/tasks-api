package dev.marcostavares.tasks_api.dtos.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskRequest {

    private String title;
    private String description;

    @Future(message = "The due date must be in the future.")
    private LocalDateTime dueDate;

}
