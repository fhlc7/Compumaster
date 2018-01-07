package com.fhlc7.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.entidades.Usuario;

public class UsuarioDAO {
	
	public void inserir(Usuario usuario) throws SQLException{
		String sql = "INSERT INTO `compumaster`.`usuario` ("
				+ "`id`, "
				+ "`nome`, "
				+ "`senha`, "
				+ "`tipo` "
				+ ") VALUES (?, ?, ?, ?);";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, usuario.getId());
		ps.setObject(++i, usuario.getNome());
		ps.setObject(++i, usuario.getSenha());
		ps.setObject(++i, usuario.getTipo());
		ps.execute();
		ps.close();
	}
	
	public List<Usuario> lista(String procurar) throws SQLException{
		List<Usuario> list = new ArrayList<Usuario>();
		String sql = "SELECT * FROM Usuario WHERE id LIKE ? OR Nome LIKE ? OR Tipo LIKE ? ";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setString(1, "%" + procurar + "%");
		ps.setString(2, "%" + procurar + "%");
		ps.setString(3, "%" + procurar + "%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			Usuario usuario = new Usuario();
			int i = 0;
			usuario.setId(rs.getInt(++i));
			usuario.setNome(rs.getString(++i));
			usuario.setSenha(rs.getString(++i));
			usuario.setTipo(rs.getString(++i));
			list.add(usuario);
		}
		rs.close();
		ps.close();
		return list;
	}
	
	public Usuario getUsuario(int id) throws SQLException{
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM Usuario WHERE id = ?";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			int i = 0;
			usuario.setId(rs.getInt(++i));
			usuario.setNome(rs.getString(++i));
			usuario.setSenha(rs.getString(++i));
			usuario.setTipo(rs.getString(++i));
		}
		rs.close();
		ps.close();
		return usuario;
	}

	public void alterar(Usuario usuario) throws SQLException{
		String sql = "UPDATE `compumaster`.`usuario` SET "
				+ "`Nome` = ?, "
				+ "`Senha` = ?, "
				+ "`Tipo` = ? "
				+ "WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		int i = 0;
		ps.setObject(++i, usuario.getNome());
		ps.setObject(++i, usuario.getSenha());
		ps.setObject(++i, usuario.getTipo());
		ps.setObject(++i, usuario.getId());
		ps.execute();
		ps.close();
	}
	
	public void delete(Usuario usuario) throws SQLException{
		String sql = "DELETE FROM `compumaster`.`usuario` WHERE id = ?;";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setObject(1, usuario.getId());
		ps.execute();
		ps.close();
	}
	
	public boolean login(Usuario usuario) throws SQLException {
		String sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?";
		PreparedStatement ps = Conexao.conexao.prepareStatement(sql);
		ps.setString(1, usuario.getNome());
		ps.setString(2, usuario.getSenha());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		rs.close();
		ps.close();
		return false;
	}
	
}
