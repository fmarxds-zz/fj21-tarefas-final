<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/bootstrap.css">
		<script src="assets/js/jquery.js" type="text/javascript"></script>
		<title>Gerenciador de Tarefas</title>
	</head>
	<body>
		<a href="/fj21-tarefas">Página Inicial</a>
		<a href="novaTarefa">Nova Tarefa </a>
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>DESCRIÇÃO</th>
					<th>STATUS</th>
					<th>DATA FINALIZAÇÃO</th>
					<th>MODIFICAR</th>
					<th>EXCLUIR</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tarefa" items="${tarefas}">
					<tr>
						<td>${tarefa.id}</td>
						<td>${tarefa.descricao}</td>
						<td id="tarefa-${tarefa.id}">
							<c:if test="${tarefa.finalizado eq true}">Concluída</c:if>
							<c:if test="${tarefa.finalizado eq false}">
								<a href="#" onclick="finalizaTarefa(${tarefa.id})">Finalizar</a>
							</c:if>
						</td>
						<td id="tarefaData-${tarefa.id}"><fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/></td>
						<td><a href="exibeTarefa?id=${tarefa.id}">Modificar</a></td>
						<td>
							<form action="excluirTarefa" method="post">
								<input name="id" type="hidden" value="${tarefa.id}" />
								<input type="submit" value="Excluir" />
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<script type="text/javascript">
			function finalizaTarefa(id){
				$.post("finalizaTarefa", {"id" : id}, function(){
					$("#tarefa-"+id).html("Concluída");
					now = new Date;
					mes = new Array("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12")
					$("#tarefaData-"+id).html(now.getDate()+"/"+mes[now.getMonth()]+"/"+now.getFullYear());
				});
			}
		</script>
	</body>
</html>