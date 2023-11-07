package net.java.backend.service;


import net.java.backend.exception.EmployeeNotFound;
import net.java.backend.model.Employee;
import net.java.backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;



	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public void deleteEmployee(long id) throws EmployeeNotFound {
		Employee employeeFind = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("User not found"));
		employeeRepository.delete(employeeFind);
	}

	public Employee getEmployeeById(long id) throws EmployeeNotFound {
		return employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFound("User not found"));
	}

	public Employee updateEmployee(long id, Employee employee) throws EmployeeNotFound {
		Employee employeeFind = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFound("User not found"));
		employeeFind.setEmail(employee.getEmail());
		employeeFind.setFirstName(employee.getFirstName());
		employeeFind.setLastName(employee.getLastName());
		employeeRepository.save(employeeFind);
		return employeeFind;

	}
}
