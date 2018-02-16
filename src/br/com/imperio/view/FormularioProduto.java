package br.com.imperio.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FormularioProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProd;
	private JTextField txtQtdProd;
	private JTextField txtPrecoProd;
	private JTextField txtPrecoTotalProd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioProduto frame = new FormularioProduto();
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
	public FormularioProduto() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HomeScreen.class.getResource("/br/com/imperio/image/product.png")));
		setTitle("Cadastro de Produtos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 100, 586, 410);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNomeProd = new JTextField();
		txtNomeProd.setBounds(105, 102, 190, 20);
		contentPane.add(txtNomeProd);
		txtNomeProd.setColumns(10);
		
		txtQtdProd = new JTextField();
		txtQtdProd.setBounds(418, 102, 73, 20);
		contentPane.add(txtQtdProd);
		txtQtdProd.setColumns(10);
		
		txtPrecoProd = new JTextField();
		txtPrecoProd.setBounds(155, 157, 114, 20);
		contentPane.add(txtPrecoProd);
		txtPrecoProd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(51, 102, 67, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Quantidade:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(325, 102, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Pre\u00E7o Unitario:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(51, 157, 207, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Produto");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(245, 33, 95, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Pre\u00E7o Total:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(289, 157, 83, 14);
		contentPane.add(lblNewLabel_4);
		
		txtPrecoTotalProd = new JTextField();
		txtPrecoTotalProd.setBounds(382, 157, 109, 20);
		contentPane.add(txtPrecoTotalProd);
		txtPrecoTotalProd.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(117, 240, 364, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnEditProd = new JButton("Edit");
		btnEditProd.setIcon(new ImageIcon(FormularioProduto.class.getResource("/br/com/imperio/image/edit.png")));
		btnEditProd.setBounds(149, 7, 84, 30);
		panel.add(btnEditProd);
		btnEditProd.setBackground(new Color(255, 140, 0));
		
		JButton btnSaveProdutos = new JButton("Save");
		btnSaveProdutos.setIcon(new ImageIcon(FormularioProduto.class.getResource("/br/com/imperio/image/add.png")));
		btnSaveProdutos.setBounds(50, 7, 84, 30);
		panel.add(btnSaveProdutos);
		btnSaveProdutos.setBackground(new Color(50, 205, 50));
		
		JButton button = new JButton("Del");
		button.setIcon(new ImageIcon(FormularioProduto.class.getResource("/br/com/imperio/image/delete.png")));
		button.setBounds(243, 7, 84, 30);
		panel.add(button);
		button.setBackground(Color.RED);
	}
}
