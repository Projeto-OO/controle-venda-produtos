package views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controllers.ProductController;

public class ProductView {
  private JFrame frame;
  private JTable table;

  public ProductView() {
    ProductController productController = new ProductController();

    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);

    String[] columns = { "Nome", "Preço", "Estoque" };
    Object[][] data = new Object[productController.readAllProducts().size()][columns.length];

    for (int i = 0; i < productController.readAllProducts().size(); i++) {
      String[] product = { productController.readAllProducts().get(i).getName(),
          String.valueOf(productController.readAllProducts().get(i).getSalePrice()),
          String.valueOf(productController.readAllProducts().get(i).getStock()) };

      data[i] = product;
    }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(400, 15, 375, 475);
        frame.getContentPane().add(scrollPane);
    
        table = new JTable(data, columns);
        scrollPane.setViewportView(table);
  }

  public JFrame getFrame() {
    return frame;
  }
}
