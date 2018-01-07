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
import javax.swing.JOptionPane;

import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;

public class FrmCompumaster extends JFrame {

	private String sobre = "Sistema: Compumaster"
			+ "\n\nVersão: 1.0 / Atualização: 07/01/2018"
			+ "\n\nDesenvolvido por: Fabiano Henrique Leitão Coelho"
			+ "\n\nFone, WhatsApp, Telegram: (99) 98854-8517"
			+ "\n\nE-mail: fabiano@fhlc7.com"
			+ "\n\nwww.fhlc7.com";
	
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
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCompumaster.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setTitle("Compumaster");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		mnCadastro.setMnemonic('c');
		menuBar.add(mnCadastro);
		
		JMenuItem mntmAluno = new JMenuItem("Aluno");
		mntmAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmAluno().setVisible(true);
			}
		});
		mnCadastro.add(mntmAluno);
		
		JMenuItem mntmTurma = new JMenuItem("Turma");
		mntmTurma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mntmTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmTurma().setVisible(true);
			}
		});
		mnCadastro.add(mntmTurma);
		
		JMenu mnRegistro = new JMenu("Registro");
		mnRegistro.setMnemonic('r');
		menuBar.add(mnRegistro);
		
		JMenuItem mntmMatrcula = new JMenuItem("Matr\u00EDcula");
		mntmMatrcula.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
		mntmMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmMatricula().setVisible(true);
			}
		});
		mnRegistro.add(mntmMatrcula);
		
		JMenuItem mntmChamada = new JMenuItem("Chamada");
		mntmChamada.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0));
		mntmChamada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new FrmChamada().setVisible(true);
			}
		});
		mnRegistro.add(mntmChamada);
		
		JMenuItem mntmParcela = new JMenuItem("Parcela");
		mntmParcela.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnRegistro.add(mntmParcela);
		
		JMenu mnConfigurao = new JMenu("Configura\u00E7\u00E3o");
		mnConfigurao.setMnemonic('o');
		menuBar.add(mnConfigurao);
		
		JMenuItem mntmUsurio = new JMenuItem("Usu\u00E1rio");
		mntmUsurio.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0));
		mntmUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmUsuario().setVisible(true);
			}
		});
		mnConfigurao.add(mntmUsurio);
		
		JMenu mnAjuda = new JMenu("Ajuda");
		mnAjuda.setMnemonic('a');
		menuBar.add(mnAjuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, sobre);
			}
		});
		mnAjuda.add(mntmSobre);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setMnemonic('s');
		menuBar.add(mnSair);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		mnSair.add(mntmSair);
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
				.addGap(0, 229, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}

}
