package com.fhlc7.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import com.fhlc7.controles.AlunoControle;
import com.fhlc7.controles.UsuarioControle;
import com.fhlc7.dao.UsuarioDAO;
import com.fhlc7.entidades.Usuario;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmUsuario extends JFrame {

	private Usuario usuario = new Usuario();
	
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JPasswordField pwdSenha;
	private JPasswordField pwdConfirmarSenha;
	private JTextField txtProcurar;
	private JTable table;
	private JComboBox comboBoxTipo;

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
					FrmUsuario frame = new FrmUsuario();
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
	public FrmUsuario() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				atualizar();
			}
		});
		setTitle("Usu\u00E1rio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmUsuario.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(950, 625));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.setBounds(6, 6, 938, 154);
		panel.add(panel_1);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		
		txtId = new JTextField();
		txtId.setBackground(Color.CYAN);
		txtId.setEditable(false);
		txtId.setText("id");
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		
		txtNome = new JTextField();
		txtNome.setText("Nome");
		txtNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("Senha");
		
		JLabel lblConfirmarSenha = new JLabel("Confirmar senha:");
		
		pwdConfirmarSenha = new JPasswordField();
		pwdConfirmarSenha.setText("Confirmar senha");
		
		JLabel lblTipo = new JLabel("Tipo:");
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Recepcionista", "Professor"}));
		comboBoxTipo.setEditable(true);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(263)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCdigo)
						.addComponent(lblNome)
						.addComponent(lblSenha)
						.addComponent(lblTipo))
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(comboBoxTipo, 0, 352, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(pwdSenha, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblConfirmarSenha)
							.addGap(6)
							.addComponent(pwdConfirmarSenha, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome))
					.addGap(232))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblCdigo))
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(12)
							.addComponent(lblNome))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblConfirmarSenha))
						.addComponent(pwdConfirmarSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(lblSenha))
						.addComponent(pwdSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(11)
							.addComponent(lblTipo))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(6)
							.addComponent(comboBoxTipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(6, 172, 938, 363);
		panel.add(panel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("Procurar:");
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		
		txtProcurar = new JTextField();
		txtProcurar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				recarregarTabela();
			}
		});
		txtProcurar.setText("Procurar");
		txtProcurar.setFont(new Font("SansSerif", Font.BOLD, 12));
		txtProcurar.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 972, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtProcurar, GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 282, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(txtProcurar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editar();
			}
		});
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				editar();
			}
		});
		scrollPane.setViewportView(table);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(6, 541, 938, 78);
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 5, 0, 0));
		
		JButton button = new JButton("Atualizar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				atualizar();
			}
		});
		button.setMnemonic('a');
		panel_3.add(button);
		
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
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button_4.setMnemonic('f');
		panel_3.add(button_4);
	}
	
	private void atualizar(){
		limpar();
		recarregarTabela();
		txtProcurar.requestFocus();
	}
	
	private void limpar(){
		String limpar = null;
		txtId.setText(limpar);
		txtNome.setText(limpar);
		pwdSenha.setText(limpar);
		pwdConfirmarSenha.setText(limpar);
		comboBoxTipo.setSelectedItem(limpar);
		txtProcurar.setText(limpar);
	}

	private boolean verificar(){
		if (txtNome.getText().trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite o Nome");
			txtNome.requestFocus();
			return false;
		}
		if (String.valueOf(pwdSenha.getPassword()).isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite a Senha");
			pwdSenha.requestFocus();
			return false;
		}
		if (String.valueOf(pwdConfirmarSenha.getPassword()).isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite a Confirmação de Senha");
			pwdConfirmarSenha.requestFocus();
			return false;
		}
		if (!String.valueOf(pwdSenha.getPassword()).equals(String.valueOf(pwdConfirmarSenha.getPassword()))){
			JOptionPane.showMessageDialog(null, "As senhas não coincidem\n\nTente novamente");
			pwdSenha.setText(null);
			pwdConfirmarSenha.setText(null);
			pwdSenha.requestFocus();
			return false;
		}
		if (comboBoxTipo.getSelectedItem() == null) {
			JOptionPane.showMessageDialog(null, "Escolha ou Digite o Tipo");
			comboBoxTipo.requestFocus();
			return false;
		}
		if (comboBoxTipo.getSelectedItem().toString().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Escolha ou Digite o Tipo");
			comboBoxTipo.requestFocus();
			return false;
		}
		return true;
	}
	
	private void criarObjetoFormulario(){
		try {
			usuario.setId(Integer.valueOf(txtId.getText()));
		} catch (Exception e) {
			usuario.setId(0);
		}
		usuario.setNome(txtNome.getText());
		usuario.setSenha(String.valueOf(pwdSenha.getPassword()));
		usuario.setTipo(comboBoxTipo.getSelectedItem().toString());
	}
	
	private void salvar(){
		if(verificar()){
			criarObjetoFormulario();
			UsuarioControle.salvar(usuario);
			atualizar();
		}
	}
	
	private void recarregarTabela(){
		table.setModel(UsuarioControle.defaultTableModel(txtProcurar.getText().trim()));
		/*table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for (int i = 1; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(150);
		}*/
	}

	private void criarObjetoTaela(){
		int linha = table.getSelectedRow();
		int coluna = 0;
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (table.getColumnName(i).equals("Código")) {
				coluna = i;
				break;
			}
		}
		int id = Integer.valueOf(table.getValueAt(linha, coluna).toString());
		usuario = UsuarioControle.getUsuario(id);
	}
	
	private void deObjetoParaFormulario(){
		limpar();
		txtId.setText(String.valueOf(usuario.getId()));
		txtNome.setText(usuario.getNome());
		pwdSenha.setText(usuario.getSenha());
		pwdConfirmarSenha.setText(usuario.getSenha());
		comboBoxTipo.setSelectedItem(usuario.getTipo());
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
		if (usuario.getId() != 0) {
			if (JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar este usuário?", getTitle(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				UsuarioControle.deletar(usuario);
				atualizar();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um usuário na tabela para deletar");
		}
	}
	
	private void novo(){
		limpar();
		txtNome.requestFocus();
	}
}
