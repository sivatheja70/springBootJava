/*
package com.example.springboot.springbootcrudexample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import com.example.springboot.model.EmployeeDocuments;
import com.example.springboot.repository.EmployeeDocumentsRepository;
import com.example.springboot.service.EmployeeDocumentsService;

//@ExtendWith(MockitoExtension.class)
public class EmployeeDocumentsServiceTest {
*/
/*
	@Mock
	private EmployeeDocumentsRepository repo;
	@InjectMocks
	private EmployeeDocumentsService service;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void getEmployeeList() {
		List<EmployeeDocuments> list = new ArrayList<EmployeeDocuments>();

		EmployeeDocuments dt  = new EmployeeDocuments();EmployeeDocuments dt1  = new EmployeeDocuments();
		EmployeeDocuments dt2  = new EmployeeDocuments();EmployeeDocuments dt3  = new EmployeeDocuments();

		dt.setDocId(1);dt.setDocName("adhar");dt.setDocLocation("files");dt.setEmpId(1);
		dt1.setDocId(1);dt1.setDocName("adhar");dt1.setDocLocation("files");dt1.setEmpId(1);
		dt2.setDocId(1);dt2.setDocName("adhar");dt2.setDocLocation("files");dt2.setEmpId(1);
		dt3.setDocId(1);dt3.setDocName("adhar");dt3.setDocLocation("files");dt3.setEmpId(1);

		list.add(dt);list.add(dt1);list.add(dt2);list.add(dt3);

		when(repo.findAll()).thenReturn(list);

		List<EmployeeDocuments> emp = service.allEmployeeDocuments();
		assertEquals(4,emp.size());
		verify(repo,times(1)).findAll();
	}
	@Test
	public void TestEmployeeDocumentsByID() { *//*

		//EmployeeDocuments docTes = repo.findByDocId(4);
		*/
/*
		 * OngoingStubbing<EmployeeDocuments> thenReturn = when(repo.findById(4).get());
		 * System.out.println("==========="+thenReturn);
		 *//*

		//thenReturn(new EmployeeDocuments(5,"adhar","files",4))
	*/
/*	List<EmployeeDocuments> list = new ArrayList<EmployeeDocuments>();

		EmployeeDocuments dt  = new EmployeeDocuments(5,"adhar","files",4);
		list.add(dt);
		when(repo.findAll()).thenReturn(list);
		EmployeeDocuments doc = service.employeeDocuemnrsByEmpID(5);

		assertEquals("adhar", doc.getDocName());
		assertEquals("files", doc.getDocLocation());
		assertEquals(4, doc.getEmpId());
	}
	@Test
	public void createEmployeeDocumentsTest() {
		EmployeeDocuments doc = new EmployeeDocuments(7,"pan","newLoc",6);

		service.createEmployeeDocument(doc);
		verify(repo,times(1)).save(doc);
	} *//*

}
*/
