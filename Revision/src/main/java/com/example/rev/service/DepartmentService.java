package com.example.rev.service;

import java.util.List;

import com.example.rev.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department dept);

	Department fectchByDepatmentName(String deptName);

	List<Department> fetchAllDeparmtent();

	Department fetchByDepartmentID(Long deparmtentID);
	
	Department updateDepartmentByID(Long deparmtentID,Department dept);

}
