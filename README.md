<img src = "assets/cabecalho.png">

# API 3ºBD
# DATASKILL

A equipe **DataTech** é composta por estudantes do 3º Semestre do curso de **Banco de Dados**, comprometidos com o desenvolvimento de uma plataforma semelhante a um **LinkedIn Interno**, onde é possível cadastrar talentos e competências de colaboradores.  
O objetivo é **facilitar o processo de gestão e busca de talentos** dentro da empresa **Altave**, conectando perfis e competências de forma eficiente.

--- 

## Integrantes do Projeto 
| <center>Linkedin</center> | Integrante | Função | Identificação |
|-------------------------- |------------|--------|---------------|
|<a href="https://www.linkedin.com/in/thor-lyndgaard-b2155826b/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin" ></a> | Thor Lyndgaard | DEV | <a href=""><center><img src="assets/team-profile/thor.jpg" height="55" width="55"></a></center> |
|<a href="https://www.linkedin.com/in/lucas-silva-sousa-79058421a/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin" ></a> | Lucas Sousa | DEV | <a href=""><center><img src="assets/team-profile/lucas.jpg" height="55" width="55"></a></center> |
|<a href="https://www.linkedin.com/in/cau%C3%AA-gandini-7928771a2/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin" ></a> | Cauê Gandini | P.O | <a href=""><center><img src="assets/team-profile/caue.jpg" height="55" width="55"></a></center> |
|<a href="https://www.linkedin.com/in/johnatan-souza/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin" ></a> | Johnatan Souza | DEV | <a href=""><center><img src="assets/team-profile/john.jpg" height="55" width="55"></a></center> |
|<a href="https://www.linkedin.com/in/jacksonmoraes/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin" ></a> | Jackson Tadeu | SCM | <a href=""><center><img src="assets/team-profile/jackson.jpg" height="55" width="55"></a></center> |
|<a href="https://www.linkedin.com/in/davi-gramacho-702a48326/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin" ></a> | Davi Gramacho | DEV | <a href=""><center><img src="assets/team-profile/davi.jpg" height="55" width="55"></a></center> |
|<a href="https://www.linkedin.com/in/abimael-souza-dos-santos-8776751a8/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin" ></a> | Abimael dos Santos | DEV | <a href=""><center><img src="assets/team-profile/abimael.jpg" height="55" width="55"></a></center> |

---

## 📍 Índice do projeto 
<center>

