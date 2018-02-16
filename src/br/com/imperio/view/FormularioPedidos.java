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
import javax.swing.table.TableRowSorter;

import br.com.imperio.dao.CadastraPedidoDao;
import br.com.imperio.model.CadastraPedido;

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
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	@SuppressWarnings("unused")
	private void initComponente() {
		// TODO Auto-generated method stub
		initComponente();
		DefaultTableModel modelo = (DefaultTableModel) tblPedidos.getModel();
		tblPedidos.setRowSorter(new TableRowSorter<DefaultTableModel>(modelo));

		readjTable();
	}
	
	//METODO  DE INSERCAO DE DADOS NA TABELA 
	public void readjTable(){
		DefaultTableModel modelo = (DefaultTableModel)tblPedidos.getModel();
		modelo.setNumRows(0);
		CadastraPedidoDao cadao = new CadastraPedidoDao();

		for(CadastraPedido c: cadao.findAll()){
	 
			modelo.addRow(new Object[]{
					c.getRua(),
					c.getNumero(),
					c.getData(),
					c.getValor(), 
					c.getSituacao()});

	}
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
		desktopPane.setBackground(Color.LIGHT_GRAY);
		desktopPane.setBounds(10, 11, 884, 461);
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
		scrollPane.setBounds(45, 169, 788, 187);
		desktopPane.add(scrollPane);
		
		tblPedidos = new JTable();
		tblPedidos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Rua", "Numero", "Data", "Valor", "Nome", "Situacao"
			}
		));
		scrollPane.setViewportView(tblPedidos);
		
		JButton btnPush = new JButton("View ");
		btnPush.setBounds(45, 367, 89, 23);
		desktopPane.add(btnPush);
	}
	
	
}
