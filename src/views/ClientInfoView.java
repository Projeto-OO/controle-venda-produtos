package views;

import javax.swing.JFrame;
import javax.swing.JLabel;

import models.Client;

public class ClientInfoView {
  private JFrame frame;
  private String name;

  public ClientInfoView(Client client) {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    this.name = client.getName();

    JLabel label = new JLabel(this.name);
    label.setBounds(250, 25, 300, 30);
    frame.getContentPane().add(label);
    frame.setLocationRelativeTo(null);
  }

  public JFrame getFrame() {
    return frame;
  }
}
