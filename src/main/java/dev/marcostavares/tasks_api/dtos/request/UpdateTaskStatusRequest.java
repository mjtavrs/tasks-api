package dev.marcostavares.tasks_api.dtos.request;

import dev.marcostavares.tasks_api.domain.model.TaskStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateTaskStatusRequest {

    @NotNull(message = "Status is required.")
    private TaskStatus status;

}
