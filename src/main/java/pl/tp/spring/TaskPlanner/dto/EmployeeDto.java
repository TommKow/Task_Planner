package pl.tp.spring.TaskPlanner.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeDto {
    @NotNull
    @Size(min = 3, max = 20, message = "Wrong data")
    private String firstName;
    @NotNull
    @Size(min = 2, max = 20, message = "Wrong data")
    private String lastName;
    @NotBlank
    private String address;
    private Long phoneNumber;
    private Double salaryPm;

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeDto setAddress(String address) {
        this.address = address;
        return this;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public EmployeeDto setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Double getSalaryPm() {
        return salaryPm;
    }

    public EmployeeDto setSalaryPm(Double salaryPm) {
        this.salaryPm = salaryPm;
        return this;
    }
}
