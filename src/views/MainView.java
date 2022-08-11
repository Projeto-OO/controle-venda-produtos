package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import controllers.ClientController;
import database.Store;
import models.Address;
import models.Payment;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class MainView {
	private JFrame frame;
	private JTextField emailTextField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		MainView window = new MainView();
		window.frame.setVisible(true);

		Store.getInstance();

		ClientController clientController = new ClientController();

		Payment brunoPayment = new Payment("débito", "1234567", 123, "12/2025");
		Address brunoAddress = new Address("DF", "gama", "123456", 1, "Faculdade do Gama");
		clientController.createClient("bruno", "brunão@gmail.com", brunoAddress, "123.456.789-10", "1234",
				"6199999999", brunoPayment);
	}

	public MainView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel storeNameLabel = new JLabel("Lojão do Brunão");
		storeNameLabel.setFont(new Font("Meera", Font.BOLD, 25));
		storeNameLabel.setBounds(315, 100, 175, 60);
		frame.getContentPane().add(storeNameLabel);

		JLabel emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(315, 190, 70, 15);
		frame.getContentPane().add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setBounds(315, 210, 170, 20);
		frame.getContentPane().add(emailTextField);
		emailTextField.setColumns(10);

		JLabel passwordLabel = new JLabel("Senha");
		passwordLabel.setBounds(315, 250, 70, 15);
		frame.getContentPane().add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(315, 270, 170, 20);
		frame.getContentPane().add(passwordField);

		JButton createAdminButton = new JButton("Entrar como Administrador");
		createAdminButton.setBounds(285, 340, 225, 25);
		createAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductView productView = new ProductView();

				productView.getFrame().setVisible(true);
				frame.dispose();
			}
		});
		frame.getContentPane().add(createAdminButton);
	}
}
