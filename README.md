# Sistema de Gerenciamento de Estoque (Estoque API)

Uma API REST desenvolvida em Java e Spring Boot projetada para resolver problemas simples de controle de estoque de forma robusta, focando na integridade dos dados e na prevenção de erros operacionais.

## 🚀 Tecnologias e Ferramentas

Para construir uma base sólida e alinhada com as práticas de mercado, o projeto utiliza:

* **Java 17**
* **Spring Boot 3** (Ecossistema Web e JPA)
* **PostgreSQL** (Banco de dados relacional para persistência segura)
* **Lombok** (Produtividade e Clean Code removendo códigos repetitivos)
* **Jakarta Bean Validation** (Validação automática de regras de negócio na entrada)

## ⚙️ Funcionalidades e Diferenciais Técnicos

O sistema vai além do CRUD básico, aplicando conceitos de arquitetura limpa e robustez no tratamento de dados:

* **Validação Automática de Entradas (Bean Validation):** 
    * O sistema impede o cadastro de produtos com o nome em branco ou vazio (`@NotBlank`).
    * Proteção financeira barrando preços menores ou iguais a zero (`@Positive`).
    * Controle de estoque inteligente que aceita produtos zerados, mas bloqueia quantidades negativas (`@PositiveOrZero`).
* **Tratamento Global de Exceções (Exception Handler):** * Centralizador de erros que intercepta falhas de validação ou recursos não encontrados.
    * Respostas da API padronizadas em formato JSON (`ApiError`), devolvendo mensagens amigáveis e os status HTTP corretos (como `400 Bad Request` e `404 Not Found`).

## 🛠️ Como Executar o Projeto

### Pré-requisitos
* Java 17 instalado
* PostgreSQL rodando localmente (ou via Docker)
* Git instalado

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com/igu-7z/estoque-api
   cd estoque-api
   
2. **Configurar o Banco de Dados**
* Abra o arquivo src/main/resources/application.properties (ou .yml).
* Ajuste as credenciais do seu banco de dados PostgreSQL (username, password e a URL da base tb_produto).

3. **Executar a aplicação**
* Execute o comando abaixo no terminal da raiz do projeto:
   ```bash
   ./mvnw spring-boot:run
* Ou simplesmente abra o projeto no IntelliJ e clique no botão Play verde na classe principal.
  
4. **Testar os Endpoints**
* Use o Postman ou Insomnia para enviar requisições para http://localhost:8080/api/products.