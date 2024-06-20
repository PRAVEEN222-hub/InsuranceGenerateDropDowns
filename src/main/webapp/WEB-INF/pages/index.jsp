<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Welcome to RealTime Project</title>
</head>


<body>
<div class="container">
<h3 class="pb=3 pt=3">Report Generation</h3>
<form:form action="search" method="post" modelAttribute="sh">
<table>
          <tr>
              <td>Plane Name:</td>
                <td>
                    <form:select path="planName">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${names}"/>
                    </form:select>
                </td>
                <td>Plane Status:</td>
                <td>
                    <form:select path="PlanStatus">
                        <form:option value="">-Select-</form:option>
                        <form:options items="${status}"/>
                    </form:select>
                </td>
               <%--  <tr>
                <td>Gender:</td>
     <form:select path="gender">
     <form:option value="">-select-</form:option>
    <form:options value="MALE">Male</form:options>
    <form:options value="FEMALE">Female</form:options>
    <form:options value="OTHER">Other</form:options>
</form:select>

  </tr> --%>
  
     <td>Gender:</td>
                <td>
                    <form:select path="gender">
                        <form:option value="">-select-</form:option>
                        <form:option value="Male">Male</form:option>
                        <form:option value="Female">Female</form:option>
                    </form:select>
                    </td>
                    </tr>
    <tr>                
    <td> Start Date:</td>  
    <td>  
   
<%--     <fmt:formatDate value="${yourObject.date}" var="dateString" pattern="dd/MM/yyyy" /> --%>
    
    <td><form:input type="date" path="startDate"/></td>
   
   
    </td>  
    <td>End Date:</td>         
    <td>
    <form:input path="endDate"  type="date"/>
    </td>
          </tr>
         
          <tr>
              <td>
                  <input type="submit" value="Search"
                   class="btn btn-primary" />
              </td>
          </tr>
      </table>

</form:form>
</div>
<hr/>


<table class="table table-striped table-hover">
<thead>
<tr>
<th>S.NO</th>
<th>Holder Name</th>
<th>Plan Name</th>
<th>Plan Status</th>
<th>Start Date</th>
<th>End Date</th>
</tr>
</thead>

                 <tbody>
 
                    <c:forEach items="${plans}" var="plan" varStatus="index">
          <tr>
         <td>${index.count}</td>
        <td>${plan.userName}</td>
        <td>${plan.planName}</td>
        <td>${plan.planStatus}</td>
        <td>${plan.startDate}</td>
        <td>${plan.endDate}</td>
         </tr>
                        
    </c:forEach>
    <c:if test="${ empty plans}">
    <td colspan="7" style="text-align: center;">No Recoerd Found</td>
    </c:if>
  
  </tbody>
</table>
<hr/>
                Export: <a href="excel">Excel</a>   <a href="pdf">PDF</a>
</body>
</html>