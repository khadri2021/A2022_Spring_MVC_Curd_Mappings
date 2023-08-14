package com.khadri.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.khadri.spring.mvc.entity.Employee;

@Service
public class EmployeeService {

	public List<Employee> listEmployees() {

		return mapEmployees();
	}

	// Mock employee object
	private List<Employee> mapEmployees() {
		Employee emp1 = new Employee();
		emp1.setId(101);
		emp1.setName("JHON");
		emp1.setSalary(50000.00);

		Employee emp2 = new Employee();
		emp2.setId(102);
		emp2.setName("ALLEN");
		emp2.setSalary(60000.00);

		Employee emp3 = new Employee();
		emp3.setId(103);
		emp3.setName("JHON");
		emp3.setSalary(50000.00);

		Employee emp4 = new Employee();
		emp4.setId(104);
		emp4.setName("GIRIDHAR");
		emp4.setSalary(90000.00);

		Employee emp5 = new Employee();
		emp5.setId(105);
		emp5.setName("VIKRAM");
		emp5.setSalary(60000.00);

		Employee emp6 = new Employee();
		emp6.setId(106);
		emp6.setName("COSTINE");
		emp6.setSalary(40000.00);

		Employee emp7 = new Employee();
		emp7.setId(107);
		emp7.setName("MIKE");
		emp7.setSalary(50000.00);

		Employee emp8 = new Employee();
		emp8.setId(108);
		emp8.setName("BABAJAN");
		emp8.setSalary(70000.00);

		Employee emp9 = new Employee();
		emp9.setId(109);
		emp9.setName("JEELAN");
		emp9.setSalary(100000.00);

		Employee emp10 = new Employee();
		emp10.setId(110);
		emp10.setName("JHON");
		emp10.setSalary(50000.00);

		return List.of(emp1, emp2, emp4, emp3, emp6, emp5, emp9, emp7, emp8, emp10);
	}

}
