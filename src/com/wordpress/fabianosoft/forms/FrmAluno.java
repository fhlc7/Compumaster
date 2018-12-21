package com.wordpress.fabianosoft.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.logging.SimpleFormatter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import com.toedter.calendar.JDayChooser;
import com.wordpress.fabianosoft.controles.AlunoControle;
import com.wordpress.fabianosoft.entidades.Aluno;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class FrmAluno extends JFrame {
	
	private Aluno aluno = new Aluno();
	
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNomeAluno;
	private JTextField txtNomeResponsvel;
	private JTextField txtRg;
	private JTextField txtCpfCnpj;
	private JFormattedTextField frmtdtxtfldFone_1;
	private JFormattedTextField frmtdtxtfldFone_2;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtBairro;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTable table;
	private JTextField txtProcurar;
	private JDateChooser dateChooser;
	private JTextArea txtrObs;

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
					FrmAluno frame = new FrmAluno();
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
	public FrmAluno() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmAluno.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				atualizar();
			}
		});
		setTitle("Cadastro de Alunos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		txtProcurar = new JTextField();
		txtProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				recarregarTabela();
			}
		});
		txtProcurar.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtProcurar.setText("Procurar");
		txtProcurar.setColumns(10);
		
		JLabel lblProcurar = new JLabel("Procurar:");
		lblProcurar.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 946, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblProcurar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtProcurar, GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblProcurar)
						.addComponent(txtProcurar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				editar();
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editar();
			}
		});
		scrollPane.setViewportView(table);
		panel_1.setLayout(gl_panel_1);
		panel_2.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setMnemonic('a');
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		panel_2.add(btnAtualizar);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setMnemonic('n');
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				txtNomeAluno.requestFocus();
			}
		});
		panel_2.add(btnNovo);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setMnemonic('s');
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvar();
			}
		});
		panel_2.add(btnSalvar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setMnemonic('d');
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		panel_2.add(btnDeletar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setMnemonic('f');
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel_2.add(btnFechar);
		
		JLabel lblId = new JLabel("Matr\u00EDcula:");
		
		txtId = new JTextField();
		txtId.setBackground(Color.CYAN);
		txtId.setEditable(false);
		txtId.setText("id");
		txtId.setColumns(10);
		
		JLabel lblNomeAluno = new JLabel("Nome Aluno:");
		
		txtNomeAluno = new JTextField();
		txtNomeAluno.setText("Nome Aluno");
		txtNomeAluno.setColumns(10);
		
		dateChooser = new JDateChooser();
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		
		JLabel lblNomeResponsvel = new JLabel("Nome Respons\u00E1vel");
		
		txtNomeResponsvel = new JTextField();
		txtNomeResponsvel.setText("Nome Respons\u00E1vel");
		txtNomeResponsvel.setColumns(10);
		
		JLabel lblRg = new JLabel("RG:");
		
		txtRg = new JTextField();
		txtRg.setText("RG");
		txtRg.setColumns(10);
		
		JLabel lblCpfCnpj = new JLabel("CPF / CNPJ:");
		
		txtCpfCnpj = new JTextField();
		txtCpfCnpj.setText("CPF / CNPJ");
		txtCpfCnpj.setColumns(10);
		
		MaskFormatter fone1 = new MaskFormatter();
		try {
			fone1 = new MaskFormatter("(##) #####-####");
		} catch (ParseException e) {
			//
			e.printStackTrace();
		}
		
		JLabel lblFone = new JLabel("Fone 1:");
		
		frmtdtxtfldFone_1 = new JFormattedTextField(fone1);
		frmtdtxtfldFone_1.setText("");
		
		MaskFormatter fone2 = new MaskFormatter();
		try {
			fone2 = new MaskFormatter("(##) #####-####");
		} catch (ParseException e) {
			//
			e.printStackTrace();
		}
		
		JLabel lblFone_1 = new JLabel("Fone 2:");
		
		frmtdtxtfldFone_2 = new JFormattedTextField(fone2);
		frmtdtxtfldFone_2.setText("");
		
		JLabel lblEmail = new JLabel("E-mail:");
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		txtEmail.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		
		txtEndereco = new JTextField();
		txtEndereco.setText("Endere\u00E7o");
		txtEndereco.setColumns(10);
		
		JLabel lblNumero = new JLabel("N\u00BA:");
		
		txtNumero = new JTextField();
		txtNumero.setText("N\u00FAmero");
		txtNumero.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		
		txtBairro = new JTextField();
		txtBairro.setText("Bairro");
		txtBairro.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		
		txtCidade = new JTextField();
		txtCidade.setText("Cidade");
		txtCidade.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		
		txtEstado = new JTextField();
		txtEstado.setText("Estado");
		txtEstado.setColumns(10);
		
		JLabel lblObs = new JLabel("Obs.:");
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEndereo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNumero)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNumero, 0, 0, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblFone)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(frmtdtxtfldFone_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblFone_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(frmtdtxtfldFone_2))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNomeResponsvel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNomeResponsvel))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNomeAluno)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNomeAluno, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblDataDeNascimento)
									.addGap(6)
									.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblRg)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(lblBairro)
											.addComponent(lblEmail)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(txtEmail)
												.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
											.addGap(6)
											.addComponent(lblCpfCnpj)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtCpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblCidade)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblEstado)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblObs)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_1)))
					.addGap(19))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNomeAluno)
							.addComponent(txtNomeAluno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDataDeNascimento)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNomeResponsvel)
						.addComponent(txtNomeResponsvel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRg)
						.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCpfCnpj)
						.addComponent(txtCpfCnpj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFone)
						.addComponent(frmtdtxtfldFone_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFone_1)
						.addComponent(frmtdtxtfldFone_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEndereo)
						.addComponent(txtEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumero)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBairro)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCidade)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado)
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblObs)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		txtrObs = new JTextArea();
		scrollPane_1.setViewportView(txtrObs);
		txtrObs.setText("Obs.");
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void atualizar(){
		limpar();
		recarregarTabela();
		txtProcurar.requestFocus();
	}
	
	private void limpar(){
		String limpar = null;
		txtId.setText(limpar);
		txtNomeAluno.setText(limpar);
		dateChooser.setCalendar(null);
		txtNomeResponsvel.setText(limpar);
		txtRg.setText(limpar);
		txtCpfCnpj.setText(limpar);
		frmtdtxtfldFone_1.setText(limpar);
		frmtdtxtfldFone_2.setText(limpar);
		txtEmail.setText(limpar);
		txtEndereco.setText(limpar);
		txtNumero.setText(limpar);
		txtBairro.setText(limpar);
		txtCidade.setText(limpar);
		txtEstado.setText(limpar);
		txtrObs.setText(limpar);
		txtProcurar.setText(limpar);
	}

	private boolean verificar(){
		if (txtNomeAluno.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite o Nome do Aluno");
			txtNomeAluno.requestFocus();
			return false;
		}
		return true;
	}
	
	private void criarObjetoFormulario(){
		try {
			aluno.setId(Integer.valueOf(txtId.getText()));
		} catch (Exception e) {
			aluno.setId(0);
		}
		aluno.setNomeAluno(txtNomeAluno.getText());
		aluno.setDataDeNascimento(dateChooser.getCalendar());
		aluno.setNomeResponsavel(txtNomeResponsvel.getText());
		aluno.setRg(txtRg.getText());
		aluno.setCpfCnpj(txtCpfCnpj.getText());
		aluno.setFone1(frmtdtxtfldFone_1.getText());
		aluno.setFone2(frmtdtxtfldFone_2.getText());
		aluno.setEmail(txtEmail.getText());
		aluno.setEndereco(txtEndereco.getText());
		aluno.setNumero(txtNumero.getText());
		aluno.setBairro(txtBairro.getText());
		aluno.setCidade(txtCidade.getText());
		aluno.setEstado(txtEstado.getText());
		aluno.setObs(txtrObs.getText());
	}
	
	private void salvar(){
		if(verificar()){
			criarObjetoFormulario();
			AlunoControle.salvar(aluno);
			atualizar();
		}
	}
	
	private void recarregarTabela(){
		table.setModel(AlunoControle.defaultTableModel(txtProcurar.getText().trim()));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(150);
		}
	}

	private void criarObjetoTaela(){
		int linha = table.getSelectedRow();
		int coluna = 0;
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (table.getColumnName(i).equals("Matrícula")) {
				coluna = i;
				break;
			}
		}
		int id = Integer.valueOf(table.getValueAt(linha, coluna).toString());
		aluno = AlunoControle.getAluno(id);
	}
	
	private void deObjetoParaFormulario(){
		limpar();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		txtId.setText(String.valueOf(aluno.getId()));
		txtNomeAluno.setText(aluno.getNomeAluno());
		dateChooser.setCalendar(aluno.getDataDeNascimento());
		txtNomeResponsvel.setText(aluno.getNomeResponsavel());
		txtRg.setText(aluno.getRg());
		txtCpfCnpj.setText(aluno.getCpfCnpj());
		frmtdtxtfldFone_1.setText(aluno.getFone1());
		frmtdtxtfldFone_2.setText(aluno.getFone2());
		txtEmail.setText(aluno.getEmail());
		txtEndereco.setText(aluno.getEndereco());
		txtNumero.setText(aluno.getNumero());
		txtBairro.setText(aluno.getBairro());
		txtCidade.setText(aluno.getCidade());
		txtEstado.setText(aluno.getEstado());
		txtrObs.setText(aluno.getObs());
	}
	
	private void editar(){
		try {
			criarObjetoTaela();
			deObjetoParaFormulario();
		} catch (Exception e) {
			System.out.println("Selecionou coluna");
		}
	}
	
	private void deletar() {
		criarObjetoFormulario();
		if (aluno.getId() != 0) {
			if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este aluno?", getTitle(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				AlunoControle.deletar(aluno);
				atualizar();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um aluno na tabela para deletar");
		}
	}
	
}
