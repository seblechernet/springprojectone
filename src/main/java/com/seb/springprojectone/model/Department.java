package com.seb.springprojectone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long depId;
    private String depName;


    @JsonIgnore
    @OneToMany(mappedBy = "department" ,cascade = CascadeType.ALL)

    private Set<Employee> employees;

    public Department() {
        employees=new HashSet<>();
    }

    public Department(String depName) {
        this.depName = depName;
        employees=new HashSet<>();
    }

    public long getDepId() {
        return depId;
    }

    public void setDepId(long depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee empployee){
        this.employees.add(empployee);
    }
}
