package pl.tp.spring.TaskPlanner.dto;

import javax.validation.constraints.NotNull;

public class LocalizationDto {
    @NotNull
    private String name;
    @NotNull
    private Long account;

    public String getName() {
        return name;
    }

    public LocalizationDto setName(String name) {
        this.name = name;
        return this;
    }

    public Long getAccount() {
        return account;
    }

    public LocalizationDto setAccount(Long account) {
        this.account = account;
        return this;
    }
}
