package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controllers.ClientController;
import database.Store;
import models.Payment;
import models.Address;
import models.Client;

class ClientControllerTests {
	Store database;
	ClientController clientController;

	@BeforeEach
	void setUp() {
		this.database = Store.getInstance();
		this.clientController = new ClientController();
		this.database.clearDatabase();
	}

	// Deve ser possível criar um cliente
	@Test
	void createClientTest() {
		Payment testClientPayment = new Payment("débito", "1234567", 123, "12/2025");
		Address testClientAddress = new Address("DF", "gama", "123456", 1, "Faculdade do Gama");

		clientController.createClient("Cliente de Teste", "john.doe@example.com", testClientAddress, "123.456.789-10",
				"1234",
				"6199999999", testClientPayment);

		assertEquals("Cliente de Teste", database.getClients().get(0).getName());
	}

	// Deve ser possível ler todos os clientes
	@Test
	void readAllClientsTest() {
		Payment testClientPayment = new Payment("débito", "1234567", 123, "12/2025");
		Address testClientAddress = new Address("DF", "gama", "123456", 1, "Faculdade do Gama");

		clientController.createClient("Cliente de Teste", "john.doe@example.com", testClientAddress, "123.456.789-10",
				"1234",
				"6199999999", testClientPayment);

		assertEquals(1, database.getClients().size());
	}

	// Deve ser possível ler um cliente
	@Test
	void readOneClientTest() {
		Payment testClientPayment = new Payment("débito", "1234567", 123, "12/2025");
		Address testClientAddress = new Address("DF", "gama", "123456", 1, "Faculdade do Gama");

		clientController.createClient("Cliente de Teste", "john.doe@example.com", testClientAddress, "123.456.789-10",
				"1234",
				"6199999999", testClientPayment);

		assertEquals("Cliente de Teste", clientController.readOneClient("john.doe@example.com").getName());
	}

	// Deve ser possível atualizar um cliente
	@Test
	void updateClientTest() {
		Payment testClientPayment = new Payment("débito", "1234567", 123, "12/2025");
		Address testClientAddress = new Address("DF", "gama", "123456", 1, "Faculdade do Gama");

		clientController.createClient("Cliente de Teste", "john.doe@example.com", testClientAddress, "123.456.789-10",
				"1234",
				"6199999999", testClientPayment);

		clientController.updateClient(
				new Client("Cliente de Teste Editado", "john.doe@example.com", "123.456.789-10", "1234", "6199999999",
						testClientAddress, testClientPayment));

		assertEquals("Cliente de Teste Editado", clientController.readOneClient("john.doe@example.com").getName());
	}

	// Deve ser possível deletar um cliente
	@Test
	void deleteClientTest() {
		Payment testClientPayment = new Payment("débito", "1234567", 123, "12/2025");
		Address testClientAddress = new Address("DF", "gama", "123456", 1, "Faculdade do Gama");

		clientController.createClient("Cliente de Teste", "john.doe@example.com", testClientAddress, "123.456.789-10",
				"1234",
				"6199999999", testClientPayment);

		clientController.deleteClient(clientController.readOneClient("john.doe@example.com"));

		assertEquals(0, database.getClients().size());
	}
}
