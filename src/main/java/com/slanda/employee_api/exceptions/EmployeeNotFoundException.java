package com.slanda.employee_api.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {}

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
