package com.khadri.spring.mvc.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.dao.EmployeeDAO;
import com.khadri.spring.mvc.dto.EmployeeDTO;
import com.khadri.spring.mvc.form.EmployeeForm;
import com.khadri.spring.mvc.mapper.EmployeeFormToDTO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Autowired
	private EmployeeFormToDTO formToDTO;

	public void createEmployee(EmployeeForm employeeForm) {

		EmployeeDTO dtoEmployee = formToDTO.map(employeeForm);
		
		dao.createEmployee(dtoEmployee);
	}

	public void updateEmpployee(EmployeeForm employeeForm) {

		EmployeeDTO dtoEmployee = formToDTO.map(employeeForm);

		dao.updateEmpployee(dtoEmployee);
	}

	public List<EmployeeForm> listEmployees() {

		Function<EmployeeDTO, EmployeeForm> mapper = (empDto) -> {
			EmployeeForm form = new EmployeeForm();
			form.setId(empDto.getEmpId());
			form.setName(empDto.getEmpName());
			form.setSalary(empDto.getEmpSalary());
			return form;
		};

		List<EmployeeForm> listForm = dao.listEmployees().stream().map(mapper).collect(Collectors.toList());

		return listForm;
	}

}
