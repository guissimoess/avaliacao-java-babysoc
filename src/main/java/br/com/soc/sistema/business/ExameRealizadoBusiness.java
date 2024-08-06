package br.com.soc.sistema.business;

import java.text.SimpleDateFormat;
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
	
	public List<ExameRealizadoVo> listarExamesRealizados() {
		return dao.selectAllExamesRealizados();
	}
	
	public List<ExameRealizadoVo> listarExamesRealizadosId () {
		return dao.selectAllExamesRealizadosId();
	}

	public void salvarExameRealizado(ExameRealizadoVo exameRealizadoVo) {
		try {
			dao.insertExameRealizado(exameRealizadoVo);
		} catch (Exception e) {
			throw new BusinessException("Não foi possivel salvar o exame realizado");
		}
		
	}

	public void excluirExameRealizado(ExameRealizadoVo exameRealizadoVo) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dao.deleteExameRealizado(exameRealizadoVo.getFuncionarioVo().getRowid(), exameRealizadoVo.getExameVo().getRowid(), sdf.format(exameRealizadoVo.getDataExame()));
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
	
	
}
