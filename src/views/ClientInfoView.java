package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controllers.ClientController;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import models.Address;
import models.Client;
import models.Payment;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class ClientInfoView {
  private JFrame frame;
  private String name;
  private String email;
  private String cpf;
  private String rg;
  private String cellphone;
  private String state;
  private String city;
  private String cep;
  private int number;
  private String complement;
  private String type;
  private String cardNumber;
  private int cvv;
  private String expiresAt;
  private JTextField stateTextField;
  private JTextField cityTextField;
  private JTextField cepTextField;
  private JTextField numberTextField;
  private JTextField complementTextField;
  private JTextField typeTextField;
  private JTextField cardNumberTextField;
  private JTextField cvvTextField;
  private JTextField expiresAtTextField;
  private JTable cartTable;
  private JTable pastOrdersTable;
  private ClientController clientController;

  public ClientInfoView(Client client) {
    clientController = new ClientController();

    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);

    this.name = client.getName();
    this.email = client.getEmail();
    this.cpf = client.getCpf();
    this.rg = client.getRg();
    this.cellphone = client.getCellphone();
    this.state = client.getAddress().getState();
    this.city = client.getAddress().getCity();
    this.cep = client.getAddress().getCep();
    this.number = client.getAddress().getNumber();
    this.complement = client.getAddress().getComplement();
    this.type = client.getPayment().getType();
    this.cardNumber = client.getPayment().getNumber();
    this.cvv = client.getPayment().getCvv();
    this.expiresAt = client.getPayment().getExpiresAt();

    JLabel nameLabel = new JLabel(name);
    nameLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    nameLabel.setBounds(30, 25, 150, 15);
    frame.getContentPane().add(nameLabel);

    JLabel emailLabel = new JLabel(email);
    emailLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    emailLabel.setBounds(30, 75, 250, 15);
    frame.getContentPane().add(emailLabel);

    JLabel cpfLabel = new JLabel("CPF:");
    cpfLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cpfLabel.setBounds(30, 120, 70, 15);
    frame.getContentPane().add(cpfLabel);

    JLabel rgLabel = new JLabel("RG:");
    rgLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    rgLabel.setBounds(30, 150, 70, 15);
    frame.getContentPane().add(rgLabel);

    JLabel cellphoneLabel = new JLabel("Telefone:");
    cellphoneLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cellphoneLabel.setBounds(30, 180, 100, 15);
    frame.getContentPane().add(cellphoneLabel);

    JLabel userCpfTextField = new JLabel(cpf);
    userCpfTextField.setBounds(200, 120, 100, 15);
    frame.getContentPane().add(userCpfTextField);

    JLabel userRgTextField = new JLabel(rg);
    userRgTextField.setBounds(200, 150, 100, 15);
    frame.getContentPane().add(userRgTextField);

    JTextField userCellphoneTextField = new JTextField(cellphone);
    userCellphoneTextField.setBounds(200, 180, 100, 15);
    frame.getContentPane().add(userCellphoneTextField);

    JButton returnButton = new JButton("Salvar e Voltar");
    returnButton.setBounds(300, 480, 200, 25);
    frame.getContentPane().add(returnButton);

    JLabel stateLabel = new JLabel("Estado:");
    stateLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    stateLabel.setBounds(30, 210, 100, 15);
    frame.getContentPane().add(stateLabel);

    JLabel cityLabel = new JLabel("Cidade:");
    cityLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cityLabel.setBounds(30, 240, 100, 15);
    frame.getContentPane().add(cityLabel);

    JLabel cepLabel = new JLabel("CEP: ");
    cepLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cepLabel.setBounds(30, 270, 100, 15);
    frame.getContentPane().add(cepLabel);

    JLabel numberLabel = new JLabel("Número:");
    numberLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    numberLabel.setBounds(30, 300, 100, 15);
    frame.getContentPane().add(numberLabel);

    stateTextField = new JTextField(state);
    stateTextField.setBounds(200, 210, 100, 15);
    frame.getContentPane().add(stateTextField);

    cityTextField = new JTextField(city);
    cityTextField.setBounds(200, 240, 100, 15);
    frame.getContentPane().add(cityTextField);

    cepTextField = new JTextField(cep);
    cepTextField.setBounds(200, 270, 100, 15);
    frame.getContentPane().add(cepTextField);

    numberTextField = new JTextField(Integer.toString(number));
    numberTextField.setBounds(200, 300, 100, 15);
    frame.getContentPane().add(numberTextField);

    JLabel complementLabel = new JLabel("Complemento:");
    complementLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    complementLabel.setBounds(30, 330, 150, 15);
    frame.getContentPane().add(complementLabel);

    complementTextField = new JTextField(complement);
    complementTextField.setBounds(200, 330, 100, 15);
    frame.getContentPane().add(complementTextField);

    JLabel typeLabel = new JLabel("Tipo:");
    typeLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    typeLabel.setBounds(30, 360, 70, 15);
    frame.getContentPane().add(typeLabel);

    JLabel cardNumberLabel = new JLabel("Número do Cartão:");
    cardNumberLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cardNumberLabel.setBounds(30, 390, 150, 15);
    frame.getContentPane().add(cardNumberLabel);

    JLabel cvvLabel = new JLabel("CVV:");
    cvvLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cvvLabel.setBounds(30, 420, 150, 15);
    frame.getContentPane().add(cvvLabel);

    JLabel expiresAtLabel = new JLabel("Data de Expiração:");
    expiresAtLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    expiresAtLabel.setBounds(30, 450, 150, 15);
    frame.getContentPane().add(expiresAtLabel);

    typeTextField = new JTextField(type);
    typeTextField.setBounds(200, 358, 100, 15);
    frame.getContentPane().add(typeTextField);

    cardNumberTextField = new JTextField(cardNumber);
    cardNumberTextField.setBounds(200, 388, 100, 15);
    frame.getContentPane().add(cardNumberTextField);

    cvvTextField = new JTextField(String.valueOf(cvv));
    cvvTextField.setBounds(200, 418, 100, 15);
    frame.getContentPane().add(cvvTextField);

    expiresAtTextField = new JTextField(expiresAt);
    expiresAtTextField.setBounds(200, 448, 100, 15);
    frame.getContentPane().add(expiresAtTextField);

    JLabel cartLabel = new JLabel("Carrinho de Compras");
    cartLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    cartLabel.setBounds(350, 25, 300, 15);
    frame.getContentPane().add(cartLabel);

    JScrollPane cartScrollPane = new JScrollPane();
    cartScrollPane.setBounds(350, 50, 300, 180);
    frame.getContentPane().add(cartScrollPane);

    String[] cartTableColumns = { "Produto", "Quantidade", "Preço Unitário", "Preço Total" };
    DefaultTableModel cartTableModel = new DefaultTableModel(cartTableColumns,
        client.getCurrentOrder().getProducts().size());

    cartTable = new JTable(cartTableModel);
    cartScrollPane.setViewportView(cartTable);

    for (int i = 0; i < client.getCurrentOrder().getProducts().size(); i++) {
      cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getName(), i, 0);
      cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getAmount(), i, 1);
      cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getSalePrice(), i, 2);
      cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getSalePrice()
          * client.getCurrentOrder().getProducts().get(i).getAmount(), i, 3);
    }

    JLabel pastOrdersLabel = new JLabel("Compras Anteriores");
    pastOrdersLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    pastOrdersLabel.setBounds(350, 250, 300, 15);
    frame.getContentPane().add(pastOrdersLabel);

    JScrollPane pastOrdersScrollPane = new JScrollPane();
    pastOrdersScrollPane.setBounds(350, 280, 400, 180);
    frame.getContentPane().add(pastOrdersScrollPane);

    String[] pastOrdersTableColumns = { "Compras" };
    DefaultTableModel pastOrdersTableModel = new DefaultTableModel(pastOrdersTableColumns,
        client.getPastOrders().size());

    pastOrdersTable = new JTable(pastOrdersTableModel);
    pastOrdersScrollPane.setViewportView(pastOrdersTable);

    for (int i = 0; i < client.getPastOrders().size(); i++) {
      pastOrdersTableModel.setValueAt(client.getPastOrders().get(i).toString(), i, 0);
    }

    JButton addProductButton = new JButton("Adicionar");
    addProductButton.setBounds(665, 120, 120, 25);
    frame.getContentPane().add(addProductButton);

    JButton finnishButton = new JButton("Finalizar");
    finnishButton.setBounds(665, 160, 120, 25);
    frame.getContentPane().add(finnishButton);

    SearchProductPopUpView searchProductPopUpView = new SearchProductPopUpView(client);

    addProductButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        searchProductPopUpView.getFrame().setVisible(true);
      }
    });

    searchProductPopUpView.getFrame().addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        String[] cartTableColumns = { "Produto", "Quantidade", "Preço Unitário", "Preço Total" };
        DefaultTableModel cartTableModel = new DefaultTableModel(cartTableColumns,
            client.getCurrentOrder().getProducts().size());

        cartTable = new JTable(cartTableModel);
        cartScrollPane.setViewportView(cartTable);

        for (int i = 0; i < client.getCurrentOrder().getProducts().size(); i++) {
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getName(), i, 0);
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getAmount(), i, 1);
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getSalePrice(), i, 2);
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getSalePrice()
              * client.getCurrentOrder().getProducts().get(i).getAmount(), i, 3);
        }

        searchProductPopUpView.clearInputs();
      }
    });

    cartTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent event) {
        if (cartTable.getSelectedRow() > -1) {
          int dialogButton = JOptionPane.YES_NO_OPTION;
          int dialogResult = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse produto?",
              "Confirme sua ação", dialogButton);

          if (dialogResult == JOptionPane.YES_OPTION) {
            cartTableModel.removeRow(cartTable.getSelectedRow());
          }
        }
      }
    });

    finnishButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        client.checkout();

        String[] cartTableColumns = { "Produto", "Quantidade", "Preço Unitário", "Preço Total" };
        DefaultTableModel cartTableModel = new DefaultTableModel(cartTableColumns,
            client.getCurrentOrder().getProducts().size());

        cartTable = new JTable(cartTableModel);

        for (int i = 0; i < client.getCurrentOrder().getProducts().size(); i++) {
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getName(), i, 0);
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getAmount(), i, 1);
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getSalePrice(), i, 2);
          cartTableModel.setValueAt(client.getCurrentOrder().getProducts().get(i).getProduct().getSalePrice()
              * client.getCurrentOrder().getProducts().get(i).getAmount(), i, 3);
        }

        cartScrollPane.setViewportView(cartTable);

        String[] pastOrdersTableColumns = { "Compras" };
        DefaultTableModel pastOrdersTableModel = new DefaultTableModel(pastOrdersTableColumns,
            client.getPastOrders().size());

        pastOrdersTable = new JTable(pastOrdersTableModel);

        for (int i = 0; i < client.getPastOrders().size(); i++) {
          pastOrdersTableModel.setValueAt(client.getPastOrders().get(i).toString(), i, 0);
        }

        pastOrdersScrollPane.setViewportView(pastOrdersTable);
      }
    });

    returnButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Address updatedAddress = new Address(stateTextField.getText(), cityTextField.getText(), cepTextField.getText(),
            Integer.valueOf(numberTextField.getText()), complementTextField.getText());
        Payment updatedPayment = new Payment(typeTextField.getText(), numberTextField.getText(),
            Integer.valueOf(cvvTextField.getText()),
            expiresAtTextField.getText());
        Client updatedCliente = new Client(client.getName(), client.getEmail(), client.getCpf(), client.getRg(),
            userCpfTextField.getText(),
            updatedAddress, updatedPayment);

        clientController.updateClient(updatedCliente);

        ClientView clientView = new ClientView();

        clientView.getFrame().setVisible(true);

        frame.dispose();
      }
    });
  }

  public JFrame getFrame() {
    return frame;
  }
}
