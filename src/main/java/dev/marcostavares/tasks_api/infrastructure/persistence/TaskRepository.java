package dev.marcostavares.tasks_api.infrastructure.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.marcostavares.tasks_api.domain.model.TaskStatus;

public interface TaskRepository extends JpaRepository<TaskEntity, UUID> {

    List<TaskEntity> findByStatus(TaskStatus status);

    boolean existsByTitle(String title);

}
