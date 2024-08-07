package br.com.soc.sistema.action.relatorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class RelatorioAction extends Action {
	private ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
	private List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	private ExameRealizadoBusiness business = new ExameRealizadoBusiness();
	private String dataInicial;
	private String dataFinal;
	

	public String browser () {
		return "browser";
	}
	
	public String filtrar () {
		try {
			Date dataInicialFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(dataInicial);
			Date dataFinalFormatada = new SimpleDateFormat("yyyy-MM-dd").parse(dataFinal);
			examesRealizados = business.filtrarExamesRealizadosPorPeriodo(dataInicialFormatada, dataFinalFormatada);
			return "browser";
			
		} catch (Exception e) {
            e.printStackTrace();
		}
		return "browser";
		
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

	public ExameRealizadoBusiness getBusiness() {
		return business;
	}

	public void setBusiness(ExameRealizadoBusiness business) {
		this.business = business;
	}

	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	

}
