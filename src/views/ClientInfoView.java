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
import java.util.ArrayList;

import models.Address;
import models.Cart;
import models.Client;
import models.Payment;
import models.ProductAmount;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * Classe que cria a tela com as informações de um cliente em específico
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 * 
 */
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
  private JLabel nameLabel;
  private JLabel emailLabel;
  private JLabel cpfLabel;
  private JLabel rgLabel;
  private JLabel cellphoneLabel;
  private JLabel stateLabel;
  private JLabel cityLabel;
  private JLabel cepLabel;
  private JLabel numberLabel;
  private JLabel complementLabel;
  private JLabel typeLabel;
  private JLabel cardNumberLabel;
  private JLabel cvvLabel;
  private JLabel expiresAtLabel;
  private JLabel userCpfTextField;
  private JLabel userRgTextField;
  private JTextField userCellphoneTextField;
  private JButton returnButton;
  private JLabel cartLabel;
  private JScrollPane cartScrollPane;
  private JLabel pastOrdersLabel;
  private JScrollPane pastOrdersScrollPane;
  private JButton addProductButton;
  private JButton finnishButton;
  private JButton deleteClientButton;

  /**
   * Construtor da classe ClientInfoView que cria todos os componentes da tela
   * 
   * @param client Cliente selecionado
   */
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

    nameLabel = new JLabel(name);
    emailLabel = new JLabel(email);
    cpfLabel = new JLabel("CPF:");
    rgLabel = new JLabel("RG:");
    cellphoneLabel = new JLabel("Telefone:");
    userCpfTextField = new JLabel(cpf);
    stateLabel = new JLabel("Estado:");
    cityLabel = new JLabel("Cidade:");
    cepLabel = new JLabel("CEP: ");
    numberLabel = new JLabel("Número:");
    complementLabel = new JLabel("Complemento:");
    typeLabel = new JLabel("Tipo:");
    cardNumberLabel = new JLabel("Número do Cartão:");
    cvvLabel = new JLabel("CVV:");
    expiresAtLabel = new JLabel("Data de Expiração:");
    cartLabel = new JLabel("Carrinho de Compras");
    userRgTextField = new JLabel(rg);
    userCellphoneTextField = new JTextField(cellphone);
    stateTextField = new JTextField(state);
    cityTextField = new JTextField(city);
    cepTextField = new JTextField(cep);
    numberTextField = new JTextField(Integer.toString(number));
    complementTextField = new JTextField(complement);
    typeTextField = new JTextField(type);
    cardNumberTextField = new JTextField(cardNumber);
    cvvTextField = new JTextField(String.valueOf(cvv));
    expiresAtTextField = new JTextField(expiresAt);
    returnButton = new JButton("Salvar e Voltar");

    nameLabel.setBounds(30, 25, 150, 15);
    emailLabel.setBounds(30, 75, 250, 15);
    cpfLabel.setBounds(30, 120, 70, 15);
    rgLabel.setBounds(30, 150, 70, 15);
    cellphoneLabel.setBounds(30, 180, 100, 15);
    userCpfTextField.setBounds(200, 120, 100, 15);
    userRgTextField.setBounds(200, 150, 100, 15);
    userCellphoneTextField.setBounds(200, 180, 100, 15);
    returnButton.setBounds(300, 480, 200, 25);
    stateLabel.setBounds(30, 210, 100, 15);
    cityLabel.setBounds(30, 240, 100, 15);
    cepLabel.setBounds(30, 270, 100, 15);
    numberLabel.setBounds(30, 300, 100, 15);
    stateTextField.setBounds(200, 210, 100, 15);
    cityTextField.setBounds(200, 240, 100, 15);
    cepTextField.setBounds(200, 270, 100, 15);
    numberTextField.setBounds(200, 300, 100, 15);
    complementLabel.setBounds(30, 330, 150, 15);
    complementTextField.setBounds(200, 330, 100, 15);
    typeLabel.setBounds(30, 360, 70, 15);
    cardNumberLabel.setBounds(30, 390, 150, 15);
    cvvLabel.setBounds(30, 420, 150, 15);
    expiresAtLabel.setBounds(30, 450, 150, 15);
    typeTextField.setBounds(200, 360, 100, 15);
    cardNumberTextField.setBounds(200, 388, 100, 15);
    cvvTextField.setBounds(200, 418, 100, 15);
    expiresAtTextField.setBounds(200, 448, 100, 15);
    cartLabel.setBounds(350, 25, 300, 15);

    nameLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    emailLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    cpfLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    rgLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cellphoneLabel.setFont(new Font("Dialog", Font.BOLD, 14));

    frame.getContentPane().add(nameLabel);
    frame.getContentPane().add(emailLabel);
    frame.getContentPane().add(cpfLabel);
    frame.getContentPane().add(rgLabel);
    frame.getContentPane().add(cellphoneLabel);
    frame.getContentPane().add(userCpfTextField);
    frame.getContentPane().add(userRgTextField);
    frame.getContentPane().add(userCellphoneTextField);
    frame.getContentPane().add(returnButton);

    stateLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cityLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cepLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    numberLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    complementLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    typeLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cardNumberLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cvvLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    expiresAtLabel.setFont(new Font("Dialog", Font.BOLD, 14));

    frame.getContentPane().add(stateLabel);
    frame.getContentPane().add(cityLabel);
    frame.getContentPane().add(cepLabel);
    frame.getContentPane().add(numberLabel);
    frame.getContentPane().add(stateTextField);
    frame.getContentPane().add(cityTextField);
    frame.getContentPane().add(cepTextField);
    frame.getContentPane().add(numberTextField);
    frame.getContentPane().add(complementLabel);
    frame.getContentPane().add(complementTextField);
    frame.getContentPane().add(typeLabel);
    frame.getContentPane().add(cardNumberLabel);
    frame.getContentPane().add(cvvLabel);
    frame.getContentPane().add(expiresAtLabel);
    frame.getContentPane().add(typeTextField);
    frame.getContentPane().add(cardNumberTextField);
    frame.getContentPane().add(cvvTextField);
    frame.getContentPane().add(expiresAtTextField);

    cartLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    frame.getContentPane().add(cartLabel);

    cartScrollPane = new JScrollPane();
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

    pastOrdersLabel = new JLabel("Compras Anteriores");
    pastOrdersScrollPane = new JScrollPane();

    pastOrdersLabel.setBounds(350, 250, 300, 15);
    pastOrdersScrollPane.setBounds(350, 280, 400, 180);

    pastOrdersLabel.setFont(new Font("Dialog", Font.BOLD, 22));

    frame.getContentPane().add(pastOrdersLabel);
    frame.getContentPane().add(pastOrdersScrollPane);

    String[] pastOrdersTableColumns = { "Compras" };
    DefaultTableModel pastOrdersTableModel = new DefaultTableModel(pastOrdersTableColumns,
        client.getPastOrders().size());

    pastOrdersTable = new JTable(pastOrdersTableModel);
    pastOrdersScrollPane.setViewportView(pastOrdersTable);

    for (int i = 0; i < client.getPastOrders().size(); i++) {
      pastOrdersTableModel.setValueAt(client.getPastOrders().get(i).toString(), i, 0);
    }

    addProductButton = new JButton("Adicionar");
    finnishButton = new JButton("Finalizar");
    deleteClientButton = new JButton("Excluir Cliente");

    addProductButton.setBounds(665, 120, 120, 25);
    finnishButton.setBounds(665, 160, 120, 25);
    deleteClientButton.setBounds(625, 480, 150, 25);

    frame.getContentPane().add(addProductButton);
    frame.getContentPane().add(finnishButton);
    frame.getContentPane().add(deleteClientButton);

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

        cartTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent event) {
            if (cartTable.getSelectedRow() > -1) {
              int dialogButton = JOptionPane.YES_NO_OPTION;
              int dialogResult = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse produto?",
                  "Confirme sua ação", dialogButton);

              if (dialogResult == JOptionPane.YES_OPTION) {
                ProductAmount selectedProduct = client.getCurrentOrder().getProducts().get(cartTable.getSelectedRow());

                selectedProduct.getProduct()
                    .setStock(selectedProduct.getProduct().getStock() + selectedProduct.getAmount());

                client.getCurrentOrder().getProducts().remove(cartTable.getSelectedRow());
                cartTableModel.removeRow(cartTable.getSelectedRow());
              }
            }
          }
        });

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
            ProductAmount selectedProduct = client.getCurrentOrder().getProducts().get(cartTable.getSelectedRow());

            selectedProduct.getProduct()
                .setStock(selectedProduct.getProduct().getStock() + selectedProduct.getAmount());

            client.getCurrentOrder().getProducts().remove(cartTable.getSelectedRow());
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
        Cart orders = client.getCurrentOrder();
        ArrayList<Cart> pastOrders = client.getPastOrders();

        Address updatedAddress = new Address(stateTextField.getText(), cityTextField.getText(), cepTextField.getText(),
            Integer.valueOf(numberTextField.getText()), complementTextField.getText());
        Payment updatedPayment = new Payment(typeTextField.getText(), numberTextField.getText(),
            Integer.valueOf(cvvTextField.getText()),
            expiresAtTextField.getText());
        Client updatedClient = new Client(client.getName(), client.getEmail(), client.getCpf(), client.getRg(),
            userCellphoneTextField.getText(),
            updatedAddress, updatedPayment);

        updatedClient.setPastOrders(pastOrders);
        updatedClient.setCurrentOrder(orders);

        clientController.updateClient(updatedClient);

        ClientView clientView = new ClientView();

        clientView.getFrame().setVisible(true);

        frame.dispose();
      }
    });

    deleteClientButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir esse cliente?",
            "Confirme sua ação", dialogButton);

        if (dialogResult == JOptionPane.YES_OPTION) {
          clientController.deleteClient(client);
          ClientView clientView = new ClientView();
          clientView.getFrame().setVisible(true);
          frame.dispose();
        }
      }
    });
  }

  public JFrame getFrame() {
    return frame;
  }
}
