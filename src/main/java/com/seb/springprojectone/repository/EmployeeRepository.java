package com.seb.springprojectone.repository;

import com.seb.springprojectone.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {
}
