package com.example.springboot.springbootcrudexample;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.dto.EmployeeVo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeTest {
    @LocalServerPort
    private int port;
    private static String baseUrl ="http://localhost";
    @Autowired
    private static  RestTemplate restTemplate;
    @Autowired
    private H2TestRepo h2TestRepo;

    @BeforeAll
    public static void init() {
        restTemplate = new RestTemplate();
    }
    @BeforeEach
    public void setUp(){
        baseUrl = baseUrl.concat(":").concat(port+"").concat("/api/v1/employee");
    }
   @Test
    public void testEmployee(){
       //String request ="{\"firstName\":\"Madhusudhan\",\"lastName\":\"Reddy\",\"emailId\":\"madhu@gmail.com\",\"empSalary\":\"190000\"}";
       EmployeeDto dto = new EmployeeDto("chandrika","bellamkonda","test@gmail.com",79000);
       EmployeeDto response = restTemplate.postForObject(baseUrl,dto,EmployeeDto.class);
       assertEquals(1,h2TestRepo.findAll().size());
    }
    @Test
    public void testEmployeeHighestSal(){
        EmployeeDto dto = new EmployeeDto("chandrika","bellamkonda","test@gmail.com",79000);
        EmployeeDto dto1 = new EmployeeDto("chandrika","bellamkonda","test@gmail.com",99000);
        EmployeeDto dto2 = new EmployeeDto("chandrika","bellamkonda","test@gmail.com",29000);

        List<EmployeeDto> list = new ArrayList<EmployeeDto>();
        list.add(dto);list.add(dto1);list.add(dto2);

        Optional<EmployeeDto> hj = list.stream().sorted(Comparator.comparing(EmployeeDto::getEmpSalary).reversed()).skip(1).findFirst();
        //list.forEach(System.out::println);
       EmployeeDto hjh = list.stream().max(Comparator.comparing(EmployeeDto::getEmpSalary)).get();
        System.out.println(hj.get());
        list.forEach(new Consumer<EmployeeDto>(){

            @Override
            public void accept(EmployeeDto employeeDto) {

            }
        });
    }
}
