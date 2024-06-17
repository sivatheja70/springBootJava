package com.example.springboot.springbootcrudexample;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface H2TestRepo extends JpaRepository<Employee,Long> {
}
