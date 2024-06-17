package com.example.springboot.dto;

import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDocumentsDto {
	private Integer docId;
	private String docName;
	private String docLocation;
	private Integer empId;
	public long getDocId() {
		return docId;
	}
	public void setDocId(Integer docId) {
		this.docId = docId;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getDocLocation() {
		return docLocation;
	}
	public void setDocLocation(String docLocation) {
		this.docLocation = docLocation;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	@Override
	public String toString() {
		return "EmployeeDocumentsDto [docId=" + docId + ", docName=" + docName + ", docLocation=" + docLocation
				+ ", empId=" + empId + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(docId, docLocation, docName, empId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDocumentsDto other = (EmployeeDocumentsDto) obj;
		return docId == other.docId && Objects.equals(docLocation, other.docLocation)
				&& Objects.equals(docName, other.docName) && Objects.equals(empId, other.empId);
	}
	public EmployeeDocumentsDto(Integer docId, String docName, String docLocation, Integer empId) {
		super();
		this.docId = docId;
		this.docName = docName;
		this.docLocation = docLocation;
		this.empId = empId;
	}
	
	public EmployeeDocumentsDto() {
			
	}
}
