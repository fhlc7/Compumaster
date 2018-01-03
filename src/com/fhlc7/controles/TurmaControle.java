package com.fhlc7.controles;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.dao.TurmaDAO;
import com.fhlc7.entidades.Turma;

public class TurmaControle {
	
	public static DefaultTableModel defaultTableModel(String procurar){
		DefaultTableModel defaultTableModel = new DefaultTableModel(null, new Object[]{
				"Código",
				"Dia da semana",
				"Horário",
				"Curso",
				"Status",
				"Data Início",
				"Data Término",
			}) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
		};
		try {
			Conexao.conectar();
			TurmaDAO dao = new TurmaDAO();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			for (Turma turma : dao.lista(procurar)) {
				defaultTableModel.addRow(new Object[]{
					turma.getId(),
					turma.getDiaDaSemana(),
					turma.getHorario(),
					turma.getCurso(),
					turma.getStatus(),
					turma.getDataInicio() == null ? null : format.format(turma.getDataInicio().getTime()),
					turma.getDataTermino() == null ? null : format.format(turma.getDataTermino().getTime())
				});
			}
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar criar DefaultTableModel: " + e);
		} finally {
			Conexao.desconectar();
		}
		return defaultTableModel;
	}

	public static void salvar(Turma turma){
		try {
			Conexao.conectar();
			TurmaDAO dao = new TurmaDAO();
			if (turma.getId() == 0) {
				dao.inserir(turma);
			} else {
				dao.alterar(turma);
			}
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Salvo com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar turma: " + e);
		}finally{
			Conexao.desconectar();
		}
	}

	public static Turma getTurma(int id){
		Turma turma = new Turma();
		try {
			Conexao.conectar();
			TurmaDAO dao = new TurmaDAO();
			turma = dao.getTurma(id);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao obter turma: " + e);
		}finally{
			Conexao.desconectar();
		}
		return turma;
	}
	
	public static void deletar(Turma turma){
		try {
			Conexao.conectar();
			TurmaDAO dao = new TurmaDAO();
			dao.deletar(turma);
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Deletar com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar deletar turma: " + e);
		}finally{
			Conexao.desconectar();
		}
	}
	
}
