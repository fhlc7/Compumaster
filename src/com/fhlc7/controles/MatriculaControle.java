package com.fhlc7.controles;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.dao.AlunoDAO;
import com.fhlc7.dao.MatriculaDAO;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Matricula;
import com.fhlc7.entidades.Turma;

public class MatriculaControle {

	public static void salvar(Matricula matricula){
		try {
			Conexao.conectar();
			MatriculaDAO dao = new MatriculaDAO();
			if (dao.verificar(matricula)) {
				JOptionPane.showMessageDialog(null, "Este aluno já está matriculado nesta turma");
			} else {
				dao.inserir(matricula);
				JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso");
				Conexao.commit();
			}
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar matricular aluno: " + e);
		} finally {
			Conexao.desconectar();
		}
	}
	
	public static DefaultTableModel defaultTableModel(Turma turma){
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
			MatriculaDAO dao = new MatriculaDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			for (Aluno aluno : dao.alunosMatriculados(turma)) {
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
			JOptionPane.showMessageDialog(null, "Erro ao tentar criar tabela de alunos matriculados: " + e);
		} finally {
			Conexao.desconectar();
		}
		return defaultTableModel;
	}
	
	public static void deletar(Matricula matricula){
		try {
			Conexao.conectar();
			MatriculaDAO dao = new MatriculaDAO();
			dao.deletar(matricula);
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Aluno removido com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar remover aluno: " + e);
		} finally {
			Conexao.desconectar();
		}
	}
	
}
