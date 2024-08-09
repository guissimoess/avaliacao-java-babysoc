package br.com.soc.sistema.action.funcionario;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioAction extends Action{
	private List<FuncionarioVo> funcionarios = new ArrayList<>();
	private FuncionarioVo funcionarioVo = new FuncionarioVo();
	private FuncionarioBusiness business = new FuncionarioBusiness();
	private String valorFiltro;
	private String tipoFiltro;
	
	public String listar () {
		funcionarios = business.listarTodosFuncionarios();
		return "listar";
	}
	
	public String incluir () {
		return "incluir";
	}
	
	public String salvar () {
		business.salvarFuncionario(funcionarioVo);
		return "redirect";
	}
	
	public String editar () {
		funcionarioVo = business.buscarFuncionarioPorId(funcionarioVo.getRowid());
		return "editar";
	}
	
	public String salvarEdicao () {
		business.atualizarFuncionario(funcionarioVo);
		return "redirect";
	}
	
	public String excluir () {
		business.excluirFuncionario(funcionarioVo.getRowid());
        return "redirect";
	}
	
	public String filtrar () {
		if (valorFiltro.isEmpty()) {
			return "redirect";
		}
		
		funcionarios = business.filtrarFuncionarios(tipoFiltro, valorFiltro);
		return "listar";
	}
	
	
	

	public List<FuncionarioVo> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVo> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public FuncionarioVo getFuncionarioVo() {
		return funcionarioVo;
	}

	public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
		this.funcionarioVo = funcionarioVo;
	}

	public FuncionarioBusiness getBusiness() {
		return business;
	}

	public void setBusiness(FuncionarioBusiness business) {
		this.business = business;
	}
	
	public String getValorFiltro() {
		return valorFiltro;
	}
	
	public void setValorFiltro(String valorFiltro) {
		this.valorFiltro = valorFiltro;
	}
	
	public String getTipoFiltro() {
		return tipoFiltro;
	}
	
	public void setTipoFiltro(String tipoFiltro) {
		this.tipoFiltro = tipoFiltro;
	}
	
	
	
	
	
	
	

	
}
