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

		ImageIcon icon = new ImageIcon(this.getClass().getResource("/br/com/imperio/image/fundoaguas.png"));
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
		
		desktopPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		desktopPane.setBackground(Color.WHITE);

		desktopPane.setBounds(0, 0, 1400, 800);
		getContentPane().add(desktopPane);
		desktopPane.setLayout(null);
		setVisible(true);
	
		setResizable(false);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnPedido = new JMenu("Pedido");
		menuBar.add(mnPedido);
		
		JMenuItem mntmNovoPedido = new JMenuItem("Novo Pedido");
		mntmNovoPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormularioPedidos pedidos = new FormularioPedidos();
				pedidos.setVisible(true);
			}
		});
		mnPedido.add(mntmNovoPedido);
		

		JMenu mnProduto = new JMenu("Produtos");
		menuBar.add(mnProduto);
		
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
