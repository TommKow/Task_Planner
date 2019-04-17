package pl.tp.spring.TaskPlanner.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "name")
    private String name;

    public Team() {
    }

    public Team(@NotNull String name) {
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

    public Team setName(String name) {
        this.name = name;
        return this;
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
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
