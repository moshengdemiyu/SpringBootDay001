<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<fmt:formatDate value="<%=new java.util.Date()%>" pattern="yyyy-MM-dd"></fmt:formatDate>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome ${sessionScope.admin.username}!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
							    头像
							</td>
							<td>
								姓名
							</td>
							<td>
								工资
							</td>
							<td>
								年龄
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach items="${sessionScope.emps}" var="emp">
						<tr class="row1">
							<td>
								${emp.id}
							</td>
							 <td>
							  <img width="40px" height="40px" src="${pageContext.request.contextPath}/img/${emp.picture}" />
							</td>
							<td>
								${emp.username}
							</td>
							<td>
								${emp.salary}
							</td>
							<td>
								${emp.age}
							</td>
							<td>
								${emp.dep.department}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/emp/deleteEmp?id=${emp.id}&depid=${emp.dep.id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/emp/selectEmp?id=${emp.id}">update emp</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					821541969@qq.com
				</div>
			</div>
		</div>
	</body>
</html>
