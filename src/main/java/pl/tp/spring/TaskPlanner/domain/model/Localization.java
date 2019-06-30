package pl.tp.spring.TaskPlanner.domain.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Proxy(lazy = false)
@Entity
@Table(name = "localizations")
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "account", unique = true)
    private Long account;
    @OneToMany(mappedBy = "localizations", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<JobPlanner> jobPlanner = new ArrayList<>();

    public Localization() {
    }

    public Localization(@NotNull String name, @NotNull long account) {
        this.name = name;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public Localization setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Localization setName(String name) {
        this.name = name;
        return this;
    }

    public Long getAccount() {
        return account;
    }

    public Localization setAccount(Long account) {
        this.account = account;
        return this;
    }

    public List<JobPlanner> getJobPlanner() {
        return jobPlanner;
    }

    public Localization setJobPlanner(List<JobPlanner> jobPlanner) {
        this.jobPlanner = jobPlanner;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Localization that = (Localization) o;
        return id == that.id &&
                account == that.account &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, account);
    }

    @Override
    public String toString() {
        return "Localization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account=" + account +
                ", jobPlanner=" + jobPlanner +
                '}';
    }
}


