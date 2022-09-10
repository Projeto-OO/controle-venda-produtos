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

/**
 * Classe responsável por exibir a tela de busca de produtos.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class SearchProductPopUpView {
  private JFrame frame;
  private JTextField productTextField;
  private JTextField amountTextField;
  private ProductController productController;
  private JLabel productLabel;
  private JLabel amountLabel;
  private JButton addButton;

  public SearchProductPopUpView(Client client) {
    this.productController = new ProductController();

    frame = new JFrame();
    frame.setBounds(200, 200, 400, 250);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);

    productTextField = new JTextField();
    productLabel = new JLabel("Produto");
    amountTextField = new JTextField();
    amountLabel = new JLabel("Quantidade");
    addButton = new JButton("Adicionar");

    productTextField.setBounds(120, 50, 150, 20);
    productLabel.setBounds(120, 30, 70, 15);
    amountTextField.setBounds(120, 120, 150, 20);
    amountLabel.setBounds(120, 100, 150, 15);
    addButton.setBounds(120, 170, 150, 25);

    frame.getContentPane().add(productTextField);
    frame.getContentPane().add(productLabel);
    frame.getContentPane().add(amountTextField);
    frame.getContentPane().add(amountLabel);
    frame.getContentPane().add(addButton);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Product searchedProduct = productController.readOneProduct(productTextField.getText());
        if (searchedProduct != null) {

          int amount = Integer.parseInt(amountTextField.getText());
          ProductAmount productAmount = new ProductAmount(searchedProduct, amount);

          if (searchedProduct.getStock() >= amount) {
            client.getCurrentOrder().getProducts().add(productAmount);
            searchedProduct.setStock(searchedProduct.getStock() - amount);

            JOptionPane.showMessageDialog(null, "Produto adicionado ao carrinho");
          } else {
            JOptionPane.showMessageDialog(null, "Quantidade indisponível em estoque");
          }
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

  /**
   * Limpa os campos de texto da tela.
   */
  public void clearInputs() {
    productTextField.setText("");
    amountTextField.setText("");
  }
}
