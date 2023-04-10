# language: pt
Funcionalidade: Crud de Vendedores
	Como usuário
	Eu quero listar, incluir, alterar e excluir vendedores
	
Cenário: Deve fornecer lista de vendedores
	Dado que tenho uma chamada valida
	Quando pesquisar 
	Então retorna uma lista de vendedores 
	
Cenário: Deve fornecer dados do vendedor solicitado por documento id
	Dado que tenho o documento id 1
	Quando pesquisar vendedor por documento
	Então retorna dados do vendedor por documento
	
Cenário: Deve fornecer dados do vendedor solicitado por matricula
	Dado que tenho a matricula "4905092523" do vendedor
	Quando pesquisar vendedor por matricula
	Então retorna dados do vendedor por matricula
	
Cenário: Deve incluir vendedor 
	Dado que tenho os dados do vendedor
	| matricula   | nome                  |dataNascimento  | filial	|
	| 4905092532  | José da Silva II      |1996-06-20      | 1      |	   
	Quando solicitar inclusão do vendedor
	Então retorna dados do vendedor incluido
	
Cenário: Deve alterar vendedor
	Dado que tenho os dados de alteração do vendedor
	| matricula   | nome                  |dataNascimento  | filial	|
	| 4905092530  | Antônio José da Silva |1988-03-19      | 4      |	   
	Quando solicitar alteração do vendedor
	Então retorna dados do vendedor alterado