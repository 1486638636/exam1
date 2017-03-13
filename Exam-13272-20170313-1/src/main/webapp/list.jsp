<%@ page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.List,java.util.ArrayList,com.hand.entity.Film,com.hand.entity.Language" %>

<html>
<head>
<title>员工信息查询</title>
<style type="text/css">
.row1 {
	background-color: silver;
}

.row2 {
	background-color: orange;
}
</style>
</head>

<body bgcolor="#E8F2FE">
	<table width='80%' border='1px' cellspacing='0px' cellpadding='5px'
		align='center' style='text-align:center'>
		<caption>
			<h1>查询结果</h1>
		</caption>
		<tr style="background-color: silver;">
			<td>film_id</td>
			<td>title</td>
			<td>description</td>
			<td>language</td>
		</tr>
		<% List<Film> fList=(ArrayList<Film>) request.getAttribute("fList");
		List<Language> lList=(ArrayList<Language>)request.getAttribute("lList");
		for(int i=0;i<fList.size();i++){
			Film f=fList.get(i);%>
			<tr>
				<td><%=f.getFilm_id() %></td>
				<td><%=f.getTitle() %></td>
				<td><%=f.getDescription() %></td>
				
				
			<%} %>
				<%for(int j=0;j<lList.size();j++){
					Language l=lList.get(j); %>
					<td><%=l.getName() %></td>
					<%} %>
				
			</tr>
			</table>

</body>
</html>
