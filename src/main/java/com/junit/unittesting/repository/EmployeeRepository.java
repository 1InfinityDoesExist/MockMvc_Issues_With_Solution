package com.junit.unittesting.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.junit.unittesting.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

  public Employee getEmployeeById(String id);

}