| [Requisitos](#requisitos) | [Tecnologias Utilizadas](#tecnologias-utilizadas) | [Estrutura do Projeto](#estrutura-do-projeto) | [Backlog](#backlog-do-produto) | [Cronograma](#cronograma-de-sprints) | [Como Executar o Projeto](#como-executar-o-projeto) | [Equipe](#integrantes-do-projeto) |

</center>

---

## 📋 Requisitos

### Requisitos Funcionais
- Implementar Aplicação usando Linguagem de Programação Java Web para BackEnd;
- Implementar Aplicação usando conceitos de Orientação a Objetos;
- Utilizar IDE’s na implementação de aplicação em Java;
- Aplicar técnicas de depuração e análise de logs;
- Implementar web services REST;
- Implementar clientes para consumir web services;
- Implementar projeto de Banco de Dados Relacional em termos de seus principais objetos (Schema, Tabelas, Views, Índices);
- Implementar consultas SQL com junções, subconsultas e agrupamentos;
- Implementar manutenção de dados utilizando DML.

### Requisitos Não Funcionais
- Manual de Instalação;
- Manual do Usuário;
- Front minimalista e responsivo;
- Modelo de banco de dados relacional normalizado até a 3FN;
- Documentação da API com Swagger;
- Hierarquia mínima de perfis: **Diretor > Supervisor > Colaborador**;
- Banco de dados com **mínimo de 100 registros**, sendo 7 diretores e 2 supervisores por diretor.

---

## 🧠 Tecnologias Utilizadas

| Categoria | Tecnologias |
|------------|-------------|
| **Back-end** | Java 17 • Spring Boot • JPA • Maven |
| **Front-end** | Angular |
| **Banco de Dados** | MySQL |
| **Documentação de API** | Swagger (OpenAPI) |
| **Controle de Versão** | Git • GitHub |
| **IDE’s** | IntelliJ IDEA • VS Code |
| **Outros** | Postman (testes de endpoints) |

---

## 📁 Estrutura do Projeto

O projeto **DataSkill** segue uma arquitetura **Java Spring Boot + Angular**, organizada de forma modular para facilitar manutenção, escalabilidade e trabalho em equipe.

Abaixo está a estrutura real do projeto:

| **Pasta / Arquivo** | **Descrição** |
|----------------------|---------------|
| `controller/` | Contém os endpoints da API REST. |
| `service/` | Implementa a lógica de negócio do sistema. |
| `repository/` | Camada de persistência, com interfaces JPA para o MySQL. |
| `entity/` | Define as entidades do banco de dados. |
| `config/` | Contém configurações globais (Swagger, etc). |
| `resources/` | Inclui arquivos de configuração, como `application.properties`. |
| `frontend/` | Projeto Angular responsável pela interface do usuário. |
| `dataskilldbmodelo.mwb` | Modelo conceitual/lógico do banco de dados. |
| `pom.xml` | Arquivo Maven responsável por dependências e build. |

---

## 🧭 Cronograma de Sprints

| Sprint | Período | Principais Entregas | Status |
|---------|----------|---------------------|---------|
| **Sprint 1** | 08/09 a 28/09 | Estrutura inicial do projeto, setup de ambiente, CRUD de colaboradores, início do front-end | ✅ Concluída |
| **Sprint 2** | 06/10 a 26/10 | Dashboard de competências, filtros e autoavaliação | 🔄 Em andamento |
| **Sprint 3** | 03/11 a 23/11 | Ajustes finais, documentação completa e deploy | ⏳ Pendente |

---

## ⚙️ Como Executar o Projeto

### 🔧 Pré-requisitos
- Java 17+
- Node.js 18+
- MySQL 8+
- Maven instalado
- Angular CLI

### 🗃️ Banco de Dados
1. Crie um banco de dados chamado `dataskill_db`.
2. Configure o arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/dataskill_db
   spring.datasource.username=root
   spring.datasource.password=senha


📊 Backlog do Produto

| #  | Prioridade | User Story                                                                                                   | Sprint | Status       |
|----|------------|--------------------------------------------------------------------------------------------------------------|--------|--------------|
| 1  | Alta       | Como gestor, quero visualizar o perfil dos colaboradores, para buscar novos talentos para meu setor.    | 1     | Em andamento   |
| 2  | Alta       | Como gestor, quero visualizar um Dashboard, para que eu possa ver a relação de competência de uma área, ou de diversos colaboradores.| 2      | Pendente  |
| 3  | Média      | Como usuário, quero realizar uma auto avaliação, para saber se a visão do meu gestor está contingente.  | 2      | Pendente     |
| 4  | Alta       | Como gestor, quero filtrar as competências do colaborador para saber se encaixa em outra atividade.     | 2     | Pendente    |
| 5  | Alta       | Como gestor, quero alocar algum colaboradores que se encaixam nas skills desejadas, para mapear melhor os talentos do meu departamento. | 2      | Pendente |
| 6  | Alta       | Como usuário, quero cadastrar minhas competências para ficar à mostra a todos os supervisores/diretores que tiverem interesse. | 1      | Em andamento |
| 7  | Média       | Como usuário, eu quero visualizar os perfis dos colegas em uma interface intuitiva, com cards organizados por competências, setor e nível de proficiência, para que eu possa navegar e identificar talentos internos. | 1      | Em andamento |
| 8  | Média       | Como usuário, quero que o produto seja entregue com todas a documentações e manuais de usuário, para que haja uma melhor organização e orientação quando formos usar o sistema | 3  | Pendente|


🧩 Definition of Ready (DoR) e ✅ Definition of Done (DoD)
📌 Definition of Ready (DoR)

## 📌 **Definition of Ready (DoR)**
Uma *User Story* está **pronta para desenvolvimento** quando:

- ✅ O objetivo está claramente descrito e compreendido por todos.  
- ✅ Os critérios de aceitação estão definidos e validados pelo Product Owner.  
- ✅ As dependências estão identificadas e resolvidas (APIs, banco, telas anteriores).   
- ✅ As tarefas técnicas estão quebradas e estimadas.  
- ✅ Há dados de teste ou ambiente pronto para validação.

---

## 🚀 **Definition of Done (DoD)**
Uma *User Story* é considerada **concluída** quando:

- 🧠 Todo o código foi desenvolvido conforme os critérios de aceitação.  
- 🔍 Foram realizados **testes** com sucesso.  
- 📘 A documentação técnica e/ou manual de usuário foi atualizada.  
- 🔒 Os dados estão tratados e armazenados de forma segura.  
- 💬 O Product Owner revisou e aprovou a entrega.  
- 🚀 A funcionalidade está pronta para ser liberada em produção.

📋 Aplicação do DoR e DoD nas User Stories

| # | User Story (Resumo) | 🧩 DoR Específico | ✅ DoD Específico |
|:-:|----------------------|------------------|------------------|
| **1** | Visualizar perfil dos colaboradores | Mockups prontos e estrutura do banco definida | Perfis listados e filtráveis por setor; PO validou usabilidade |
| **2** | Dashboard de competências | Métricas e dados a exibir definidos | Dashboard funcional mostrando relação de competências por área |
| **3** | Autoavaliação do usuário | Campos da autoavaliação definidos | Usuário consegue avaliar e salvar competências; dados persistem corretamente |
| **4** | Filtrar competências | Critérios de filtro definidos (por cargo, área, skill) | Filtros funcionam e retornam resultados esperados |
| **5** | Alocar colaborador em skill desejada | Lógica de alocação e permissões definidas | Colaborador alocado corretamente; gestor visualiza atualização |
| **6** | Cadastrar competências | Campos de cadastro definidos e validados | Competências salvas e visíveis aos gestores |
| **7** | Visualizar colegas com cards | Estrutura dos cards e layout definidos | Cards exibem colegas, competências e setores corretamente |
| **8** | Entrega com documentação | Itens de documentação definidos e revisados | Sistema entregue com manual e instruções completas |


## 🌿 Estratégia de Branch

| **Branch** | **Função** |
|-------------|------------|
| `main` | Contém o código **estável** e **pronto para produção**. Nenhum commit direto é feito nela — apenas merges revisados. |
| `sprint1`, `sprint2`, `sprint3` | Cada branch representa uma **entrega de sprint**, com features específicas desenvolvidas nesse ciclo. |

<img src = "assets/rodape.png">
