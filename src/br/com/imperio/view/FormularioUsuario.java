package br.com.imperio.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.imperio.dao.UsuarioAguasDao;
import br.com.imperio.model.Usuario;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Panel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class FormularioUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeUser;
	private JTextField txtLoginUser;
	private JTextField txtCpfUser;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioUsuario frame = new FormularioUsuario();
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
	public FormularioUsuario() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(HomeScreen.class.getResource("/br/com/imperio/image/user.png")));
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 100, 530, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNomeUser = new JTextField();
		txtNomeUser.setBounds(83, 71, 362, 20);
		contentPane.add(txtNomeUser);
		txtNomeUser.setColumns(10);

		txtLoginUser = new JTextField();
		txtLoginUser.setBounds(83, 129, 164, 20);
		contentPane.add(txtLoginUser);
		txtLoginUser.setColumns(10);

		JComboBox cboUser = new JComboBox();
		cboUser.setModel(new DefaultComboBoxModel(new String[] { "Admin", "User" }));
		cboUser.setBounds(358, 179, 86, 20);
		contentPane.add(cboUser);

		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(34, 73, 74, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Login:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(34, 131, 74, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(254, 131, 167, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Tipo User:");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(271, 181, 74, 14);
		contentPane.add(lblNewLabel_3);

		txtCpfUser = new JTextField();
		txtCpfUser.setColumns(10);
		txtCpfUser.setBounds(83, 179, 164, 20);
		contentPane.add(txtCpfUser);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCpf.setBounds(34, 182, 74, 14);
		contentPane.add(lblCpf);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(83, 258, 338, 52);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnSaveUser = new JButton("Save");
		btnSaveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// salvando dados
				try {
					Usuario user = SaveUser(cboUser);

					if (fieldsValidationUser()) {
						// validando campos
						JOptionPane.showMessageDialog(null, "*Campo vazio, Por favor preencha!!");
					} else {

						UsuarioAguasDao.getInstance().salvar(user);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						// Limpando campos
						clearfields();
					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				}

			}

		});
		btnSaveUser.setIcon(new ImageIcon(FormularioUsuario.class.getResource("/br/com/imperio/image/add.png")));
		btnSaveUser.setBounds(26, 11, 84, 30);
		panel.add(btnSaveUser);
		btnSaveUser.setBackground(new Color(50, 205, 50));

		JButton btnEditUser = new JButton("Edit");
		btnEditUser.setIcon(new ImageIcon(FormularioUsuario.class.getResource("/br/com/imperio/image/edit.png")));
		btnEditUser.setBackground(Color.ORANGE);
		btnEditUser.setBounds(129, 11, 84, 30);
		panel.add(btnEditUser);

		JButton btnDeleteUser = new JButton("Del");
		btnDeleteUser.setIcon(new ImageIcon(FormularioUsuario.class.getResource("/br/com/imperio/image/delete.png")));
		btnDeleteUser.setBackground(Color.RED);
		btnDeleteUser.setBounds(233, 11, 84, 30);
		panel.add(btnDeleteUser);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(303, 129, 135, 20);
		contentPane.add(passwordField);
	}

	public Usuario SaveUser(JComboBox<?> cboUser) {
		Usuario user = new Usuario();
		user.setNomeUsu(txtNomeUser.getText());
		user.setLoginUsu(txtLoginUser.getText());
		user.setSenhaUsu(passwordField.getText());
		user.setTipoUsu(cboUser.getSelectedItem().toString());
		return user;
	}

	private boolean fieldsValidationUser() {
		return txtNomeUser.getText().isEmpty()
				|| (txtLoginUser.getText().isEmpty() || (passwordField.getText().isEmpty()))
				|| (txtCpfUser.getText().isEmpty());
	}

	public void clearfields() {
		// Limpando campoas
		txtNomeUser.setText(null);
		txtLoginUser.setText(null);
		passwordField.setText(null);
		txtCpfUser.setText(null);

		// Desativando campos
		txtNomeUser.setEditable(false);
		txtLoginUser.setEditable(false);
		passwordField.setEditable(false);
		txtCpfUser.setEditable(false);
	}

}
