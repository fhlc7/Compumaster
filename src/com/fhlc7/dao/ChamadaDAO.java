package com.fhlc7.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Chamada;
import com.fhlc7.entidades.Matricula;
import com.fhlc7.entidades.Turma;

public class ChamadaDAO {
	
	public void inserir(Chamada chamada) throws SQLException{
		String sql = "INSERT INTO chamada (Data, idAluno, idTurma, Obs) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, chamada.getData().getTime());
		ps.setObject(++i, chamada.getAluno().getId());
		ps.setObject(++i, chamada.getTurma().getId());
		ps.setObject(++i, chamada.getObs());
		ps.execute();
		ps.close();
	}
	
	public boolean verificar(Chamada chamada) throws SQLException{
		boolean tem = false;
		String sql = "SELECT * FROM chamada WHERE Data = ? AND idAluno = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setObject(1, new SimpleDateFormat("yyyy-MM-dd").format(chamada.getData().getTime()));
		ps.setInt(2, chamada.getAluno().getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			tem = true;
		}
		rs.close();
		ps.close();
		return tem;
	}
	
	public List<Chamada> chamadasDeUmaTurma(Turma turma) throws SQLException{
		List<Chamada> list = new ArrayList<Chamada>();
		String sql = "SELECT * FROM chamada WHERE idTurma = ? GROUP BY Data ASC;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, turma.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Chamada chamada = new Chamada();
			int i = 0;
			chamada.setId(rs.getInt(++i));
			Date date = rs.getDate(++i);
			if (date != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				chamada.setData(calendar);
			}
			chamada.setAluno(new AlunoDAO().getAluno(rs.getInt(++i)));
			chamada.setTurma(new TurmaDAO().getTurma(rs.getInt(++i)));
			chamada.setObs(rs.getString(++i));
			list.add(chamada);
		}
		rs.close();
		ps.close();
		return list;
	}
	
	public List<Chamada> chamadasDeUmaData(Chamada chamada) throws SQLException{
		List<Chamada> list = new ArrayList<Chamada>();
		String sql = "SELECT * FROM chamada WHERE Data = ? AND idTurma = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, new SimpleDateFormat("yyyy-MM-dd").format(chamada.getData().getTime()));
		ps.setObject(++i, chamada.getTurma().getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			chamada = new Chamada();
			i = 0;
			chamada.setId(rs.getInt(++i));
			Date date = rs.getDate(++i);
			if (date != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				chamada.setData(calendar);
			}
			chamada.setAluno(new AlunoDAO().getAluno(rs.getInt(++i)));
			chamada.setTurma(new TurmaDAO().getTurma(rs.getInt(++i)));
			chamada.setObs(rs.getString(++i));
			list.add(chamada);
		}
		rs.close();
		ps.close();
		return list;
	}
	
	public void deletar(Chamada chamada) throws SQLException{
		String sql = "DELETE FROM chamada WHERE Data = ? AND idAluno = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, new SimpleDateFormat("yyyy-MM-dd").format(chamada.getData().getTime()));
		ps.setObject(++i, chamada.getAluno().getId());
		ps.execute();
		ps.close();
	}
	
}
