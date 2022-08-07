package views;

import javax.swing.JFrame;

public class RegisterPersonView {
  private JFrame frame;

  public static void main(String[] args) {
    RegisterPersonView window = new RegisterPersonView();
    window.frame.setVisible(true);
  }

  public RegisterPersonView() {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);
  }

  public JFrame getFrame() {
    return frame;
  }
}
