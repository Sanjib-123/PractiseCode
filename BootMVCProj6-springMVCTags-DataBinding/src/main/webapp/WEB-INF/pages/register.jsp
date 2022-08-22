<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:green;text-align:center">EMPLOYEE FORM REGISTRATION FORM</h1>

<form:form modelAttribute="emp">
 <table align="center" bgcolor="cyan">
  <tr><td>EMPLOYEE NUMBER::</td><td><form:input path="eno"/></td></tr>
   <tr><td>EMPLOYEE NAME::</td><td><form:input path="ename"/></td></tr>
    <tr><td>EMPLOYEE ADDRS::</td><td><form:input path="eadd"/></td></tr>
     <tr><td>EMPLOYEE SALARY::</td><td><form:input path="salary"/></td></tr>
     <tr><td colspan="2"><input type="submit" value="register"></td></tr>
 </table>
</form:form>