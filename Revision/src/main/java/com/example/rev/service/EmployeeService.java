package com.example.rev.service;

import java.util.List;
import java.util.Optional;

import com.example.rev.entity.Employee;

public interface EmployeeService {

	Employee saveDepartment(Employee emply) throws Exception;

	Employee fectchByDepatmentName(String emplyName);

	List<Employee> fetchAllDeparmtent();

	Optional<Employee> fetchByDepartmentID(Long emplyID);
	
	Employee updateEmployeeDetails(Long emplyID,Employee employee);
}
