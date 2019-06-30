package pl.tp.spring.TaskPlanner.domain.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
@Proxy(lazy = false)
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
    @Column(name = "account", unique = true)
    private Long account;
    @OneToMany(mappedBy = "job", cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<JobPlanner> jobPlanner;

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

    public List<JobPlanner> getJobPlanner() {
        return jobPlanner;
    }

    public Job setJobPlanner(List<JobPlanner> jobPlanner) {
        this.jobPlanner = jobPlanner;
        return this;
    }


    @Override
    public String toString() {
        return this.name + " " + this.account;
    }
}
