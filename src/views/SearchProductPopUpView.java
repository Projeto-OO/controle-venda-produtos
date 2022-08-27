package views;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controllers.ProductController;
import models.Client;
import models.Product;
import models.ProductAmount;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchProductPopUpView {
  private JFrame frame;
  private JTextField productTextField;
  private JTextField amountTextField;
  private ProductController productController;

  public SearchProductPopUpView(Client client) {
    this.productController = new ProductController();

    frame = new JFrame();
    frame.setBounds(200, 200, 400, 250);
    frame.getContentPane().setLayout(null);

    productTextField = new JTextField();
    productTextField.setBounds(120, 50, 150, 20);
    frame.getContentPane().add(productTextField);
    productTextField.setColumns(10);

    JLabel productLabel = new JLabel("Produto");
    productLabel.setBounds(120, 30, 70, 15);
    frame.getContentPane().add(productLabel);

    amountTextField = new JTextField();
    amountTextField.setColumns(10);
    amountTextField.setBounds(120, 120, 150, 20);
    frame.getContentPane().add(amountTextField);

    JLabel amountLabel = new JLabel("Quantidade");
    amountLabel.setBounds(120, 100, 150, 15);
    frame.getContentPane().add(amountLabel);

    JButton addButton = new JButton("Adicionar");
    addButton.setBounds(120, 170, 150, 25);
    frame.getContentPane().add(addButton);
    frame.setLocationRelativeTo(null);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (productController.readOneProduct(productTextField.getText()) != null) {
          client.getCurrentOrder().getProducts().add(new ProductAmount(
              productController.readOneProduct(productTextField.getText()),
              Integer.parseInt(amountTextField.getText())));
        } else {
          JOptionPane.showMessageDialog(null, "Produto não encontrado!");
        }
      }
    });
  }

  public JFrame getFrame() {
    return frame;
  }

  public Product getProduct() {
    return productController.readOneProduct(productTextField.getText());
  }

  public int getQuantity() {
    return Integer.parseInt(amountTextField.getText());
  }

  public void clearInputs() {
    productTextField.setText("");
    amountTextField.setText("");
  }
}
