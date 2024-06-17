package com.example.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.model.EmployeeDocuments;

@Repository
public interface EmployeeDocumentsRepository extends JpaRepository<EmployeeDocuments, Integer>{
	
	public EmployeeDocuments findByDocId(Integer id);

	public List<EmployeeDocuments> findByDocName(String string);
}
