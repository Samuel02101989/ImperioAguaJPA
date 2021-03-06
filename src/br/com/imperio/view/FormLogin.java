package br.com.imperio.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.com.imperio.dao.UsuarioAguasDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;

public class FormLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setTitle("Bem Vindo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(FormLogin.class.getResource("/br/com/imperio/image/user.png")));

		setResizable(false);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLogin.setBounds(114, 47, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(114, 89, 80, 14);
		contentPane.add(lblPassword);

		txtLogin = new JTextField();
		txtLogin.setBounds(157, 45, 258, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {

				if ((!txtLogin.getText().isEmpty() && !passwordField.getText().isEmpty())) {

					try {
						if (UsuarioAguasDao.getInstance().getByLogo(txtLogin.getText(), passwordField.getText())) {
							HomeScreen home = new HomeScreen();
							home.setVisible(true);
							dispose();

						} else {
							JOptionPane.showMessageDialog(null, "Campo de Login ou Senha vazio !!");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Login ou senha Incorreto!!s");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Campo vazio!!");
				}
			}
		});
		btnOk.setBackground(new Color(50, 205, 50));
		btnOk.setIcon(new ImageIcon(FormLogin.class.getResource("/br/com/imperio/image/add.png")));
		btnOk.setBounds(260, 118, 89, 23);
		contentPane.add(btnOk);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FormLogin.class.getResource("/br/com/imperio/image/login.png")));
		lblNewLabel.setBounds(58, 47, 46, 37);
		contentPane.add(lblNewLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(185, 87, 230, 20);
		contentPane.add(passwordField);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setIcon(new ImageIcon(FormLogin.class.getResource("/br/com/imperio/image/ifexit.png")));
		button.setBackground(Color.RED);
		button.setBounds(368, 118, 46, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(FormLogin.class.getResource("/br/com/imperio/image/gerente.png")));
		button_1.setToolTipText("Acesso Restrito");
		button_1.setBackground(Color.YELLOW);
		button_1.setBounds(29, 118, 46, 23);
		contentPane.add(button_1);
		
		JLabel lblesqueciASenha = new JLabel("*Esqueci a senha");
		lblesqueciASenha.setForeground(Color.WHITE);
		lblesqueciASenha.setBounds(25, 146, 121, 14);
		contentPane.add(lblesqueciASenha);
	}
}
