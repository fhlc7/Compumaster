package com.fhlc7.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FrmCompumaster extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCompumaster frame = new FrmCompumaster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCompumaster() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCompumaster.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setTitle("Compumaster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmAluno = new JMenuItem("Aluno");
		mntmAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmAluno().setVisible(true);
			}
		});
		mnCadastro.add(mntmAluno);
		
		JMenuItem mntmTurma = new JMenuItem("Turma");
		mntmTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmTurma().setVisible(true);
			}
		});
		mnCadastro.add(mntmTurma);
		
		JMenu mnMatrcula = new JMenu("Matr\u00EDcula");
		menuBar.add(mnMatrcula);
		
		JMenuItem mntmMatrcula = new JMenuItem("Matr\u00EDcula");
		mntmMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmMatricula().setVisible(true);
			}
		});
		mnMatrcula.add(mntmMatrcula);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 252, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
