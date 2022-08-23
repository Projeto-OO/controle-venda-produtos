package views;

import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Client;
import java.awt.Font;

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

    JLabel userCpfLabel = new JLabel(cpf);
    userCpfLabel.setBounds(160, 140, 100, 15);
    frame.getContentPane().add(userCpfLabel);

    JLabel userRgLabel = new JLabel(rg);
    userRgLabel.setBounds(160, 170, 100, 15);
    frame.getContentPane().add(userRgLabel);

    JLabel userCellphoneLabel = new JLabel(cellphone);
    userCellphoneLabel.setBounds(160, 200, 100, 15);
    frame.getContentPane().add(userCellphoneLabel);

    JLabel userPaymentLabel = new JLabel(payment);
    userPaymentLabel.setBounds(160, 230, 100, 15);
    frame.getContentPane().add(userPaymentLabel);

    JLabel userAddressLabel = new JLabel(address);
    userAddressLabel.setBounds(160, 260, 100, 15);
    frame.getContentPane().add(userAddressLabel);
  }

  public JFrame getFrame() {
    return frame;
  }
}
