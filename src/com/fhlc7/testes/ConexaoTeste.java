package com.fhlc7.testes;

import com.fhlc7.conexoes.Conexao;

public class ConexaoTeste {
	public static void main(String[] args) {
		
		Conexao mySQL = new Conexao();
		mySQL.conectar();
		mySQL.commit();
		mySQL.rollback();
		mySQL.desconectar();
		
	}
}
