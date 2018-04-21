<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/bootstrap.css">
		<title>Autenticacao</title>
	</head>
	<body>
		<h2>Pagina de login das tarefas</h2>
		<h3 style="color: red">${param.erro}</h3>
		<form action="efetuaLogin" method="post">
			LOGIN: <input type="text" name="login"/><br/>
			SENHA: <input type="password" name="senha"/><br/>
			<input type="submit" value="logar"/>
		</form>
	</body>
	</html>