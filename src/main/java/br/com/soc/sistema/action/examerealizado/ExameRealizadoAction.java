package br.com.soc.sistema.action.examerealizado;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExameRealizadoAction extends Action{

	private ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
	private List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	private ExameRealizadoBusiness exameRealizadoBusiness = new ExameRealizadoBusiness();
	private ExameRealizadoVo novoExame = new ExameRealizadoVo();
	private String tipoFiltro;
	private String valorFiltro;

	public String listar() {
		examesRealizados = exameRealizadoBusiness.listarExamesRealizados();
		return "listar";
	}

	public String incluir() {
		return "incluir";
	}

	public String salvar() {
		exameRealizadoBusiness.salvarExameRealizado(exameRealizadoVo);
		return "redirect";
	}

	public String excluir() {
		exameRealizadoBusiness.excluirExameRealizado(exameRealizadoVo);
		return "redirect";
	}

	public String editar() {
		return "editar";
	}

	public String salvarEdicao() {
		exameRealizadoBusiness.atualizarExameRealizado(exameRealizadoVo, novoExame);

		return "redirect";
	}

	public String filtrar() {
		if (valorFiltro.isEmpty()) {
			return "redirect";
		}
		examesRealizados = exameRealizadoBusiness.filtrarExameRealizado(tipoFiltro, valorFiltro);
		return "listar";
	}

	public ExameRealizadoBusiness getExameRealizadoBusiness() {
		return exameRealizadoBusiness;
	}

	public void setExameRealizadoBusiness(ExameRealizadoBusiness exameRealizadoBusiness) {
		this.exameRealizadoBusiness = exameRealizadoBusiness;
	}

	public ExameRealizadoVo getExameRealizadoVo() {
		return exameRealizadoVo;
	}

	public void setExameRealizadoVo(ExameRealizadoVo exameRealizadoVo) {
		this.exameRealizadoVo = exameRealizadoVo;
	}

	public List<ExameRealizadoVo> getExamesRealizados() {
		return examesRealizados;
	}

	public void setExamesRealizados(List<ExameRealizadoVo> examesRealizados) {
		this.examesRealizados = examesRealizados;
	}

	public ExameRealizadoVo getNovoExame() {
		return novoExame;
	}

	public void setNovoExame(ExameRealizadoVo novoExame) {
		this.novoExame = novoExame;
	}

	public String getTipoFiltro() {
		return tipoFiltro;
	}

	public void setTipoFiltro(String tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}

	public String getValorFiltro() {
		return valorFiltro;
	}

	public void setValorFiltro(String valorFiltro) {
		this.valorFiltro = valorFiltro;
	}

}
