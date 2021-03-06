<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;UTF-8" isELIgnored="false" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath}/css/style.css" />
		<script type="application/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="application/javascript">

            $(function () {
                $.ajax({
                    url:"${pageContext.request.contextPath}/dep/ajax",
                    type:"GET",
                    dataType:"JSON",
                    success:function (deps) {
                        for(var i=0;i<deps.length;i++){
                            if(deps[i].id==${emp.dep.id}){
                                var option=$("<option selected value="+deps[i].id+">"+deps[i].department+"</option>")
                                $("#dep").append(option);
                            }
                            if (deps[i].id!=${emp.dep.id}) {
                                var option=$("<option value="+deps[i].id+">"+deps[i].department+"</option>")
                                $("#dep").append(option);
                            }

                        }
                    }
                })
            });

		</script>
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
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="${pageContext.request.contextPath}/emp/updateEmp" method="post" enctype="multipart/form-data">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<input type="hidden" name="id" value="${emp.id}">
                            <input type="hidden" name="did" value="${emp.dep.id}">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									${emp.id}
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
								</td>
								<td valign="middle" align="left">
								<img width="40px" height="40px" src="${pageContext.request.contextPath}/img/${emp.picture}"/>
									<input type="file" name="upload"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" value="${emp.username}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${emp.salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${emp.age}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									部门:
								</td>
								<td valign="middle" align="left">
									<select id="dep" name="depid">
									  <%--<option>${emp.dep.department}</option>--%>
									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="修改" />
						</p>
					</form>
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
