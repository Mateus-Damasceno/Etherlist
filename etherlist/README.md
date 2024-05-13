# EtherList Application

## Descrição

A aplicação EtherList é um sistema de gerenciamento de listas que permite aos usuários criar, atualizar e visualizar listas de itens categorizados. Cada item na lista possui um nome, valor e categoria associada. A aplicação também fornece funcionalidades para gerar datas de criação e "explosão" (data limite) para cada lista.

## Tecnologias Utilizadas

- Kotlin: Linguagem de programação.
- Spring Boot: Framework para facilitar a configuração e publicação de aplicações baseadas em Spring.
- MongoDB: Banco de dados NoSQL utilizado para armazenar as listas e itens.
- Feign Client: Utilizado para comunicação entre serviços.
- Jackson: Biblioteca para serialização e deserialização de objetos Java para JSON e vice-versa.

## Configuração

### Pré-requisitos

- JDK 11 ou superior
- MongoDB
- Maven

### Configuração do Banco de Dados

Certifique-se de que o MongoDB está instalado e rodando na sua máquina. A aplicação está configurada para se conectar a um banco de dados MongoDB local padrão sem autenticação.

### Variáveis de Ambiente

Configure as seguintes variáveis de ambiente, se necessário:

- `MONGODB_URI`: URI de conexão para o MongoDB. Padrão: `mongodb://localhost:27017/etherlist`

## Executando a Aplicação

Para executar a aplicação, inicie o mongoDB e o mockServer pelo docker e inicie a aplicação.
Necessita do Insomnia para passar as listas
# Exemplo de Request:
```
{
  "id" : "{% uuid 'v4' %}",
  "itens" :[
    {
      "nome" : "Dub inc",
      "valor" : 25.0
    },
    {
      "nome" : "Jason Mraz",
      "valor" : 25.0
			
    },
		 {
      "nome" : "Pedra Leticia",
      "valor" : 20.0
    },
		{
      "nome" : "RAPadura",
      "valor" : 2.5
    },
		{
      "nome" : "Eddie Murphy - Red Light ft. Snoop Dog ",
      "valor" : 2.5
    }
  ]
}
```
# Exemplo de Response
```
{
	"id": "e6f0e191-56c5-402e-8bc3-a37e90af17c9",
	"etherListRequestDTO": [
		{
			"id": "e6f0e191-56c5-402e-8bc3-a37e90af17c9",
			"itensDTO": [
				{
					"nome": "Dub inc",
					"valor": 25.0,
					"categoria": "Amarelo"
				},
				{
					"nome": "Jason Mraz",
					"valor": 25.0,
					"categoria": "Amarelo"
				},
				{
					"nome": "Pedra Leticia",
					"valor": 20.0,
					"categoria": "Verde"
				},
				{
					"nome": "RAPadura",
					"valor": 2.5,
					"categoria": "Azul"
				},
				{
					"nome": "Eddie Murphy - Red Light ft. Snoop Dog ",
					"valor": 2.5,
					"categoria": "Vermelho"
				}
			]
		}
	],
	"dataCriacao": "2024-04-10 20:08:15",
	"dataExplosao": "2024-04-11 20:08:15"
}
```


# Funcionalidades Principais
- Criação de Listas: Os usuários podem criar listas de itens com nome, valor e categoria.
- Atualização de Listas: Os usuários podem atualizar os itens de uma lista existente.
- Visualização de Listas: Os usuários podem visualizar todas as listas criadas, incluindo os itens e categorias associadas.
- Geração de Datas: A aplicação gera automaticamente a data de criação e explosão


