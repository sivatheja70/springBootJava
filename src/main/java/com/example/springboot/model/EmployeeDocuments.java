package com.example.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_employee_documents")
public class EmployeeDocuments {

	private Integer docId;
	private String docName;
	private String docLocation;
	private Integer empId;
	
	public EmployeeDocuments() {
		
	}
	public EmployeeDocuments(Integer docId, String docName, String docLocation,Integer empId) {
		this.docId = docId;
		this.docName = docName;
		this.docLocation = docLocation;
		this.empId = empId;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="doc_id")
	public Integer getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	@Column(name="doc_name")
	public String getDocName() {
		return docName;
	}
	
	public void setDocName(String docName) {
		this.docName = docName;
	}
	@Column(name="doc_location")
	public String getDocLocation() {
		return docLocation;
	}
	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	}
	@Column(name="emp_id")
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "EmployeeDocuments [docId=" + docId + ", docName=" + docName + ", docLocation=" + docLocation
				+ ", empId=" + empId + "]";
	}
	
}
