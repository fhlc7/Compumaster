package com.wordpress.fabianosoft.forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import com.wordpress.fabianosoft.controles.UsuarioControle;
import com.wordpress.fabianosoft.entidades.Usuario;

import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class FrmLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;

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
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmLogin.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(282, 275);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnEntrar.setFont(new Font("Calibri", Font.BOLD, 25));
		btnEntrar.setMnemonic('e');
		btnEntrar.setBounds(6, 177, 262, 64);
		contentPane.add(btnEntrar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(6, 49, 262, 116);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(31, 26, 55, 16);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tecladoFormulario(e);
			}
		});
		txtUsuario.setBounds(98, 20, 122, 28);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setBounds(31, 66, 55, 16);
		panel.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tecladoFormulario(e);
			}
		});
		txtSenha.setBounds(98, 60, 122, 28);
		panel.add(txtSenha);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblLogin.setBounds(6, 6, 262, 31);
		contentPane.add(lblLogin);
	}

	private void login() {
		String nome, senha;
		nome = txtUsuario.getText().trim();
		senha = new String(txtSenha.getPassword());
		if(nome.isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite o usuï¿½rio");
			txtUsuario.requestFocus();
			return;
		}
		if(senha.isEmpty()){
			JOptionPane.showMessageDialog(null, "Digite a senha");
			txtSenha.requestFocus();
			return;
		}
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setSenha(senha);
		if(UsuarioControle.login(usuario)){
			//existe
			JOptionPane.showMessageDialog(null, "Seja Muito Bem Vindo " + usuario.getNome());
			FrmCompumaster menu = new FrmCompumaster();
			menu.setVisible(true);
			limpar();
			dispose();
		} else {
			//nï¿½o existe
			JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto(s)\n\nTente novamente");
			limpar();
		}
	}
	
	private void tecladoFormulario(KeyEvent e) {
		if(e.getKeyCode() == 10) login();// 10 ï¿½ o cï¿½digo da tecla enter
	}
	
	private void limpar(){
		txtUsuario.setText(null);
		txtSenha.setText(null);
		txtUsuario.requestFocus();
	}
	
}
