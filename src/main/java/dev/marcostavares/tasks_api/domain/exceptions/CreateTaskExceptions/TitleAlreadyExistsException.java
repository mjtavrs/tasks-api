package dev.marcostavares.tasks_api.domain.exceptions.CreateTaskExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class TitleAlreadyExistsException extends RuntimeException {
    public TitleAlreadyExistsException() {
        super("There is a task with this title.");
    }
}
