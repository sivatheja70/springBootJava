package com.example.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "tbl_employee")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "employee_id")
	private long id;
	@Column(name = "employee_name", nullable = false)
	private String firstName;
	@Column(name = "emp_last_name", nullable = false)
	private String lastName;
	@Column(name = "emp_email", nullable = false)
	private String emailId;
	@Column(name = "employee_salary", nullable = false)
	private Integer empSalary;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_profile_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private EmployeeProfile profile;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="employee_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<EmployeeAddress> addr = new ArrayList<EmployeeAddress>();//list
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="employee_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private List<EmployeeDocuments> docs = new ArrayList<EmployeeDocuments>();

	/*public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}

	public EmployeeProfile getProfile() {
		return profile;
	}

	public void setProfile(EmployeeProfile profile) {
		this.profile = profile;
	}

	public List<EmployeeAddress> getAddr() {
		return addr;
	}

	public void setAddr(List<EmployeeAddress> addr) {
		this.addr = addr;
	}

	public List<EmployeeDocuments> getDocs() {
		return docs;
	}

	public void setDocs(List<EmployeeDocuments> docs) {
		this.docs = docs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(addr, docs, emailId, empSalary, firstName, id, lastName, profile);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(addr, other.addr) && Objects.equals(docs, other.docs)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(empSalary, other.empSalary)
				&& Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(profile, other.profile);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId=" + emailId
				+ ", empSalary=" + empSalary + ", profile=" + profile + ", addr=" + addr + ", docs=" + docs + "]";
	}

	*/
	
	//lambook
	//builder pattern
	//toString, equals & hashcode
	 
}
