package pl.tp.spring.TaskPlanner.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "account")
    private Long account;
    @Column(name = "work_quantity")
    private double workQuantity;
    @ManyToOne
    @JoinColumn(name = "job_planner_id")
    private JobPlanner jobPlanner;
    @ManyToMany
    private List<Localization> localizations;

    public Job() {
    }

    public Job(@NotNull String name, @NotNull Long account) {
        this.name = name;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public Job setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Job setName(String name) {
        this.name = name;
        return this;
    }

    public Long getAccount() {
        return account;
    }

    public Job setAccount(Long account) {
        this.account = account;
        return this;
    }

    public JobPlanner getJobPlanner() {
        return jobPlanner;
    }

    public Job setJobPlanner(JobPlanner jobPlanner) {
        this.jobPlanner = jobPlanner;
        return this;
    }
}
