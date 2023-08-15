package com.khadri.spring.mvc.controller;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.khadri.spring.mvc.form.EmployeeForm;
import com.khadri.spring.mvc.service.EmployeeService;

@Controller
@RequestMapping(path = "curd")
public class CurdEmployeeController {

	// POST/PUT,PATCH,GET,DELETE

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	@ResponseBody
	public ModelAndView getEmployeeById(@RequestParam Integer empId) {
		System.out.println("Search for emp Id : " + empId);

		List<EmployeeForm> listEmployees = employeeService.listEmployees();

		Predicate<EmployeeForm> predicate = (emp) -> {
			return emp.getId().equals(empId);
		};

		EmployeeForm employeeForm = listEmployees.stream().filter(predicate).findFirst().get();

		ModelAndView view = new ModelAndView();
		view.addObject("emp", employeeForm);
		view.setViewName("result");

		return view;
	}

	@GetMapping("/all/employee")
	@ResponseBody
	public ModelAndView getAllEmployee() {
		System.out.println("Search for all employees : ");

		List<EmployeeForm> listEmployees = employeeService.listEmployees();

		Comparator<EmployeeForm> compSort = (e1, e2) -> {

			return -e1.getId().compareTo(e2.getId());

		};

		List<EmployeeForm> sortedList = listEmployees.stream().sorted(compSort).collect(Collectors.toList());

		ModelAndView view = new ModelAndView();
		view.addObject("emp_all", sortedList);
		view.setViewName("result_all");

		return view;
	}

	@PostMapping(value = "/create/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createEmployee(EmployeeForm employeeForm) {
		employeeService.createEmployee(employeeForm);
	}

	@PostMapping("/update/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void updateEmployee(EmployeeForm employeeForm) {
		employeeService.updateEmpployee(employeeForm);
	}

}
