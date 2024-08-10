package br.com.soc.sistema.action.relatorio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.soc.sistema.business.ExameRealizadoBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.relatorio.ExamesRealizadosRelatorio;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class RelatorioAction extends Action {
	private List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
	private ExameRealizadoBusiness business = new ExameRealizadoBusiness();
	private ExamesRealizadosRelatorio relatorio = new ExamesRealizadosRelatorio();
	private String dataInicial;
	private String dataFinal;

	public String browser() {
		return "browser";
	}

	public String filtrar() {

		examesRealizados = business.filtrarExamesRealizadosPorPeriodo(dataInicial, dataFinal);
		relatorio.gerarRelatorioExames(examesRealizados);
		return "browser";
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
