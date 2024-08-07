<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><s:text name="Editar exame realizado" /></title>
<link rel='stylesheet'
	href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
</head>
<body class="bg-secondary">

	<div class="container">
		<s:form action="/salvarEdicaoExamesRealizados.action">
			<div class="card mt-5">
				<div class="card-header">
					<div class="row">
						<div class="col-sm-5">
							<s:url action="listarExamesRealizados" var="listar" />
							<a href="${listar}" class="btn btn-success">Exames realizados</a>
						</div>

						<div class="col-sm">
							<h5 class="card-title">Atualizar Exame</h5>
						</div>
					</div>
				</div>

				<div class="card-body">
					<div class="row">

						<div class="col-sm-4 mb-3">
							<label for="idFuncionario" class="form-label">ID do
								Funcionário:</label>
							<s:textfield cssClass="form-control" id="idFuncionario"
								name="exameRealizadoVo.funcionarioVo.rowid" readonly="true" />
						</div>

						<div class="col-sm-4 mb-3">
							<label for="idExame" class="form-label">ID do Exame:</label>
							<s:textfield cssClass="form-control" id="idExame"
								name="exameRealizadoVo.exameVo.rowid" readonly="true" />
						</div>

						<div class="col-sm-4 mb-3">
							<label for="dataExame" class="form-label">Data do Exame:</label>
							<s:textfield cssClass="form-control" id="dataExame"
								name="dataExame" readonly="true" type="date" />
						</div>
					</div>
				</div>

				<div class="card-body">
					<div class="row">

						<div class="col-sm-4 mb-3">
							<label for="idFuncionario" class="form-label">Novo ID do
								Funcionário:</label>
							<s:textfield cssClass="form-control" id="idFuncionario"
								name="novoExame.funcionarioVo.rowid"  type="number" required="true"/>
						</div>

						<div class="col-sm-4 mb-3">
							<label for="idExame" class="form-label">Novo ID do Exame:</label>
							<s:textfield cssClass="form-control" id="idExame"
								name="novoExame.exameVo.rowid" type="number" required="true"/>
						</div>

						<div class="col-sm-4 mb-3">
							<label for="dataExame" class="form-label">Nova Data do
								Exame: </label>
							<s:textfield cssClass="form-control" id="dataExame"
								name="novaDataExame" type="date" required="true" />
						</div>
					</div>
				</div>



				<div class="card-footer">
					<div class="form-row">
						<button class="btn btn-primary col-sm-4 offset-sm-1">Salvar</button>
						<button type="reset"
							class="btn btn-secondary col-sm-4 offset-sm-2">Limpar
							Formulario</button>
					</div>
				</div>
			</div>
		</s:form>
	</div>

	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>