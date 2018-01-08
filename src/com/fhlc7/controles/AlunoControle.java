package com.fhlc7.controles;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.dao.AlunoDAO;
import com.fhlc7.entidades.Aluno;

public class AlunoControle {
	
	public static void salvar(Aluno aluno){
		try {
			Conexao.conectar();
			AlunoDAO dao = new AlunoDAO();
			if (aluno.getId() == 0) {
				dao.inserir(aluno);
			} else {
				dao.alterar(aluno);
			}
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar aluno: " + e);
		} finally {
			Conexao.desconectar();
		}
	}
	
	public static DefaultTableModel defaultTableModel(String procurar){
		DefaultTableModel defaultTableModel = new DefaultTableModel(null, new Object[] {
				"Matrícula",
				"Nome Aluno",
				"Data de Nascimento",
				"Nome Responsavel",
				"RG",
				"CPF / CNPJ",
				"Fone 1",
				"Fone 2",
				"Email",
				"Endereco",
				"Numero",
				"Bairro",
				"Cidade",
				"Estado",
				"Obs"}){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			Conexao.conectar();
			AlunoDAO dao = new AlunoDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			for (Aluno aluno : dao.lista(procurar)) {
				defaultTableModel.addRow(new Object[] {
					aluno.getId(),
					aluno.getNomeAluno(),
					aluno.getDataDeNascimento() == null ? null : sdf.format(aluno.getDataDeNascimento().getTime()),
					aluno.getNomeResponsavel(),
					aluno.getRg(),
					aluno.getCpfCnpj(),
					aluno.getFone1(),
					aluno.getFone2(),
					aluno.getEmail(),
					aluno.getEndereco(),
					aluno.getNumero(),
					aluno.getBairro(),
					aluno.getCidade(),
					aluno.getEstado(),
					aluno.getObs()
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
	
	public static Aluno getAluno(int id){
		Aluno aluno = new Aluno();
		try {
			Conexao.conectar();
			AlunoDAO dao = new AlunoDAO();
			aluno = dao.getAluno(id);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar retornar aluno: " + e);
		} finally {
			Conexao.desconectar();
		}
		return aluno;
	}
	
	public static void deletar(Aluno aluno){
		try {
			Conexao.conectar();
			AlunoDAO dao = new AlunoDAO();
			dao.delete(aluno);
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar deletar aluno: " + e);
		} finally {
			Conexao.desconectar();
		}
	}
	
}
