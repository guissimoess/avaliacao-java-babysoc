package br.com.soc.sistema.dao.funcionarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioDao extends Dao {

	public void insertFuncionario(FuncionarioVo funcionarioVo) {
		String query = "INSERT INTO funcionario (nm_funcionario) values (?)";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, funcionarioVo.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFuncionario(FuncionarioVo funcionarioVo) {
		String query = "UPDATE funcionario SET nm_funcionario = ? WHERE rowid = ?";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, funcionarioVo.getNome());
			ps.setString(2, funcionarioVo.getRowid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteFuncionario(Integer rowid) {
		String query = "DELETE from funcionario WHERE rowid = ?";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, rowid);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<FuncionarioVo> selectAllFuncionarios() {
		List<FuncionarioVo> funcionarios = new ArrayList<>();
		String query = "SELECT rowid, nm_funcionario FROM funcionario";
		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				FuncionarioVo funcionario = new FuncionarioVo();
				funcionario.setRowid(rs.getString("rowid"));
				funcionario.setNome(rs.getString("nm_funcionario"));
				funcionarios.add(funcionario);
			}

			return funcionarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public FuncionarioVo selectFuncionarioById(Integer rowid) {
		FuncionarioVo funcionario = new FuncionarioVo();
		String query = "SELECT rowid, nm_funcionario FROM funcionario WHERE rowid = ?";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setInt(1, rowid);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					funcionario.setRowid(rs.getString("rowid"));
					funcionario.setNome(rs.getString("nm_funcionario"));
				}
				return funcionario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<FuncionarioVo> selectAllFuncionariosByNome(String nome) {
		List<FuncionarioVo> funcionarios = new ArrayList<FuncionarioVo>();
		String query = "SELECT rowid, nm_funcionario FROM funcionario WHERE LOWER (nm_funcionario) LIKE LOWER(?)";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, "%" + nome + "%");

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					FuncionarioVo funcionario = new FuncionarioVo();
					funcionario.setRowid(rs.getString("rowid"));
					funcionario.setNome(rs.getString("nm_funcionario"));
					funcionarios.add(funcionario);
				}
				return funcionarios;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();

	}

}
