package com.seb.springprojectone.controller;

import com.seb.springprojectone.model.Department;
import com.seb.springprojectone.model.Employee;
import com.seb.springprojectone.repository.DepartmentRepository;
import com.seb.springprojectone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("/")
    public String showEmployeeAndDepartment(Model model) {

        model.addAttribute("departments", departmentRepository.findAll());
        return "index";
    }

    @RequestMapping("/adddepartment")
    public String addDepartment(Model model) {


        model.addAttribute("department", new Department());
        return "adddepartment";
    }

    @PostMapping("/savedepartment")
    public String saveDepartment(Department department) {

        departmentRepository.save(department);

        return "redirect:/";

    }

    @RequestMapping("/addemployee")
    public String addEmployee(HttpRequest request,Model model) {

        if (request.)


        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", departmentRepository.findAll());

        return "addemployee";
    }

    @PostMapping("/saveemployee")
    public String saveEmployee(@RequestParam String name, String jobTitle, Employee employee, String namedep, Department department) {

        employee.setFullName(name);
        employee.setJobTitle(jobTitle);

        department = departmentRepository.findAllByDepName(namedep);
        employee.setDepartment(department);
        employeeRepository.save(employee);


        return "redirect:/";

    }
}
