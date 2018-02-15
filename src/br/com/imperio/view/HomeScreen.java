package br.com.imperio.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Button;

public class HomeScreen extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
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
	public HomeScreen() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(HomeScreen.class.getResource("/br/com/imperio/image/food.png")));
		setTitle("Imperio das Aguas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		getContentPane().setLayout(null);

		ImageIcon icon = new ImageIcon(this.getClass().getResource("/br/com/imperio/image/Fundosoft.jpg"));
		Image img = icon.getImage();
		JDesktopPane desktopPane = new JDesktopPane() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			}
		};
		
		desktopPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		desktopPane.setBackground(Color.WHITE);

		desktopPane.setBounds(0, 0, 1400, 800);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		toolBar.setBounds(0, 0, 200, 54);
		desktopPane.add(toolBar);
		
		JButton btnPedido = new JButton("");
		btnPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioPedidos pedidos = new FormularioPedidos();
				pedidos.setVisible(true);
			}
		});
		btnPedido.setToolTipText("Pedido");
		btnPedido.setIcon(new ImageIcon(HomeScreen.class.getResource("/br/com/imperio/image/pedidos.png")));
		toolBar.add(btnPedido);
		
		JButton btnProduto = new JButton("");
		btnProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormularioProduto prod = new FormularioProduto();
				prod.setVisible(true);
			}
		});
		btnProduto.setToolTipText("Produtos");
		btnProduto.setIcon(new ImageIcon(HomeScreen.class.getResource("/br/com/imperio/image/box.png")));
		toolBar.add(btnProduto);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(HomeScreen.class.getResource("/br/com/imperio/image/stock.png")));
		btnNewButton.setToolTipText("estoque");
		toolBar.add(btnNewButton);
		
		JButton btnGerente = new JButton("");
		btnGerente.setToolTipText("Gerente");
		btnGerente.setIcon(new ImageIcon(HomeScreen.class.getResource("/br/com/imperio/image/manager.png")));
		toolBar.add(btnGerente);
		
		JToolBar toolBar_1 = new JToolBar();
		toolBar_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		toolBar_1.setBounds(200, 0, 1180, 54);
		desktopPane.add(toolBar_1);
		
		JButton btnExit = new JButton("");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setToolTipText("Sair");
		btnExit.setIcon(new ImageIcon(HomeScreen.class.getResource("/br/com/imperio/image/exit.png")));
		toolBar_1.add(btnExit);
		setVisible(true);
	
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPedido = new JMenu("Pedido");
		mnPedido.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FormularioPedidos pedidos = new FormularioPedidos();
				pedidos.setVisible(true);
			}
		});
		menuBar.add(mnPedido);

		JMenu mnProduto = new JMenu("Produtos");
		menuBar.add(mnProduto);
		
		JMenuItem mntmCadastraProduto = new JMenuItem("Novo Produto");
		mntmCadastraProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioProduto prod = new FormularioProduto();
				prod.setVisible(true);
			}
		});
		mnProduto.add(mntmCadastraProduto);
		
		JMenuItem mntmListaEstoque = new JMenuItem("Estoque");
		mnProduto.add(mntmListaEstoque);
		
		JMenu mnGerente = new JMenu("Gerente");
		menuBar.add(mnGerente);
		
		JMenu mnSair = new JMenu("Sair");
		mnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		menuBar.add(mnSair);
		
		
	}
}
