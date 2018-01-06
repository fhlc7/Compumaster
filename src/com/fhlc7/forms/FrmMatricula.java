package com.fhlc7.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;

import com.fhlc7.controles.AlunoControle;
import com.fhlc7.controles.MatriculaControle;
import com.fhlc7.controles.TurmaControle;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Matricula;
import com.fhlc7.entidades.Turma;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.CardLayout;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmMatricula extends JFrame {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private Turma turma = new Turma();
	private Aluno aluno = new Aluno();
	private Matricula matricula = new Matricula();
	
	private JPanel contentPane;
	private JTextField txtProcurarTurma;
	private JTable tableTurma;
	private JTable tableMatricula;
	private JLabel lblTurma;
	private JPanel panelTurma;
	private JPanel panelMatricula;
	private JPanel panelAluno;
	private JButton btnVoltar;
	private JTextField txtProcurarAluno;
	private JTable tableAluno;

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
					FrmMatricula frame = new FrmMatricula();
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
	public FrmMatricula() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				atualizar();
			}
		});
		setResizable(false);
		setTitle("Matr\u00EDculas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMatricula.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelTurma = new JPanel();
		contentPane.add(panelTurma, "name_1802151457432");
		
		JLabel lblSelecioneUmaTurma = new JLabel("Selecione uma Turma");
		lblSelecioneUmaTurma.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUmaTurma.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JLabel lblProcurar = new JLabel("Procurar:");
		lblProcurar.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		txtProcurarTurma = new JTextField();
		txtProcurarTurma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				recarregarTabelaTurma();
			}
		});
		txtProcurarTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtProcurarTurma.setText("Procurar");
		txtProcurarTurma.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelTurma = new GroupLayout(panelTurma);
		gl_panelTurma.setHorizontalGroup(
			gl_panelTurma.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelTurma.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTurma.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
						.addComponent(lblSelecioneUmaTurma, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_panelTurma.createSequentialGroup()
							.addComponent(lblProcurar)
							.addGap(18)
							.addComponent(txtProcurarTurma, GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelTurma.setVerticalGroup(
			gl_panelTurma.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTurma.createSequentialGroup()
					.addGap(47)
					.addComponent(lblSelecioneUmaTurma)
					.addGap(33)
					.addGroup(gl_panelTurma.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProcurarTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblProcurar))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		tableTurma = new JTable();
		tableTurma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				selecionarTurma(e);
			}
		});
		tableTurma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarTurma(e);
			}
		});
		scrollPane.setViewportView(tableTurma);
		panelTurma.setLayout(gl_panelTurma);
		
		panelMatricula = new JPanel();
		contentPane.add(panelMatricula, "name_3826389354609");
		
		lblTurma = new JLabel("Turma:");
		lblTurma.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTurma.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_panelAlunosMatriculados = new GroupLayout(panelMatricula);
		gl_panelAlunosMatriculados.setHorizontalGroup(
			gl_panelAlunosMatriculados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlunosMatriculados.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAlunosMatriculados.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAlunosMatriculados.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panelAlunosMatriculados.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
							.addContainerGap())
						.addComponent(lblTurma, GroupLayout.PREFERRED_SIZE, 978, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panelAlunosMatriculados.setVerticalGroup(
			gl_panelAlunosMatriculados.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlunosMatriculados.createSequentialGroup()
					.addComponent(lblTurma, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionarAluno();
			}
		});
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltar();
			}
		});
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		btnVoltar.setMnemonic('v');
		btnVoltar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnVoltar.setBackground(Color.GREEN);
		panel.add(btnVoltar);
		panel.add(btnAdicionar);
		btnAdicionar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAdicionar.setBackground(Color.CYAN);
		btnAdicionar.setMnemonic('a');
		
		tableMatricula = new JTable();
		tableMatricula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarAluno(e, "remover");
			}
		});
		scrollPane_1.setViewportView(tableMatricula);
		panelMatricula.setLayout(gl_panelAlunosMatriculados);
		
		panelAluno = new JPanel();
		contentPane.add(panelAluno, "name_897038100982");
		
		JLabel label = new JLabel("Procurar:");
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		txtProcurarAluno = new JTextField();
		txtProcurarAluno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				recarregarTabelaAluno();
			}
		});
		txtProcurarAluno.setText("Procurar");
		txtProcurarAluno.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtProcurarAluno.setColumns(10);
		
		JLabel lblSelecioneUmAluno = new JLabel("Selecione um Aluno");
		lblSelecioneUmAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelecioneUmAluno.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setMnemonic('c');
		btnCancelar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnCancelar.setBackground(Color.YELLOW);
		panel_1.add(btnCancelar);
		GroupLayout gl_panelAluno = new GroupLayout(panelAluno);
		gl_panelAluno.setHorizontalGroup(
			gl_panelAluno.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAluno.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAluno.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
						.addComponent(lblSelecioneUmAluno, GroupLayout.PREFERRED_SIZE, 972, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelAluno.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(txtProcurarAluno, GroupLayout.PREFERRED_SIZE, 899, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 972, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelAluno.setVerticalGroup(
			gl_panelAluno.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAluno.createSequentialGroup()
					.addGap(26)
					.addGap(20)
					.addComponent(lblSelecioneUmAluno, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_panelAluno.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAluno.createSequentialGroup()
							.addGap(6)
							.addComponent(label))
						.addComponent(txtProcurarAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
		);
		
		tableAluno = new JTable();
		tableAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarAluno(e, "adicionar");
			}
		});
		tableAluno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				selecionarAluno(e, "adicionar");
			}
		});
		scrollPane_2.setViewportView(tableAluno);
		panelAluno.setLayout(gl_panelAluno);
	}
	
	private void selecionarPainel(JPanel painel){
		if (painel.equals(panelTurma)) {
			panelTurma.setVisible(true);
			panelMatricula.setVisible(false);
			panelAluno.setVisible(false);
		} else if (painel.equals(panelMatricula)) {
			panelTurma.setVisible(false);
			panelMatricula.setVisible(true);
			panelAluno.setVisible(false);
		} else if (painel.equals(panelAluno)) {
			panelTurma.setVisible(false);
			panelMatricula.setVisible(false);
			panelAluno.setVisible(true);
		}
	}
	
	private void atualizar(){
		limpar();
		recarregarTabelaTurma();
		txtProcurarTurma.requestFocus();
	}
	
	private void limpar(){
		String s = null;
		txtProcurarTurma.setText(s);
		txtProcurarAluno.setText(s);
	}
	
	private void recarregarTabelaTurma(){
		tableTurma.setModel(TurmaControle.defaultTableModel(txtProcurarTurma.getText().trim()));
		tableTurma.getColumnModel().getColumn(0).setPreferredWidth(7);
	}
	
	private void recarregarTabelaAluno(){
		tableAluno.setModel(AlunoControle.defaultTableModel(txtProcurarAluno.getText().trim()));
		tableAluno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < tableAluno.getColumnCount(); i++) {
			tableAluno.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
	}
	
	private void recarregarTabelaMatricula(Turma turma){
		tableMatricula.setModel(MatriculaControle.defaultTableModel(turma));
		tableMatricula.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < tableMatricula.getColumnCount(); i++) {
			tableMatricula.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
	}
	
	private void selecionarTurma(MouseEvent e){
		if (e.getClickCount() >= 2){
			turmaSelecionada();
		}
	}
	
	private void selecionarTurma(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			turmaSelecionada();
			e.consume();
		}
	}
	
	private void selecionarAluno(MouseEvent e, String cmd){
		if (e.getClickCount() >= 2){
			alunoSelecionado(cmd);
		}
	}
	
	private void selecionarAluno(KeyEvent e, String cmd){
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			alunoSelecionado(cmd);
			e.consume();
		}
	}
	
	private void alunoSelecionado(String cmd){
		if (cmd.equals("adicionar")){
			salvar();
		} else if (cmd.equals("remover")){
			remover();
		}
		
	}
	
	private void salvar() {
		int id = retornarId(tableAluno, "Matrícula");
		aluno = AlunoControle.getAluno(id);
		matricula.setAluno(aluno);
		matricula.setTurma(turma);
		MatriculaControle.salvar(matricula);
		selecionarPainel(panelMatricula);
		recarregarTabelaMatricula(turma);
	}
	
	private int retornarId(JTable table, String nomeId){
		int l = table.getSelectedRow();
		int c = 0;
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (table.getColumnName(i).equals(nomeId)){
				c = i;
				break;
			}
		}
		return Integer.valueOf(table.getValueAt(l, c).toString());
	}
	
	private void turmaSelecionada(){
		selecionarPainel(panelMatricula);
		int id = retornarId(tableTurma, "Código");
		turma = TurmaControle.getTurma(id);
		lblTurma.setText("Turma: " 
				+ turma.getId() + " | "
				+ turma.getDiaDaSemana() + " | "
				+ turma.getHorario() + " | "
				+ turma.getCurso() + " | "
				+ turma.getStatus() + " | "
				+ (turma.getDataInicio() == null ? "Sem data de Início" : dateFormat.format(turma.getDataInicio().getTime())) + " | "
				+ (turma.getDataTermino() == null ? "Sem data de Término" : dateFormat.format(turma.getDataTermino().getTime())));
		recarregarTabelaMatricula(turma);
	}
	
	private void adicionarAluno(){
		limpar();
		selecionarPainel(panelAluno);
		recarregarTabelaAluno();
		txtProcurarAluno.requestFocus();
	}
	
	private void voltar(){
		selecionarPainel(panelTurma);
	}
	
	private void cancelar() {
		selecionarPainel(panelMatricula);
	}
	
	private void remover() {
		int id = retornarId(tableMatricula, "Matrícula");
		aluno = AlunoControle.getAluno(id);
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja remover o aluno " + aluno.getId() + ": " + aluno.getNomeAluno() + "?", getTitle(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			matricula.setAluno(aluno);
			matricula.setTurma(turma);
			MatriculaControle.deletar(matricula);
			recarregarTabelaMatricula(turma);
		}
	}
}
