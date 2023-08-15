<%@ page import="com.khadri.spring.mvc.form.EmployeeForm" %>
<%@ page import="java.util.List" %>

Your result

<% List<EmployeeForm> listEmployee = (List<EmployeeForm>)request.getAttribute("emp_all");%>

<table border=2>
  <tr> <th>EMP NO</th> <th>EMP NAME</th> <th>EMP SALARY </th> </tr>
  <%for(EmployeeForm employee : listEmployee) {%>
  
  <tr> <td><%=employee.getId()%></td> <td><%=employee.getName()%></td><td><%=employee.getSalary()%></td> </tr> 
  
  <%}%>
  
</table>