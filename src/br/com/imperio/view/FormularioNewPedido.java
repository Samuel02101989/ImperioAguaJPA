package br.com.imperio.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class FormularioNewPedido extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeAguas;
	private JTextField txtRuaAgua;
	private JTextField txtNumAguas;
	private JTextField txtValorAgua;
	private JTextField txtDataAguas;
	private JButton btnEdit;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioNewPedido frame = new FormularioNewPedido();
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
	public FormularioNewPedido() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HomeScreen.class.getResource("/br/com/imperio/image/client.png")));
		setTitle("Cadastrar Pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 515, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(50, 175, 54, 14);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel);
		
		txtNomeAguas = new JTextField();
		txtNomeAguas.setBounds(99, 173, 291, 20);
		contentPane.add(txtNomeAguas);
		txtNomeAguas.setColumns(10);
		
		txtRuaAgua = new JTextField();
		txtRuaAgua.setBounds(99, 126, 163, 20);
		contentPane.add(txtRuaAgua);
		txtRuaAgua.setColumns(10);
		
		txtNumAguas = new JTextField();
		txtNumAguas.setBounds(336, 126, 54, 20);
		contentPane.add(txtNumAguas);
		txtNumAguas.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Rua:");
		lblNewLabel_1.setBounds(50, 126, 54, 14);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero:");
		lblNewLabel_2.setBounds(272, 131, 54, 14);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setBounds(50, 227, 46, 14);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3);
		
		txtValorAgua = new JTextField();
		txtValorAgua.setBounds(99, 227, 86, 20);
		contentPane.add(txtValorAgua);
		txtValorAgua.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data:");
		lblNewLabel_4.setBounds(267, 227, 46, 14);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_4);
		
		txtDataAguas = new JTextField();
		txtDataAguas.setBounds(306, 227, 86, 20);
		contentPane.add(txtDataAguas);
		txtDataAguas.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(113, 22, 249, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(141, 11, 84, 30);
		panel.add(btnEdit);
		btnEdit.setIcon(new ImageIcon(FormularioNewPedido.class.getResource("/br/com/imperio/image/edit.png")));
		btnEdit.setBackground(Color.ORANGE);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(27, 11, 84, 30);
		panel.add(btnNewButton);
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setIcon(new ImageIcon(FormularioNewPedido.class.getResource("/br/com/imperio/image/add.png")));
	}
}
