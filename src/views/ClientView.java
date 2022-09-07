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

		nameTextField = new JTextField();
		nameTextField.setBounds(50, 50, 150, 25);
		frame.getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(50, 100, 150, 25);
		frame.getContentPane().add(emailTextField);

		nameLabel = new JLabel("Nome");
		nameLabel.setBounds(50, 30, 70, 15);
		frame.getContentPane().add(nameLabel);

		emailLabel = new JLabel("E-mail");
		emailLabel.setBounds(50, 80, 70, 15);
		frame.getContentPane().add(emailLabel);

		rgTextField = new JTextField();
		rgTextField.setColumns(10);
		rgTextField.setBounds(50, 150, 150, 25);
		frame.getContentPane().add(rgTextField);

		rgLabel = new JLabel("RG");
		rgLabel.setBounds(50, 130, 70, 15);
		frame.getContentPane().add(rgLabel);

		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		cpfTextField.setBounds(50, 200, 150, 25);
		frame.getContentPane().add(cpfTextField);

		cpfLabel = new JLabel("CPF");
		cpfLabel.setBounds(50, 180, 70, 15);
		frame.getContentPane().add(cpfLabel);

		cellphoneTextField = new JTextField();
		cellphoneTextField.setColumns(10);
		cellphoneTextField.setBounds(50, 250, 150, 25);
		frame.getContentPane().add(cellphoneTextField);

		cellphoneLabel = new JLabel("Telefone");
		cellphoneLabel.setBounds(50, 230, 70, 15);
		frame.getContentPane().add(cellphoneLabel);
		frame.setLocationRelativeTo(null);

		// Address Section

		stateTextField = new JTextField();
		stateTextField.setBounds(300, 50, 150, 25);
		frame.getContentPane().add(stateTextField);
		stateTextField.setColumns(10);

		cityTextField = new JTextField();
		cityTextField.setColumns(10);
		cityTextField.setBounds(300, 100, 150, 25);
		frame.getContentPane().add(cityTextField);

		stateLabel = new JLabel("Estado");
		stateLabel.setBounds(300, 30, 70, 15);
		frame.getContentPane().add(stateLabel);

		cityLabel = new JLabel("Cidade");
		cityLabel.setBounds(300, 80, 70, 15);
		frame.getContentPane().add(cityLabel);

		cepTextField = new JTextField();
		cepTextField.setColumns(10);
		cepTextField.setBounds(300, 150, 150, 25);
		frame.getContentPane().add(cepTextField);

		cepLabel = new JLabel("CEP");
		cepLabel.setBounds(300, 130, 70, 15);
		frame.getContentPane().add(cepLabel);

		numberTextField = new JTextField();
		numberTextField.setColumns(10);
		numberTextField.setBounds(300, 200, 150, 25);
		frame.getContentPane().add(numberTextField);

		numberLabel = new JLabel("Número");
		numberLabel.setBounds(300, 180, 70, 15);
		frame.getContentPane().add(numberLabel);

		complementTextField = new JTextField();
		complementTextField.setColumns(10);
		complementTextField.setBounds(300, 250, 150, 25);
		frame.getContentPane().add(complementTextField);

		complementLabel = new JLabel("Complemento");
		complementLabel.setBounds(300, 230, 100, 15);
		frame.getContentPane().add(complementLabel);
		frame.setLocationRelativeTo(null);

		// Payment Section

		typeTextField = new JTextField();
		typeTextField.setBounds(550, 50, 150, 25);
		frame.getContentPane().add(typeTextField);
		typeTextField.setColumns(10);

		paymentNumberTextField = new JTextField();
		paymentNumberTextField.setColumns(10);
		paymentNumberTextField.setBounds(550, 100, 150, 25);
		frame.getContentPane().add(paymentNumberTextField);

		typeLabel = new JLabel("Tipo");
		typeLabel.setBounds(550, 30, 70, 15);
		frame.getContentPane().add(typeLabel);

		paymentNumberLabel = new JLabel("Número");
		paymentNumberLabel.setBounds(550, 80, 70, 15);
		frame.getContentPane().add(paymentNumberLabel);

		cvvTextField = new JTextField();
		cvvTextField.setColumns(10);
		cvvTextField.setBounds(550, 150, 150, 25);
		frame.getContentPane().add(cvvTextField);

		cvvLabel = new JLabel("CVV");
		cvvLabel.setBounds(550, 130, 70, 15);
		frame.getContentPane().add(cvvLabel);

		expiresAtTextField = new JTextField();
		expiresAtTextField.setColumns(10);
		expiresAtTextField.setBounds(550, 200, 150, 25);
		frame.getContentPane().add(expiresAtTextField);

		expiresAtLabel = new JLabel("Data de expiração");
		expiresAtLabel.setBounds(550, 180, 150, 15);
		frame.getContentPane().add(expiresAtLabel);

		JButton createClientButton = new JButton("Criar Cliente");
		createClientButton.setBounds(550, 250, 150, 25);
		frame.getContentPane().add(createClientButton);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 300, 650, 150);
		frame.getContentPane().add(scrollPane);

		returnButton = new JButton("Voltar");
		returnButton.setBounds(275, 475, 200, 25);
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
