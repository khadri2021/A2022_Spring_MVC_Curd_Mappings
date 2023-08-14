<%@ page import="com.khadri.spring.mvc.entity.Employee" %>
<%@ page import="java.util.List" %>

Your result

<% List<Employee> listEmployee = (List<Employee>)request.getAttribute("emp_all");%>

<table border=2>
  <tr> <th>EMP NO</th> <th>EMP NAME</th> <th>EMP SALARY </th> </tr>
  <%for(Employee employee : listEmployee) {%>
  
  <tr> <td><%=employee.getId()%></td> <td><%=employee.getName()%></td><td><%=employee.getSalary()%></td> </tr> 
  
  <%}%>
  
</table>