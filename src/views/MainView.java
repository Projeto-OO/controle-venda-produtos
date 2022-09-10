package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controllers.AdminController;
import models.Store;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

/**
 * Classe principal da aplicação. Responsável por exibir a tela de login e
 * redirecionar para a tela de administração.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class MainView {
	private JFrame frame;
	private JLabel storeNameLabel;
	private JLabel emailLabel;
	private JLabel passwordLabel;
	private JTextField emailTextField;
	private JPasswordField passwordField;
	private JButton createAdminButton;

	/**
	 * Cria a janela, instancia a base de dados e preenche a base de dados com dados
	 * pré-cadastrados.
	 */
	public static void main(String[] args) {
		MainView window = new MainView();
		window.frame.setVisible(true);

		Store.getInstance();
		Store.fillDatabase();
	}

	/**
	 * Cria a janela principal da aplicação.
	 */
	public MainView() {
		AdminController adminController = new AdminController();
		String storeName = Store.getName();

		boolean isFirstTime = adminController.readAllAdmins().isEmpty();

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		// Create labels and button
		if (isFirstTime) {
			storeNameLabel = new JLabel("Bem-vindo(a)!");
		} else {
			storeNameLabel = new JLabel(storeName);
		}

		emailLabel = new JLabel("E-mail");
		passwordLabel = new JLabel("Senha");
		emailTextField = new JTextField();
		passwordField = new JPasswordField();

		if (isFirstTime) {
			createAdminButton = new JButton("Entrar pela primeira vez");
		} else {
			createAdminButton = new JButton("Entrar como Administrador");
		}

		storeNameLabel.setFont(new Font("Meera", Font.BOLD, 25));

		// Set labels and button bounds
		storeNameLabel.setBounds(325, 100, 175, 60);
		emailLabel.setBounds(315, 190, 70, 15);
		passwordLabel.setBounds(315, 250, 70, 15);
		emailTextField.setBounds(315, 210, 170, 20);
		passwordField.setBounds(315, 270, 170, 20);
		if (!isFirstTime) {
			createAdminButton.setBounds(285, 340, 225, 25);
		} else {
			createAdminButton.setBounds(285, 250, 225, 25);
		}

		// Add labels and button to frame
		frame.getContentPane().add(storeNameLabel);
		if (!isFirstTime) {
			frame.getContentPane().add(emailLabel);
			frame.getContentPane().add(passwordLabel);
			frame.getContentPane().add(emailTextField);
			frame.getContentPane().add(passwordField);
		}
		frame.getContentPane().add(createAdminButton);

		createAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isFirstTime) {
					AdminView adminView = new AdminView();
					adminView.getFrame().setVisible(true);
					frame.dispose();
				} else {
					if (adminController.login(emailTextField.getText(), new String(passwordField.getPassword()))) {
						SelectSectionView selectSectionView = new SelectSectionView();
						selectSectionView.getFrame().setVisible(true);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "E-mail ou senha incorretos");
					}
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}
}
