# Projeto de Cadastro de Canetas


Este projeto tem como objetivo criar um programa capaz de cadastrar, excluir e listar objetos do tipo `Caneta`. As tecnologias utilizadas são JSF, Primefaces e Hibernate.
## ALUNOS:
Davi Felipe Cavalcante Mendes 1-2019215976
Mateus Gomes Moreira  1-2018110612

## Sumário

- [Cadastro de Caneta](#cadastro-de-caneta)
- [Listagem de Canetas](#listagem-de-canetas)
- [Funcionalidades](#funcionalidades)

## Cadastro de Caneta

- Acesse a página de cadastro em [http://localhost:8080/AV3-DSW2024.1/index.xhtml](http://localhost:8080/AV3-DSW2024.1/index.xhtml).
- Preencha os campos de Marca, Modelo e Cor e clique em Salvar.

## Listagem de Canetas

- Acesse a página de listagem em [http://localhost:8080/AV3-DSW2024.1/listagem.xhtml](http://localhost:8080/AV3-DSW2024.1/listagem.xhtml).
- Visualize a lista de canetas cadastradas, exclua ou selecione uma caneta para ver detalhes.

## Funcionalidades

- Criar a classe Caneta com as variáveis id, marca, modelo e cor e seus respectivos getters e setters.
- Anotar a classe Caneta com `@Entity`, `@Id`, `@Column` e `@GeneratedValue`.
- Criar a classe CanetaDAO com métodos para salvar, excluir e listar objetos Caneta.
- Configurar persistence.xml e criar a classe JPAUtil para gerenciar EntityManager.
- Página de cadastro (index.xhtml) para salvar objetos Caneta.
- Página de listagem (listagem.xhtml) para exibir canetas salvas.
- Funcionalidade para excluir canetas da tabela e do banco de dados.
- Funcionalidade para selecionar e exibir detalhes de uma caneta.
- Funcionalidade para exibir a quantidade de canetas por cor usando `<p:messages>`.
- Implementação da classe CanetaBean para comunicação entre as páginas e funcionalidades.
