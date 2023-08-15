package com.khadri.spring.mvc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khadri.spring.mvc.dto.EmployeeDTO;
import com.khadri.spring.mvc.entity.Employee;
import com.khadri.spring.mvc.mapper.EmployeeDTOToEntity;

@Component
public class EmployeeDAO {

	@Autowired
	private EmployeeDTOToEntity dtoToEntity;

	private static List<Employee> employees = new ArrayList<>();

	public void createEmployee(EmployeeDTO dto) {

		Employee emp = dtoToEntity.map(dto);
		employees.add(emp);
	}

	public List<EmployeeDTO> listEmployees() {

		Function<Employee, EmployeeDTO> mapper = (emp) -> {
			EmployeeDTO dto = new EmployeeDTO();
			dto.setEmpId(emp.getId());
			dto.setEmpName(emp.getName());
			dto.setEmpSalary(emp.getSalary());

			return dto;
		};

		List<EmployeeDTO> list = employees.stream().map(mapper).collect(Collectors.toList());

		return list;
	}

	public void updateEmpployee(EmployeeDTO employeeDTO) {

		Function<Employee, Employee> function = (emp) -> {

			if (emp.getId().equals(employeeDTO.getEmpId())) {
				emp.setName(employeeDTO.getEmpName());
				emp.setSalary(employeeDTO.getEmpSalary());
			}

			return emp;
		};

		employees.stream().map(function).collect(Collectors.toList());
	}
}
