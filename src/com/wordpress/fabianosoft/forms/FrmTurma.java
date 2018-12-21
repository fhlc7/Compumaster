package com.wordpress.fabianosoft.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JDateChooser;
import com.wordpress.fabianosoft.controles.TurmaControle;
import com.wordpress.fabianosoft.entidades.Turma;

import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmTurma extends JFrame {

	private Turma turma = new Turma();
	
	private JPanel contentPane;
	private JTextField txtId;
	private JLabel lblDiasDaSemana;
	private JTextField txtDiaDaSemana;
	private JLabel lblHorrio;
	private JTextField txtHorario;
	private JLabel lblCurso;
	private JTextField txtCurso;
	private JLabel lblStatus;
	private JLabel lblDataTermino;
	private JPanel panel_1;
	private JLabel lblProcurar;
	private JTextField txtProcurar;
	private JPanel panel_2;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JTable table;
	private JComboBox comboBoxStatus;
	private JDateChooser dateChooserDataInicio;
	private JDateChooser dateChooserDataTermino;

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
					FrmTurma frame = new FrmTurma();
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
	public FrmTurma() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				atualizar();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmTurma.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setResizable(false);
		setTitle("Cadastro de Turmas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setLayout(new GridLayout(0, 5, 0, 0));
		
		button = new JButton("Atualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizar();
			}
		});
		button.setMnemonic('a');
		panel_2.add(button);
		
		button_1 = new JButton("Novo");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				novo();
			}
		});
		button_1.setMnemonic('n');
		panel_2.add(button_1);
		
		button_2 = new JButton("Salvar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				salvar();
			}
		});
		button_2.setMnemonic('s');
		panel_2.add(button_2);
		
		button_3 = new JButton("Deletar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletar();
			}
		});
		button_3.setMnemonic('d');
		panel_2.add(button_3);
		
		button_4 = new JButton("Fechar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_4.setMnemonic('f');
		panel_2.add(button_4);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 962, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblProcurar = new JLabel("Procurar:");
		lblProcurar.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		txtProcurar = new JTextField();
		txtProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				recarregarTabela();
			}
		});
		txtProcurar.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtProcurar.setText("Procurar");
		txtProcurar.setColumns(10);
		
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
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
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
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBackground(Color.CYAN);
		txtId.setText("id");
		txtId.setColumns(10);
		
		JLabel lblId = new JLabel("C\u00F3digo:");
		
		lblDiasDaSemana = new JLabel("Dia(s) da semana:");
		
		txtDiaDaSemana = new JTextField();
		txtDiaDaSemana.setText("Dia da semana");
		txtDiaDaSemana.setColumns(10);
		
		lblHorrio = new JLabel("Hor\u00E1rio:");
		
		txtHorario = new JTextField();
		txtHorario.setText("Horario");
		txtHorario.setColumns(10);
		
		lblCurso = new JLabel("Curso:");
		
		txtCurso = new JTextField();
		txtCurso.setText("Curso");
		txtCurso.setColumns(10);
		
		lblStatus = new JLabel("Status:");
		
		comboBoxStatus = new JComboBox();
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] {"Em andamento", "Finalizado"}));
		
		JLabel lblDataIncio = new JLabel("Data In\u00EDcio:");
		
		dateChooserDataInicio = new JDateChooser();
		
		lblDataTermino = new JLabel("Data T\u00E9rmino:");
		
		dateChooserDataTermino = new JDateChooser();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(77, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblId)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDiasDaSemana)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtDiaDaSemana, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblHorrio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblCurso)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCurso, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblStatus)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(comboBoxStatus, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblDataIncio)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooserDataInicio, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblDataTermino)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(dateChooserDataTermino, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addGap(64))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(31, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDiasDaSemana)
						.addComponent(txtDiaDaSemana, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHorrio)
						.addComponent(txtHorario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCurso)
						.addComponent(txtCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(lblDataTermino))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(dateChooserDataTermino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblStatus)
									.addComponent(comboBoxStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblDataIncio))
								.addComponent(dateChooserDataInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(28))
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {dateChooserDataInicio, dateChooserDataTermino});
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void atualizar(){
		limpar();
		recarregarTabela();
		txtProcurar.requestFocus();
	}
	
	private void limpar(){
		String t = null;
		txtProcurar.setText(t);
		txtId.setText(t);
		txtDiaDaSemana.setText(t);
		txtHorario.setText(t);
		txtCurso.setText(t);
		comboBoxStatus.setSelectedIndex(0);
		dateChooserDataInicio.setCalendar(null);
		dateChooserDataTermino.setCalendar(null);
	}
	
	private void recarregarTabela(){
		table.setModel(TurmaControle.defaultTableModel(txtProcurar.getText().trim()));
		table.getColumnModel().getColumn(0).setPreferredWidth(7);
	}
	
	private void novo() {
		limpar();
		txtDiaDaSemana.requestFocus();
	}
	
	private boolean verificar(){
		if(txtDiaDaSemana.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite o dia da semana");
			txtDiaDaSemana.requestFocus();
			return false;
		}
		if(txtHorario.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite o horário");
			txtHorario.requestFocus();
			return false;
		}
		if(txtCurso.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite o curso");
			txtCurso.requestFocus();
			return false;
		}
		return true;
	}
	
	private void criarEntidadeFormulario() {
		try {
			turma.setId(Integer.valueOf(txtId.getText()));
		} catch (Exception e) {
			turma.setId(0);
		}
		turma.setDiaDaSemana(txtDiaDaSemana.getText().trim());
		turma.setHorario(txtHorario.getText().trim());
		turma.setCurso(txtCurso.getText().trim());
		turma.setStatus(comboBoxStatus.getSelectedItem().toString());
		turma.setDataInicio(dateChooserDataInicio.getCalendar());
		turma.setDataTermino(dateChooserDataTermino.getCalendar());
	}
	
	private void salvar(){
		if (verificar()){
			criarEntidadeFormulario();
			TurmaControle.salvar(turma);
			atualizar();
		}
	}
	
	private void criarEntidadeTabela() {
		int linha = table.getSelectedRow();
		int coluna = 0;
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (table.getColumnName(i).equals("Código")){
				coluna = i;
				break;
			}
		}
		int id = Integer.valueOf(table.getValueAt(linha, coluna).toString());
		turma = TurmaControle.getTurma(id);
	}
	
	private void entidadeParaFormulario(){
		txtId.setText(String.valueOf(turma.getId()));
		txtDiaDaSemana.setText(turma.getDiaDaSemana());
		txtHorario.setText(turma.getHorario());
		txtCurso.setText(turma.getCurso());
		comboBoxStatus.setSelectedItem(turma.getStatus());
		dateChooserDataInicio.setCalendar(turma.getDataInicio());
		dateChooserDataTermino.setCalendar(turma.getDataTermino());
	}
	
	private void editar() {
		try {
			criarEntidadeTabela();
			entidadeParaFormulario();
		} catch (Exception e) {
			System.out.println("Selecionou coluna");
		}
	}

	private void deletar(){
		if (txtId.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Selecione uma turma da tabela clicando");
			return;
		} else {
			if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar esta turma?", getTitle(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				TurmaControle.deletar(turma);
				atualizar();
			}
		}
	}
	
}
