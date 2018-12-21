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
import com.wordpress.fabianosoft.entidades.Aluno;

public class AlunoDAO {
	
	public void inserir(Aluno aluno) throws SQLException{
		String sql = "INSERT INTO `aluno` ("
				+ "`id`, "
				+ "`Nome_Aluno`, "
				+ "`Data_de_Nascimento`, "
				+ "`Nome_Responsavel`, "
				+ "`RG`, "
				+ "`CPF_CNPJ`, "
				+ "`Fone_1`, "
				+ "`Fone_2`, "
				+ "`Email`, "
				+ "`Endereco`, "
				+ "`Numero`, "
				+ "`Bairro`, "
				+ "`Cidade`, "
				+ "`Estado`, "
				+ "`Obs`"
				+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, aluno.getId());
		ps.setObject(++i, aluno.getNomeAluno());
		try {
			//ps.setObject(++i, aluno.getDataDeNascimento().get(Calendar.YEAR) + "-" + (aluno.getDataDeNascimento().get(Calendar.MONTH) + 1) + "-" + aluno.getDataDeNascimento().get(Calendar.DATE));
			ps.setObject(++i, aluno.getDataDeNascimento().getTime());
		} catch (Exception e) {
			ps.setObject(i, null);
		}
		ps.setObject(++i, aluno.getNomeResponsavel());
		ps.setObject(++i, aluno.getRg());
		ps.setObject(++i, aluno.getCpfCnpj());
		ps.setObject(++i, aluno.getFone1());
		ps.setObject(++i, aluno.getFone2());
		ps.setObject(++i, aluno.getEmail());
		ps.setObject(++i, aluno.getEndereco());
		ps.setObject(++i, aluno.getNumero());
		ps.setObject(++i, aluno.getBairro());
		ps.setObject(++i, aluno.getCidade());
		ps.setObject(++i, aluno.getEstado());
		ps.setObject(++i, aluno.getObs());
		ps.execute();
		ps.close();
	}
	
	public List<Aluno> lista(String procurar) throws SQLException{
		List<Aluno> list = new ArrayList<Aluno>();
		String sql = "SELECT * FROM Aluno WHERE id LIKE ? OR Nome_Aluno LIKE ? OR Nome_Responsavel LIKE ? ";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setString(1, "%" + procurar + "%");
		ps.setString(2, "%" + procurar + "%");
		ps.setString(3, "%" + procurar + "%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
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
	
	public Aluno getAluno(int id) throws SQLException{
		Aluno aluno = new Aluno();
		String sql = "SELECT * FROM Aluno WHERE id = ?";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
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
		}
		rs.close();
		ps.close();
		return aluno;
	}

	public void alterar(Aluno aluno) throws SQLException{
		String sql = "UPDATE `aluno` SET "
				+ "`Nome_Aluno` = ?, "
				+ "`Data_de_Nascimento` = ?, "
				+ "`Nome_Responsavel` = ?, "
				+ "`RG` = ?, "
				+ "`CPF_CNPJ` = ?, "
				+ "`Fone_1` = ?, "
				+ "`Fone_2` = ?, "
				+ "`Email` = ?, "
				+ "`Endereco` = ?, "
				+ "`Numero` = ?, "
				+ "`Bairro` = ?, "
				+ "`Cidade` = ?, "
				+ "`Estado` = ?, "
				+ "`Obs` = ? "
				+ "WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, aluno.getNomeAluno());
		try {
			//ps.setObject(++i, aluno.getDataDeNascimento().get(Calendar.YEAR) + "-" + (aluno.getDataDeNascimento().get(Calendar.MONTH) + 1) + "-" + aluno.getDataDeNascimento().get(Calendar.DATE));
			ps.setObject(++i, aluno.getDataDeNascimento().getTime());
		} catch (Exception e) {
			ps.setObject(i, null);
		}
		ps.setObject(++i, aluno.getNomeResponsavel());
		ps.setObject(++i, aluno.getRg());
		ps.setObject(++i, aluno.getCpfCnpj());
		ps.setObject(++i, aluno.getFone1());
		ps.setObject(++i, aluno.getFone2());
		ps.setObject(++i, aluno.getEmail());
		ps.setObject(++i, aluno.getEndereco());
		ps.setObject(++i, aluno.getNumero());
		ps.setObject(++i, aluno.getBairro());
		ps.setObject(++i, aluno.getCidade());
		ps.setObject(++i, aluno.getEstado());
		ps.setObject(++i, aluno.getObs());
		ps.setObject(++i, aluno.getId());
		ps.execute();
		ps.close();
	}
	
	public void delete(Aluno aluno) throws SQLException{
		String sql = "DELETE FROM `aluno` WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setObject(1, aluno.getId());
		ps.execute();
		ps.close();
	}
	
}
