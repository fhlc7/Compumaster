package com.wordpress.fabianosoft.controles;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.wordpress.fabianosoft.conexoes.Conexao;
import com.wordpress.fabianosoft.dao.ChamadaDAO;
import com.wordpress.fabianosoft.dao.MatriculaDAO;
import com.wordpress.fabianosoft.entidades.Aluno;
import com.wordpress.fabianosoft.entidades.Chamada;
import com.wordpress.fabianosoft.entidades.ControleChamada;
import com.wordpress.fabianosoft.entidades.Turma;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

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
		DefaultTableModel defaultTableModel = new DefaultTableModel(null, new Object[] {"Nº", "Data", "Quantidade de alunos presentes"}){
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
					sdf.format(chamada.getData().getTime()),
					chamada.getObs()
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
	
	public static List<ControleChamada> listar(Turma turma) {
		List<ControleChamada> lista = new ArrayList<ControleChamada>();
		try {
			Conexao.conectar();
			MatriculaDAO dao = new MatriculaDAO();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int numero = 0;
			for (Aluno aluno : dao.alunosMatriculados(turma)) {
				ControleChamada controleChamada = new ControleChamada(
						turma.getDiaDaSemana(), 
						turma.getHorario(), 
						turma.getCurso(), 
						sdf.format(turma.getDataInicio().getTime()), 
						sdf.format(turma.getDataTermino().getTime()), 
						String.valueOf(++numero), 
						aluno.getId() + ": " + aluno.getNomeAluno());
				lista.add(controleChamada);
			}
			Conexao.commit();
		} catch (Exception e) {
			Conexao.rollback();
			JOptionPane.showMessageDialog(null, "Erro ao tentar listar Controle de Chamada: " + e);
		} finally {
			Conexao.desconectar();
		}
		return lista;
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
	
	public static void gerarRelatorio(List<ControleChamada> lista) {
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(ParcelaControle.class.getResourceAsStream("/com/wordpress/fabianosoft/relatorios/Chamada.jrxml"));
			JRDataSource jrDataSource = new JRBeanCollectionDataSource(lista);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, jrDataSource);
			JasperViewer.viewReport(jasperPrint, false);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não foi possível gerar a Chamada: " + e);
		}
	}
	
}
