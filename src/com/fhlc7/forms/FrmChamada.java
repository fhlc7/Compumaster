package com.fhlc7.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fhlc7.controles.AlunoControle;
import com.fhlc7.controles.ChamadaControle;
import com.fhlc7.controles.MatriculaControle;
import com.fhlc7.controles.TurmaControle;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Chamada;
import com.fhlc7.entidades.Turma;

import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class FrmChamada extends JFrame {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private Turma turma = new Turma();
	private Aluno aluno = new Aluno();
	private Chamada chamada = new Chamada();
	
	private JPanel contentPane;
	private JTextField txtProcurarTurma;
	private JTable tableTurma;
	private JLabel lblTurmaChamada;
	private JPanel panelTurma;
	private JPanel panelChamada;
	private JTable tableMatriculas;
	private JTable tableChamada;
	private JDateChooser dateChooser;
	private JLabel lblObs;
	private JScrollPane scrollPane_3;
	private JTextArea txtrObs;
	private JPanel panelChamadas;
	private JLabel lblTurmaChamadas;
	private JScrollPane scrollPane_4;
	private JTable tableChamadas;
	private JPanel panel_1;
	private JButton btnVoltar_1;
	private JButton btnNova;
	private JButton button_5;
	private JButton btnAtualizar;

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
					FrmChamada frame = new FrmChamada();
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
	public FrmChamada() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				atualizar();
			}
		});
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmChamada.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setTitle("Chamada");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelTurma = new JPanel();
		contentPane.add(panelTurma, "name_7858013555618");
		
		JLabel label = new JLabel("Selecione uma Turma");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JLabel label_1 = new JLabel("Procurar:");
		label_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		txtProcurarTurma = new JTextField();
		txtProcurarTurma.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				recarregarTabelaTurma();
			}
		});
		txtProcurarTurma.setText("Procurar");
		txtProcurarTurma.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtProcurarTurma.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelTurma = new GroupLayout(panelTurma);
		gl_panelTurma.setHorizontalGroup(
			gl_panelTurma.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelTurma.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTurma.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 972, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelTurma.createSequentialGroup()
							.addComponent(label_1)
							.addGap(18)
							.addComponent(txtProcurarTurma, GroupLayout.PREFERRED_SIZE, 899, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 972, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelTurma.setVerticalGroup(
			gl_panelTurma.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelTurma.createSequentialGroup()
					.addContainerGap(47, Short.MAX_VALUE)
					.addGap(41)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addGroup(gl_panelTurma.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTurma.createSequentialGroup()
							.addGap(6)
							.addComponent(label_1))
						.addComponent(txtProcurarTurma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 499, GroupLayout.PREFERRED_SIZE)
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
		
		panelChamadas = new JPanel();
		contentPane.add(panelChamadas, "name_14397992291985");
		
		lblTurmaChamadas = new JLabel("Turma:");
		lblTurmaChamadas.setBackground(Color.CYAN);
		lblTurmaChamadas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurmaChamadas.setFont(new Font("Calibri", Font.BOLD, 18));
		
		scrollPane_4 = new JScrollPane();
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarPainel(panelTurma);
			}
		});
		btnVoltar_1.setMnemonic('v');
		panel_1.add(btnVoltar_1);
		
		btnNova = new JButton("Nova");
		btnNova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nova();
			}
		});
		btnNova.setMnemonic('n');
		panel_1.add(btnNova);
		
		button_5 = new JButton("Fechar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_5.setMnemonic('f');
		panel_1.add(button_5);
		GroupLayout gl_panelChamadas = new GroupLayout(panelChamadas);
		gl_panelChamadas.setHorizontalGroup(
			gl_panelChamadas.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelChamadas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelChamadas.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
						.addComponent(lblTurmaChamadas, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 972, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 972, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelChamadas.setVerticalGroup(
			gl_panelChamadas.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChamadas.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTurmaChamadas, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_4, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		tableChamadas = new JTable();
		tableChamadas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				selecionarChamadas(e);
			}
		});
		tableChamadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarChamadas(e);
			}
		});
		scrollPane_4.setViewportView(tableChamadas);
		panelChamadas.setLayout(gl_panelChamadas);
		
		panelChamada = new JPanel();
		contentPane.add(panelChamada, "name_7873089012802");
		
		lblTurmaChamada = new JLabel("Turma:");
		lblTurmaChamada.setBounds(6, 40, 972, 45);
		lblTurmaChamada.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurmaChamada.setFont(new Font("Calibri", Font.BOLD, 18));
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(834, 6, 144, 28);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(793, 12, 29, 16);
		lblData.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 128, 487, 353);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(499, 128, 479, 444);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 578, 972, 78);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionarPainel(panelChamadas);
				recarregarTabelaChamadas(turma);
			}
		});
		btnVoltar.setMnemonic('v');
		panel.add(btnVoltar);
		
		JButton button_4 = new JButton("Fechar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_4.setMnemonic('f');
		panel.add(button_4);
		
		lblObs = new JLabel("Obs.:");
		lblObs.setBounds(6, 493, 29, 16);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(41, 484, 452, 88);
		
		txtrObs = new JTextArea();
		txtrObs.setText("Obs");
		scrollPane_3.setViewportView(txtrObs);
		
		tableChamada = new JTable();
		tableChamada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarAluno(e, "deletar");
			}
		});
		scrollPane_2.setViewportView(tableChamada);
		
		tableMatriculas = new JTable();
		tableMatriculas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				selecionarAluno(e, "adicionar");
			}
		});
		tableMatriculas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarAluno(e, "adicionar");
			}
		});
		scrollPane_1.setViewportView(tableMatriculas);
		panelChamada.setLayout(null);
		panelChamada.add(lblData);
		panelChamada.add(dateChooser);
		panelChamada.add(lblTurmaChamada);
		panelChamada.add(scrollPane_1);
		panelChamada.add(scrollPane_2);
		panelChamada.add(panel);
		panelChamada.add(lblObs);
		panelChamada.add(scrollPane_3);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarChamada();
			}
		});
		btnAtualizar.setMnemonic('a');
		btnAtualizar.setBounds(691, 6, 90, 28);
		panelChamada.add(btnAtualizar);
		
		JLabel lblAlunosMatriculadosNesta = new JLabel("Alunos matriculados nesta turma:");
		lblAlunosMatriculadosNesta.setForeground(Color.BLUE);
		lblAlunosMatriculadosNesta.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblAlunosMatriculadosNesta.setBounds(6, 97, 233, 19);
		panelChamada.add(lblAlunosMatriculadosNesta);
		
		JLabel lblChamada = new JLabel("Alunos presentes na chamada:");
		lblChamada.setForeground(Color.BLUE);
		lblChamada.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblChamada.setBounds(499, 97, 233, 19);
		panelChamada.add(lblChamada);
	}
	
	private void nova() {
		selecionarPainel(panelChamada);
		limpar();
		recarregarTabelaMatriculas(turma);
		tableChamada.setModel(new DefaultTableModel());
	}

	private void atualizar() {
		limpar();
		recarregarTabelaTurma();
		txtProcurarTurma.requestFocus();
	}
	
	private void selecionarPainel(JPanel painel) {
		if (painel.equals(panelTurma)) {
			panelTurma.setVisible(true);
			panelChamadas.setVisible(false);
			panelChamada.setVisible(false);
		} else if (painel.equals(panelChamadas)) {
			panelTurma.setVisible(false);
			panelChamadas.setVisible(true);
			panelChamada.setVisible(false);
		} else if (painel.equals(panelChamada)) {
			panelTurma.setVisible(false);
			panelChamadas.setVisible(false);
			panelChamada.setVisible(true);
		}
	}
	
	private void limpar() {
		String t = null;
		txtProcurarTurma.setText(t);
		dateChooser.setCalendar(null);
		txtrObs.setText(t);
	}
	
	private void recarregarTabelaTurma(){
		tableTurma.setModel(TurmaControle.defaultTableModel(txtProcurarTurma.getText().trim()));
		tableTurma.getColumnModel().getColumn(0).setPreferredWidth(7);
	}
	
	private String retornarObjeto(JTable table, String nomeId){
		int l = table.getSelectedRow();
		int c = 0;
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (table.getColumnName(i).equals(nomeId)){
				c = i;
				break;
			}
		}
		return table.getValueAt(l, c).toString();
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
	
	private void turmaSelecionada(){
		selecionarPainel(panelChamadas);
		int id = Integer.valueOf(retornarObjeto(tableTurma, "Código"));
		turma = TurmaControle.getTurma(id);
		String turmaLabel = "Turma: " 
				+ turma.getId() + " | "
				+ turma.getDiaDaSemana() + " | "
				+ turma.getHorario() + " | "
				+ turma.getCurso() + " | "
				+ turma.getStatus() + " | "
				+ (turma.getDataInicio() == null ? "Sem data de Início" : dateFormat.format(turma.getDataInicio().getTime())) + " | "
				+ (turma.getDataTermino() == null ? "Sem data de Término" : dateFormat.format(turma.getDataTermino().getTime()));
		lblTurmaChamadas.setText(turmaLabel);
		lblTurmaChamada.setText(turmaLabel);
		recarregarTabelaChamadas(turma);
	}
	
	private void recarregarTabelaChamadas(Turma turma){
		tableChamadas.setModel(ChamadaControle.defaultTableModelChamadas(turma));
		//tableChamadas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < tableChamadas.getColumnCount(); i++) {
			tableChamadas.getColumnModel().getColumn(i).setPreferredWidth(150);
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
		} else if (cmd.equals("deletar")){
			remover();
		}
	}
	
	private void salvar() {
		int id = Integer.valueOf(retornarObjeto(tableMatriculas, "Matrícula"));
		aluno = AlunoControle.getAluno(id);
		if (dateChooser.getCalendar() == null) {
			JOptionPane.showMessageDialog(null, "Escolha a data");
			dateChooser.requestFocus();
			tableChamada.setModel(new DefaultTableModel());
			return;
		}
		chamada.setData(dateChooser.getCalendar());
		chamada.setAluno(aluno);
		chamada.setTurma(turma);
		chamada.setObs(txtrObs.getText().trim());
		ChamadaControle.salvar(chamada);
		txtrObs.setText(null);
		//recarregarTabelaMatriculas(turma);
		recarregarTabelaChamada(chamada);
	}
	
	private void remover() {
		if (dateChooser.getCalendar() == null) {
			JOptionPane.showMessageDialog(null, "Escolha a data");
			dateChooser.requestFocus();
			tableChamada.setModel(new DefaultTableModel());
			return;
		}
		int id = Integer.valueOf(retornarObjeto(tableChamada, "Matrícula"));
		aluno = AlunoControle.getAluno(id);
		if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja colocar falta no aluno " + aluno.getId() + ": " + aluno.getNomeAluno() + "?", getTitle(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			chamada.setData(dateChooser.getCalendar());
			chamada.setAluno(aluno);
			//chamada.setTurma(turma);
			//chamada.setObs(txtrObs.getText().trim());
			ChamadaControle.deletar(chamada);
			recarregarTabelaChamada(chamada);
		}
	}
	
	private void recarregarTabelaMatriculas(Turma turma){
		tableMatriculas.setModel(MatriculaControle.defaultTableModel(turma));
		tableMatriculas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < tableMatriculas.getColumnCount(); i++) {
			tableMatriculas.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
	}
	
	private void recarregarTabelaChamada(Chamada chamada){
		tableChamada.setModel(ChamadaControle.defaultTableModelChamada(chamada));
		tableChamada.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < tableChamada.getColumnCount(); i++) {
			tableChamada.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
	}
	
	private void atualizarChamada(){
		if (dateChooser.getCalendar() == null) {
			JOptionPane.showMessageDialog(null, "Escolha a data");
			dateChooser.requestFocus();
			tableChamada.setModel(new DefaultTableModel());
			return;
		}
		chamada.setData(dateChooser.getCalendar());
		//chamada.setAluno(aluno);
		chamada.setTurma(turma);
		//chamada.setObs(txtrObs.getText().trim());
		recarregarTabelaChamada(chamada);
	}
	
	private void selecionarChamadas(MouseEvent e){
		if (e.getClickCount() >= 2){
			chamadasSelecionada();
		}
	}
	
	private void selecionarChamadas(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			chamadasSelecionada();
			e.consume();
		}
	}
	
	private void chamadasSelecionada(){
		nova();
		String data = retornarObjeto(tableChamadas, "Data");
		String[] v = data.split("/");
		String d = v[0], m = v[1], a = v[2];
		int dia = Integer.valueOf(d), mes = Integer.valueOf(m) - 1, ano = Integer.valueOf(a);
		dateChooser.setCalendar(new GregorianCalendar(ano, mes, dia));
		atualizarChamada();
	}
}
