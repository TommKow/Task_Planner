package pl.tp.spring.TaskPlanner.domain.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
    private List<JobPlanner> jobPlanners;

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Team setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobPlanner> getJobPlanners() {
        return jobPlanners;
    }

    public Team setJobPlanners(List<JobPlanner> jobPlanners) {
        this.jobPlanners = jobPlanners;
        return this;
    }
    public void removeJobPlanner(JobPlanner jobPlanner) {
        jobPlanners.remove(jobPlanner);
        jobPlanner.setId(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
