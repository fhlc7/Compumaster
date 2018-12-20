package com.fhlc7.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	public static Connection conexao;
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//conexao = DriverManager.getConnection("jdbc:sqlite:dbCompumaster.s3db");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/Compumaster2", "root", "1root2");
			//conexao = DriverManager.getConnection("jdbc:mysql://192.168.1.2/Compumaster", "fhlc", "fhlc123");
			conexao.setAutoCommit(false);
			System.out.println("Conectado com sucesso");
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, "Erro ao tentar conectar com banco de dados: " + e);
			JOptionPane.showMessageDialog(null, "Conecte-se a rede Compumaster");
		}
		return conexao;
	}
	
	public static void commit() {
		try {
			conexao.commit();
			System.out.println("Commit executado com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar commit em banco de dados: " + e);
		}
	}
	
	public static void rollback() {
		try {
			conexao.rollback();;
			System.out.println("Rollback executado com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar rollback em banco de dados: " + e);
		}
	}
	
	public static void desconectar() {
		try {
			conexao.close();
			System.out.println("Desconectado com sucesso");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar desconectar com banco de dados: " + e);
		}
	}
	
}
