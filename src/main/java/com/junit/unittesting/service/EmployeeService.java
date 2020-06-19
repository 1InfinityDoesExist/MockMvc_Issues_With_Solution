package com.junit.unittesting.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.junit.unittesting.entity.Employee;

@Service
public interface EmployeeService {

  public Employee createEmpoyee(Employee empoyee);

  public Employee getEmployeeById(String id);

  public List<Employee> getAllEmpoyee();

  public void deleteEmployee(String id);

  public Employee updateEmployee(String id, Employee employee);

}
