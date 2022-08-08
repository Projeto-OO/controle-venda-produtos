package views;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class MainView {

	private JFrame frame;

	public static void main(String[] args) {
		MainView window = new MainView();
		window.frame.setVisible(true);
	}

	public MainView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JButton createUserButton = new JButton("Criar Usuário");
		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		createUserButton.setBounds(300, 370, 200, 25);
		frame.getContentPane().add(createUserButton);

		JButton createProductButton = new JButton("Criar Produto");
		createProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		createProductButton.setBounds(300, 407, 200, 25);
		frame.getContentPane().add(createProductButton);

		JLabel storeNameLabel = new JLabel("Lojão do Brunão");
		storeNameLabel.setFont(new Font("Meera", Font.BOLD, 25));
		storeNameLabel.setBounds(317, 102, 163, 59);
		frame.getContentPane().add(storeNameLabel);

		createUserButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();

				RegisterPersonView window = new RegisterPersonView();
				window.getFrame().setVisible(true);
			}
		});
	}
}
