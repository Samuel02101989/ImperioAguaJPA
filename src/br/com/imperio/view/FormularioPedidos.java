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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioPedidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioPedidos frame = new FormularioPedidos();
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
	public FormularioPedidos() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HomeScreen.class.getResource("/br/com/imperio/image/client.png")));
		setTitle("Pedidos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(150, 100, 900, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.BLACK);
		desktopPane.setBounds(0, 0, 884, 461);
		contentPane.add(desktopPane);
		
		JLabel lblPedidosEmAberto = new JLabel("Pedidos em Aberto");
		lblPedidosEmAberto.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPedidosEmAberto.setForeground(Color.WHITE);
		lblPedidosEmAberto.setBounds(331, 11, 250, 57);
		desktopPane.add(lblPedidosEmAberto);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(229, 59, 391, 49);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNovoPedido = new JButton("Novo Pedido");
		btnNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioNewPedido formNew = new FormularioNewPedido();
				formNew.setVisible(true);
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
		scrollPane.setBounds(58, 131, 760, 219);
		desktopPane.add(scrollPane);
		
		tblPedidos = new JTable();
		scrollPane.setViewportView(tblPedidos);
		tblPedidos.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Comanda", "Cliente", "Produto", "Data", "Situa\u00E7ao"
			}
		));
	}
	
}
