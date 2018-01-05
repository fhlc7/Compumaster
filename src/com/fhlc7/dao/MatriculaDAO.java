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
import com.fhlc7.entidades.Turma;

public class MatriculaDAO {
	
	public void inserir(Matricula matricula) throws SQLException {
		String sql = "INSERT INTO matricula (idAluno, idTurma) VALUES (?, ?);";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, matricula.getAluno().getId());
		ps.setObject(++i, matricula.getTurma().getId());
		ps.execute();
		ps.close();
	}
	
	public List<Aluno> alunosMatriculados(Turma turma) throws SQLException{
		List<Aluno> list = new ArrayList<Aluno>();
		String sql = "SELECT aluno.* FROM matricula INNER JOIN aluno ON matricula.idAluno = aluno.id WHERE idTurma = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, turma.getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Aluno aluno = new Aluno();
			int i = 0;
			aluno.setId(rs.getInt(++i));
			aluno.setNomeAluno(rs.getString(++i));
			Date date = rs.getDate(++i);
			if (date != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(date);
				aluno.setDataDeNascimento(calendar);
			}
			aluno.setNomeResponsavel(rs.getString(++i));
			aluno.setRg(rs.getString(++i));
			aluno.setCpfCnpj(rs.getString(++i));
			aluno.setFone1(rs.getString(++i));
			aluno.setFone2(rs.getString(++i));
			aluno.setEmail(rs.getString(++i));
			aluno.setEndereco(rs.getString(++i));
			aluno.setNumero(rs.getString(++i));
			aluno.setBairro(rs.getString(++i));
			aluno.setCidade(rs.getString(++i));
			aluno.setEstado(rs.getString(++i));
			aluno.setObs(rs.getString(++i));
			list.add(aluno);
		}
		rs.close();
		ps.close();
		return list;
	}
	
	public boolean verificar(Matricula matricula) throws SQLException{
		boolean tem = false;
		String sql = "SELECT idAluno, idTurma FROM matricula WHERE idAluno = ? AND idTurma = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, matricula.getAluno().getId());
		ps.setInt(2, matricula.getTurma().getId());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			tem = true;
		}
		rs.close();
		ps.close();
		return tem;
	}
	
	public void deletar(Matricula matricula) throws SQLException {
		String sql = "DELETE FROM matricula WHERE idAluno = ? AND idTurma = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, matricula.getAluno().getId());
		ps.setObject(++i, matricula.getTurma().getId());
		ps.execute();
		ps.close();
	}
	
}
