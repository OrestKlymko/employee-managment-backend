package net.java.backend.controller;


import net.java.backend.exception.EmployeeNotFound;
import net.java.backend.model.Employee;
import net.java.backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins = {"*"})
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable long id) {
		try {
			return ResponseEntity.ok(employeeService.getEmployeeById(id));
		} catch (EmployeeNotFound e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.createEmployee(employee));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
		try {
			return ResponseEntity.ok(employeeService.updateEmployee(id,employee));
		} catch (EmployeeNotFound e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable long id) {
		try {
			employeeService.deleteEmployee(id);
			return ResponseEntity.ok("Success deleted");
		} catch (EmployeeNotFound e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
