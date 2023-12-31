package com.example.rev.serviceImp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.rev.entity.Employee;
import com.example.rev.repository.EmployeeRepository;
import com.example.rev.service.EmployeeService;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveDepartment(Employee emply) throws Exception {

		Optional<Employee> duplicate = Optional
				.ofNullable(employeeRepository.findByempFirstName(emply.getEmpFirstName()));
		if (!duplicate.isEmpty()) {
			throw new IllegalArgumentException("Employee with name " + emply.getEmpFirstName() + " already exist");
		}

		if (!StringUtils.hasLength(emply.getEmpFirstName())) {
			throw new IllegalArgumentException("Employee with name should not be empty");

		}
		return employeeRepository.save(emply);
	}

	@Override
	public Employee fectchByDepatmentName(String emplyName) {
		return employeeRepository.findByempFirstName(emplyName);
	}

	@Override
	public List<Employee> fetchAllDeparmtent() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> fetchByDepartmentID(Long emplyID) {
		return employeeRepository.findById(emplyID);
	}

	@Override
	public Employee updateEmployeeDetails(Long emplyID, Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(employee.getId());
		if (emp.isPresent()) {
			if (Objects.nonNull(employee.getEmpLastName()) && !"".equalsIgnoreCase(employee.getEmpLastName())) {
				emp.get().setEmpLastName(employee.getEmpLastName());
			}
			if (Objects.nonNull(employee.getEmpFirstName()) && !"".equalsIgnoreCase(employee.getEmpFirstName())) {
				emp.get().setEmpFirstName(employee.getEmpFirstName());
			}
		}
		return employeeRepository.save(emp.get());
	}

}
