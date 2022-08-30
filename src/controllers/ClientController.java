package controllers;

import java.util.ArrayList;

import database.Store;
import models.Address;
import models.Client;
import models.Payment;

/**
 * Classe que controla as regras de negócio do cliente.
 * 
 * @author Gustavo Kenzo
 * @author Bruno Medeiros
 */
public class ClientController {
  private Store database;

  /**
   * Construtor da classe ClientController
   * 
   */
  public ClientController() {
    this.database = Store.getInstance();
  }

  /**
   * Adiciona um cliente ao banco de dados.
   * 
   * @param name      Nome do cliente
   * @param email     Email do cliente
   * @param cpf       CPF do cliente
   * @param rg        RG do cliente
   * @param cellphone Celular do cliente
   * @param address   Endereço do cliente
   * @param payment   Forma de pagamento do cliente
   */
  public void createClient(
      String name,
      String email,
      Address address,
      String cpf,
      String rg,
      String cellphone,
      Payment payment) {
    Client client = new Client(name, email, cpf, rg, cellphone, address, payment);
    this.database.getClients().add(client);
  }

  /**
   * Lista todos os clientes do banco de dados.
   * 
   * @return ArrayList de clientes
   */
  public ArrayList<Client> readAllClients() {
    return this.database.getClients();
  }

  /**
   * Lista um cliente em específico do banco de dados, a partir de seu e-mail.
   * 
   * @param email Email do cliente
   * @return Cliente
   */
  public Client readOneClient(String email) {
    Client clientFound = null;

    for (Client client : this.database.getClients()) {
      if (client.getEmail().equals(email)) {
        clientFound = client;
        break;
      }
    }

    return clientFound;
  }

  /**
   * Atualiza um cliente em específico do banco de dados.
   * 
   * @param Client cliente já atualizado
   */
  public void updateClient(Client client) {
    for (int i = 0; i < this.database.getClients().size(); i++) {
      if (this.database.getClients().get(i).getEmail().equals(client.getEmail())) {
        this.database.getClients().set(i, client);
        break;
      }
    }
  }

  /**
   * Remove um cliente em específico do banco de dados.
   * 
   * @param Client cliente a ser removido
   */
  public void deleteClient(Client client) {
    this.database.getClients().remove(client);
  }
}
