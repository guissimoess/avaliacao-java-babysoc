package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.funcionarios.FuncionarioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioBusiness {

	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private FuncionarioDao dao;
	private ExameRealizadoBusiness exameRealizadoBusiness = new ExameRealizadoBusiness();

	public FuncionarioBusiness() {
		this.dao = new FuncionarioDao();
		
	}

	public List<FuncionarioVo> listarTodosFuncionarios() {
		return dao.selectAllFuncionarios();
	}

	public void salvarFuncionario(FuncionarioVo funcionarioVo) {
		try {
			if (funcionarioVo.getNome().isEmpty()) {
				throw new IllegalArgumentException("Nome nao pode ser em branco");
			}
			dao.insertFuncionario(funcionarioVo);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
		}
	}

	public void atualizarFuncionario(FuncionarioVo funcionarioVo) {
		try {
			if (funcionarioVo.getNome().isEmpty()) {
				throw new IllegalArgumentException("Nome nao pode ser em branco");
			}
			dao.updateFuncionario(funcionarioVo);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a atualizacao do registro");
		}
	}

	public void excluirFuncionario(String rowid) {
		try {
			Integer codigo = Integer.parseInt(rowid);
			exameRealizadoBusiness.excluirExamesRealizadosPorFuncionario(rowid);
			dao.deleteFuncionario(codigo);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a exclusao do registro");
		}
	}

	public FuncionarioVo buscarFuncionarioPorId(String rowid) {
		try {
			Integer codigo = Integer.parseInt(rowid);
			return dao.selectFuncionarioById(codigo);
		} catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}

	public List<FuncionarioVo> buscarFuncionariosPorNome(String nome) {
		return dao.selectAllFuncionariosByNome(nome);
	}

	public List<FuncionarioVo> filtrarFuncionarios(String tipoFiltro, String valorFiltro) {
		List<FuncionarioVo> funcionarios = new ArrayList<FuncionarioVo>();
			switch (tipoFiltro) {
			case "ID":
				try {
					Integer codigo = Integer.parseInt(valorFiltro);
					funcionarios.add(dao.selectFuncionarioById(codigo));
				} catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			case "Nome":
				funcionarios.addAll(dao.selectAllFuncionariosByNome(valorFiltro));
				break;
			}
		return funcionarios;
	}
}
