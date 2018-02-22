package br.com.imperio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.imperio.dao.ProdutosDao;
import br.com.imperio.model.Produtos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FormularioProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProd;
	private JTextField txtQtdProd;
	private JTextField txtPrecoUnit;
	private JTextField txtPrecoTotalProd;
	private JTextField txtDataEntrega;
	private JTextField txtPlacaVeiculo;
	private JTextField txtVeiculo;

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
		txtQtdProd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String QtdProd = "0987654321";
				if (!QtdProd.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtQtdProd.setBounds(418, 102, 93, 20);
		contentPane.add(txtQtdProd);
		txtQtdProd.setColumns(10);

		txtPrecoUnit = new JTextField();
		txtPrecoUnit.setBounds(155, 157, 114, 20);
		contentPane.add(txtPrecoUnit);
		txtPrecoUnit.setColumns(10);

		JLabel lblNewLabel = new JLabel("Produto:");
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

		JLabel lblNewLabel_4 = new JLabel("Preco Total:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(289, 157, 83, 14);
		contentPane.add(lblNewLabel_4);

		txtPrecoTotalProd = new JTextField();
		txtPrecoTotalProd.setBounds(382, 157, 129, 20);
		contentPane.add(txtPrecoTotalProd);
		txtPrecoTotalProd.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(115, 260, 364, 47);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnEditProd = new JButton("Edit");
		btnEditProd.setIcon(new ImageIcon(FormularioProduto.class.getResource("/br/com/imperio/image/edit.png")));
		btnEditProd.setBounds(149, 7, 84, 30);
		panel.add(btnEditProd);
		btnEditProd.setBackground(new Color(255, 140, 0));

		JButton btnSaveProdutos = new JButton("Save");
		btnSaveProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Salvando dados no banco
					Produtos prod = SaveProduct();
					

					if (fieldsValidationUser()) {
						// validando campos
						JOptionPane.showMessageDialog(null, "*Campo vazio, Por favor preencha!!");
					} else {
						ProdutosDao.getInstance().salvar(prod);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						clearsFields();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				}

			}

		});
		btnSaveProdutos.setIcon(new ImageIcon(FormularioProduto.class.getResource("/br/com/imperio/image/add.png")));
		btnSaveProdutos.setBounds(50, 7, 84, 30);
		panel.add(btnSaveProdutos);
		btnSaveProdutos.setBackground(new Color(50, 205, 50));

		JButton button = new JButton("Del");
		button.setIcon(new ImageIcon(FormularioProduto.class.getResource("/br/com/imperio/image/delete.png")));
		button.setBounds(243, 7, 84, 30);
		panel.add(button);
		button.setBackground(Color.RED);

		JLabel lblData = new JLabel("Data:");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(56, 209, 83, 14);
		contentPane.add(lblData);

		txtDataEntrega = new JTextField();
		txtDataEntrega.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String dataKey = "0987654321//";
				if (!dataKey.contains(e.getKeyChar() + "")) {
					e.consume();
				}
			}
		});
		txtDataEntrega.setColumns(10);
		txtDataEntrega.setBounds(105, 207, 109, 20);
		contentPane.add(txtDataEntrega);

		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setForeground(Color.WHITE);
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlaca.setBounds(224, 209, 83, 14);
		contentPane.add(lblPlaca);

		txtPlacaVeiculo = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("AAA/####");
			txtPlacaVeiculo = new javax.swing.JFormattedTextField(format_textField4);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		txtPlacaVeiculo.setColumns(10);
		txtPlacaVeiculo.setBounds(263, 207, 77, 20);
		contentPane.add(txtPlacaVeiculo);

		JLabel lblVeiculo = new JLabel("Veiculo:");
		lblVeiculo.setForeground(Color.WHITE);
		lblVeiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVeiculo.setBounds(350, 209, 83, 14);
		contentPane.add(lblVeiculo);

		txtVeiculo = new JTextField();
		txtVeiculo.setColumns(10);
		txtVeiculo.setBounds(402, 207, 109, 20);
		contentPane.add(txtVeiculo);
	}

	// Metodo que salva o produto no banco de dados
	public Produtos SaveProduct() {
		Produtos prod = new Produtos();
		
		prod.setNomeProd(txtNomeProd.getText());
		prod.setPrecounit(txtPrecoUnit.getText());
		prod.setPrecoProd(txtPrecoTotalProd.getText());
		prod.setQuantProd(txtQtdProd.getText());
		prod.setDataEntrega(txtDataEntrega.getText());
		prod.setPlaca(txtPlacaVeiculo.getText());
		prod.setVeiculo(txtVeiculo.getText());
		return prod;

	}

	// LImpar e desativar campos
	public void clearsFields() {
		// Limpando campos
		txtNomeProd.setText(null);
		txtPrecoUnit.setText(null);
		txtPrecoTotalProd.setText(null);
		txtQtdProd.setText(null);
		txtDataEntrega.setText(null);
		txtPlacaVeiculo.setText(null);
		txtVeiculo.setText(null);

		// Desativando campos
		txtNomeProd.setEditable(false);
		txtPrecoUnit.setEditable(false);
		txtPrecoTotalProd.setEditable(false);
		txtQtdProd.setEditable(false);
		txtDataEntrega.setEditable(false);
		txtPlacaVeiculo.setEditable(false);
		txtVeiculo.setEditable(false);
	}

	// Metodo de validaçao de campos
	private boolean fieldsValidationUser() {
		return txtNomeProd.getText().isEmpty()
				|| (txtPrecoUnit.getText().isEmpty() || (txtPrecoTotalProd.getText().isEmpty()))
				|| (txtQtdProd.getText().isEmpty()) || (txtDataEntrega.getText().isEmpty())
				|| (txtPlacaVeiculo.getText().isEmpty()) || (txtVeiculo.getText().isEmpty());
	}
}
