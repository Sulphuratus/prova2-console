Prova 02 2021/02 - POO
Professor: André Chaves
Aluno: João Soares Júnior - ADS Noturno - 2º Periodo

Programa para controle de estoque de uma farmácia.

Foram criadas duas versões, uma para execução no console e outra para execução com interface gráfica.

Versão console (pasta Prova2):
Foram criadas as classes Estoque.java, Produto.java, Medicamento.java, Higiene.java e TestaEstoque.java (programa main) que chama a execução do programa. Ao ser executado o programa mostra um menu para escolha das funções, onde o usuário pode optar por:
* Cadastrar produto (Escolha entre medicamento e produto de higiene);
Na escolha de medicamento a ser cadastrado, o usuário escolhe entre medicamento genérico ou não genérico, o que irá resultar em preço atualizado conforme tipo de medicamento. 
* Mostrar detalhes do produto com vencimento mais próximo (descrição, código, preço atualizado, quantos dias para o vencimento);
* Alterar dados do produto;
* Mostrar lista de produtos no estoque (código, descrição, preço atualizado, data de vencimento) ;
* Finalizar

Versão interface gráfica (pasta Prova2InterGraf):
Foram utilizadas as classes Estoque.java, Produto.java, Medicamento.java e Higiene.java do programa console e adicionada a classe InterfaceFarma.java na pasta view contendo a implementação gráfica. Ao ser executado o programam mostra um painel com 4 abas, dando escolha ao usuário para:
* Cadastrar produto: usuário digita os os dados do produto e confirma no botão cadastrar; 
* Mostrar detalhes do produto com vencimento mais próximo (descrição, código, preço atualizado, quantos dias para o vencimento);
* Consultar: o usuário digita o código do produto e ao apertar o botão "consulta", se o produto for medicamento, o usuário deve escolher entre Medicamento genérico ou não genérico, para exibir o preço atualizado conforme tipo de medicamento.
* Vencimento: ao clicar no botão é mostrado os detalhes do produto com menor prazo de vencimento;  
* Alterar dados do produto: o usuário digita o código do produto e confirma no botão "confirmar", aparece os nome do produto a alterar. Ao digitar os dados, confirma no botão "atualizar";
