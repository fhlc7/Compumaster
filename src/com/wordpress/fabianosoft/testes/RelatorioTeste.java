package com.wordpress.fabianosoft.testes;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.wordpress.fabianosoft.entidades.Carne;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioTeste {

	public static void main(String[] args) {
		
		try {
			String endereco = RelatorioTeste.class.getResource("/com/wordpress/fabianosoft/relatorios/Carn�.jrxml").toURI().getPath();
			System.out.println(endereco);
			JasperReport report = JasperCompileManager.compileReport(endereco);
			List<Carne> carnes = new ArrayList<Carne>();
			Carne carne = new Carne("Maria", "123", "S�bado", "R$ 250,45", "100", "Montagem & Manuten��o", "12/12/2019", "13 as 15");
			carnes.add(carne);
			carnes.add(carne);
			carnes.add(carne);
			carnes.add(carne);
			carnes.add(carne);
			carnes.add(carne);
			carnes.add(carne);
			JRDataSource dataSource = new JRBeanCollectionDataSource(carnes);
			JasperPrint print = JasperFillManager.fillReport(report, null, dataSource);
			JasperViewer.viewReport(print);
		} catch (Exception e) {
			// TODO Bloco catch gerado automaticamente
			e.printStackTrace();
		}
		
	}
	
}
