<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="label.titulo.pagina.consulta" /></title>
<link rel='stylesheet'
	href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body class="bg-secondary">
	<div class="container">
		<div style="padding: 10px;" align="center">
			<s:url action="todosExames" var="exames" />
			<a href="${exames}" class="btn btn-primary"> <s:text
					name="label.exames" />
			</a>
			<s:url action="listarExamesRealizados" var="examesRealizados" />
			<a href="${examesRealizados}" class="btn btn-primary"> <s:text
					name="Exames realizados" />
			</a>
			<s:url action="browserRelatorios" var="relatorios" />
			<a href="${relatorios}" class="btn btn-primary"> <s:text
					name="Relatorios" />
			</a>
		</div>
		<div class="row mt-5 mb-2">
			<div class="col-sm p-0">
				<s:form action="filtrarFuncionarios.action">
					<div class="input-group">
						<span class="input-group-text"> <strong><s:text
									name="label.buscar.por" /></strong>
						</span>
						<s:select cssClass="form-select" name="tipoFiltro" label="Tipo"
							list="#{'ID':'ID', 'Nome':'NOME'}" headerKey=""
							headerValue="Escolha..." />
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
						<th><s:text name="label.id" /></th>
						<th><s:text name="label.nome" /></th>
						<th class="text-end mt-5"><s:text name="label.acao" /></th>
					</tr>
				</thead>

				<tbody>
					<s:iterator value="funcionarios">
						<tr>
							<td>${rowid}</td>
							<td>${nome}</td>
							<td class="text-end"><s:url action="editarFuncionarios"
									var="editar">
									<s:param name="funcionarioVo.rowid" value="rowid"></s:param>
								</s:url> <a href="${editar}" class="btn btn-warning text-white"> <s:text
										name="label.editar" /></a> <s:url action="excluirFuncionarios"
									var="excluir">
									<s:param name="funcionarioVo.rowid" value="rowid"></s:param>
								</s:url> <a href="${excluir}" class="btn btn-danger"> <s:text
										name="label.excluir" />
							</a></td>
						</tr>
					</s:iterator>
				</tbody>

				<tfoot class="table-secondary">
					<tr>
						<td colspan="3"><s:url action="incluirFuncionarios"
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