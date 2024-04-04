# Projeto de Gerenciamento de Tickets

Este é um projeto de sistema de gerenciamento de tickets semelhante ao Zendesk ou Movidesk, desenvolvido utilizando o framework Spring Boot, com persistência de dados em um banco de dados H2 e JPA (Java Persistence API).

## Descrição

O sistema permite o registro, acompanhamento e resolução de tickets de suporte ou solicitações de serviço enviadas por clientes. Os usuários podem criar tickets, atribuir prioridades, associar a categorias específicas e monitorar o progresso das resoluções. Os agentes de suporte podem visualizar os tickets atribuídos a eles, atualizar o status e fornecer respostas aos clientes.

## Funcionalidades Principais

- Cadastro de tickets por clientes.
- Atribuição de prioridades e categorias aos tickets.
- Atribuição de tickets a agentes de suporte.
- Acompanhamento do status dos tickets.
- Comunicação entre agentes e clientes por meio de comentários nos tickets.

## Tecnologias Utilizadas

- **Spring Boot**: Framework Java para desenvolvimento de aplicativos web.
- **H2 Database**: Banco de dados em memória para desenvolvimento e teste.
- **JPA (Java Persistence API)**: Especificação Java para mapeamento objeto-relacional.
- **Maven**: Gerenciador de dependências e construção de projetos.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **`src/main/java`**: Contém o código-fonte Java.
  - **`br.com.infnet.minddesk.controllers`**: Controladores REST para manipulação de tickets.
  - **`br.com.infnet.minddesk.model`**: Classes de modelo que representam os tickets, clientes, agentes, etc.
  - **`br.com.infnet.minddesk.repositories`**: Interfaces de repositório para acesso aos dados.
  - **`br.com.infnet.minddesk.services`**: Serviços para lógica de negócios.
- **`src/main/resources`**: Contém os arquivos de configuração.
  - **`application.properties`**: Configurações do Spring Boot e do banco de dados H2.
- **`src/test/java`**: Contém os testes unitários e de integração.

## Como Executar

1. Certifique-se de ter o Java e o Maven instalados em seu ambiente de desenvolvimento.
2. Clone o repositório do projeto para o seu computador.
3. Navegue até o diretório raiz do projeto.
4. Execute o comando `mvn spring-boot:run` para iniciar o aplicativo.
5. O aplicativo estará acessível em `http://localhost:8080`.

## Documentação

- Abra o navegador: http://localhost:8080/swagger-ui/index.html

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
