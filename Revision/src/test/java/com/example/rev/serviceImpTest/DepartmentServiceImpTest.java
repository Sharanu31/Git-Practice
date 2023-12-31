package com.example.rev.serviceImpTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.rev.entity.Department;
import com.example.rev.service.DepartmentService;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DepartmentServiceImpTest {

	@Autowired
	private DepartmentService departmentService;

	@Test
	@Disabled
	void creatingDepartment() {
		Department inputDepartment = Department.builder().deptName("Tenjin Adapter").build();

		Department outputDepartment = departmentService.saveDepartment(inputDepartment);

		assertEquals("Tenjin Adapter", outputDepartment.getDeptName());
	}

	@Test
	@Disabled
	void creatingDepartmentAndtoCheckWetherItWillthrowExceptionWhenSameIsPassed() {
		Department inputDepartment = Department.builder().deptName("Tenjin Adapter").build();

		Department outputDepartment = departmentService.saveDepartment(inputDepartment);

		assertThrows(IllegalArgumentException.class, () -> departmentService.saveDepartment(outputDepartment));
	}

	@Test
	@Disabled
	void toCheckWetherItWIllThorwIllegalArgumentExceptioWhenEmptyDeprtnameIsPAssed() {
		Department inputDepartment = Department.builder().deptName("").build();

		assertThrows(IllegalArgumentException.class, () -> departmentService.saveDepartment(inputDepartment));

	}

	@Test
	@Disabled
	void fetchingTocheckWetherItWIllFetchByName() {
		Department inputDepartment = Department.builder().deptName("Tenjin Adapter").build();
		departmentService.saveDepartment(inputDepartment);

		Department fectDept = departmentService.fectchByDepatmentName(inputDepartment.getDeptName());

		assertEquals("Tenjin Adapter", fectDept.getDeptName());

	}

	@Test
	@Disabled
	void throwIllegalArgumtnExceptionWhenNullvalueIsPassed() {
		Department inputDepartment = Department.builder().deptName("Tenjin Adapter").build();
		departmentService.saveDepartment(inputDepartment);
		assertThrows(IllegalArgumentException.class, () -> departmentService.fectchByDepatmentName(null));

	}

	@Test
	@Disabled
	void fetchingAllDepartment() {
		departmentService.saveDepartment(inputDepartment());
		departmentService.saveDepartment(inputDepartment1());
		assertTrue(departmentService.fetchAllDeparmtent().size() > 0);
	}

	@Test
	void toCheckUpdateWorksOrnot() {
		departmentService.saveDepartment(inputDepartment());
		departmentService.saveDepartment(inputDepartment1());
		long dpetID = 2;
		Department inputDepartment = Department.builder().deptName("Tenjin Adapter").build();

		Department updateddept = departmentService.updateDepartmentByID(dpetID, inputDepartment);

		assertEquals("Tenjin Adapter", updateddept.getDeptName());

	}

	public Department inputDepartment() {
		Department inputDp = new Department();
		inputDp.setId(1L);
		inputDp.setDeptName("QA Trainee");
		return inputDp;

	}

	public Department inputDepartment1() {
		Department inputDp = new Department();
		inputDp.setId(2L);
		inputDp.setDeptName("Software Trainee");
		return inputDp;

	}

}
