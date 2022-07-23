# Controle de Venda de Produtos

Repositório para o projeto da disciplina de Orientação a Objetos da Universidade de Brasília. O objetivo é desenvolver uma aplicação desktop standalone com GUI em Java, utilizando os paradigmas da Programação Orientada a Objetos, e seguindo um diagrama UML.

[!UML](UML.png)

# Alunos

| Aluno                                                           | Matrícula |
| --------------------------------------------------------------- | --------- |
| [Gustavo Kenzo Araki Takechi](https://github.com/gustavokenzo1) | 211029343 |
| [Bruno Medeiros de Oliveira](https://github.com/brunomed)       | 211031646 |

# Cenário

- Uma loja de produtos deseja administar melhor as suas vendas.

- Ela possui produtos com os seguintes atributos: nome, preço, quantidade em estoque e descrição.

- A cada venda de produtos, ela deseja registrar o fluxo de caixa, que consiste em um registro de data, quantidade de produtos vendidos e o valor total da venda.

- Cada produto deve ter a habilidade de ser criado, lido, atualizado e excluído.

- A loja deseja também cadastrar, ler, atualizar e excluir clientes, para ter um registro de todos os clientes que compram produtos da loja, como nome, endereço, telefone, CPF e email.

- Cada compra deve ter a habilidade de ser criada, lida, atualizada e excluída. Também deve ter uma lista com todos os produtos, quem está fazendo a compra e o valor total da compra.

- Todo esse sistema deve ser controlado por um usuário administrador, que só pode ser acessado com uma senha.

# UML

O Unified Modeling Language (UML) é uma linguagem de modelagem que foi usada para modelar a lógica do projeto.

Link: (Somente após a finalização, para evitar edições)

# Backlog da Aplicação

| US   | Descrição                                                                                                                    |
| ---- | ---------------------------------------------------------------------------------------------------------------------------- |
| US01 | Eu, como usuário, gostaria de cadastrar um produto no sistema, para que minha loja tenha sempre produtos novos.              |
| US02 | Eu, como usuário, gostaria de ler um produto, para que eu tenha sempre acesso às informações do mesmo.                       |
| US03 | Eu, como usuário, gostaria de atualizar um produto, para que seu preço e estoque estejam sempre coerentes para os clientes.  |
| US04 | Eu, como usuário, gostaria de deletar um produto, caso eu não deseje mais vendê-lo.                                          |
| US05 | Eu, como usuário, gostaria de cadastrar um cliente, para que eu tenha registro de quem comprou na loja.                      |
| US06 | Eu, como usuário, gostaria de ler um cliente, para que eu tenha sempre acesso às informações do mesmo.                       |
| US07 | Eu, como usuário, gostaria de atualizar um cliente, para que seu endereço e telefone estejam sempre atualizados para nós.    |
| US08 | Eu, como usuário, gostaria de deletar um cliente, para caso algum cliente deseje excluir os seus dados.                      |
| US09 | Eu, como usuário, gostaria de cadastrar uma compra, para que eu tenha informações sobre as vendas da loja.                   |
| US10 | Eu, como usuário, gostaria de ler uma compra, para que eu tenha sempre acesso às informações da mesma.                       |
| US11 | Eu, como usuário, gostaria de atualizar uma compra, para que sua lista de produtos e valor total estejam sempre atualizados. |
| US12 | Eu, como usuário, gostaria de deletar uma compra, para caso algum cliente desista de realizá-la.                             |
| US13 | Eu, como usuário, gostaria de ser um usuário administrador, para que eu tenha acesso ao sistema.                             |

# Conceitos da Orientação a Objetos

- Classe: Template para criar objetos.

- Objeto: Instância de uma classe.

- Construtor: Método que é executado quando um objeto é criado.

- Encapsulamento: Deixar acessível apenas o que for estritamente necessário para manipular o objeto.

- Herança: Comportamento ou característica de um objeto que é herdado de outro objeto.

- Polimorfismo: Capacidade de um objeto se comportar de forma diferente de acordo com o contexto.

- Coesão: Não misturar responsabilidades.

- Acoplamento: Quantidade de relacionamentos entre objetos. Deve-se procurar um balanço entre o acoplamento e a coesão.

- Atributos: Características de um objeto.

- Métodos: Ações de um objeto.

- Ocultamento de informações: Mostrar o mínimo necessário para a operação de um componente.

- UML: Unified Modeling Language.

- Getters e Setters: Métodos que retornam ou alteram o valor de um atributo. Promovem o encapsulamento e ocultamento de informações.

- Sobrecarga: Dois métodos de uma mesma classe com mesmo nome, porém com assinaturas diferentes.

- Sobrescrita: Redefinir um código já definido. Polimorfismo.

- Dependência: Relação indireta entre objetos. Um objeto depende de outro para ser executado. É necessário minimizar as dependências, para evitar acoplamento.

- Associação: Relacionamento não forte, mas explícito entre objetos. Definida por eliminação.

- Multiplicidade: Recurso UML para representar quantos objetos podem preencher uma propriedade. (Many to Many, One to Many e assim sucessivamente, ver slide 14 da aula 8).

- Agregação: Caso particular de associação. Uma das classes do relacionamento está contida em outra classe. Objetos podem existir independentes uns dos outros.

- Composição: Caso particular de associação. Uma das classes do relacionamento está contida em outra classe. Objetos são dependentes uns dos outros.

- Classes Abstratas: TODO
