package views;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controllers.AdminController;
import models.Admin;
import models.Store;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe responsável por exibir a tela de administração.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class AdminView {
  private JFrame frame;
  private JLabel nameLabel;
  private JLabel emailLabel;
  private JLabel passwordLabel;
  private JLabel storeNameLabel;
  private JTextField nameField;
  private JTextField emailField;
  private JPasswordField passwordField;
  private JTextField storeNameField;
  private JButton createAdminButton;
  private AdminController adminController;
  private JTable table;
  private JScrollPane scrollPane;
  private JButton returnButton;
  private Admin selectedAdmin;
  private JButton editAdminButton;
  private JButton deleteAdminButton;

  /**
   * Cria a tela de administrador, preenche a tabela com os administradores
   */
  public AdminView() {
    frame = new JFrame();
    frame.setBounds(100, 100, 800, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    frame.setLocationRelativeTo(null);

    this.adminController = new AdminController();

    nameLabel = new JLabel("Nome");
    emailLabel = new JLabel("Email");
    passwordLabel = new JLabel("Senha");
    storeNameLabel = new JLabel("Nome da loja");
    nameField = new JTextField();
    emailField = new JTextField();
    passwordField = new JPasswordField();
    storeNameField = new JTextField(Store.getName());
    createAdminButton = new JButton("Criar administrador");
    returnButton = new JButton("Voltar");
    editAdminButton = new JButton("Editar Administrador");
    deleteAdminButton = new JButton("Deletar Administrador");

    nameLabel.setBounds(10, 50, 200, 25);
    emailLabel.setBounds(10, 120, 200, 25);
    passwordLabel.setBounds(10, 190, 200, 25);
    storeNameLabel.setBounds(10, 450, 200, 25);
    nameField.setBounds(10, 80, 200, 25);
    emailField.setBounds(10, 150, 200, 25);
    passwordField.setBounds(10, 220, 200, 25);
    storeNameField.setBounds(10, 480, 200, 25);
    createAdminButton.setBounds(10, 270, 200, 25);
    returnButton.setBounds(375, 475, 100, 25);
    editAdminButton.setBounds(10, 310, 200, 25);
    deleteAdminButton.setBounds(10, 350, 200, 25);

    frame.getContentPane().add(nameLabel);
    frame.getContentPane().add(emailLabel);
    frame.getContentPane().add(passwordLabel);
    frame.getContentPane().add(storeNameLabel);
    frame.getContentPane().add(nameField);
    frame.getContentPane().add(emailField);
    frame.getContentPane().add(passwordField);
    frame.getContentPane().add(storeNameField);
    frame.getContentPane().add(createAdminButton);
    frame.getContentPane().add(returnButton);
    frame.getContentPane().add(editAdminButton);
    frame.getContentPane().add(deleteAdminButton);

    String[] columns = { "Nome", "Email" };
    Object[][] data = new Object[adminController.readAllAdmins().size()][columns.length];

    for (int i = 0; i < adminController.readAllAdmins().size(); i++) {
      data[i][0] = adminController.readAllAdmins().get(i).getName();
      data[i][1] = adminController.readAllAdmins().get(i).getEmail();
    }

    table = new JTable(data, columns);

    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent event) {
        if (table.getSelectedRow() > -1) {
          selectedAdmin = adminController.readAllAdmins().get(table.getSelectedRow());

          nameField.setText(selectedAdmin.getName());
          emailField.setText(selectedAdmin.getEmail());
          passwordField.setText(selectedAdmin.getPassword());
        }
      }
    });

    scrollPane = new JScrollPane();
    scrollPane.setBounds(225, 15, 550, 450);
    scrollPane.setViewportView(table);

    frame.getContentPane().add(scrollPane);

    frame.setVisible(true);

    createAdminButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());

        adminController.createAdmin(name, email, password);

        JOptionPane.showMessageDialog(null, "Administrador criado com sucesso!");

        String[] columns = { "Nome", "Email" };
        Object[][] data = new Object[adminController.readAllAdmins().size()][columns.length];

        for (int i = 0; i < adminController.readAllAdmins().size(); i++) {
          data[i][0] = adminController.readAllAdmins().get(i).getName();
          data[i][1] = adminController.readAllAdmins().get(i).getEmail();
        }

        table = new JTable(data, columns);
        scrollPane.setViewportView(table);

        addTableRowSelectionEventListener();

        clearInputs();
      }
    });

    editAdminButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        String password = String.valueOf(passwordField.getPassword());

        Admin updatedAdmin = new Admin(name, email, password);
        adminController.updateAdmin(updatedAdmin);

        JOptionPane.showMessageDialog(null, "Administrador editado com sucesso!");

        String[] columns = { "Nome", "Email" };
        Object[][] data = new Object[adminController.readAllAdmins().size()][columns.length];

        for (int i = 0; i < adminController.readAllAdmins().size(); i++) {
          data[i][0] = adminController.readAllAdmins().get(i).getName();
          data[i][1] = adminController.readAllAdmins().get(i).getEmail();
        }

        table = new JTable(data, columns);
        scrollPane.setViewportView(table);

        addTableRowSelectionEventListener();

        clearInputs();
      }
    });

    deleteAdminButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        adminController.deleteAdmin(selectedAdmin);

        JOptionPane.showMessageDialog(null, "Administrador deletado com sucesso!");

        String[] columns = { "Nome", "Email" };
        Object[][] data = new Object[adminController.readAllAdmins().size()][columns.length];

        for (int i = 0; i < adminController.readAllAdmins().size(); i++) {
          data[i][0] = adminController.readAllAdmins().get(i).getName();
          data[i][1] = adminController.readAllAdmins().get(i).getEmail();
        }

        table = new JTable(data, columns);
        scrollPane.setViewportView(table);

        addTableRowSelectionEventListener();

        clearInputs();
      }
    });

    returnButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Store.setName(storeNameField.getText());

        if (adminController.readAllAdmins().size() == 0) {
          JOptionPane.showMessageDialog(null, "É necessário criar um administrador para continuar!");
        } else {
          SelectSectionView selectSectionView = new SelectSectionView();
          selectSectionView.getFrame().setVisible(true);
          frame.dispose();
        }

      }
    });
  }

  public JFrame getFrame() {
    return frame;
  }

  /**
   * Limpa todos os inputs do formulário
   */
  private void clearInputs() {
    nameField.setText("");
    emailField.setText("");
    passwordField.setText("");
  }

  /**
   * Adiciona um evento de seleção de linha na tabela
   */
  public void addTableRowSelectionEventListener() {
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      public void valueChanged(ListSelectionEvent event) {
        if (table.getSelectedRow() > -1) {
          selectedAdmin = adminController.readAllAdmins().get(table.getSelectedRow());

          nameField.setText(selectedAdmin.getName());
          emailField.setText(selectedAdmin.getEmail());
          passwordField.setText(selectedAdmin.getPassword());
        }
      }
    });
  }
}
