package br.com.soc.sistema.dao.exames;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.exception.DBException;
import br.com.soc.sistema.vo.ExameVo;

public class ExameDao extends Dao {

	public void insertExame(ExameVo exameVo) {
		StringBuilder query = new StringBuilder("INSERT INTO exame (nm_exame) values (?)");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {

			int i = 1;
			ps.setString(i++, exameVo.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateExame(ExameVo exameVo) {
		String query = "UPDATE exame SET nm_exame = ? WHERE rowid = (?)";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, exameVo.getNome());
			ps.setString(2, exameVo.getRowid());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void deleteExame(String rowid) {
		String query = "DELETE from exame WHERE rowid = (?)";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, rowid);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new DBException("O exame está sendo realizado por algum funcionário");
		}
	}

	public List<ExameVo> findAllExames() {
		StringBuilder query = new StringBuilder("SELECT rowid id, nm_exame nome FROM exame");
		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery()) {

			ExameVo vo = null;
			List<ExameVo> exames = new ArrayList<>();
			while (rs.next()) {
				vo = new ExameVo();
				vo.setRowid(rs.getString("id"));
				vo.setNome(rs.getString("nome"));

				exames.add(vo);
			}
			return exames;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public List<ExameVo> findAllByNome(String nome) {
		StringBuilder query = new StringBuilder("SELECT rowid id, nm_exame nome FROM exame ")
				.append("WHERE lower(nm_exame) like lower(?)");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;

			ps.setString(i, "%" + nome + "%");

			try (ResultSet rs = ps.executeQuery()) {
				ExameVo vo = null;
				List<ExameVo> exames = new ArrayList<>();

				while (rs.next()) {
					vo = new ExameVo();
					vo.setRowid(rs.getString("id"));
					vo.setNome(rs.getString("nome"));

					exames.add(vo);
				}
				return exames;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	public ExameVo findByCodigo(Integer codigo) {
		StringBuilder query = new StringBuilder("SELECT rowid id, nm_exame nome FROM exame ").append("WHERE rowid = ?");

		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
			int i = 1;

			ps.setInt(i, codigo);

			try (ResultSet rs = ps.executeQuery()) {
				ExameVo vo = null;

				while (rs.next()) {
					vo = new ExameVo();
					vo.setRowid(rs.getString("id"));
					vo.setNome(rs.getString("nome"));
				}
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}