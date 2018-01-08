package com.fhlc7.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.fhlc7.controles.AlunoControle;
import com.fhlc7.controles.MatriculaControle;
import com.fhlc7.controles.ParcelaControle;
import com.fhlc7.controles.TurmaControle;
import com.fhlc7.entidades.Aluno;
import com.fhlc7.entidades.Matricula;
import com.fhlc7.entidades.Parcela;
import com.fhlc7.entidades.Turma;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmParcela extends JFrame {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private Turma turma = new Turma();
	private Aluno aluno = new Aluno();
	private Parcela parcela = new Parcela();
	
	private JPanel contentPane;
	private JTextField txtProcurar;
	private JTable tableTurma;
	private JTable tableAluno;
	private JTextField txtId;
	private JLabel lblTurma2;
	private JLabel lblAluno;
	private JLabel lblTurma1;
	private JTextField txtValorPago;
	private JPanel panelTurmas;
	private JPanel panelAlunos;
	private JPanel panelParcela;
	private JTable tableParcela;
	private JDateChooser dateChooserDataDeVencimento;
	private JDateChooser dateChooserDataDePagamento;

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
					FrmParcela frame = new FrmParcela();
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
	public FrmParcela() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				atualizar();
			}
		});
		setTitle("Parcela");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmParcela.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panelTurmas = new JPanel();
		contentPane.add(panelTurmas, "name_29621081172592");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("Selecione uma Turma");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.BOLD, 25));
		
		JLabel label_1 = new JLabel("Procurar:");
		label_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		txtProcurar = new JTextField();
		txtProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				recarregarTabelaTurma();
			}
		});
		txtProcurar.setText("Procurar");
		txtProcurar.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtProcurar.setColumns(10);
		GroupLayout gl_panelTurmas = new GroupLayout(panelTurmas);
		gl_panelTurmas.setHorizontalGroup(
			gl_panelTurmas.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 984, Short.MAX_VALUE)
				.addGroup(gl_panelTurmas.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelTurmas.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
						.addGroup(gl_panelTurmas.createSequentialGroup()
							.addComponent(label_1)
							.addGap(18)
							.addComponent(txtProcurar, GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelTurmas.setVerticalGroup(
			gl_panelTurmas.createParallelGroup(Alignment.LEADING)
				.addGap(0, 662, Short.MAX_VALUE)
				.addGroup(gl_panelTurmas.createSequentialGroup()
					.addGap(47)
					.addComponent(label)
					.addGap(33)
					.addGroup(gl_panelTurmas.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtProcurar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
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
		panelTurmas.setLayout(gl_panelTurmas);
		
		panelAlunos = new JPanel();
		contentPane.add(panelAlunos, "name_29719131962084");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltarParaTurmas();
			}
		});
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setMnemonic('v');
		btnVoltar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnVoltar.setBackground(Color.BLACK);
		panel_1.add(btnVoltar);
		
		lblTurma1 = new JLabel("Turma:");
		lblTurma1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurma1.setFont(new Font("Calibri", Font.BOLD, 18));
		GroupLayout gl_panelAlunos = new GroupLayout(panelAlunos);
		gl_panelAlunos.setHorizontalGroup(
			gl_panelAlunos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlunos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelAlunos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelAlunos.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panelAlunos.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 972, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(lblTurma1, GroupLayout.PREFERRED_SIZE, 964, GroupLayout.PREFERRED_SIZE))
					.addGap(10))
		);
		gl_panelAlunos.setVerticalGroup(
			gl_panelAlunos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelAlunos.createSequentialGroup()
					.addComponent(lblTurma1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBackground(Color.BLUE);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recarregarTabelaMatricula(turma);
			}
		});
		btnAtualizar.setFont(new Font("Calibri", Font.BOLD, 18));
		btnAtualizar.setMnemonic('a');
		panel_1.add(btnAtualizar);
		
		tableAluno = new JTable();
		tableAluno.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selecionarAluno(e);
			}
		});
		tableAluno.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				selecionarAluno(e);
			}
		});
		scrollPane_1.setViewportView(tableAluno);
		panelAlunos.setLayout(gl_panelAlunos);
		
		panelParcela = new JPanel();
		contentPane.add(panelParcela, "name_29918979322567");
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setLayout(new GridLayout(0, 7, 0, 0));
		
		JButton btnVoltar_1 = new JButton("Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				voltarParaAlunos();
			}
		});
		btnVoltar_1.setMnemonic('v');
		panel_3.add(btnVoltar_1);
		
		JButton button = new JButton("Atualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarParcela();
			}
		});
		button.setMnemonic('a');
		panel_3.add(button);
		
		JButton btnGerarParcelas = new JButton("Gerar Parcela(s)");
		btnGerarParcelas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarParcelas();
			}
		});
		btnGerarParcelas.setMnemonic('g');
		panel_3.add(btnGerarParcelas);
		
		JButton button_1 = new JButton("Novo");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novo();
			}
		});
		button_1.setMnemonic('n');
		panel_3.add(button_1);
		
		JButton button_2 = new JButton("Salvar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		button_2.setMnemonic('s');
		panel_3.add(button_2);
		
		JButton button_3 = new JButton("Deletar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		button_3.setMnemonic('d');
		panel_3.add(button_3);
		
		JButton button_4 = new JButton("Fechar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_4.setMnemonic('f');
		panel_3.add(button_4);
		
		JLabel lblId = new JLabel("C\u00F3digo:");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBackground(Color.CYAN);
		txtId.setText("id");
		txtId.setColumns(10);
		
		lblTurma2 = new JLabel("Turma:");
		lblTurma2.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lblAluno = new JLabel("Aluno:");
		lblAluno.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		JLabel lblDataDeVencimento = new JLabel("Data de Vencimento:");
		
		dateChooserDataDeVencimento = new JDateChooser();
		
		JLabel lblDataDePagamento = new JLabel("Data de Pagamento:");
		
		dateChooserDataDePagamento = new JDateChooser();
		
		JLabel lblValorPago = new JLabel("Valor Pago:");
		
		txtValorPago = new JTextField();
		txtValorPago.setText("Valor Pago");
		txtValorPago.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblTurma2, GroupLayout.PREFERRED_SIZE, 946, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDataDeVencimento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooserDataDeVencimento, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDataDePagamento)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooserDataDePagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblValorPago)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtValorPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAluno, GroupLayout.PREFERRED_SIZE, 946, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTurma2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblAluno)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblId))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblDataDeVencimento))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblDataDePagamento))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(lblValorPago))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(txtValorPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(dateChooserDataDeVencimento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(dateChooserDataDePagamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {dateChooserDataDePagamento, dateChooserDataDeVencimento});
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		tableParcela = new JTable();
		tableParcela.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editar();
			}
		});
		tableParcela.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				editar();
			}
		});
		scrollPane_2.setViewportView(tableParcela);
		GroupLayout gl_panelParcela = new GroupLayout(panelParcela);
		gl_panelParcela.setHorizontalGroup(
			gl_panelParcela.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelParcela.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelParcela.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelParcela.setVerticalGroup(
			gl_panelParcela.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelParcela.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_2, GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
		);
		panelParcela.setLayout(gl_panelParcela);
	}
	
	private void atualizar(){
		limpar();
		recarregarTabelaTurma();
		txtProcurar.requestFocus();
	}
	
	private void atualizarParcela(){
		limpar();
		recarregarTabelaParcela(aluno, turma);
		dateChooserDataDeVencimento.requestFocus();
	}
	
	private void limpar(){
		String s = null;
		txtProcurar.setText(s);
		txtId.setText(s);
		dateChooserDataDeVencimento.setCalendar(null);
		dateChooserDataDePagamento.setCalendar(null);
		txtValorPago.setText(s);
	}
	
	private void selecionarPainel(JPanel painel){
		if (painel.equals(panelTurmas)) {
			panelTurmas.setVisible(true);
			panelAlunos.setVisible(false);
			panelParcela.setVisible(false);
		} else if (painel.equals(panelAlunos)) {
			panelTurmas.setVisible(false);
			panelAlunos.setVisible(true);
			panelParcela.setVisible(false);
		} else if (painel.equals(panelParcela)) {
			panelTurmas.setVisible(false);
			panelAlunos.setVisible(false);
			panelParcela.setVisible(true);
		}
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
	
	private void recarregarTabelaTurma(){
		tableTurma.setModel(TurmaControle.defaultTableModel(txtProcurar.getText().trim()));
		tableTurma.getColumnModel().getColumn(0).setPreferredWidth(7);
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
		selecionarPainel(panelAlunos);
		int id = retornarId(tableTurma, "Código");
		turma = TurmaControle.getTurma(id);
		String turmaString = "Turma: " 
				+ turma.getId() + " | "
				+ turma.getDiaDaSemana() + " | "
				+ turma.getHorario() + " | "
				+ turma.getCurso() + " | "
				+ turma.getStatus() + " | "
				+ (turma.getDataInicio() == null ? "Sem data de Início" : dateFormat.format(turma.getDataInicio().getTime())) + " | "
				+ (turma.getDataTermino() == null ? "Sem data de Término" : dateFormat.format(turma.getDataTermino().getTime()));
		lblTurma1.setText(turmaString);
		lblTurma2.setText(turmaString);
		recarregarTabelaMatricula(turma);
	}
	
	private void recarregarTabelaMatricula(Turma turma){
		tableAluno.setModel(MatriculaControle.defaultTableModel(turma));
		tableAluno.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < tableAluno.getColumnCount(); i++) {
			tableAluno.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
	}
	
	private void voltarParaTurmas(){
		selecionarPainel(panelTurmas);
	}
	
	private void voltarParaAlunos(){
		selecionarPainel(panelAlunos);
	}
	
	private void selecionarAluno(MouseEvent e){
		if (e.getClickCount() >= 2){
			alunoSelecionado();
		}
	}
	
	private void selecionarAluno(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_ENTER){
			alunoSelecionado();
			e.consume();
		}
	}
	
	private void alunoSelecionado(){
		selecionarPainel(panelParcela);
		limpar();
		int id = retornarId(tableAluno, "Matrícula");
		aluno = AlunoControle.getAluno(id);
		String alunoString = "Aluno: " 
				+ aluno.getId() + " | "
				+ aluno.getNomeAluno() + " | "
				+ (aluno.getDataDeNascimento() == null ? "Sem data de nascimento" : dateFormat.format(aluno.getDataDeNascimento().getTime())) + " | "
				+ aluno.getNomeResponsavel() + " | "
				+ aluno.getRg() + " | "
				+ aluno.getCpfCnpj() + " | "
				+ aluno.getFone1() + " | "
				+ aluno.getFone2() + " | "
				+ aluno.getEmail() + " | "
				+ aluno.getEndereco() + " | "
				+ aluno.getNumero() + " | "
				+ aluno.getBairro() + " | "
				+ aluno.getCidade() + " | "
				+ aluno.getEstado() + " | "
				+ aluno.getObs();
		lblAluno.setText(alunoString);
		recarregarTabelaParcela(aluno, turma);
	}
	
	private void recarregarTabelaParcela(Aluno aluno, Turma turma){
		tableParcela.setModel(ParcelaControle.defaultTableModel(aluno, turma));
		/*tableParcela.getColumnModel().getColumn(0).setPreferredWidth(7);
		tableParcela.getColumnModel().getColumn(1).setPreferredWidth(7);*/
	}
	
	private void novo(){
		limpar();
		dateChooserDataDeVencimento.requestFocus();
	}
	
	private boolean verificar(){
		if(dateChooserDataDeVencimento.getCalendar() == null){
			JOptionPane.showMessageDialog(null, "Escolha a data de vencimento");
			dateChooserDataDeVencimento.requestFocus();
			return false;
		}
		/*if(dateChooserDataDePagamento.getCalendar() == null){
			JOptionPane.showMessageDialog(null, "Escolha a data de pagamento");
			dateChooserDataDePagamento.requestFocus();
			return false;
		}*/
		if (!txtValorPago.getText().isEmpty()) {
			try {
				Double.valueOf(txtValorPago.getText().trim().replace(",", "."));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite o valor pago numérico válido");
				txtValorPago.requestFocus();
				return false;
			}
		}
		return true;
	}
	
	private void criarEntidadeFormulario(){
		try {
			parcela.setId(Integer.valueOf(txtId.getText()));
		} catch (NumberFormatException e) {
			parcela.setId(0);
		}
		parcela.setDataDeVencimento(dateChooserDataDeVencimento.getCalendar());
		parcela.setDataDePagamento(dateChooserDataDePagamento.getCalendar());
		try {
			parcela.setValorPago(Double.valueOf(txtValorPago.getText().trim().replace(",", ".")));
		} catch (NumberFormatException e) {
			parcela.setValorPago(0);
		}
		parcela.setMatricula(MatriculaControle.getMatricula(aluno, turma));
	}
	
	private void criarEntidadeTabela(){
		int id = retornarId(tableParcela, "Código");
		parcela = ParcelaControle.getParcela(id);
	}
	
	private void deEntidadeParaFormulario(){
		txtId.setText("" + parcela.getId());
		dateChooserDataDeVencimento.setCalendar(parcela.getDataDeVencimento());
		dateChooserDataDePagamento.setCalendar(parcela.getDataDePagamento());
		txtValorPago.setText(String.valueOf(parcela.getValorPago()).replace(".", ","));
	}
	
	private void salvar(){
		if (verificar()) {
			criarEntidadeFormulario();
			ParcelaControle.salvar(parcela);
			atualizarParcela();
		}
	}
	
	private void editar(){
		try {
			criarEntidadeTabela();
			deEntidadeParaFormulario();
		} catch (Exception e) {
			System.out.println("Selecionou a coluna");
		}
	}
	
	private void deletar() {
		criarEntidadeFormulario();
		if (parcela.getId() != 0) {
			if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar esta parcela?", getTitle(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				ParcelaControle.deletar(parcela);
				atualizarParcela();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione uma parcela na tabela para deletar");
		}
	}
	
	private void gerarParcelas(){
		try {
			if (verificar()) {
				String qtd = JOptionPane.showInputDialog("Digite a quantidade de parcelas");
				int quantidade = Integer.valueOf(qtd);
				txtId.setText(null);
				dateChooserDataDePagamento.setCalendar(null);
				txtValorPago.setText(null);
				criarEntidadeFormulario();
				for (int i = 0; i < quantidade; i++) {
					//System.out.println(dateFormat.format(parcela.getDataDeVencimento().getTime()));;
					ParcelaControle.salvar(parcela, true);
					parcela.getDataDeVencimento().add(Calendar.MONTH, 1);
				}
				JOptionPane.showMessageDialog(null, "Parcela(s) gerada(s) com sucesso");
				atualizarParcela();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Quantidade inválida\n\nTente novamente");
		}
	}
	
}
