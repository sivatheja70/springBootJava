/*
package com.example.springboot.springbootcrudexample;

  import static org.junit.jupiter.api.Assertions.assertEquals;

  import java.util.List;

  import org.junit.Test; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

  import com.example.springboot.model.Employee; import
  com.example.springboot.repository.EmployeeRepository;

  @DataJpaTest
  public class EmployeeRepositoryTest {

  @Autowired private EmployeeRepository employeeRepository;

  @Test public void testFindAll() { List<Employee> list =
  employeeRepository.findAll(); assertEquals(3, list.size()); }

  @Test public void testFindEmployee() { Employee item =
  employeeRepository.findById(2l).get();
  assertEquals("Chandu",item.getFirstName()); } }
*/
