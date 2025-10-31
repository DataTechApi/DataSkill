<img src = "assets/cabecalho.png">

# API 3ºBD
# DATASKILL

A equipe **DataTech** é composta por estudantes do 3º Semestre do curso de **Banco de Dados**, comprometidos com o desenvolvimento de uma plataforma semelhante a um **LinkedIn Interno**, onde é possível cadastrar talentos e competências de colaboradores.  
O objetivo é **facilitar o processo de gestão e busca de talentos** dentro da empresa **Altave**, conectando perfis e competências de forma eficiente.

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
| **Back-end** | Java 21 • Spring Boot • JPA • Maven |
| **Front-end** | Angular | Thymeleaf |
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
- Java 21+
- MySQL 8+
- Maven instalado

### 🗃️ Banco de Dados
1. Crie um banco de dados chamado `dataskilldb`.
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
| **Pull Request** | Utilizado para **unir branches** (ex: `sprint2` → `main`), garantindo **revisão de código** e **controle de versão seguro** antes do merge. |

## 🧩 Padrão de Commits

Adotamos o padrão **[Conventional Commits]** para manter um histórico **organizado**, **padronizado** e **de fácil leitura**.  
Esse padrão define prefixos que descrevem o tipo de alteração realizada no projeto.  

### Exemplos de commits válidos:
- `feat: criação da tela de login`
- `fix: correção no endpoint de autenticação`
- `docs: atualização do README`
- `refactor: melhoria na estrutura do componente`

### Estrutura do Commit

A estrutura básica de um commit segue o padrão:

<tipo> (escopo opcional): <descrição breve>

### Exemplos de estruturas:

- `feat(login): adicionar validação de credenciais`
- `fix(api): corrigir erro de resposta no endpoint de usuários`
- `docs(readme): atualizar seção de instalação`

### Tipos mais usados:
| Tipo | Descrição |
|------|------------|
| `feat` | Nova funcionalidade |
| `fix` | Correção de bug |
| `docs` | Alterações em documentação |
| `style` | Mudanças visuais ou de formatação (sem alterar comportamento) |
| `refactor` | Refatoração de código sem alterar funcionalidade |
| `test` | Adição ou ajuste de testes |




<img src = "assets/rodape.png">
