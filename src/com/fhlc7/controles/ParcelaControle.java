package com.fhlc7.controles;

import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.fhlc7.conexoes.Conexao;
import com.fhlc7.dao.AlunoDAO;
import com.fhlc7.dao.MatriculaDAO;
import com.fhlc7.dao.ParcelaDAO;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Matricula;
import com.fhlc7.entidades.Parcela;
import com.fhlc7.entidades.Turma;

public class ParcelaControle {

	public static DefaultTableModel defaultTableModel(Aluno aluno, Turma turma){
		DefaultTableModel defaultTableModel = new DefaultTableModel(null, new Object[] {
				"Nº",
				"Código",
				"Data de Vencimento",
				"Data de Pagamento",
				"Valor Pago"}){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		try {
			Conexao.conectar();
			ParcelaDAO dao = new ParcelaDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
			int i = 1;
			for (Parcela parcela : dao.lista(aluno, turma)) {
				defaultTableModel.addRow(new Object[] {
					i++,
					parcela.getId(),
					parcela.getDataDeVencimento() == null ? null : sdf.format(parcela.getDataDeVencimento().getTime()),
					parcela.getDataDePagamento() == null ? null : sdf.format(parcela.getDataDePagamento().getTime()),
					String.valueOf(parcela.getValorPago()).replace(".", ",")	
				});
			}
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar criar tabela de parcelas: " + e);
		} finally {
			Conexao.desconectar();
		}
		return defaultTableModel;
	}
	
	public static void salvar(Parcela parcela, boolean... gerarParcelas){
		try {
			Conexao.conectar();
			ParcelaDAO dao = new ParcelaDAO();
			if (parcela.getId() == 0) {
				dao.inserir(parcela);
			} else {
				dao.alterar(parcela);
			}
			Conexao.commit();
			if (gerarParcelas.length <= 0) {
				JOptionPane.showMessageDialog(null, "Salvo com sucesso");
			}
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar salvar parcela: " + e);
		} finally {
			Conexao.desconectar();
		}
	}

	public static Parcela getParcela(int id) {
		Parcela parcela = new Parcela();
		try {
			Conexao.conectar();
			ParcelaDAO dao = new ParcelaDAO();
			parcela = dao.getParcela(id);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar retornar parcela: " + e);
		} finally {
			Conexao.desconectar();
		}
		return parcela;
	}

	public static void deletar(Parcela parcela) {
		try {
			Conexao.conectar();
			ParcelaDAO dao = new ParcelaDAO();
			dao.delete(parcela);
			Conexao.commit();
			JOptionPane.showMessageDialog(null, "Deletado com sucesso");
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar deletar parcela: " + e);
		} finally {
			Conexao.desconectar();
		}
	}
	
}
