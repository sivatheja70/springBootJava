package com.example.springboot.streams;

import com.example.springboot.dto.EmployeeVo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streaming {
    public static void main(String[] args) {
        int[] arr = {1,4,5,6,3,8,4,6};
       long sum =  Arrays.stream(arr).filter(n-> n>5).mapToLong(n ->n).sum();
        System.out.println(sum);

        Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

       Stream<Integer> integerStream =  Arrays.stream(arr).boxed();
       integerStream.sorted();


       List<EmployeeVo> list = new ArrayList<EmployeeVo>();
       list.add(new EmployeeVo(33L,"chandrikak"));
       list.add(new EmployeeVo(73L,"Testing"));
       list.add(new EmployeeVo(13L,"Laptop"));
        list.add(new EmployeeVo(13L,"bellamkonda"));

      list.sort(Comparator.comparing(EmployeeVo::getEmpName).reversed());
      list.forEach(System.out::println);

    }
}
