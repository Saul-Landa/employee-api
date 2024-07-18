package com.slanda.employee_api.services.impl;

import com.slanda.employee_api.dto.EmployeeDTO;
import com.slanda.employee_api.exceptions.EmployeeNotFoundException;
import com.slanda.employee_api.models.Employee;
import com.slanda.employee_api.repositories.EmployeeRepository;
import com.slanda.employee_api.services.IEmployeeService;
import com.slanda.employee_api.utils.GlobalVariables;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException(
                        GlobalVariables.EMPLOYEE_NOT_FOUND_MESSAGE + id
                ));
    }

    @Transactional
    @Override
    public Employee save(EmployeeDTO employeeDTO) {
        Employee employee = Employee.builder()
                .name(employeeDTO.getName())
                .position(employeeDTO.getPosition())
                .salary(employeeDTO.getSalary())
                .build();

        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public Employee update(EmployeeDTO employeeDTO, Long id) {
        Employee employee = findById(id);

        employee.setName(employeeDTO.getName());
        employee.setPosition(employeeDTO.getPosition());
        employee.setSalary(employeeDTO.getSalary());

        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        try {
            Employee employee = findById(id);
            employeeRepository.delete(employee);
        } catch (Exception exception) {
            throw new EmployeeNotFoundException(exception.getMessage());
        }
    }
}
