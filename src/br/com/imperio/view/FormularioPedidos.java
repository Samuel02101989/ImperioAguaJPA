package br.com.imperio.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.imperio.dao.CadastraPedidoDao;
import br.com.imperio.model.CadastraPedido;


public class FormularioPedidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRuaPed;
	private JTextField txtNumPed;
	private JTextField txtNomeClie;
	private JTextField txtValorPed;
	private JTextField txtDataPed;
	private JTable tblTable;

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

	DefaultTableModel dadosTable = new DefaultTableModel();
	private JTextField txtHora;

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
		cboSitua.setBounds(517, 179, 91, 20);
		cboSitua.setModel(new DefaultComboBoxModel(new String[] { "Entregue", "Pendente", "Saiu p/Entrega" }));
		desktopPane.add(cboSitua);

		JButton btnNovoPedido = new JButton("Novo Pedido");
		btnNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (fieldsValidationUser()) {
					CadastraPedido p = new CadastraPedido(txtRuaPed.getText(), Integer.valueOf(txtNumPed.getText()),
							txtNomeClie.getText(), txtValorPed.getText(), txtDataPed.getText(),
							cboSitua.getSelectedItem().toString(),txtHora.getText());

					DefaultTableModel tabela = (DefaultTableModel) tblTable.getModel();
					tabela.addRow(p.obterDados());

				}

				try {
					// salvando dados
					CadastraPedido cadPed = SavePedido(cboSitua);

					CadastraPedidoDao.getInstance().salvar(cadPed);

					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					// limpando campos e desativando
					clearFields();
					activeFields();

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

		JLabel lbl = new JLabel("Rua:");
		lbl.setBounds(67, 143, 54, 14);
		lbl.setForeground(Color.WHITE);
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desktopPane.add(lbl);

		txtRuaPed = new JTextField();
		txtRuaPed.setBounds(116, 143, 199, 20);
		txtRuaPed.setColumns(10);
		desktopPane.add(txtRuaPed);

		txtNumPed = new JTextField();
		txtNumPed.setBounds(389, 143, 62, 20);
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
		desktopPane.add(txtNumPed);

		JLabel label_1 = new JLabel("Numero:");
		label_1.setBounds(325, 143, 54, 14);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desktopPane.add(label_1);

		JLabel label_2 = new JLabel("Nome:");
		label_2.setBounds(67, 181, 54, 14);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desktopPane.add(label_2);

		txtNomeClie = new JTextField();
		txtNomeClie.setBounds(116, 179, 334, 20);
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
		desktopPane.add(txtNomeClie);

		JLabel label_3 = new JLabel("Valor:");
		label_3.setBounds(461, 143, 46, 14);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desktopPane.add(label_3);

		JLabel label_4 = new JLabel("Data:");
		label_4.setBounds(582, 143, 46, 14);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desktopPane.add(label_4);

		JLabel label_5 = new JLabel("Situacao:");
		label_5.setBounds(463, 179, 54, 14);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		desktopPane.add(label_5);

		txtValorPed = new JTextField();
		txtValorPed.setBounds(500, 143, 72, 20);
		txtValorPed.setColumns(10);
		desktopPane.add(txtValorPed);

		txtDataPed = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##/##/##");
			txtDataPed = new javax.swing.JFormattedTextField(format_textField3);
		} catch (Exception e) {
		}
		
		txtDataPed.setBounds(623, 143, 72, 20);
		txtDataPed.setColumns(10);
		desktopPane.add(txtDataPed);

		DateFormat txtDataPed = new SimpleDateFormat("EEEE dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(txtDataPed.format(date));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 224, 748, 206);
		desktopPane.add(scrollPane);

		tblTable = new JTable();
		tblTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rua", "Numero", "Valor", "Data", "Hora", "Nome", "Situacao"
			}
		));
		tblTable.getColumnModel().getColumn(0).setPreferredWidth(130);
		tblTable.getColumnModel().getColumn(0).setMinWidth(20);
		tblTable.getColumnModel().getColumn(1).setPreferredWidth(50);
		tblTable.getColumnModel().getColumn(1).setMinWidth(20);
		tblTable.getColumnModel().getColumn(2).setPreferredWidth(55);
		tblTable.getColumnModel().getColumn(2).setMinWidth(20);
		tblTable.getColumnModel().getColumn(3).setPreferredWidth(55);
		tblTable.getColumnModel().getColumn(3).setMinWidth(20);
		tblTable.getColumnModel().getColumn(4).setPreferredWidth(55);
		tblTable.getColumnModel().getColumn(4).setMinWidth(20);
		tblTable.getColumnModel().getColumn(5).setPreferredWidth(130);
		tblTable.getColumnModel().getColumn(5).setMinWidth(20);
		tblTable.getColumnModel().getColumn(6).setPreferredWidth(70);
		tblTable.getColumnModel().getColumn(6).setMinWidth(20);
		scrollPane.setViewportView(tblTable);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHora.setForeground(Color.WHITE);
		lblHora.setBounds(705, 143, 46, 14);
		desktopPane.add(lblHora);
		
		txtHora = new JTextField();
		try {
			javax.swing.text.MaskFormatter format_textField3 = new javax.swing.text.MaskFormatter("##:##");
			txtHora = new javax.swing.JFormattedTextField(format_textField3);
		} catch (Exception e) {
		}
		txtHora.setBounds(739, 143, 72, 20);
		desktopPane.add(txtHora);
		txtHora.setColumns(10);

	}

	public CadastraPedido SavePedido(JComboBox<Object> cboSitua) {
		CadastraPedido cadPed = new CadastraPedido(txtRuaPed.getText(), Integer.parseInt(txtNumPed.getText()),
				txtNomeClie.getText(), txtValorPed.getText(), txtDataPed.getText(),
				cboSitua.getSelectedItem().toString(),txtHora.getText());

		cadPed.setRua(txtRuaPed.getText());
		cadPed.setNumero(Integer.parseInt(txtNumPed.getText()));
		cadPed.setNome(txtNomeClie.getText());
		cadPed.setData(txtDataPed.getText());
		cadPed.setValor(txtValorPed.getText());
		cadPed.setSituacao(cboSitua.getSelectedItem().toString());
		cadPed.setHora(txtHora.getText());
		return cadPed;
	}

	public void clearFields() {
		txtRuaPed.setText(null);
		txtNumPed.setText(null);
		txtDataPed.setText(null);
		txtNomeClie.setText(null);
		txtValorPed.setText(null);
	}

	public void activeFields() {
		// Desativando campos
		txtRuaPed.setEditable(true);
		txtNumPed.setEditable(true);
		txtDataPed.setEditable(true);
		txtNomeClie.setEditable(true);
		txtValorPed.setEditable(true);
	}

	public void DesactFields() {
		// Desativando campos
		txtRuaPed.setEditable(false);
		txtNumPed.setEditable(false);
		txtDataPed.setEditable(false);
		txtNomeClie.setEditable(false);
		txtValorPed.setEditable(false);
	}

	private boolean fieldsValidationUser() {
		boolean valido = true;
		if (txtRuaPed.getText().isEmpty() || (txtNumPed.getText().isEmpty()) || (txtDataPed.getText().isEmpty())
				|| (txtValorPed.getText().isEmpty() || (txtNomeClie.getText().isEmpty()) || (txtHora.getText().isEmpty()))) {
			
			valido = false;
			JOptionPane.showMessageDialog(null, "*Preenha os campos obrigatorios");
		}
		try {
			Integer.valueOf(txtNumPed.getText());
		} catch (Exception e) {
			valido = false;
			JOptionPane.showMessageDialog(null, "Alerta, Campo valor aceita apenas numeros!!");
		}
		return valido;
	}
}
