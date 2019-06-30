package pl.tp.spring.TaskPlanner.domain.model;

import org.hibernate.annotations.Proxy;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Proxy(lazy = false)
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    private String address;
    @Column(name = "phoneNr")
    private Long phoneNumber;
    private Double salaryPm;
    @ManyToMany(mappedBy = "employees")
    private List<JobPlanner> jobPlanner;

    public Employee() {
    }
    public Employee(@NotNull String firstName, @NotNull String lastName, String address, long phoneNumber, double salaryPm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salaryPm = salaryPm;
    }

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Employee setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public Employee setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Double getSalaryPm() {
        return salaryPm;
    }

    public Employee setSalaryPm(Double salaryPm) {
        this.salaryPm = salaryPm;
        return this;
    }

    public List<JobPlanner> getJobPlanner() {
        return jobPlanner;
    }

    public Employee setJobPlanner(List<JobPlanner> jobPlanner) {
        this.jobPlanner = jobPlanner;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                phoneNumber == employee.phoneNumber &&
                Double.compare(employee.salaryPm, salaryPm) == 0 &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(address, employee.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}


