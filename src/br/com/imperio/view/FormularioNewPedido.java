package br.com.imperio.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.imperio.dao.CadastraPedidoDao;
import br.com.imperio.model.CadastraPedido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JButton btnEditPedidos;
	private JPanel panel;
	private JLabel lblPedidos;
	private JButton btnDelPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioNewPedido frame = new FormularioNewPedido();
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
	public FormularioNewPedido() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HomeScreen.class.getResource("/br/com/imperio/image/client.png")));
		setTitle("Cadastrar Pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 515, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
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
		txtNomeAguas.setBounds(99, 173, 333, 20);
		contentPane.add(txtNomeAguas);
		txtNomeAguas.setColumns(10);
		
		txtRuaAgua = new JTextField();
		txtRuaAgua.setBounds(99, 126, 199, 20);
		contentPane.add(txtRuaAgua);
		txtRuaAgua.setColumns(10);
		
		txtNumAguas = new JTextField();
		txtNumAguas.setBounds(372, 126, 62, 20);
		contentPane.add(txtNumAguas);
		txtNumAguas.setColumns(10);
		
		JComboBox<Object> cboSituacao = new JComboBox<Object>();
		cboSituacao.setModel(new DefaultComboBoxModel<Object>(new String[] {"Entregue", "Pendente", "Saiu p/ entrega"}));
		cboSituacao.setBounds(340, 227, 91, 20);
		contentPane.add(cboSituacao);
		
		JLabel lblNewLabel_1 = new JLabel("Rua:");
		lblNewLabel_1.setBounds(50, 126, 54, 14);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numero:");
		lblNewLabel_2.setBounds(308, 131, 54, 14);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Valor:");
		lblNewLabel_3.setBounds(50, 227, 46, 14);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3);
		
		txtValorAgua = new JTextField();
		txtValorAgua.setBounds(99, 227, 62, 20);
		contentPane.add(txtValorAgua);
		txtValorAgua.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Data:");
		lblNewLabel_4.setBounds(171, 227, 46, 14);
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_4);
		
		txtDataAguas = new JTextField();
		txtDataAguas.setBounds(204, 225, 75, 20);
		contentPane.add(txtDataAguas);
		txtDataAguas.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(99, 283, 333, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnEditPedidos = new JButton("Edit");
		btnEditPedidos.setBounds(132, 11, 84, 30);
		panel.add(btnEditPedidos);
		btnEditPedidos.setIcon(new ImageIcon(FormularioNewPedido.class.getResource("/br/com/imperio/image/edit.png")));
		btnEditPedidos.setBackground(Color.ORANGE);
		
		JButton btnSavePedidos = new JButton("Save");
		btnSavePedidos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					//salvando dados
					CadastraPedido cadPed = SavePedido(cboSituacao);
					
					
					
					if(fieldsValidationUser()){
						//validando campos
						JOptionPane.showMessageDialog(null, "*Campo vazio, Por favor preencha!!");
					}else{
						CadastraPedidoDao.getInstance().salvar(cadPed);
						JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
						//limpando campos e desativando
						clearFields();
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao salvar!");
				}
				
			}

			

		
		});
		btnSavePedidos.setBounds(27, 11, 84, 30);
		panel.add(btnSavePedidos);
		btnSavePedidos.setBackground(new Color(50, 205, 50));
		btnSavePedidos.setIcon(new ImageIcon(FormularioNewPedido.class.getResource("/br/com/imperio/image/add.png")));
		
		btnDelPedidos = new JButton("Del");
		btnDelPedidos.setIcon(new ImageIcon(FormularioNewPedido.class.getResource("/br/com/imperio/image/delete.png")));
		btnDelPedidos.setBackground(Color.RED);
		btnDelPedidos.setBounds(235, 11, 84, 30);
		panel.add(btnDelPedidos);
		
		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setForeground(Color.WHITE);
		lblPedidos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPedidos.setBounds(204, 47, 75, 14);
		contentPane.add(lblPedidos);
		

		JLabel lblSituacao = new JLabel("Situacao:");
		lblSituacao.setForeground(Color.WHITE);
		lblSituacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSituacao.setBounds(286, 228, 54, 14);
		contentPane.add(lblSituacao);
	}
	public CadastraPedido SavePedido(JComboBox<Object> cboSituacao) {
		CadastraPedido cadPed = new CadastraPedido();
		cadPed.setRua(txtRuaAgua.getText());
		cadPed.setNumero(txtNumAguas.getText());
		cadPed.setNome(txtNomeAguas.getText());
		cadPed.setData(txtDataAguas.getText());
		cadPed.setValor(txtValorAgua.getText());
		cadPed.setSituacao(cboSituacao.getSelectedItem().toString());
		return cadPed;
	}
	public void clearFields() {
		txtRuaAgua.setText(null);
		txtNumAguas.setText(null);
		txtDataAguas.setText(null);
		txtNomeAguas.setText(null);
		txtValorAgua.setText(null);

		// Desativando campos
		txtRuaAgua.setEditable(false);
		txtNumAguas.setEditable(false);
		txtDataAguas.setEditable(false);
		txtNomeAguas.setEditable(false);
		txtValorAgua.setEditable(false);
	}
	private boolean fieldsValidationUser() {
		return txtRuaAgua.getText().isEmpty()
				|| (txtNumAguas.getText().isEmpty() || (txtDataAguas.getText().isEmpty()))
				|| (txtValorAgua.getText().isEmpty());
	}
	
}
