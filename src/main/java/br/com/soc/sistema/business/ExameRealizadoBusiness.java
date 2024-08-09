package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.soc.sistema.dao.examesrealizados.ExameRealizadoDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExameRealizadoBusiness {
	
	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private ExameRealizadoDao dao;
	
	public ExameRealizadoBusiness() {
		this.dao = new ExameRealizadoDao();
	}

	
	public List<ExameRealizadoVo> listarExamesRealizados () {
		return dao.selectAllExamesRealizados();
	}

	public void salvarExameRealizado(ExameRealizadoVo exameRealizadoVo) {
		try {
			dao.insertExameRealizado(exameRealizadoVo);
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel salvar o exame realizado");
		}
		
	}

	public void excluirExameRealizado(ExameRealizadoVo exameRealizadoVo) {
		try {
			dao.deleteExameRealizado(exameRealizadoVo);
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel excluir o exame realizado");
		}
	}
	
	public void excluirExamesRealizadosPorFuncionario (String rowid) {
		try {
            dao.deleteExamesRealizadosPorFuncionario(rowid);
        } catch (Exception e) {
            throw new BusinessException("Não foi possivel excluir os exames realizados");
        }
    }
	
	public void atualizarExameRealizado(ExameRealizadoVo antigoExame, ExameRealizadoVo exameAtualizado) {
		dao.updateExamesRealizados(antigoExame, exameAtualizado);
	}
	
	public List<ExameRealizadoVo> filtrarExameRealizado(String tipoFiltro, String valorFiltro) {
		List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
			switch (tipoFiltro) {
			case "FuncionarioID":
				try {
					examesRealizados.addAll(dao.selectAllExamesRealizadosByFuncionarioId(valorFiltro));
					return examesRealizados;
				} catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			case "ExameID":
				try {
					examesRealizados.addAll(dao.selectAllExamesRealizadosByExameId(valorFiltro));
					return examesRealizados;
				} catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			}
			return examesRealizados;
		
	}
	
	public List<ExameRealizadoVo> filtrarExamesRealizadosPorPeriodo(Date dataInicial, Date dataFinal) {
		List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
		try {
			examesRealizados.addAll(dao.selectAllExamesRealizadosPorPeriodo(dataInicial, dataFinal));
			return examesRealizados;
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel filtrar os exames realizados por periodo");
		}
	}
	
	
}
