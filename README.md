# Avaliacao-Backend-Attornatus
Teste Avaliativo da Empresa Attornatus para Vaga de Desenvolvedor Back-End Java

## DESAFIO PROPOSTO
Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  
>1.	Criar uma pessoa X 
>
>1.	Editar uma pessoa X
>
>1.	Consultar uma pessoa X 
>
>1.	Listar pessoas X
>
>1.	Criar endereço para pessoa X 
>
>1.	Listar endereços da pessoa X
>
>1.	Poder informar qual endereço é o principal da pessoa X   

---
Uma Pessoa deve ter os seguintes campos:  
>1. Nome
>
>1. Data de nascimento
>
>1.	Endereço:
>       1.	Logradouro
>       1.	CEP
>       1.	Número
>       1.	Cidade
---

## API REST DESENVOLVIDO COM SPRING BOOT

### 1. ADIÇÃO DE DADOS

Adição feito por um corpo JSON, pode ser feita diretamente pela URL caso for utilizar em uma página sem a necessidade de JS. 

<img src="./img/add.png">

### 2. LISTAR TODOS OS DADOS

Listar todos os dados dos usuários apenas com o /all

<img src="./img/all.png">

### 3. LISTAR DADOS ESPECIFICOS

Lista dados de Usuário específico com /id/<número da id>

<img src="./img/user.png">

### 4. LISTAR ENDEREÇOS DE PESSOA ESPECIFICA

Lista endereços da pessoa com /end/<número da id>

<img src="./img/user_end.png">

### 5. ATUALIZAR QUALQUER DADO DA PESSOA

Atualiza os dados da pessoal por um corpo JSON, pode ser alterado todos ou apenas alguns.

<img src="./img/att.png">

### 6. DEFININDO UM ENDEREÇO PRINCIPAL PARA PESSOA

Define o endereço principal da Pessoa pela URL, ela pode visualizar antes e definir logo em seguida digitando /end/Lista endereços da pessoa com /end/<número_da_id>/<posição_do_endereço principal_dela>, além de evitar colocar um número acima da quantidade existente de endereços registrados no nome da Pessoa

<img src="./img/def_user_end.png">

### 7. DELETANDO DADOS DA PESSOA

Deleta todos os dados da Pessoa

<img src="./img/del.png">