package pl.tp.spring.TaskPlanner.domain.model;

import org.apache.tomcat.util.digester.ArrayStack;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "job_planner")
public class JobPlanner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "description")
    private String description;
    @Column(name = "created")
    private LocalDateTime created = LocalDateTime.now();
    @Column(name = "updated")
    private LocalDateTime updated;
    @ManyToMany(mappedBy = "jobPlanner", fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
    @OneToMany(mappedBy = "jobPlanner", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Job> jobs = new ArrayList<>();
    @ManyToMany(mappedBy = "jobPlanner", fetch = FetchType.LAZY)
    private List<Localization> localizations = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public JobPlanner() {
    }

    public long getId() {
        return id;
    }

    public JobPlanner setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JobPlanner setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public JobPlanner setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public JobPlanner setUpdated(LocalDateTime updated) {
        this.updated = updated;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public JobPlanner setEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public JobPlanner setJobs(List<Job> jobs) {
        this.jobs = jobs;
        return this;
    }

    public List<Localization> getLocalizations() {
        return localizations;
    }

    public JobPlanner setLocalizations(List<Localization> localizations) {
        this.localizations = localizations;
        return this;
    }

    public User getUser() {
        return user;
    }

    public JobPlanner setUser(User user) {
        this.user = user;
        return this;
    }

    public Team getTeam() {
        return team;
    }

    public JobPlanner setTeam(Team team) {
        this.team = team;
        return this;
    }

    @Override
    public String toString() {
        return "JobPlanner{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

