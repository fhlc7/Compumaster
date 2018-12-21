package com.wordpress.fabianosoft.controles;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.wordpress.fabianosoft.conexoes.Conexao;
import com.wordpress.fabianosoft.dao.ParcelaDAO;
import com.wordpress.fabianosoft.entidades.Aluno;
import com.wordpress.fabianosoft.entidades.Carne;
import com.wordpress.fabianosoft.entidades.Parcela;
import com.wordpress.fabianosoft.entidades.Turma;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

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
	
	public static List<Parcela> listar(Aluno aluno, Turma turma){
		List<Parcela> lista = null;
		try {
			Conexao.conectar();
			ParcelaDAO dao = new ParcelaDAO();
			lista = dao.lista(aluno, turma);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar parcelas: " + e);
		} finally {
			Conexao.desconectar();
		}
		return lista;
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
	
	public static void gerarRelatorio(List<Carne> lista) {
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(ParcelaControle.class.getResourceAsStream("/com/wordpress/fabianosoft/relatorios/Carnê.jrxml"));
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
			JasperViewer.viewReport(jasperPrint, false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível gerar o Carnê: " + e);
		}
	}
	
}
