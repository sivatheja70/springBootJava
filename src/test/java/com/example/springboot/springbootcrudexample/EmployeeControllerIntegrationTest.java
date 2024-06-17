package com.example.springboot.springbootcrudexample;

import com.example.springboot.dto.EmployeeDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private H2TestRepo h2TestRepo;

    @BeforeEach
    void setUp() {
        // You can perform any setup operations here.
    }

    @AfterEach
    void tearDown() {
        // You can perform any cleanup operations here.
    }

    @Test
    @DirtiesContext
    public void testCreateEmployee() throws JsonProcessingException {
        // Create an EmployeeDto object for testing
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setFirstName("John");
        employeeDto.setLastName("Doe");
        // Set other properties as needed

        // Send a POST request to the endpoint
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        ResponseEntity<EmployeeDto> response = restTemplate.exchange(
                "http://localhost:" + port + "/api/v1/employee",
                HttpMethod.POST,
                new HttpEntity<>(objectMapper.writeValueAsString(employeeDto), headers),
                EmployeeDto.class
        );

        // Check the response status
        assertEquals(HttpStatus.OK, response.getStatusCode());

        // Check if the returned EmployeeDto is not null
        assertNotNull(response.getBody());

        // You can perform additional assertions based on your business logic
        // For example, check if the saved data in the database matches the expected values.
    }
}

