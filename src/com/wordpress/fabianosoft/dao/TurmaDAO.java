package com.wordpress.fabianosoft.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.wordpress.fabianosoft.conexoes.Conexao;
import com.wordpress.fabianosoft.entidades.Turma;

public class TurmaDAO {

	public List<Turma> lista(String procurar) throws SQLException {
		List<Turma> list = new ArrayList<Turma>();
		String sql = "SELECT * FROM turma WHERE id LIKE ? OR dia_da_semana LIKE ? OR horario LIKE ? OR curso LIKE ? OR status LIKE ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		for (int j = 1; j <= 5; j++) {
			ps.setObject(j, "%"+procurar+"%");
		}
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Turma turma = new Turma();
			int i = 0;
			turma.setId(rs.getInt(++i));
			turma.setDiaDaSemana(rs.getString(++i));
			turma.setHorario(rs.getString(++i));
			turma.setCurso(rs.getString(++i));
			turma.setStatus(rs.getString(++i));
			Date inicio = rs.getDate(++i);
			if (inicio != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(inicio);
				turma.setDataInicio(calendar);
			}
			Date termino = rs.getDate(++i);
			if (termino != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(termino);
				turma.setDataTermino(calendar);
			}
			list.add(turma);
		}
		rs.close();
		ps.close();
		return list;
	}

	public void inserir(Turma turma) throws SQLException {
		String sql = "INSERT INTO `turma` ("
				+ "`id`, "
				+ "`Dia_da_semana`, "
				+ "`Horario`, "
				+ "`Curso`, "
				+ "`Status`, "
				+ "`Data_Inicio`, "
				+ "`Data_Termino` "
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, turma.getId());
		ps.setObject(++i, turma.getDiaDaSemana());
		ps.setObject(++i, turma.getHorario());
		ps.setObject(++i, turma.getCurso());
		ps.setObject(++i, turma.getStatus());
		ps.setObject(++i, turma.getDataInicio() == null ? null : turma.getDataInicio().getTime());
		ps.setObject(++i, turma.getDataTermino() == null ? null : turma.getDataTermino().getTime());
		ps.execute();
		ps.close();
	}
	
	public void alterar(Turma turma) throws SQLException {
		String sql = "UPDATE `turma` SET "
				+ "`Dia_da_semana` = ?, "
				+ "`Horario` = ?, "
				+ "`Curso` = ?, "
				+ "`Status` = ?, "
				+ "`Data_Inicio` = ?, "
				+ "`Data_Termino` = ? "
				+ "WHERE `id` = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, turma.getDiaDaSemana());
		ps.setObject(++i, turma.getHorario());
		ps.setObject(++i, turma.getCurso());
		ps.setObject(++i, turma.getStatus());
		ps.setObject(++i, turma.getDataInicio() == null ? null : turma.getDataInicio().getTime());
		ps.setObject(++i, turma.getDataTermino() == null ? null : turma.getDataTermino().getTime());
		ps.setObject(++i, turma.getId());
		ps.execute();
		ps.close();
	}
	
	public Turma getTurma(int id) throws SQLException {
		Turma turma = new Turma();
		String sql = "SELECT * FROM turma WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setObject(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			int i = 0;
			turma.setId(rs.getInt(++i));
			turma.setDiaDaSemana(rs.getString(++i));
			turma.setHorario(rs.getString(++i));
			turma.setCurso(rs.getString(++i));
			turma.setStatus(rs.getString(++i));
			Date inicio = rs.getDate(++i);
			if (inicio != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(inicio);
				turma.setDataInicio(calendar);
			}
			Date termino = rs.getDate(++i);
			if (termino != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(termino);
				turma.setDataTermino(calendar);
			}
		}
		rs.close();
		ps.close();
		return turma;
	}

	public void deletar(Turma turma) throws SQLException {
		String sql = "DELETE FROM turma WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, turma.getId());
		ps.execute();
		ps.close();
	}
	
}
