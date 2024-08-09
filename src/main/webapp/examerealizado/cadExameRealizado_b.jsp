<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="Exames realizados" /></title>
<link rel='stylesheet'
	href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body class="bg-secondary">
	<div class="container">
		<div style="padding: 10px;" align="center">
			<s:url action="todosExames" var="exames" />
			<a href="${exames}" class="btn btn-primary"> <s:text
					name="Exames" />
			</a>
			<s:url action="listarFuncionarios" var="funcionarios" />
			<a href="${funcionarios}" class="btn btn-primary"> <s:text
					name="Funcionarios" />
			</a>
			<s:url action="browserRelatorios" var="relatorios" />
			<a href="${relatorios}" class="btn btn-primary"> <s:text
					name="Relatorios" />
			</a>
		</div>
		<div class="row mt-5 mb-2">
			<div class="col-sm p-0">
				<s:form action="filtrarExamesRealizados.action">
					<div class="input-group">
						<span class="input-group-text"> <strong><s:text
									name="label.buscar.por" /></strong>
						</span>
						<s:select cssClass="form-select" name="tipoFiltro" label="Tipo"
							list="#{'FuncionarioID':'FUNCIONARIO ID', 'ExameID':'EXAME ID'}"
							headerKey="" headerValue="Escolha..." />
						<s:textfield cssClass="form-control" label="Valor"
							name="valorFiltro" />
						<button class="btn btn-primary" type="submit">
							<s:text name="label.pesquisar" />
						</button>
					</div>
				</s:form>
			</div>
		</div>

		<div class="row">
			<table class="table table-light table-striped align-middle">
				<thead>
					<tr>
						<th>FUNCION�RIO ID</th>
						<th>EXAME ID</th>
						<th>DATA EXAME</th>
						<th class="text-end mt-5"><s:text name="label.acao" /></th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="examesRealizados">
						<tr>
							<td>${funcionarioVo.rowid}</td>
							<td>${exameVo.rowid}</td>
							<td><fmt:formatDate value="${dataExame}" type="date"
									pattern="dd/MM/yyyy" /></td>
							<td class="text-end">
							
							<s:url action="editarExamesRealizados"
									var="editar">
									<s:param name="exameRealizadoVo.funcionarioVo.rowid"
										value="funcionarioVo.rowid"></s:param>
									<s:param name="exameRealizadoVo.exameVo.rowid"
										value="exameVo.rowid"></s:param>
									<s:param name="exameRealizadoVo.dataExame" value="dataExame"></s:param>
								</s:url> <a href="${editar}" class="btn btn-warning text-white"> <s:text
										name="label.editar" />
							</a> 
							
							<s:url action="excluirExamesRealizados" var="excluir">
									<s:param name="exameRealizadoVo.funcionarioVo.rowid"
										value="funcionarioVo.rowid"></s:param>
									<s:param name="exameRealizadoVo.exameVo.rowid"
										value="exameVo.rowid"></s:param>
									<s:param name="exameRealizadoVo.dataExame" value="dataExame"></s:param>
								</s:url> <a href="${excluir}" class="btn btn-danger"> <s:text
										name="label.excluir" />
							</a></td>
						</tr>
					</s:iterator>
				</tbody>

				<tfoot class="table-secondary">
					<tr>
						<td colspan="4"><s:url action="incluirExamesRealizados"
								var="novo" /> <a href="${novo}" class="btn btn-success"> <s:text
									name="label.novo" />
						</a></td>
					</tr>
				</tfoot>
			</table>
		</div>

		<div class="row"></div>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>