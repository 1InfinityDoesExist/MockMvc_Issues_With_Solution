package com.junit.unittesting.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.junit.unittesting.entity.Employee;
import com.junit.unittesting.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;


  @PostMapping(path = "/")
  public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
    Employee response = employeeService.createEmpoyee(employee);

    return new ResponseEntity<Employee>(response, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getEmployeeById(@PathVariable(value = "id", required = true) String id) {
    Employee response = employeeService.getEmployeeById(id);
    return new ResponseEntity<Employee>(response, HttpStatus.OK);
  }

  @GetMapping("/")
  public ResponseEntity<?> getAllEmployee() {
    List<Employee> listOfEmployee = employeeService.getAllEmpoyee();
    return new ResponseEntity<List<Employee>>(listOfEmployee, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteEmployeeById(
      @PathVariable(value = "id", required = true) String id) {
    employeeService.deleteEmployee(id);
    return new ResponseEntity<String>("Successfully Deleted", HttpStatus.OK);
  }


}
