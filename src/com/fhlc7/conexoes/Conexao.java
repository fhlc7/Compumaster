package com.fhlc7.conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {

	public static Connection conexao;
	
	public static Connection conectar() {
		try {
			//conexao = DriverManager.getConnection("jdbc:sqlite:dbCompumaster.s3db");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/Compumaster", "root", "root");
			conexao.setAutoCommit(false);
			System.out.println("Conectado com sucesso");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao tentar conectar com banco de dados: " + e);
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