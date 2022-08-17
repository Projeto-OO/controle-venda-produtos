package views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.ProductController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ProductView {
  private JFrame frame;
  private JTable table;
  private JTextField nameTextField;
  private JTextField salePriceTextField;
  private JTextField factoryPriceTextField;
  private JTextField stockTextField;
  private JTextField categoryTextField;

  public ProductView() {
    ProductController productController = new ProductController();

    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);

    String[] columns = { "Nome", "Preço de Venda", "Estoque", "Lucro por Produto" };
    Object[][] data = new Object[productController.readAllProducts().size()][columns.length];

    for (int i = 0; i < productController.readAllProducts().size(); i++) {
      String[] product = { productController.readAllProducts().get(i).getName(),
          String.valueOf(productController.readAllProducts().get(i).getSalePrice()),
          String.valueOf(productController.readAllProducts().get(i).getStock()),
          String.valueOf(productController.readAllProducts().get(i).getSalePrice()
              - productController.readAllProducts().get(i).getFactoryPrice())
      };

      data[i] = product;
    }
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(225, 15, 550, 475);
    frame.getContentPane().add(scrollPane);

    table = new JTable(data, columns);
    scrollPane.setViewportView(table);

    JButton createProductButton = new JButton("Criar Produto");
    createProductButton.setBounds(10, 375, 200, 25);
    frame.getContentPane().add(createProductButton);

    nameTextField = new JTextField();
    nameTextField.setBounds(10, 125, 200, 25);
    frame.getContentPane().add(nameTextField);
    nameTextField.setColumns(10);

    salePriceTextField = new JTextField();
    salePriceTextField.setBounds(10, 175, 200, 25);
    frame.getContentPane().add(salePriceTextField);
    salePriceTextField.setColumns(10);

    factoryPriceTextField = new JTextField();
    factoryPriceTextField.setBounds(10, 225, 200, 25);
    frame.getContentPane().add(factoryPriceTextField);
    factoryPriceTextField.setColumns(10);

    stockTextField = new JTextField();
    stockTextField.setBounds(10, 275, 200, 25);
    frame.getContentPane().add(stockTextField);
    stockTextField.setColumns(10);

    categoryTextField = new JTextField();
    categoryTextField.setBounds(10, 325, 200, 25);
    frame.getContentPane().add(categoryTextField);
    categoryTextField.setColumns(10);

    JLabel nameLabel = new JLabel("Nome");
    nameLabel.setBounds(10, 110, 70, 15);
    frame.getContentPane().add(nameLabel);

    JLabel salePriceLabel = new JLabel("Preço de Venda");
    salePriceLabel.setBounds(10, 160, 200, 15);
    frame.getContentPane().add(salePriceLabel);

    JLabel factoryPriceLabel = new JLabel("Preço de Fábrica");
    factoryPriceLabel.setBounds(10, 210, 200, 15);
    frame.getContentPane().add(factoryPriceLabel);

    JLabel stockLabel = new JLabel("Estoque");
    stockLabel.setBounds(10, 260, 200, 15);
    frame.getContentPane().add(stockLabel);

    JLabel categoryLabel = new JLabel("Categoria");
    categoryLabel.setBounds(10, 310, 200, 15);
    frame.getContentPane().add(categoryLabel);

    createProductButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        productController.createProduct(nameTextField.getText(),
            Double.parseDouble(salePriceTextField.getText()),
            Double.parseDouble(factoryPriceTextField.getText()),
            Integer.parseInt(stockTextField.getText()),
            categoryTextField.getText());

        nameTextField.setText("");
        salePriceTextField.setText("");
        factoryPriceTextField.setText("");
        stockTextField.setText("");
        categoryTextField.setText("");

        String[] columns = { "Nome", "Preço de Venda", "Estoque", "Lucro por Produto" };
        Object[][] data = new Object[productController.readAllProducts().size()][columns.length];

        for (int i = 0; i < productController.readAllProducts().size(); i++) {
          String[] product = { productController.readAllProducts().get(i).getName(),
              String.valueOf(productController.readAllProducts().get(i).getSalePrice()),
              String.valueOf(productController.readAllProducts().get(i).getStock()),
              String.valueOf(productController.readAllProducts().get(i).getSalePrice()
                  - productController.readAllProducts().get(i).getFactoryPrice())
          };

          data[i] = product;
        }

        table = new JTable(data, columns);  
        scrollPane.setViewportView(table);

        frame.repaint();
      }
    });
  }

  public JFrame getFrame() {
    return frame;
  }
}
