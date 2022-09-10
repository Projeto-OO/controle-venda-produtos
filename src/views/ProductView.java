package views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.ProductController;
import models.Product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Classe responsável por exibir a tela de criação, listagem, edição e remoção
 * de produtos.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class ProductView {
  private JFrame frame;
  private JTable table;
  private JTextField nameTextField;
  private JTextField salePriceTextField;
  private JTextField factoryPriceTextField;
  private JTextField stockTextField;
  private JTextField categoryTextField;
  private Product selectedProduct;
  private JScrollPane scrollPane;
  private JButton createProductButton;
  private JButton editProductButton;
  private JButton deleteProductButton;
  private JButton returnButton;
  private ProductController productController;
  private JLabel nameLabel;
  private JLabel salePriceLabel;
  private JLabel factoryPriceLabel;
  private JLabel stockLabel;
  private JLabel categoryLabel;

  /**
   * Construtor da classe.
   */
  public ProductView() {
    productController = new ProductController();

    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);

    // Create buttons
    createProductButton = new JButton("Criar Produto");
    editProductButton = new JButton("Editar Produto");
    deleteProductButton = new JButton("Excluir Produto");
    returnButton = new JButton("Voltar para o Menu");

    // Set buttons size and position
    createProductButton.setBounds(10, 300, 200, 25);
    editProductButton.setBounds(10, 350, 200, 25);
    deleteProductButton.setBounds(10, 400, 200, 25);
    returnButton.setBounds(10, 450, 200, 25);

    // Add buttons to frame
    frame.getContentPane().add(createProductButton);
    frame.getContentPane().add(editProductButton);
    frame.getContentPane().add(deleteProductButton);
    frame.getContentPane().add(returnButton);

    // Create text fields and labels
    nameLabel = new JLabel("Nome");
    nameTextField = new JTextField();
    salePriceLabel = new JLabel("Preço de Venda");
    salePriceTextField = new JTextField();
    factoryPriceLabel = new JLabel("Preço de Fábrica");
    factoryPriceTextField = new JTextField();
    stockLabel = new JLabel("Estoque");
    stockTextField = new JTextField();
    categoryLabel = new JLabel("Categoria");
    categoryTextField = new JTextField();

    // Set text fields and labels bounds
    nameTextField.setBounds(10, 50, 200, 25);
    nameLabel.setBounds(10, 30, 70, 15);
    salePriceLabel.setBounds(10, 80, 200, 15);
    salePriceTextField.setBounds(10, 100, 200, 25);
    factoryPriceLabel.setBounds(10, 130, 200, 15);
    factoryPriceTextField.setBounds(10, 150, 200, 25);
    stockLabel.setBounds(10, 180, 200, 15);
    stockTextField.setBounds(10, 200, 200, 25);
    categoryLabel.setBounds(10, 230, 200, 15);
    categoryTextField.setBounds(10, 250, 200, 25);

    frame.getContentPane().add(nameLabel);
    frame.getContentPane().add(nameTextField);
    frame.getContentPane().add(salePriceLabel);
    frame.getContentPane().add(salePriceTextField);
    frame.getContentPane().add(factoryPriceLabel);
    frame.getContentPane().add(factoryPriceTextField);
    frame.getContentPane().add(stockLabel);
    frame.getContentPane().add(stockTextField);
    frame.getContentPane().add(categoryLabel);
    frame.getContentPane().add(categoryTextField);

    String[] columns = { "Nome", "Preço de Venda", "Estoque", "Lucro por Produto" };
    Object[][] data = new Object[productController.readAllProducts().size()][columns.length];

    // Create initial table
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

    // Listen to product selection event
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent event) {
        if (table.getSelectedRow() > -1) {
          selectedProduct = productController.readAllProducts().get(table.getSelectedRow());

          nameTextField.setText(selectedProduct.getName());
          salePriceTextField.setText(String.valueOf(selectedProduct.getSalePrice()));
          factoryPriceTextField.setText(String.valueOf(selectedProduct.getFactoryPrice()));
          stockTextField.setText(String.valueOf(selectedProduct.getStock()));
          categoryTextField.setText(selectedProduct.getCategory());
        }
      }
    });

    scrollPane = new JScrollPane();
    scrollPane.setBounds(225, 15, 550, 475);
    frame.getContentPane().add(scrollPane);

    createProductButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Product productAlreadyExists = productController.readOneProduct(nameTextField.getText());

        if (productAlreadyExists == null) {
          productController.createProduct(nameTextField.getText(),
              Double.parseDouble(salePriceTextField.getText()),
              Double.parseDouble(factoryPriceTextField.getText()),
              Integer.parseInt(stockTextField.getText()),
              categoryTextField.getText());

          clearInputs();
        } else {
          JOptionPane.showMessageDialog(null, "Esse produto já existe! Você pode excluí-lo ou editá-lo.");
        }

        String[] columns = { "Nome", "Preço de Venda", "Estoque", "Lucro por Produto" };
        Object[][] data = new Object[productController.readAllProducts().size()][columns.length];

        // Update table with new Product
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
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
          public void valueChanged(ListSelectionEvent event) {
            if (table.getSelectedRow() > -1) {
              selectedProduct = productController.readAllProducts().get(table.getSelectedRow());

              nameTextField.setText(selectedProduct.getName());
              salePriceTextField.setText(String.valueOf(selectedProduct.getSalePrice()));
              factoryPriceTextField.setText(String.valueOf(selectedProduct.getFactoryPrice()));
              stockTextField.setText(String.valueOf(selectedProduct.getStock()));
              categoryTextField.setText(selectedProduct.getCategory());
            }
          }
        });
      }
    });

    editProductButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (selectedProduct != null) {
          selectedProduct.setName(nameTextField.getText());
          selectedProduct.setSalePrice(Double.parseDouble(salePriceTextField.getText()));
          selectedProduct.setFactoryPrice(Double.parseDouble(factoryPriceTextField.getText()));
          selectedProduct.setStock(Integer.parseInt(stockTextField.getText()));
          selectedProduct.setCategory(categoryTextField.getText());
          productController.updateProduct(selectedProduct);
          JOptionPane.showMessageDialog(null, "Produto editado com sucesso!");

          String[] columns = { "Nome", "Preço de Venda", "Estoque", "Lucro por Produto" };
          Object[][] data = new Object[productController.readAllProducts().size()][columns.length];

          // Update table with new Product
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

          clearInputs();
          selectedProduct = null;
          addTableRowSelectionEventListener();
          frame.repaint();
        } else {
          JOptionPane.showMessageDialog(null, "Selecione um produto para editar!");
        }
      }
    });

    deleteProductButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (selectedProduct != null) {
          productController.deleteProduct(selectedProduct);

          String[] columns = { "Nome", "Preço de Venda", "Estoque", "Lucro por Produto" };
          Object[][] data = new Object[productController.readAllProducts().size()][columns.length];

          // Update table with deleted Product
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

          clearInputs();
          JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
          selectedProduct = null;

          addTableRowSelectionEventListener();

          frame.repaint();
        } else {
          JOptionPane.showMessageDialog(null, "Selecione um produto para deletar!");
        }
      }
    });

    returnButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        SelectSectionView selectSectionView = new SelectSectionView();
        selectSectionView.getFrame().setVisible(true);
        frame.dispose();
      }
    });

    scrollPane.setViewportView(table);
  }

  public JFrame getFrame() {
    return frame;
  }

  /**
   * Limpa todos os campos de texto.
   */
  public void clearInputs() {
    nameTextField.setText("");
    salePriceTextField.setText("");
    factoryPriceTextField.setText("");
    stockTextField.setText("");
    categoryTextField.setText("");
  }

  /**
   * Adiciona um evento de seleção de linha na tabela.
   */
  public void addTableRowSelectionEventListener() {
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent event) {
        if (table.getSelectedRow() > -1) {
          selectedProduct = productController.readAllProducts().get(table.getSelectedRow());

          nameTextField.setText(selectedProduct.getName());
          salePriceTextField.setText(String.valueOf(selectedProduct.getSalePrice()));
          factoryPriceTextField.setText(String.valueOf(selectedProduct.getFactoryPrice()));
          stockTextField.setText(String.valueOf(selectedProduct.getStock()));
          categoryTextField.setText(selectedProduct.getCategory());
        }
      }
    });
  }
}
