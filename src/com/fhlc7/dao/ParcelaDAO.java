package com.fhlc7.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Matricula;
import com.fhlc7.entidades.Parcela;
import com.fhlc7.entidades.Turma;

public class ParcelaDAO {

	public List<Parcela> lista(Aluno aluno, Turma turma) throws SQLException {
		Matricula matricula = new Matricula();
		MatriculaDAO dao = new MatriculaDAO();
		matricula = dao.getMatricula(aluno, turma);
		List<Parcela> list = new ArrayList<Parcela>();
		String sql = "SELECT * FROM parcela WHERE idMatricula = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, matricula.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Parcela parcela = new Parcela();
			int i = 0;
			parcela.setId(rs.getInt(++i));
			Date dateVencimento = rs.getDate(++i);
			if (dateVencimento != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(dateVencimento);
				parcela.setDataDeVencimento(calendar);
			}
			Date datePagamento = rs.getDate(++i);
			if (datePagamento != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(datePagamento);
				parcela.setDataDePagamento(calendar);
			}
			parcela.setValorPago(rs.getDouble(++i));
			parcela.setMatricula(matricula);
			list.add(parcela);
		}
		rs.close();
		ps.close();
		return list;
	}
	
	public void inserir(Parcela parcela) throws SQLException{
		String sql = "INSERT INTO `compumaster`.`parcela` ("
				+ "`id`, "
				+ "`Data_de_Vencimento`, "
				+ "`Data_de_Pagamento`, "
				+ "`Valor_Pago`, "
				+ "`idMatricula` "
				+ ") VALUES (?, ?, ?, ?, ?);";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, parcela.getId());
		try {
			ps.setObject(++i, parcela.getDataDeVencimento().getTime());
		} catch (Exception e) {
			ps.setObject(i, null);
		}
		try {
			ps.setObject(++i, parcela.getDataDePagamento().getTime());
		} catch (Exception e) {
			ps.setObject(i, null);
		}
		ps.setObject(++i, parcela.getValorPago());
		ps.setObject(++i, parcela.getMatricula().getId());
		ps.execute();
		ps.close();
	}
	
	public void alterar(Parcela parcela) throws SQLException{
		String sql = "UPDATE `compumaster`.`parcela` SET "
				+ "`Data_de_Vencimento` = ?, "
				+ "`Data_de_Pagamento` = ?, "
				+ "`Valor_Pago` = ?, "
				+ "`idMatricula` = ? "
				+ "WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		try {
			ps.setObject(++i, parcela.getDataDeVencimento().getTime());
		} catch (Exception e) {
			ps.setObject(i, null);
		}
		try {
			ps.setObject(++i, parcela.getDataDePagamento().getTime());
		} catch (Exception e) {
			ps.setObject(i, null);
		}
		ps.setObject(++i, parcela.getValorPago());
		ps.setObject(++i, parcela.getMatricula().getId());
		ps.setObject(++i, parcela.getId());
		ps.execute();
		ps.close();
	}

	public Parcela getParcela(int id) throws SQLException {
		Parcela parcela = new Parcela();
		String sql = "SELECT * FROM parcela WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			int i = 0;
			parcela.setId(rs.getInt(++i));
			Date dateVencimento = rs.getDate(++i);
			if (dateVencimento != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(dateVencimento);
				parcela.setDataDeVencimento(calendar);
			}
			Date datePagamento = rs.getDate(++i);
			if (datePagamento != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(datePagamento);
				parcela.setDataDeVencimento(calendar);
			}
			parcela.setValorPago(rs.getDouble(++i));
			MatriculaDAO dao = new MatriculaDAO();
			parcela.setMatricula(dao.getMatricula(rs.getInt(++i)));
		}
		rs.close();
		ps.close();
		return parcela;
	}

	public void delete(Parcela parcela) throws SQLException {
		String sql = "DELETE FROM `compumaster`.`parcela` WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setObject(1, parcela.getId());
		ps.execute();
		ps.close();
	}
	
}
