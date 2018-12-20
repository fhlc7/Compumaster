package com.fhlc7.forms;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.JobAttributes;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import janelas.CalcularJurosJanela;

public class FrmCompumaster extends JFrame {

	private String vencimento = "07/03/2019";
	private String sobre = "System: Compumaster"
			+ "\n\nVersão: 2.1 / Atualização: 20/12/2018"
			+ "\n\nVencimento: " + vencimento
			+ "\n\nDesenvolvido por: Fabiano Henrique Leitão Coelho"
			+ "\n\nFone, WhatsApp, Telegram: (99) 98854-8517"
			+ "\n\nE-mail: fhlc037@gmail.com"
			+ "\n\nwww.fabianosoft.wordpress.com";
	private URL url = getClass().getResource("/com/fhlc7/imagens/tecnologia-informacao.jpg");
	boolean mudar;
	
	private JPanel contentPane;
	private JLabel lblImagem;
	private JLayeredPane layeredPane;
	private JLabel lblCalendar;

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
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				atualizar();
			}
		});
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				atualizar();
				calendar();
			}
		});
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
		mntmParcela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FrmParcela().setVisible(true);
			}
		});
		mntmParcela.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
		mnRegistro.add(mntmParcela);
		
		JMenu mnFerramentas = new JMenu("Ferramentas");
		mnFerramentas.setMnemonic('f');
		menuBar.add(mnFerramentas);
		
		JMenuItem mntmBlocoDeNotas = new JMenuItem("Bloco de Notas");
		mntmBlocoDeNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				executar("notepad");
			}
		});
		mnFerramentas.add(mntmBlocoDeNotas);
		
		JMenuItem mntmWordpad = new JMenuItem("WordPad");
		mntmWordpad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				executar("write");
			}
		});
		mnFerramentas.add(mntmWordpad);
		
		JMenuItem mntmPaint = new JMenuItem("Paint");
		mntmPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				executar("mspaint");
			}
		});
		mnFerramentas.add(mntmPaint);
		
		JMenuItem mntmCalculadora = new JMenuItem("Calculadora");
		mntmCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				executar("calc");
			}
		});
		mnFerramentas.add(mntmCalculadora);
		
		JMenuItem mntmWindowsExplorer = new JMenuItem("Windows Explorer");
		mntmWindowsExplorer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				executar("explorer");
			}
		});
		mnFerramentas.add(mntmWindowsExplorer);
		
		JMenuItem mntmCalcularJuros = new JMenuItem("Calcular Juros");
		mntmCalcularJuros.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0));
		mntmCalcularJuros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CalcularJurosJanela cjj = new CalcularJurosJanela();
				cjj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				cjj.setVisible(true);
			}
		});
		mnFerramentas.add(mntmCalcularJuros);
		
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
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setMnemonic('s');
		menuBar.add(mnSobre);
		
		JMenuItem mntmDesenvolvedor = new JMenuItem("Desenvolvedor");
		mntmDesenvolvedor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0));
		mntmDesenvolvedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, sobre);
			}
		});
		mnSobre.add(mntmDesenvolvedor);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.setMnemonic('s');
		menuBar.add(mnSair);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sair do sistema?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		mnSair.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(6, 6, 46, 16);
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(102, 53, 228, 108);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCalendar = new JLabel("Calendar");
		lblCalendar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mudar = !mudar;
			}
		});
		lblCalendar.setForeground(Color.BLUE);
		lblCalendar.setFont(new Font("Calibri", Font.BOLD, 99));
		lblCalendar.setHorizontalAlignment(SwingConstants.CENTER);
		layeredPane.add(lblCalendar);
		contentPane.add(lblImagem);
	}
	
	private void atualizar(){
		lblImagem.setText(null);
		int d = 8;
		lblImagem.setBounds(d / 2, d / 2, contentPane.getWidth() - d, contentPane.getHeight() - d);
		layeredPane.setBounds(d / 2, d / 2, contentPane.getWidth() - d, contentPane.getHeight() - d);
		ImageIcon image = new ImageIcon(url);
		ImageIcon icon = new ImageIcon(image.getImage().getScaledInstance(lblImagem.getWidth(), lblImagem.getHeight(), Image.SCALE_DEFAULT));
		lblImagem.setIcon(icon);
	}
	
	private void mudarData(){
		Date agora = new Date();
		if (mudar) {
			lblCalendar.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS").format(agora));
		} else {
			lblCalendar.setText(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(agora));
		}
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date v = f.parse(vencimento);
			Date a = f.parse(lblCalendar.getText());
			File file = new File("c:/comp");
			if (a.getTime() > v.getTime() || file.exists()) {
				String msg = "Seu sistema venceu, entre em contato com o desenvolvedor do sistema:\n\n\n\n" + sobre;
				file.mkdirs();
				JOptionPane.showMessageDialog(null, msg);
				System.exit(0);
			}
		} catch (ParseException e) {
			System.out.println(e);
		}
	}
	
	private void calendar() {
		new Thread(){
			@Override
			public void run() {
				while (true) {
					mudarData();
				}
			}
		}.start();
	}
	
	private void executar(String string) {
		try {
			Runtime.getRuntime().exec(string);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
}
