package views;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controllers.ClientController;
import models.Address;
import models.Client;
import models.Payment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * Classe responsável por exibir a tela de cadastro e listagem de clientes
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class ClientView {
	private JFrame frame;
	private JLabel nameLabel;
	private JTextField nameTextField;
	private JLabel emailLabel;
	private JTextField emailTextField;
	private JLabel rgLabel;
	private JTextField rgTextField;
	private JLabel cpfLabel;
	private JTextField cpfTextField;
	private JLabel cellphoneLabel;
	private JTextField cellphoneTextField;
	private JLabel stateLabel;
	private JTextField stateTextField;
	private JLabel cityLabel;
	private JTextField cityTextField;
	private JLabel cepLabel;
	private JTextField cepTextField;
	private JLabel numberLabel;
	private JTextField numberTextField;
	private JLabel complementLabel;
	private JTextField complementTextField;
	private JTextField typeTextField;
	private JLabel typeLabel;
	private JTextField paymentNumberTextField;
	private JLabel paymentNumberLabel;
	private JTextField cvvTextField;
	private JLabel cvvLabel;
	private JTextField expiresAtTextField;
	private JLabel expiresAtLabel;
	private JTable table;
	private ClientController clientController;
	private Client selectedClient;
	private JScrollPane scrollPane;
	private JButton returnButton;
	private JButton createClientButton;

	/**
	 * 
	 * Construtor da classe ClientView que inicializa os componentes da tela
	 * 
	 * @param clientController
	 */
	public ClientView() {
		clientController = new ClientController();

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		// Create labels and text fields
		nameLabel = new JLabel("Nome");
		nameTextField = new JTextField();
		emailLabel = new JLabel("E-mail");
		emailTextField = new JTextField();
		rgTextField = new JTextField();
		rgLabel = new JLabel("RG");
		cpfLabel = new JLabel("CPF");
		cpfTextField = new JTextField();
		cellphoneLabel = new JLabel("Telefone");
		cellphoneTextField = new JTextField();

		// Set bounds
		nameTextField.setBounds(50, 50, 150, 25);
		emailTextField.setBounds(50, 100, 150, 25);
		nameLabel.setBounds(50, 30, 70, 15);
		emailLabel.setBounds(50, 80, 70, 15);
		rgTextField.setBounds(50, 150, 150, 25);
		rgLabel.setBounds(50, 130, 70, 15);
		cpfTextField.setBounds(50, 200, 150, 25);
		cpfLabel.setBounds(50, 180, 70, 15);
		cellphoneTextField.setBounds(50, 250, 150, 25);
		cellphoneLabel.setBounds(50, 230, 70, 15);

		// Add to frame
		frame.getContentPane().add(nameLabel);
		frame.getContentPane().add(nameTextField);
		frame.getContentPane().add(emailLabel);
		frame.getContentPane().add(emailTextField);
		frame.getContentPane().add(rgLabel);
		frame.getContentPane().add(rgTextField);
		frame.getContentPane().add(cpfLabel);
		frame.getContentPane().add(cpfTextField);
		frame.getContentPane().add(cellphoneLabel);
		frame.getContentPane().add(cellphoneTextField);

		// Address Section
		stateLabel = new JLabel("Estado");
		stateTextField = new JTextField();
		cityLabel = new JLabel("Cidade");
		cityTextField = new JTextField();
		cepLabel = new JLabel("CEP");
		cepTextField = new JTextField();
		numberLabel = new JLabel("Número");
		numberTextField = new JTextField();
		complementLabel = new JLabel("Complemento");
		complementTextField = new JTextField();

		stateLabel.setBounds(300, 30, 70, 15);
		stateTextField.setBounds(300, 50, 150, 25);
		cityLabel.setBounds(300, 80, 70, 15);
		cityTextField.setBounds(300, 100, 150, 25);
		cepLabel.setBounds(300, 130, 70, 15);
		cepTextField.setBounds(300, 150, 150, 25);
		numberLabel.setBounds(300, 180, 70, 15);
		numberTextField.setBounds(300, 200, 150, 25);
		complementLabel.setBounds(300, 230, 100, 15);
		complementTextField.setBounds(300, 250, 150, 25);
		
		frame.getContentPane().add(stateTextField);
		frame.getContentPane().add(cityTextField);
		frame.getContentPane().add(stateLabel);
		frame.getContentPane().add(cityLabel);
		frame.getContentPane().add(cepTextField);
		frame.getContentPane().add(cepLabel);
		frame.getContentPane().add(numberTextField);
		frame.getContentPane().add(numberLabel);
		frame.getContentPane().add(complementTextField);
		frame.getContentPane().add(complementLabel);
		frame.setLocationRelativeTo(null);

		// Payment Section
		typeLabel = new JLabel("Tipo");
		typeTextField = new JTextField();
		paymentNumberLabel = new JLabel("Número");
		paymentNumberTextField = new JTextField();
		cvvLabel = new JLabel("CVV");
		cvvTextField = new JTextField();
		expiresAtLabel = new JLabel("Data de expiração");
		expiresAtTextField = new JTextField();
		createClientButton = new JButton("Criar Cliente");
		scrollPane = new JScrollPane();
		returnButton = new JButton("Voltar");

		typeLabel.setBounds(550, 30, 70, 15);
		typeTextField.setBounds(550, 50, 150, 25);
		paymentNumberLabel.setBounds(550, 80, 70, 15);
		paymentNumberTextField.setBounds(550, 100, 150, 25);
		cvvLabel.setBounds(550, 130, 70, 15);
		cvvTextField.setBounds(550, 150, 150, 25);
		expiresAtLabel.setBounds(550, 180, 150, 15);
		expiresAtTextField.setBounds(550, 200, 150, 25);
		createClientButton.setBounds(550, 250, 150, 25);
		scrollPane.setBounds(50, 300, 650, 150);
		returnButton.setBounds(275, 475, 200, 25);

		frame.getContentPane().add(typeLabel);
		frame.getContentPane().add(typeTextField);
		frame.getContentPane().add(paymentNumberLabel);
		frame.getContentPane().add(paymentNumberTextField);
		frame.getContentPane().add(cvvLabel);
		frame.getContentPane().add(cvvTextField);
		frame.getContentPane().add(expiresAtLabel);
		frame.getContentPane().add(expiresAtTextField);
		frame.getContentPane().add(createClientButton);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(returnButton);

		updateTable();

		createClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Client clientAlreadyExists = clientController.readOneClient(emailTextField.getText());

				if (clientAlreadyExists == null && allInputsAreFilled()) {
					clientController.createClient(nameTextField.getText(),
							emailTextField.getText(),
							new Address(stateTextField.getText(), cityTextField.getText(), cepTextField.getText(),
									Integer.valueOf(numberTextField.getText()), complementTextField.getText()),
							cpfTextField.getText(),
							rgTextField.getText(),
							cellphoneTextField.getText(),
							new Payment(typeTextField.getText(), paymentNumberTextField.getText(),
									Integer.valueOf(cvvTextField.getText()), expiresAtTextField.getText()));

					clearInputs();
					JOptionPane.showMessageDialog(null, "Cliente criado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Cliente já existe!");
				}

				updateTable();
			}
		});

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectSectionView selectSectionView = new SelectSectionView();
				selectSectionView.getFrame().setVisible(true);

				frame.dispose();
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

	public boolean allInputsAreFilled() {
		return !nameTextField.getText().isEmpty() && !emailTextField.getText().isEmpty()
				&& !stateTextField.getText().isEmpty() && !cityTextField.getText().isEmpty()
				&& !cepTextField.getText().isEmpty() && !numberTextField.getText().isEmpty()
				&& !complementTextField.getText().isEmpty() && !cpfTextField.getText().isEmpty()
				&& !rgTextField.getText().isEmpty() && !cellphoneTextField.getText().isEmpty()
				&& !typeTextField.getText().isEmpty() && !paymentNumberTextField.getText().isEmpty()
				&& !cvvTextField.getText().isEmpty() && !expiresAtTextField.getText().isEmpty();
	}

	public void clearInputs() {
		nameTextField.setText("");
		emailTextField.setText("");
		stateTextField.setText("");
		cityTextField.setText("");
		cepTextField.setText("");
		numberTextField.setText("");
		complementTextField.setText("");
		cpfTextField.setText("");
		rgTextField.setText("");
		cellphoneTextField.setText("");
		typeTextField.setText("");
		paymentNumberTextField.setText("");
		cvvTextField.setText("");
		expiresAtTextField.setText("");
	}

	public void updateTable() {
		String[] columns = { "Nome", "E-mail", "Telefone", "Cidade", "Compras Feitas" };
		Object[][] data = new Object[clientController.readAllClients().size()][columns.length];

		// Create initial table
		for (int i = 0; i < clientController.readAllClients().size(); i++) {
			String[] product = { clientController.readAllClients().get(i).getName(),
					String.valueOf(clientController.readAllClients().get(i).getEmail()),
					String.valueOf(clientController.readAllClients().get(i).getCellphone()),
					String.valueOf(clientController.readAllClients().get(i).getAddress().getCity()),
					String.valueOf(clientController.readAllClients().get(i).getPastOrders().size())
			};

			data[i] = product;
		}

		table = new JTable(data, columns);

		// Listen to product selection event
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (table.getSelectedRow() > -1) {
					selectedClient = clientController.readAllClients().get(table.getSelectedRow());

					ClientInfoView clientInfoView = new ClientInfoView(selectedClient);
					clientInfoView.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});

		scrollPane.setViewportView(table);
	}
}
