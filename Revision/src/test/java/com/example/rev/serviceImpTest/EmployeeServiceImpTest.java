package com.example.rev.serviceImpTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.rev.entity.Employee;
import com.example.rev.service.EmployeeService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class EmployeeServiceImpTest {

	@Autowired
	private EmployeeService employeeService;

	@Test
	void creatingEmployeeDetails() throws Exception {
		Employee inputEmployee = Employee.builder().empFirstName("Sharanu").empLastName("gouda").build();

		Employee outputEmployee = employeeService.saveDepartment(inputEmployee);

		assertEquals("Sharanu", outputEmployee.getEmpFirstName());

	}
	
	@Test
	void throwAnExceptionWhenDuplicateEmpFirstNameCreated() throws Exception {
		Employee inputEmployee = Employee.builder().empFirstName("Sharanu").empLastName("gouda").build();

		Employee outputEmployee = employeeService.saveDepartment(inputEmployee);

		assertEquals("Sharanu", outputEmployee.getEmpFirstName());

	}
	

}