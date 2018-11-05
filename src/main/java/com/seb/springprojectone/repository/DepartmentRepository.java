package com.seb.springprojectone.repository;

import com.seb.springprojectone.model.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Long> {

    Department findAllByDepName(String depName);
}
