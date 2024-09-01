package net.javaguides.ems.mapper;

import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;

public class EmployeeMapper {
    
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
            employee.getId(),
            employee.getFirstName(), // Ensure this method exists in Employee
            employee.getLastName(),  // Ensure this method exists in Employee
            employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
            employeeDto.getId(),
            employeeDto.getFirstName(), // Ensure this method exists in EmployeeDto
            employeeDto.getLastName(),  // Ensure this method exists in EmployeeDto
            employeeDto.getEmail()
        );
    }

}
