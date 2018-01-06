package com.fhlc7.controles;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.dao.ChamadaDAO;
import com.fhlc7.dao.MatriculaDAO;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Chamada;
import com.fhlc7.entidades.Turma;

public class ChamadaControle {
	
	public static void salvar(Chamada chamada){
		try {
			Conexao.conectar();
			ChamadaDAO dao = new ChamadaDAO();
			if(dao.verificar(chamada)){
				JOptionPane.showMessageDialog(null, "Já foi colocado presença para este aluno");
			}else{
				dao.inserir(chamada);
				Conexao.commit();
				JOptionPane.showMessageDialog(null, "Aluno " + chamada.getAluno().getId() + ": " + chamada.getAluno().getNomeAluno() + " presente" );
			}
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar chamada: " + e);
		}finally {
			Conexao.desconectar();
		}
	}
	
	public static DefaultTableModel defaultTableModelChamadas(Turma turma){
		DefaultTableModel defaultTableModel = new DefaultTableModel(null, new Object[] {"Nº", "Data"}){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			Conexao.conectar();
			ChamadaDAO dao = new ChamadaDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int i = 1;
			for (Chamada chamada : dao.chamadasDeUmaTurma(turma)) {
				defaultTableModel.addRow(new Object[] {
					i++,
					sdf.format(chamada.getData().getTime())	
				});
			}
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar criar tabela de chamadas de uma turma: " + e);
		} finally {
			Conexao.desconectar();
		}
		return defaultTableModel;
	}
	
	public static DefaultTableModel defaultTableModelChamada(Chamada chamada){
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
				"Obs. de Aluno",
				"Obs. de Chamada"}){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			Conexao.conectar();
			ChamadaDAO dao = new ChamadaDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			for (Chamada temp : dao.chamadasDeUmaData(chamada)) {
				defaultTableModel.addRow(new Object[] {
					temp.getAluno().getId(),
					temp.getAluno().getNomeAluno(),
					temp.getAluno().getDataDeNascimento() == null ? null : sdf.format(temp.getAluno().getDataDeNascimento().getTime()),
					temp.getAluno().getNomeResponsavel(),
					temp.getAluno().getRg(),
					temp.getAluno().getCpfCnpj(),
					temp.getAluno().getFone1(),
					temp.getAluno().getFone2(),
					temp.getAluno().getEmail(),
					temp.getAluno().getEndereco(),
					temp.getAluno().getNumero(),
					temp.getAluno().getBairro(),
					temp.getAluno().getCidade(),
					temp.getAluno().getEstado(),
					temp.getAluno().getObs(),
					temp.getObs()
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
	
	public static void deletar(Chamada chamada){
		try {
			Conexao.conectar();
			ChamadaDAO dao = new ChamadaDAO();
			dao.deletar(chamada);
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Aluno " + chamada.getAluno().getId() + ": " + chamada.getAluno().getNomeAluno() + " com falta" );
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar deletar chamada: " + e);
		}finally {
			Conexao.desconectar();
		}
	}
	
}
