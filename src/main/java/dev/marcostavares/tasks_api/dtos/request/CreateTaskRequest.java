package dev.marcostavares.tasks_api.dtos.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CreateTaskRequest {

    @NotBlank(message = "The task must have a title.")
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String description;

    @NotNull(message = "The user must inform a due date to the task.")
    @Future(message = "The due date must be in the future.")
    @Getter
    @Setter
    private LocalDateTime dueDate;
}
