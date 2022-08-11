package views;

import javax.swing.JFrame;

// Default layout structure for the application.
public class TemplateView {
  private JFrame frame;

  public static void main(String[] args) {
    TemplateView window = new TemplateView();
    window.frame.setVisible(true);
  }

  public TemplateView() {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);
  }
}