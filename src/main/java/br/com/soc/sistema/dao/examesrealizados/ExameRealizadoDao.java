package br.com.soc.sistema.dao.examesrealizados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.exception.DBException;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;
import freemarker.template.SimpleDate;

public class ExameRealizadoDao extends Dao {

	public void insertExameRealizado(ExameRealizadoVo exameRealizadoVo) {
		String query = "INSERT INTO exame_funcionario (rowid_funcionario, rowid_exame, dt_exame) VALUES (?,?,?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, exameRealizadoVo.getFuncionarioVo().getRowid());
			ps.setString(2, exameRealizadoVo.getExameVo().getRowid());
			ps.setString(3, sdf.format(exameRealizadoVo.getDataExame()));
			ps.executeUpdate();

		} catch (SQLException e) {
			throw new DBException("Não foi possível salvar o exame");
		}
	}

	public List<ExameRealizadoVo> selectAllExamesRealizados() {
		List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
		String query = "SELECT rowid_funcionario, rowid_exame, dt_exame from exame_funcionario";
		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
				FuncionarioVo funcionarioVo = new FuncionarioVo();
				ExameVo exameVo = new ExameVo();
				funcionarioVo.setRowid(rs.getString("rowid_funcionario"));
				exameVo.setRowid(rs.getString("rowid_exame"));
				exameRealizadoVo.setDataExame(rs.getDate("dt_exame"));
				exameRealizadoVo.setFuncionarioVo(funcionarioVo);
				exameRealizadoVo.setExameVo(exameVo);
				examesRealizados.add(exameRealizadoVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesRealizados;
	}

	public void deleteExameRealizado(ExameRealizadoVo exameRealizadoVo) {
		String query = "DELETE FROM exame_funcionario WHERE rowid_funcionario = ? AND rowid_exame = ? AND dt_exame = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, exameRealizadoVo.getFuncionarioVo().getRowid());
			ps.setString(2, exameRealizadoVo.getExameVo().getRowid());
			ps.setString(3, sdf.format(exameRealizadoVo.getDataExame()));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteExamesRealizadosPorFuncionario(String rowidFuncionario) {
		String query = "DELETE FROM exame_funcionario WHERE rowid_funcionario = ?";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, rowidFuncionario);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateExamesRealizados(ExameRealizadoVo antigoExame, ExameRealizadoVo novoExame) {
		String query = "UPDATE exame_funcionario SET rowid_funcionario = ?, rowid_exame = ?, dt_exame = ? WHERE rowid_funcionario = ? AND rowid_exame = ? AND dt_exame = ?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, novoExame.getFuncionarioVo().getRowid());
			ps.setString(2, novoExame.getExameVo().getRowid());
			ps.setString(3, sdf.format(novoExame.getDataExame()));

			ps.setString(4, antigoExame.getFuncionarioVo().getRowid());
			ps.setString(5, antigoExame.getExameVo().getRowid());
			ps.setString(6, sdf.format(antigoExame.getDataExame()));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ExameRealizadoVo> selectAllExamesRealizadosByFuncionarioId(String rowid) {
		List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
		String query = "SELECT rowid_funcionario, rowid_exame, dt_exame from exame_funcionario WHERE rowid_funcionario = ?";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, rowid);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
					FuncionarioVo funcionarioVo = new FuncionarioVo();
					ExameVo exameVo = new ExameVo();
					funcionarioVo.setRowid(rs.getString("rowid_funcionario"));
					exameVo.setRowid(rs.getString("rowid_exame"));
					exameRealizadoVo.setDataExame(rs.getDate("dt_exame"));
					exameRealizadoVo.setFuncionarioVo(funcionarioVo);
					exameRealizadoVo.setExameVo(exameVo);
					examesRealizados.add(exameRealizadoVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesRealizados;
	}

	public List<ExameRealizadoVo> selectAllExamesRealizadosByExameId(String rowid) {
		List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
		String query = "SELECT rowid_funcionario, rowid_exame, dt_exame from exame_funcionario WHERE rowid_exame = ?";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, rowid);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
					FuncionarioVo funcionarioVo = new FuncionarioVo();
					ExameVo exameVo = new ExameVo();
					funcionarioVo.setRowid(rs.getString("rowid_funcionario"));
					exameVo.setRowid(rs.getString("rowid_exame"));
					exameRealizadoVo.setDataExame(rs.getDate("dt_exame"));
					exameRealizadoVo.setFuncionarioVo(funcionarioVo);
					exameRealizadoVo.setExameVo(exameVo);
					examesRealizados.add(exameRealizadoVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesRealizados;
	}

	public List<ExameRealizadoVo> selectAllExamesRealizadosPorPeriodo(String dataInicial, String dataFinal) {
		List<ExameRealizadoVo> examesRealizados = new ArrayList<ExameRealizadoVo>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String query = "SELECT f.rowid AS id_funcionario, f.nm_funcionario, e.rowid AS id_exame, e.nm_exame, ef.dt_exame "
				+ "FROM exame_funcionario ef " + "JOIN funcionario f ON ef.rowid_funcionario = f.rowid "
				+ "JOIN exame e ON ef.rowid_exame = e.rowid " + "WHERE ef.dt_exame BETWEEN ? AND ?";
		try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query)) {
			ps.setString(1, dataInicial);
			ps.setString(2, dataFinal);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
					FuncionarioVo funcionarioVo = new FuncionarioVo(rs.getString("id_funcionario"), rs.getString("nm_funcionario"));
					ExameVo exameVo = new ExameVo(rs.getString("id_exame"), rs.getString("nm_exame"));
					exameRealizadoVo.setExameVo(exameVo);
					exameRealizadoVo.setFuncionarioVo(funcionarioVo);
					exameRealizadoVo.setDataExame(rs.getDate("dt_exame"));
					examesRealizados.add(exameRealizadoVo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examesRealizados;
	}

}
