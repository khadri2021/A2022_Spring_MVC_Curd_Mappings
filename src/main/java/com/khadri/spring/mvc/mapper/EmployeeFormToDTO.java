package com.khadri.spring.mvc.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.dto.EmployeeDTO;
import com.khadri.spring.mvc.form.EmployeeForm;

@Component
public class EmployeeFormToDTO {

	public EmployeeDTO map(EmployeeForm employeeForm) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(employeeForm.getId());
		dto.setEmpName(employeeForm.getName());
		dto.setEmpSalary(employeeForm.getSalary());
		return dto;
	}
}
