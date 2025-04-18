# 💱 Conversor de Moedas - Java

## 📑 Índice
- [Descrição](#descrição)
- [Instalação](#instalação)
- [Configuração do .env](#configuração-do-env)
- [Uso](#uso)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Licença](#licença)
- [Autor](#Autor)

---

## 📖 Descrição
Este é um conversor de moedas simples implementado em **Java**, utilizando a **ExchangeRate-API**. Ele permite converter valores de uma moeda para outra com base nas taxas de câmbio mais recentes fornecidas por essa API.

🔗 Mais informações sobre a API: [https://www.exchangerate-api.com](https://www.exchangerate-api.com)

Este projeto foi desenvolvido como parte do programa de ensino **ONE** da **Oracle** em parceria com a **Alura**, proporcionando aprendizado prático sobre Java, tratamento de exceções, boas práticas de organização de código e consumo de APIs externas.

---

## 🛠️ Instalação

1. Certifique-se de ter o **Java** instalado no seu sistema.
    - [Download do Java](https://www.oracle.com/java/technologies/downloads/)

2. Clone este repositório:
   ```bash
   git clone https://github.com/PLeonLopes/Challenge-Conversor_moedas.git

3. As dependências já estão disponíveis na pasta lib/ (como gson.jar e dotenv-java.jar).
   Abra o projeto na sua IDE e adicione esses .jar ao classpath:
    - **IntelliJ IDEA**: File > Project Structure > Modules > Dependencies > + JARs or directories
    - Se necessário, marque como Compile ou Runtime.

---

## 📦 Configuração do .env
1. Crie um arquivo .env na raiz do projeto com o seguinte conteúdo:
   ```bash
   API_KEY=sua_chave_aqui

<small>Um arquivo de exemplo chamado .env.example já está incluído no projeto.</small>

2. Substitua _sua_chave_aqui_ pela chave da sua conta no [ExchangeRate-API](https://www.exchangerate-api.com/)

---

## ▶️ Uso

1. Abra o projeto em sua IDE Java (como IntelliJ IDEA ou Eclipse).

2. Execute o arquivo Main.java (controller/main.java).

3. Siga as instruções exibidas no console:

4. Escolha uma das opções de conversão monetária.

5. Informe o valor desejado

6. A aplicação exibirá a conversão no terminal.

---

## 🧰 Tecnologias Utilizadas
* Java 21
* Gson 2.10.1 (JSON parser)
* dotenv-java 3.0.0 (carregamento de variáveis de ambiente)

---

## 📄 Licença
Este projeto está licenciado sob a Licença MIT.

---

## ✨ Autor
Desenvolvido por [Pedro Lopes](https://github.com/PLeonLopes)
