<%@ page import="com.khadri.spring.mvc.entity.Employee" %>

Your result

<% Employee employee = (Employee)request.getAttribute("emp");%>

<table border=2>
  <tr> <th>EMP NO</th> <th>EMP NAME</th> <th>EMP SALARY </th> </tr>
  <tr> <td><%=employee.getId()%></td> <td><%=employee.getName()%></td><td><%=employee.getSalary()%></td> </tr> 
</table>