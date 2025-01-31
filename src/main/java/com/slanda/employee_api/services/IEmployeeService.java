package com.slanda.employee_api.services;

import com.slanda.employee_api.dto.EmployeeDTO;
import com.slanda.employee_api.exceptions.EmployeeNotFoundException;
import com.slanda.employee_api.models.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(Long id);
    Employee save(EmployeeDTO employeeDTO);
    Employee update(EmployeeDTO employeeDTO, Long id);
    void delete(Long id);
}
