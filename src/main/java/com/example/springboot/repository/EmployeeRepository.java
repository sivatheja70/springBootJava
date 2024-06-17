package com.example.springboot.repository;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springboot.dto.EmployeeVo;
import com.example.springboot.model.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value =" update tbl_employee set fk_profile_id= :profileId where employee_id=:employeeId",nativeQuery = true)
	@Modifying(clearAutomatically = true)// clear the persistance context and will fetch the latest one
	public void updateEmployeeProfileId(long employeeId,long profileId);
	
	@Query(value=" select  e.* from tbl_employee e left join tbl_employee_profile p "
			+ " on e.fk_profile_id = p.emp_profile_id",nativeQuery = true)
	public List<Employee> getAllEmployeeByMonthandYear();
	
	@Query(nativeQuery = true,value ="call sp_ef_get_employees_between_joiningDate_and_Salary(:in_start_date,:in_end_date,:in_min_sal,:in_max_sal)")
	public List<Employee> employeesbyJoiningDate(@Param("in_start_date") String in_start_date,@Param("in_end_date") String in_end_date,
			@Param("in_min_sal") String in_min_sal,@Param("in_max_sal") String in_max_sal);
	
	@Query(nativeQuery = true, value ="call procemployeeList(:in_emp_name)")
	public List<EmployeeVo> employeeByEmpName(@Param("in_emp_name") String in_emp_name);
	@Transactional
	@Query("SELECT new com.example.springboot.dto.EmployeeVo(e.id,e.firstName) FROM Employee e group by e.firstName")
	public List<EmployeeVo> employeeBySalary(String empSal);
}
