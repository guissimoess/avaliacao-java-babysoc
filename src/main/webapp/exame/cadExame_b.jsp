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
			<s:url action="listarFuncionarios" var="funcionarios" />
			<a href="${funcionarios}" class="btn btn-primary"> <s:text
					name="label.funcionarios" />
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

				<s:form action="/filtrarExames.action">
					<div class="input-group">
						<span class="input-group-text"> <strong><s:text
									name="label.buscar.por" /></strong>
						</span>
						<s:select cssClass="form-select" name="filtrar.opcoesCombo"
							list="listaOpcoesCombo" headerKey="" headerValue="Escolha..."
							listKey="%{codigo}" listValueKey="%{descricao}"
							value="filtrar.opcoesCombo.codigo" />

						<s:textfield cssClass="form-control" id="nome"
							name="filtrar.valorBusca" />
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
					<s:iterator value="exames">
						<tr>
							<td>${rowid}</td>
							<td>${nome}</td>
							<td class="text-end"><s:url action="editarExames"
									var="editar">
									<s:param name="exameVo.rowid" value="rowid"></s:param>
								</s:url> <a href="${editar}" class="btn btn-warning text-white"> <s:text
										name="label.editar" /></a> <s:url action="excluirExames"
									var="excluir">
									<s:param name="exameVo.rowid" value="rowid"></s:param>
								</s:url> <a href="${excluir}" class="btn btn-danger"> <s:text
										name="label.excluir" />
							</a></td>
						</tr>
					</s:iterator>
				</tbody>

				<tfoot class="table-secondary">
					<tr>
						<td colspan="3"><s:url action="novoExames" var="novo" /> <a
							href="${novo}" class="btn btn-success"> <s:text
									name="label.novo" />
						</a></td>
					</tr>
				</tfoot>
			</table>
		</div>


		<div class="row"></div>
	</div>
</body>
</html>