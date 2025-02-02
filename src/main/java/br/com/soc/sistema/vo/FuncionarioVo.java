package br.com.soc.sistema.vo;

public class FuncionarioVo {
	
	private String rowid;
	private String nome;
	
	public FuncionarioVo() {
		
	}
	
	public FuncionarioVo(String rowid, String nome) {
		this.rowid = rowid;
		this.nome = nome;
	}
	
	public String getRowid() {
		return rowid;
	}
	
	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String toString() {
		return "FuncionarioVo [rowid=" + rowid + ", nome=" + nome + "]";
	}

}
