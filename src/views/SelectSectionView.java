package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import models.Store;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe responsável por exibir a tela de seleção de seção.
 * Permite que um administrador selecione entre as seções de produtos e de
 * clientes.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class SelectSectionView {
	private JFrame frame;
	private JButton productsButton;
	private JButton clientsButton;
	private JButton adminButton;
	private JButton returnButton;
	private JLabel storeNameLabel;

	/**
	 * Construtor responsável por adicionar os elementos na tela, bem como
	 * definir as ações de cada botão.
	 */
	public SelectSectionView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		storeNameLabel = new JLabel(Store.getName());
		productsButton = new JButton("Produtos");
		clientsButton = new JButton("Clientes");
		adminButton = new JButton("Administradores");
		returnButton = new JButton("Sair");

		storeNameLabel.setFont(new Font("Meera", Font.BOLD, 25));

		storeNameLabel.setBounds(310, 100, 200, 60);
		productsButton.setBounds(300, 200, 200, 25);
		clientsButton.setBounds(300, 250, 200, 25);
		adminButton.setBounds(300, 300, 200, 25);
		returnButton.setBounds(300, 350, 200, 25);

		frame.getContentPane().add(storeNameLabel);
		frame.getContentPane().add(productsButton);
		frame.getContentPane().add(clientsButton);
		frame.getContentPane().add(adminButton);
		frame.getContentPane().add(returnButton);

		productsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductView productView = new ProductView();
				productView.getFrame().setVisible(true);
				frame.dispose();
			}
		});

		clientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientView clientView = new ClientView();
				clientView.getFrame().setVisible(true);
				frame.dispose();
			}
		});

		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminView adminView = new AdminView();
				adminView.getFrame().setVisible(true);
				frame.dispose();
			}
		});

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainView mainView = new MainView();
				mainView.getFrame().setVisible(true);
				frame.dispose();
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

}
