package br.com.imperio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import br.com.imperio.dao.CadastraPedidoDao;
import br.com.imperio.model.CadastraPedido;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;

import br.com.imperio.controller.*;



public class FormularioPedidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblPedidos;
	private JTextField txtRuaPed;
	private JTextField txtNumPed;
	private JTextField txtNomeClie;
	private JTextField txtValorPed;
	private JTextField txtDataPed;

	/**
	 * Launch the application.
	 */

	DefaultTableModel dadosTable = new DefaultTableModel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPedidos frame = new FormularioPedidos();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("unused")
	public void initComponente() {
		// TODO Auto-generated method stub
		initComponente();
		String nomeColunas[] = new String[] { "Rua", "Numero", "Data", "Nome", "Situacao" };
		dadosTable.setColumnIdentifiers(nomeColunas);
		

	}

	/**
	 * Create the frame.
	 */
	public FormularioPedidos() {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(HomeScreen.class.getResource("/br/com/imperio/image/client.png")));
		setTitle("Pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(-20, 0, 904, 472);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JLabel lblPedidosEmAberto = new JLabel("Lista de Pedidos");
		lblPedidosEmAberto.setBounds(331, 11, 250, 57);
		lblPedidosEmAberto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPedidosEmAberto.setForeground(Color.WHITE);
		desktopPane.add(lblPedidosEmAberto);

		JPanel panel = new JPanel();
		panel.setBounds(229, 59, 391, 49);
		panel.setBackground(Color.WHITE);
		desktopPane.add(panel);
		panel.setLayout(null);

		JComboBox<Object> cboSitua = new JComboBox<Object>();
		cboSitua.setModel(new DefaultComboBoxModel(new String[] { "Entregue", "Pendente", "Saiu p/Entrega" }));
		cboSitua.setBounds(517, 179, 91, 20);
		desktopPane.add(cboSitua);

		JButton btnNovoPedido = new JButton("Novo Pedido");
		btnNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// salvando dados
					CadastraPedido cadPed = SavePedido(cboSitua);

					if (fieldsValidationUser()) {
						// validando campos
						JOptionPane.showMessageDialog(null, "*Campo vazio, Por favor preencha!!");
					} else {
						CadastraPedidoDao.getInstance().salvar(cadPed);

						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						// limpando campos e desativando
						clearFields();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				}

			}
		});
		btnNovoPedido.setBounds(33, 11, 150, 25);
		btnNovoPedido.setIcon(new ImageIcon(FormularioPedidos.class.getResource("/br/com/imperio/image/add.png")));
		btnNovoPedido.setBackground(new Color(50, 205, 50));
		panel.add(btnNovoPedido);

		JButton btnEditarPedido = new JButton("Editar Pedido");
		btnEditarPedido.setBounds(200, 11, 150, 25);
		btnEditarPedido.setIcon(new ImageIcon(FormularioPedidos.class.getResource("/br/com/imperio/image/edit.png")));
		btnEditarPedido.setBackground(new Color(255, 140, 0));
		panel.add(btnEditarPedido);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 237, 788, 187);
		desktopPane.add(scrollPane);

		tblPedidos = new JTable();
		tblPedidos.setModel(new DefaultTableModel(

				new Object[][] {}, new String[] { "Rua", "Numero", "Valor", "Data", "Nome", "Situacao" }));
		scrollPane.setViewportView(tblPedidos);

		JLabel lbl = new JLabel("Rua:");
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl.setBounds(67, 143, 54, 14);
		desktopPane.add(lbl);

		txtRuaPed = new JTextField();
		txtRuaPed.setColumns(10);
		txtRuaPed.setBounds(116, 143, 199, 20);
		desktopPane.add(txtRuaPed);

		txtNumPed = new JTextField();
		txtNumPed.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String NumPed = "0987654321//";
				if (!NumPed.contains(e.getKeyChar() + "")) {
					e.consume();

				}

			}
		});
		txtNumPed.setColumns(10);
		txtNumPed.setBounds(389, 143, 62, 20);
		desktopPane.add(txtNumPed);

		JLabel label_1 = new JLabel("Numero:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setBounds(325, 143, 54, 14);
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("Nome:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(67, 181, 54, 14);
		desktopPane.add(label_2);

		txtNomeClie = new JTextField();
		txtNomeClie.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String NomeCli = "0987654321";
				if (NomeCli.contains(e.getKeyChar() + "")) {
					e.consume();

				}
			}
		});
		txtNomeClie.setColumns(10);
		txtNomeClie.setBounds(116, 179, 334, 20);
		desktopPane.add(txtNomeClie);

		JLabel label_3 = new JLabel("Valor:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(461, 143, 46, 14);
		desktopPane.add(label_3);

		JLabel label_4 = new JLabel("Data:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_4.setBounds(582, 143, 46, 14);
		desktopPane.add(label_4);

		JLabel label_5 = new JLabel("Situacao:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(463, 179, 54, 14);
		desktopPane.add(label_5);

		txtValorPed = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("R$############");
			txtValorPed = new javax.swing.JFormattedTextField(format_textField4);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		txtValorPed.setColumns(10);
		txtValorPed.setBounds(500, 143, 72, 20);
		desktopPane.add(txtValorPed);

		txtDataPed = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField4 = new javax.swing.text.MaskFormatter("##/##/####");
			txtDataPed = new javax.swing.JFormattedTextField(format_textField4);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		txtDataPed.setColumns(10);
		txtDataPed.setBounds(623, 143, 72, 20);
		desktopPane.add(txtDataPed);

		JButton btnNewButton = new JButton("Teste");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControlImperio control = new ControlImperio();
				
				control.readJtable();
				
				
				tblPedidos.setModel(dadosTable);
			}
		});
		btnNewButton.setBounds(82, 74, 89, 23);
		desktopPane.add(btnNewButton);
	}

	public CadastraPedido SavePedido(JComboBox<Object> cboSitua) {
		CadastraPedido cadPed = new CadastraPedido();
		cadPed.setRua(txtRuaPed.getText());
		cadPed.setNumero(txtNumPed.getText());
		cadPed.setNome(txtNomeClie.getText());
		cadPed.setData(txtDataPed.getText());
		cadPed.setValor(txtValorPed.getText());
		cadPed.setSituacao(cboSitua.getSelectedItem().toString());
		return cadPed;
	}

	public void clearFields() {
		txtRuaPed.setText(null);
		txtNumPed.setText(null);
		txtDataPed.setText(null);
		txtNomeClie.setText(null);
		txtValorPed.setText(null);

		// Desativando campos
		txtRuaPed.setEditable(false);
		txtNumPed.setEditable(false);
		txtDataPed.setEditable(false);
		txtNomeClie.setEditable(false);
		txtValorPed.setEditable(false);
	}

	private boolean fieldsValidationUser() {
		return txtRuaPed.getText().isEmpty() || (txtNumPed.getText().isEmpty() || (txtDataPed.getText().isEmpty()))
				|| (txtValorPed.getText().isEmpty() || (txtNomeClie.getText().isEmpty()));
	}

}
