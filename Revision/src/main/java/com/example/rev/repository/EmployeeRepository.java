package com.example.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rev.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee findByempFirstName(String empFirstName);
	

}
