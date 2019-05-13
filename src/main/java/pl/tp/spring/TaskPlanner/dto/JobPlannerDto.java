package pl.tp.spring.TaskPlanner.dto;

import pl.tp.spring.TaskPlanner.domain.model.JobPlanner;

import java.time.LocalDateTime;

public class JobPlannerDto {
    private String description;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime updated;

    public String getDescription() {
        return description;
    }

    public JobPlannerDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public JobPlannerDto setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public JobPlannerDto setUpdated(LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

}
