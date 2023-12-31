package com.example.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rev.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

	Department findBydeptName(String deptName);
	
	Department findByid(Long id);

}
