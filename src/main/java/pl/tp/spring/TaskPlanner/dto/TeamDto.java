package pl.tp.spring.TaskPlanner.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeamDto {
    @NotNull
    @Size(min = 2, max = 20, message = "Wrong data")
    private String name;

    public String getName() {
        return name;
    }

    public TeamDto setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
