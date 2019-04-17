package pl.tp.spring.TaskPlanner.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "created")
    private LocalDateTime created = LocalDateTime.now();
    @NotNull
    @Column(name = "account")
    private long account;
    @Column(name = "work_quantity")
    private double workQuantity;
    @Column(name = "user_list")
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> userList = new ArrayList<>();
    @Column(name = "team_list")
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Team> teamList = new ArrayList<>();

    public Job() {
    }

    public Job(@NotNull String name, String description, LocalDateTime created, @NotNull long account, double workQuantity, List<User> userList, List<Team> teamList) {
        this.name = name;
        this.description = description;
        this.created = created;
        this.account = account;
        this.workQuantity = workQuantity;
        this.userList = userList;
        this.teamList = teamList;
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

    public String getDescription() {
        return description;
    }

    public Job setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Job setCreated(LocalDateTime created) {
        this.created = created;
        return this;
    }

    public long getAccount() {
        return account;
    }

    public Job setAccount(long account) {
        this.account = account;
        return this;
    }

    public double getWorkQuantity() {
        return workQuantity;
    }

    public Job setWorkQuantity(double workQuantity) {
        this.workQuantity = workQuantity;
        return this;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Job setUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public Job setTeamList(List<Team> teamList) {
        this.teamList = teamList;
        return this;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", account=" + account +
                ", workQuantity=" + workQuantity +
                ", userList=" + userList +
                ", teamList=" + teamList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id &&
                account == job.account &&
                Objects.equals(name, job.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, account);
    }
}
