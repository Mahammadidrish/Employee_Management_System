package net.javaguides.ems.service.impl;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.EmployeeDto;
import net.javaguides.ems.entity.Employee;
import net.javaguides.ems.exception.ResourceNotFoundException;
import net.javaguides.ems.repository.EmployeeRepository;
import net.javaguides.ems.mapper.EmployeeMapper;
import net.javaguides.ems.service.EmployeeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        // Convert DTO to Entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        // Save Entity to DB
        Employee savedEmployee = employeeRepository.save(employee);
        // Convert Entity to DTO
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        // Find employee by ID, throw if not found
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));
        // Convert Entity to DTO
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        // Fetch all employees from the repository
        List<Employee> employees = employeeRepository.findAll();
        // Convert List of Entities to List of DTOs
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId)
            .orElseThrow(() -> 
                new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));
        
        // Update fields
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        // Save updated entity
        Employee updatedEmployeeObj = employeeRepository.save(employee);

        // Convert Entity to DTO
        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> 
            new ResourceNotFoundException("Employee does not exist with the given id: " + employeeId));

            employeeRepository.deleteById(employeeId);
    }
}
