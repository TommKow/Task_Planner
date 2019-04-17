package pl.tp.spring.TaskPlanner.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "localizations")
public class Localization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;
    @NotNull
    @Column(name = "account")
    private long account;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    public Localization() {
    }

    public Localization(@NotNull String name, @NotNull long account) {
        this.name = name;
        this.account = account;
    }

    public long getId() {
        return id;
    }

    public Localization setId(long id) {
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

    public long getAccount() {
        return account;
    }

    public Localization setAccount(long account) {
        this.account = account;
        return this;
    }

    public Job getJob() {
        return job;
    }

    public Localization setJob(Job job) {
        this.job = job;
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
                ", job=" + job +
                '}';
    }
}
