package com.example.springboot.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.example.springboot.dto.EmployeeDto;
import com.example.springboot.dto.ResponseVo;
import com.example.springboot.model.Employee;
import com.example.springboot.model.User;
@Component
public class EmployeeMapper {
	
    private static final ModelMapper modelMapper;
    static {
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }
    public EmployeeDto convertEmployeeEntityToDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto("chandrika", "bellamkonda", "test@gmail.com", 79000);
		if(employee != null) {
			 modelMapper.map(employee, employeeDto);
		}
		return employeeDto;
	}
	
    public  Employee convertEmployeeDtoToEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		if(employeeDto != null) 
			 modelMapper.map(employeeDto, employee);
		 return employee;

	}
    public List<?> mapAllListToDto(List<?> source, Class<?> targetClass) {
		
		return source.stream().map(element -> modelMapper.map(element,targetClass)).collect(Collectors.toList());
		
	}

	public ResponseVo mapUser(User createdUser, Class<ResponseVo> class1) {
		return modelMapper.map(createdUser, class1);
	}
	
	/*
	public EmployeeDto mapResourceOrgWithChildEntityToDTO(final Employee resoureorg){
		
		java.lang.reflect.Type dest = new TypeToken<List<EmployeeAddressDto>>(){}.getType();
        List<EmployeeAddressDto> postDTOList = modelMapper.map(source, dest);
        return postDTOList;
        
	   return Optional.ofNullable(resoureorg).map(p->{
	      return p.toBuilder().profile(mapResourceGroupEntityToDTO(p.getResourceGroup())).build();
	   }).orElse(null);
	}
	public EmployeeProfileDto mapResourceGroupEntityToDTO(final EmployeeProfile profile){

		 return Optional.ofNullable(profile).map(EmployeeProfile::EmployeeProfileDto);
	}
		
	@SuppressWarnings("unchecked")
	public  EmployeeDto convertEmployeeEntityToDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		
		if(employee != null) 
			BeanUtils.copyProperties(employee, employeeDto);
		if(employee.getAddr() != null && !employee.getAddr().isEmpty()) 
			employeeDto.setAddr((List<EmployeeAddressDto>) mapAll(employee.getAddr(),EmployeeAddressDto.class));
		if(employee.getProfile() != null)
			modelMapper.map(employee.getProfile(), employeeDto.getProfile());
		
		return employeeDto;
	}
	
	public  EmployeeDto convertEmployeeEntityDetailsToDto(Employee employee) {
		
		return EmployeeDto.builder().id(employee.getId()).firstName(employee.getFirstName()).emailId(employee.getEmailId())
				.build();
		
	}*/
}
