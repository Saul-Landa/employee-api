package com.slanda.employee_api.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.slanda.employee_api.dto.EmployeeDTO;
import com.slanda.employee_api.models.Employee;
import com.slanda.employee_api.repositories.EmployeeRepository;
import com.slanda.employee_api.services.impl.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;

    private EmployeeDTO employeeDTO;

    @BeforeEach
    void setUp() {
        employeeDTO = new EmployeeDTO(
                "Saúl Landa",
                "Developer",
                20000.0);
    }

    @Test
    void findAllTest() {
        List<Employee> employees = Arrays.asList(
                Employee.builder()
                        .id(1L).name("Saúl García").position("Developer").salary(15000).build(),
                Employee.builder()
                        .id(2L).name("Gustavo Luna").position("Designer").salary(15000).build()
        );

        given(employeeRepository.findAll()).willReturn(employees);

        List<Employee> employeesResult = employeeService.findAll();

        assertThat(employeesResult).isNotNull();
        assertThat(employeesResult.size()).isEqualTo(2);
    }

    @Test
    void findById() {
        Employee employee = Employee.builder()
                .id(1L)
                .name("Saúl García")
                .position("Developer")
                .salary(20000.0)
                .build();

        given(employeeRepository.findById(1L)).willReturn(Optional.of(employee));

        Employee employeeSaved = employeeService.findById(employee.getId());

        assertThat(employeeSaved).isNotNull();
    }

    @Test
    void updateTest() {
        String NAME = "Saúl Landa Edited";
        String POSITION = "Developer Jr";
        Long id = 1L;
        Employee employee = Employee.builder()
                .id(id)
                .name(NAME)
                .position(POSITION)
                .salary(20000.0)
                .build();

        given(employeeRepository.findById(id)).willReturn(Optional.of(employee));
        given(employeeRepository.save(employee)).willReturn(employee);
        employeeDTO.setName(NAME);
        employeeDTO.setPosition(POSITION);

        Employee employeeUpdated = employeeService.update(employeeDTO, id);

        assertThat(employeeUpdated.getName()).isEqualTo(NAME);
        assertThat(employeeUpdated.getPosition()).isEqualTo(POSITION);
    }
}
