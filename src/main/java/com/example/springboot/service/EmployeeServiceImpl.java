package com.example.springboot.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.dto.EmployeeVo;
import com.example.springboot.exception.ResourceNotFoundException;
import com.example.springboot.mapper.EmployeeMapper;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.repository.SearchRepository;

import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j
public class EmployeeServiceImpl implements IEmployeeService{
    private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private SearchRepository searchRepository;
	@Autowired
	private EmployeeMapper mapper;
	
	@SuppressWarnings("unchecked")
	public List<EmployeeDto> allEmployees(){
		logger.info(" Entered into allEmployees  Method : EmployeeServiceImpl testing");
		List<Employee> emp =  employeeRepository.findAll();
		List<EmployeeDto> empDto =  (List<EmployeeDto>) mapper.mapAllListToDto(emp,EmployeeDto.class); 
		return empDto;
	}
	
	public EmployeeDto employeeById(Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		if(employee != null && employee.getId() >0) {
			return mapper.convertEmployeeEntityToDto(employee);
		}
		return null;
	}
	
	public EmployeeDto createEmployee(EmployeeDto employeeDto) throws ResourceNotFoundException {
		logger.info(" Entered into createEmployee  Method : EmployeeServiceImpl");
		if(employeeDto != null && employeeDto.getId() >0) {
			Employee employee = employeeRepository.findById(employeeDto.getId())
					.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeDto.getId()));
			EmployeeDto requestDto = mapper.convertEmployeeEntityToDto(employee);
			
			requestDto.setEmailId(employeeDto.getEmailId());
			requestDto.setLastName(employeeDto.getLastName());
			requestDto.setFirstName(employeeDto.getFirstName());
			requestDto.setEmpSalary(employeeDto.getEmpSalary());
			Employee response = employeeRepository.save(employee);
			
			logger.info(" Upated the Employee Details in createEmployee Method : EmployeeServiceImpl"+ response.getId());
			return mapper.convertEmployeeEntityToDto(response);
		}else {
			Employee employee =  mapper.convertEmployeeDtoToEntity(employeeDto);
			Employee response = employeeRepository.save(employee);
			logger.info(" Saved the new Employee Details in createEmployee Method : EmployeeServiceImpl"+ response.getId());
			return mapper.convertEmployeeEntityToDto(response);
		}
		
	}
	public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
		logger.info(" Entered into deleteEmployee Method in : EmployeeServiceImpl");
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		if(employee != null && employee.getId() >0) {
			employeeRepository.deleteById(employee.getId());
			logger.info(" Deleted the Employee in deleteEmployee Method: EmployeeServiceImpl");
		}
	}
	public void updateEmployeeProfileId(Long employeeId,Long employeeProfileId) {
		employeeRepository.updateEmployeeProfileId(employeeId, employeeProfileId);
	}
	@Override
	public Map<String,List<Employee>> getAllEmployeeByMonthandYear() throws ParseException {
		final Map<String,List<Employee>> map = new HashMap<String,List<Employee>>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		
		List<Employee> list = employeeRepository.getAllEmployeeByMonthandYear();
		if(list != null && !list.isEmpty()) {
			for (Employee emp : list) {
				if(emp.getProfile() != null && emp.getProfile().getJoiningDate() != null) {
					String date = sdf.format(sdf1.parse(emp.getProfile().getJoiningDate().toString()));
					
					List<Employee> mapList = map.get(date);
					
					if(mapList != null && !mapList.isEmpty()) {
						mapList.add(emp);
					}else {
						mapList = new ArrayList<Employee>();
						mapList.add(emp);
						map.put(date, mapList);
					}
				}
			}
		}
		return map;
	}
	
	public List<Employee> getEmployeesByjoiningDate(String startDate,String endDate,String minSal,String maxSal) throws ParseException, JSONException {

		return searchRepository.getEmployeesByjoiningDate(startDate,endDate,minSal,maxSal);
	}
	
	public List<Employee> employeesbyJoiningDate(String startDate,String endDate,String minSal,String maxSal){
		return employeeRepository.employeesbyJoiningDate(startDate, endDate, minSal, maxSal);
		
	}
	
	
	
	public Employee getMatchedVo(List<Employee> list, String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM");
		if(list != null && !list.isEmpty()) {
			for (Employee emp : list) {
				if(emp.getProfile() != null & emp.getProfile().getJoiningDate() != null
						&& sdf.format(emp.getProfile().getJoiningDate()).equals(date)) {
					 return emp;
				}else {
					return null;
				}
			}
		}
		return null;
	}
	
	public List<EmployeeVo> employeeByEmpName(String empName){
		return employeeRepository.employeeByEmpName(empName);
	}
	public List<EmployeeVo> employeeBySalary(String empSal){
		return employeeRepository.employeeBySalary(empSal);
	}
}
