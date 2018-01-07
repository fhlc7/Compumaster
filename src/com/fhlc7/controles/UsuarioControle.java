package com.fhlc7.controles;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.dao.AlunoDAO;
import com.fhlc7.dao.UsuarioDAO;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Usuario;

public class UsuarioControle {

	public static boolean login(Usuario usuario) {
		boolean existe = false;
		try {
			Conexao.conectar();
			UsuarioDAO dao = new UsuarioDAO();
			existe = dao.login(usuario);
			Conexao.desconectar();
		} catch (SQLException e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar login: " + e);
		} finally {
			Conexao.desconectar();
		}
		return existe;
	}
	
	public static void salvar(Usuario usuario){
		try {
			Conexao.conectar();
			UsuarioDAO dao = new UsuarioDAO();
			if (usuario.getId() == 0) {
				dao.inserir(usuario);
			} else {
				dao.alterar(usuario);
			}
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar usuário: " + e);
		} finally {
			Conexao.desconectar();
		}
	}
	
	public static DefaultTableModel defaultTableModel(String procurar){
		DefaultTableModel defaultTableModel = new DefaultTableModel(null, new Object[] {
				"Código",
				"Nome",
				"Tipo"}){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			Conexao.conectar();
			UsuarioDAO dao = new UsuarioDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			for (Usuario usuario : dao.lista(procurar)) {
				defaultTableModel.addRow(new Object[] {
					usuario.getId(),
					usuario.getNome(),
					usuario.getTipo()	
				});
			}
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar criar tabela: " + e);
		} finally {
			Conexao.desconectar();
		}
		return defaultTableModel;
	}
	
	public static Usuario getUsuario(int id){
		Usuario usuario = new Usuario();
		try {
			Conexao.conectar();
			UsuarioDAO dao = new UsuarioDAO();
			usuario = dao.getUsuario(id);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar retornar usuário: " + e);
		} finally {
			Conexao.desconectar();
		}
		return usuario;
	}
	
	public static void deletar(Usuario usuario){
		try {
			Conexao.conectar();
			UsuarioDAO dao = new UsuarioDAO();
			dao.delete(usuario);
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar deletar usuário: " + e);
		} finally {
			Conexao.desconectar();
		}
	}
	
}
