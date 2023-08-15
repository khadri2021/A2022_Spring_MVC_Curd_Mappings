package com.khadri.spring.mvc.mapper;

import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.dto.EmployeeDTO;
import com.khadri.spring.mvc.entity.Employee;

@Component
public class EmployeeDTOToEntity {

	public Employee map(EmployeeDTO employeeDTO) {
		Employee dto = new Employee();
		dto.setId(employeeDTO.getEmpId());
		dto.setName(employeeDTO.getEmpName());
		dto.setSalary(employeeDTO.getEmpSalary());
		return dto;
	}
}
