package com.example.springboot.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.Employee;
import com.example.springboot.model.EmployeeProfile;
import com.example.springboot.utils.Utils;
@Repository
public class SearchRepository extends JdbcDaoSupport{
	
	public SearchRepository(DataSource dataSource) {
		setDataSource(dataSource);
	}
	public List<Employee> getEmployeesByjoiningDate(String startDate,String endDate,String minSal,String maxSal){
		List<Employee> returnList = new ArrayList<Employee>();
		Connection conn=null;
		CallableStatement cstmt=null;
		ResultSet rs = null;	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			conn = getJdbcTemplate().getDataSource().getConnection();
			cstmt = conn.prepareCall("call sp_ef_get_employees_between_joiningDate_and_Salary(?,?,?,?)");
			cstmt.setString(1, startDate);
			cstmt.setString(2, endDate);
			cstmt.setString(3, minSal);
			cstmt.setString(4, maxSal);
			
			rs = cstmt.executeQuery();
			if(rs !=null) {
				while(rs.next()) {
					Employee e = new Employee();
					EmployeeProfile p = new EmployeeProfile();
					
					e.setId(Utils.getLongValueForObject(rs.getInt("employee_id")));
					e.setEmailId(Utils.getStringValueForObject(rs.getString("emp_email")));
					e.setEmpSalary(Utils.getIntegerValueForObject(rs.getString("employee_salary")));
					e.setFirstName(Utils.getStringValueForObject(rs.getString("employee_name")));
					e.setLastName(Utils.getStringValueForObject(rs.getString("emp_last_name")));
					p.setProfileId(Utils.getLongValueForObject(rs.getString("fk_profile_id")));
					p.setJoiningDate(sdf1.format(sdf.parse(Utils.getStringValueForObject(rs.getString("joining_date")))));
					
					e.setProfile(p);
					returnList.add(e);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnList;
	}
}
