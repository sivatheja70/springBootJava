package com.example.springboot.springbootcrudexample;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class DemoTestClass {

    @LocalServerPort
    private int port;
    @Autowired
    private MockMvc mockMvc;
    //@Autowired
    //EmployeeRepositoryTest employeeRepositoryTest;
    @Test
    public void givenEmployee_whenPostEmployee_thenStatus200() throws Exception {
        String request ="{\"firstName\":\"Madhusudhan\",\"lastName\":\"Reddy\",\"emailId\":\"madhu@gmail.com\",\"empSalary\":\"190000\"}";
        String url = "http://localhost:".concat(port+"").concat("/api/v1/employee");
        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andDo(print()).andExpect(status().isOk());
    }
}
