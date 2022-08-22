package views;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectSectionView {
	private JFrame frame;

	public SelectSectionView() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton productsButton = new JButton("Produtos");
		productsButton.setBounds(300, 200, 200, 25);
		frame.getContentPane().add(productsButton);

		JButton clientsButton = new JButton("Clientes");
		clientsButton.setBounds(300, 300, 200, 25);
		frame.getContentPane().add(clientsButton);
		frame.setLocationRelativeTo(null);

		productsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductView productView = new ProductView();
				productView.getFrame().setVisible(true);
				frame.dispose();
			}
		});

		clientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientView clientView = new ClientView();
				clientView.getFrame().setVisible(true);
				frame.dispose();
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}

}
