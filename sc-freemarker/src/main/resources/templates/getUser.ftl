<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<title>Hello World!</title>
</head>
<body>
	<center>
		<p>welcome ${user.userName} to freemarker!</p>
		<p> 
		           年龄： ${user.age}</br>
			性别：
			<#if user.sex==0> 女 <#elseif user.sex==1> 男 <#else> 保密
			</#if>
		</p>
		<h4>我的好友：</h4>
		<#list user.friends as f> 姓名：${f.userName} , 年龄${f.age} <br>
		</#list>
	</center>
</body>
</html>