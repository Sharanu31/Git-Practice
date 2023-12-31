package com.example.rev.serviceImp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.rev.entity.Department;
import com.example.rev.repository.DepartmentRepository;
import com.example.rev.service.DepartmentService;

@Service
public class DepartmentServiceImp implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department dept) {
		if (!StringUtils.hasLength(dept.getDeptName())) {
			throw new IllegalArgumentException("Deparment name should not be empty");
		}
		Optional<Department> duplicate = Optional.ofNullable(departmentRepository.findBydeptName(dept.getDeptName()));
		if (!duplicate.isEmpty()) {
			throw new IllegalArgumentException("Deparment with " + dept.getDeptName() + "  already exist");
		}

		return departmentRepository.save(dept);
	}

	@Override
	public Department fectchByDepatmentName(String deptName) {
		if (!StringUtils.hasLength(deptName)) {
			throw new IllegalArgumentException("Department name should not be empty");
		}
		return departmentRepository.findBydeptName(deptName);
	}

	@Override
	public List<Department> fetchAllDeparmtent() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchByDepartmentID(Long deparmtentID) {
		return departmentRepository.findByid(deparmtentID);
	}

	@Override
	public Department updateDepartmentByID(Long deparmtentID, Department dept) {
		Department dbDepartment = departmentRepository.findById(deparmtentID).get();
		if (dbDepartment.getId().equals(deparmtentID)) {
			if (Objects.nonNull(dept.getDeptName()) && !"".equalsIgnoreCase(dept.getDeptName())) {
				dbDepartment.setDeptName(dept.getDeptName());
			}
		}

		return departmentRepository.save(dbDepartment);
	}

}
