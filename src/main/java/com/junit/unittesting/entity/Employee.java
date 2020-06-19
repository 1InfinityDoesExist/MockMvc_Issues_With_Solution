package com.junit.unittesting.entity;

import java.io.Serializable;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@lombok.Data
public class Employee implements Serializable {

  public Employee() {
    // TODO Auto-generated constructor stub
  }


  public Employee(String id, String name, String email, long height, String age) {
    super();
    this.id = id;
    this.name = name;
    this.email = email;
    this.height = height;
    this.age = age;
  }


  private String id;
  private String name;
  private String email;
  private long height;
  private String age;

}
