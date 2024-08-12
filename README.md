# Sistema de Locadora de Carros

## Descrição

Este é um projeto simples de locadora de carros desenvolvido em Java, utilizando princípios de programação orientada a objetos (POO). O projeto foi estruturado para representar uma locadora de carros básica, com classes que modelam carros, usuários e locações.

## Estrutura do Projeto

A estrutura do projeto é organizada da seguinte maneira:

- **`Car.java`**: Classe que representa um carro disponível para locação. Inclui atributos como marca, modelo, ano e disponibilidade.

- **`Client.java`**: Classe que representa um usuário da locadora. Inclui informações como nome e número da carteira de motorista.

- **`Rent.java`**: Classe que representa uma locação, vinculando um carro a um usuário e definindo o período da locação.

- **`SistemaDeAluguel.java`**: Classe que controla o fluxo de entrada e saída de carros.

- **`Main.java`**: Classe principal que contém o método `main` para executar o projeto e testar as funcionalidades.

## Como Executar

Para executar o projeto, siga estes passos:

1. **Compile o projeto**:
   Navegue até o diretório raiz do projeto e compile os arquivos Java com o comando:
   ```bash
   javac -d bin src/com/example/carrentalsystem/*.java
   
