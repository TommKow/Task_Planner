package pl.tp.spring.TaskPlanner.domain.model;

import org.springframework.boot.autoconfigure.batch.BatchProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;
    @NotNull
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "phoneNr")
    private long phoneNumber;
    @Column(name = "salaryPm")
    private double salaryPm;
    @ManyToOne
    @JoinColumn(name = "job_planner_id")
    private JobPlanner jobPlanner;

    public Employee() {
    }

    public Employee(@NotNull String firstName, @NotNull String lastName, String address, long phoneNumber, double salaryPm) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salaryPm = salaryPm;
    }

    public long getId() {
        return id;
    }

    public Employee setId(long id) {
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public Employee setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public double getSalaryPm() {
        return salaryPm;
    }

    public Employee setSalaryPm(double salaryPm) {
        this.salaryPm = salaryPm;
        return this;
    }

    public JobPlanner getJobPlanner() {
        return jobPlanner;
    }

    public Employee setJobPlanner(JobPlanner jobPlanner) {
        this.jobPlanner = jobPlanner;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", jobPlanner=" + jobPlanner +
                '}';
    }
}

