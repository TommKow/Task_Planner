package pl.tp.spring.TaskPlanner.domain.model;

import org.apache.tomcat.util.digester.ArrayStack;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.transaction.Transactional;


@Entity
@Table(name = "jobplanner")
public class    JobPlanner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;
    @Column(name = "work_quantity")
    private Double workQuantity;
    @Column(name = "created")
    private LocalDateTime created = LocalDateTime.now();
    @Column(name = "updated")
    private LocalDateTime updated;
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name ="jobplanner_employee",
            joinColumns = {@JoinColumn(name = "jobplanner_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private List<Employee> employees = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "localization_id")
    private Localization localizations;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public JobPlanner() {
    }

    public Long getId() {
        return id;
    }

    public JobPlanner setId(Long id) {
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

    public Job getJob() {
        return job;
    }

    public JobPlanner setJob(Job job) {
        this.job = job;
        return this;
    }

    public Localization getLocalizations() {
        return localizations;
    }

    public JobPlanner setLocalizations(Localization localizations) {
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

    public Double getWorkQuantity() {
        return workQuantity;
    }

    public JobPlanner setWorkQuantity(Double workQuantity) {
        this.workQuantity = workQuantity;
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

