package com.wordpress.fabianosoft.testes;

import com.wordpress.fabianosoft.conexoes.Conexao;

public class ConexaoTeste {
	public static void main(String[] args) {
		
		Conexao mySQL = new Conexao();
		mySQL.conectar();
		mySQL.commit();
		mySQL.rollback();
		mySQL.desconectar();
		
	}
}
