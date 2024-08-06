package br.com.soc.sistema.action.examerealizado;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExameRealizadoAction {

	private ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
	private List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	private ExameRealizadoBusiness exameRealizadoBusiness = new ExameRealizadoBusiness();
	private ExameRealizadoVo novoExame = new ExameRealizadoVo();
	private String dataExame;
	private String novaDataExame;

	public String listar() {
		examesRealizados = exameRealizadoBusiness.listarExamesRealizadosId();
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
		try {
			Date dataFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(getDataExame());
			exameRealizadoVo.setDataExame(dataFormatada);
			exameRealizadoBusiness.excluirExameRealizado(exameRealizadoVo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect";
	}
	
	public String editar () {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dataFormatada = sdf.parse(dataExame);
			exameRealizadoVo.setDataExame(dataFormatada);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "editar";
	}
	
	public String salvarEdicao () {
		try {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date antigaDataFormatada = sdf.parse(dataExame);
	        Date novaDataFormatada = sdf.parse(getNovaDataExame());
	        exameRealizadoVo.setDataExame(antigaDataFormatada);
	        novoExame.setDataExame(novaDataFormatada); 
	        exameRealizadoBusiness.atualizarExameRealizado(exameRealizadoVo, novoExame);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect";
	}
	
	

	public String getDataExame() {
		return dataExame;
	}

	public void setDataExame(String dataExame) {
		this.dataExame = dataExame;
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
	
	public String getNovaDataExame() {
		return novaDataExame;
	}
	
	public void setNovaDataExame(String novaDataExame) {
		this.novaDataExame = novaDataExame;
	}
	
	
	

}
