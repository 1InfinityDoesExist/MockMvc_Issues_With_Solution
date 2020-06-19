package com.junit.unittesting.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.junit.unittesting.entity.Employee;
import com.junit.unittesting.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {



  @MockBean
  private EmployeeService employeeService;

  // @Test
  // public void createEmployee() throws Exception {
  // RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/employee/")
  // .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(
  // "{\"id\":\"\",\"name\":\"Avinash
  // Patel\",\"email\":\"avinash.patel@gmail.com\",\"height\":10,\"age\":\"25\"}");
  // employeeService.createEmpoyee(new Employee(null, "avinash", "patel@gmail.com", 10, "25"));
  // MvcResult mvcResult =
  // mockMvc.perform(requestBuilder).andExpect(status().isCreated()).andReturn();
  // ResponseEntity<Employee> response = mvcResult.getResponse().getContentAsString();
  //
  // }



  @Autowired
  private MockMvc mvc;

  @Test
  public void createEmployeeAPI() throws Exception {
    mvc.perform(MockMvcRequestBuilders.post("/api/employee/")
        .content(asJsonString(new Employee(null, "firstName4", "email4@mail.com", 10, "2")))
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
