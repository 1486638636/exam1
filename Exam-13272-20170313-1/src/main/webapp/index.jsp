<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<html>
<body>
<h2>欢迎来到用户登录页面</h2>
<form action="login.do" method="post">
	<table>
		<caption>用户登录</caption>
		<tr>
			<td>用户名:</td>
			<td><input name="name"/></td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="登录">
			</td>
			<td>
				<input type="reset" value="取消"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>
