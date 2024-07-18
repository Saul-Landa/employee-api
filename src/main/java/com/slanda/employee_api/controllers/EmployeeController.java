package com.slanda.employee_api.controllers;

import com.slanda.employee_api.dto.EmployeeDTO;
import com.slanda.employee_api.models.Employee;
import com.slanda.employee_api.responses.Response;
import com.slanda.employee_api.services.IEmployeeService;
import com.slanda.employee_api.utils.GlobalVariables;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public ResponseEntity<Response<List<Employee>>> getAll() {
        return ResponseEntity.ok(new Response<>(employeeService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Employee>> getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(new Response<>(employeeService.findById(id)));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError()
                    .body(new Response<>(exception.getMessage(), false));
        }
    }

    @PostMapping("/")
    public ResponseEntity<Response<Employee>> save(@RequestBody EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(new Response<>(employeeService.save(employeeDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Employee>> update(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
        try {
            return ResponseEntity.ok(new Response<>(employeeService.update(employeeDTO, id)));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError()
                    .body(new Response<>(exception.getMessage(), false));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<String>> delete(@PathVariable Long id) {
        try {
            employeeService.delete(id);

            return ResponseEntity.ok(new Response<>(GlobalVariables.EMPLOYEE_DELETE_SUCCESS, true));
        } catch (Exception exception) {
            return ResponseEntity.internalServerError()
                    .body(new Response<>(exception.getMessage(), false));
        }
    }
}
