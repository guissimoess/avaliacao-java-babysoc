package br.com.soc.sistema.vo;

import java.util.Date;

public class ExameRealizadoVo {
	
	private ExameVo exameVo;
	private FuncionarioVo funcionarioVo;
	private Date dataExame;
	
	public ExameRealizadoVo() {
	}
	
	public ExameRealizadoVo(ExameVo exameVo, FuncionarioVo funcionarioVo, Date dataExame) {
		this.exameVo = exameVo;
		this.funcionarioVo = funcionarioVo;
		this.dataExame = dataExame;
	}

	public ExameVo getExameVo() {
		return exameVo;
	}

	public void setExameVo(ExameVo exameVo) {
		this.exameVo = exameVo;
	}

	public FuncionarioVo getFuncionarioVo() {
		return funcionarioVo;
	}

	public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
		this.funcionarioVo = funcionarioVo;
	}

	public Date getDataExame() {
		return dataExame;
	}

	public void setDataExame(Date dataExame) {
		this.dataExame = dataExame;
	}
	
	@Override
	public String toString() {
		return "ExameRealizado [exameVo=" + exameVo + ", funcionarioVo=" + funcionarioVo + ", dataExame=" + dataExame + "]";
	}

}
