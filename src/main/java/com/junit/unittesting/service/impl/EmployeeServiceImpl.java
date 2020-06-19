package com.junit.unittesting.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.junit.unittesting.entity.Employee;
import com.junit.unittesting.repository.EmployeeRepository;
import com.junit.unittesting.service.EmployeeService;

@Component
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Employee createEmpoyee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee getEmployeeById(String id) {
    return employeeRepository.getEmployeeById(id);
  }

  @Override
  public List<Employee> getAllEmpoyee() {
    return employeeRepository.findAll();
  }

  @Override
  public void deleteEmployee(String id) {
    employeeRepository.deleteById(id);

  }

  @Override
  public Employee updateEmployee(String id, Employee employee) {
    // TODO Auto-generated method stub
    return null;
  }

}
