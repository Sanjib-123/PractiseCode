<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <h1 style="color:red;text-align:center">READING SIMPLE VALUES</h1>
<b> name::${name}</b><br>
<b> age::${age}</b><br>
<b> address::${addrs}</b><br> --%>


<%-- c
<b>NICK NAMES(array)::</b>
<c:forEach var="name" items="${nickNames}">
 ${name}<br>
</c:forEach>
<hr>
<b>Phone number(set) ::</b>
<c:forEach var="ph" items="${phonesInfo}">
 ${ph}<br>
</c:forEach>
<hr>
<b>Ids info(Map)::</b>
<c:forEach var="id" items="${idsInfo}">
 ${id.key}===>${id.value}<br>
</c:forEach> --%>

<h1 style="color:red;text-align:center">READING Lst of model objects</h1>

<table border="1" align="center">
  <tr>
    <th>eno</th><th>ename</th><th>addrs</th><th>salary</th>  
  </tr>
</table>
<c:forEach var="emp" items="${empInfo}">
  <tr>
   <td>${emp.eno}</td>
   <td>${emp.ename}</td>
   <td>${emp.desg}</td>
   <td>${emp.salary}</td>
  </tr>
</c:forEach>

