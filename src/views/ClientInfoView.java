package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Client;
import java.awt.Font;
import javax.swing.JButton;

public class ClientInfoView {
  private JFrame frame;
  private String name;
  private String email;
  private String cpf;
  private String rg;
  private String cellphone;
  private String payment;
  private String address;

  public ClientInfoView(Client client) {
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
    this.payment = client.getPayment().getType();
    this.address = client.getAddress().getCity();

    JLabel nameLabel = new JLabel(name);
    nameLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    nameLabel.setBounds(330, 25, 150, 15);
    frame.getContentPane().add(nameLabel);

    JLabel emailLabel = new JLabel(email);
    emailLabel.setFont(new Font("Dialog", Font.BOLD, 22));
    emailLabel.setBounds(290, 75, 250, 15);
    frame.getContentPane().add(emailLabel);

    JLabel cpfLabel = new JLabel("CPF:");
    cpfLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cpfLabel.setBounds(30, 140, 70, 15);
    frame.getContentPane().add(cpfLabel);

    JLabel rgLabel = new JLabel("RG:");
    rgLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    rgLabel.setBounds(30, 170, 70, 15);
    frame.getContentPane().add(rgLabel);

    JLabel cellphoneLabel = new JLabel("Telefone:");
    cellphoneLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    cellphoneLabel.setBounds(30, 200, 100, 15);
    frame.getContentPane().add(cellphoneLabel);

    JLabel paymentLabel = new JLabel("Pagamento:");
    paymentLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    paymentLabel.setBounds(30, 230, 100, 15);
    frame.getContentPane().add(paymentLabel);

    JLabel addressLabel = new JLabel("Endereço:");
    addressLabel.setFont(new Font("Dialog", Font.BOLD, 14));
    addressLabel.setBounds(30, 260, 100, 15);
    frame.getContentPane().add(addressLabel);

    JTextField userCpfInput = new JTextField(cpf);
    userCpfInput.setBounds(160, 140, 100, 15);
    frame.getContentPane().add(userCpfInput);

    JTextField userRgInput = new JTextField(rg);
    userRgInput.setBounds(160, 170, 100, 15);
    frame.getContentPane().add(userRgInput);

    JTextField userCellphoneInput = new JTextField(cellphone);
    userCellphoneInput.setBounds(160, 200, 100, 15);
    frame.getContentPane().add(userCellphoneInput);

    JTextField userPaymentInput = new JTextField(payment);
    userPaymentInput.setBounds(160, 230, 100, 15);
    frame.getContentPane().add(userPaymentInput);

    JTextField userAddressInput = new JTextField(address);
    userAddressInput.setBounds(160, 260, 100, 15);
    frame.getContentPane().add(userAddressInput);

    JButton returnButton = new JButton("Voltar");
    returnButton.setBounds(300, 450, 200, 25);
    frame.getContentPane().add(returnButton);

    returnButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
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
