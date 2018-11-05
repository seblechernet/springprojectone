package com.seb.springprojectone.service;

import com.seb.springprojectone.model.Department;
import com.seb.springprojectone.model.Employee;
import com.seb.springprojectone.repository.DepartmentRepository;
import com.seb.springprojectone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public void run(String... args) throws Exception {

        Employee employee1=new Employee();
        employee1.setFullName("Richel");
        employee1.setJobTitle("Secretory");

        Employee employee2=new Employee();
        employee2.setFullName("Rose");
        employee2.setJobTitle("Manager");

        Employee employee3=new Employee();
        employee3.setFullName("Chandler");
        employee3.setJobTitle("Sales");

        Employee employee4=new Employee();
        employee4.setFullName("Phibi");
        employee4.setJobTitle("Accountant");

        Employee employee5=new Employee();
        employee5.setFullName("Joye");
        employee5.setJobTitle("Department Head");

        Employee employee6=new Employee();
        employee6.setFullName("Monica");
        employee6.setJobTitle("Team Leader");

        Department departmentA=new Department();
        departmentA.setDepName("Engineering Department");
        Set<Employee> employeeSetA=new HashSet<Employee>();
        employeeSetA.add(employee5);
        employeeSetA.add(employee6);
        departmentA.setEmployees(employeeSetA);
        employee5.setDepartment(departmentA);
        employee6.setDepartment(departmentA);


        Department departmentB=new Department();
        departmentB.setDepName("Human Resource Department");
        Set<Employee> employeeSetB=new HashSet<Employee>();
        employeeSetB.add(employee1);
        employeeSetB.add(employee2);
        departmentB.setEmployees(employeeSetB);
        employee1.setDepartment(departmentB);
        employee2.setDepartment(departmentB);

        Department departmentC=new Department();
        departmentC.setDepName("Finance Department");
        Set<Employee> employeeSetC=new HashSet<Employee>();
        employeeSetC.add(employee3);
        employeeSetC.add(employee4);
        departmentC.setEmployees(employeeSetC);
        employee3.setDepartment(departmentC);
        employee4.setDepartment(departmentC);

        departmentRepository.save(departmentA);
        departmentRepository.save(departmentB);
        departmentRepository.save(departmentC);


        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        employeeRepository.save(employee5);
        employeeRepository.save(employee6);



    }

}
