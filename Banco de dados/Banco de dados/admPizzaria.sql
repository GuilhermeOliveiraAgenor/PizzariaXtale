create database admPizzaria
go

use admPizzaria
go

create table Administrador
(
Nome varchar(90),
Email varchar(50),
Cpf varchar(11) primary key,
Senha varchar(10)
)
create table Produto
(
idProduto int identity primary key,
Nome varchar(40),
Preco decimal(8,2),
Categoria int,
Estoque int
)
create table Pizza
(
idPizza int identity primary key,
Nome varchar(40),
Preco decimal(8,2),
tamanhoPizza varchar(20),
Disponivel varchar(3)
)
create table categoriaProduto
(
idCategoria int identity primary key,
nomeCategoria varchar(40)
)
create table Borda
(
idBorda int identity primary key,
nomeBorda varchar(20),
Preco decimal(8,2)
)

create table Ingredientes
(
idIngrediente int identity primary key,
Nome varchar(50),
unidadedeMedida varchar(10),
Quantidade  int,
Disponivel varchar(3)
)
select *from Borda
select *from Pizza
select *from Produto
select *from categoriaProduto
select *from Ingredientes
select *from Borda
select *from Administrador
86386349
set language portuguese
-- update Produto set Estoque = '50' where Idproduto = '15'

--Inserir chave estrangeira na tabela produto
alter table Produto add foreign key (Categoria) references categoriaProduto(idCategoria)

--Inserir categoria
insert into categoriaProduto(nomeCategoria) values ('Bebida') 
insert into categoriaProduto(nomeCategoria) values ('Doce') 

-- Inserir produto
insert into Produto(Nome,Preco,Categoria,Estoque) values ('Coca-cola 2 Litros','25.00','1','50')
insert into Produto(Nome,Preco,Categoria,Estoque) values ('Guaraná 2 litros','25.00','1','50')


--Inserir admnistrador
insert into Administrador(Nome,Email,Cpf,Senha) values ('Guilherme','mandrakeguizao@gmail.com','86386349','23urit')


--Inserir pizza
insert into Pizza(Nome,Preco,tamanhoPizza,Disponivel) values ('Pizza de 4 queijos','20.00','Grande','Sim')
insert into Pizza(Nome,Preco,tamanhoPizza,Disponivel) values ('Pizza de Calabresa','20.00','Grande','Sim')

--Inserir borda
insert into Borda (nomeBorda,Preco) values ('Cheddar','3.00')
insert into Borda (nomeBorda,Preco) values ('Catupiry','3.00')
insert into Borda (nomeBorda,Preco) values ('Cream cheese','5.00')
insert into Borda (nomeBorda,Preco) values ('Normal','0.00')

--Inserir ingrediente
insert into Ingredientes (Nome,unidadedeMedida,Quantidade,Disponivel) values ('Tomate','Grama','1000','Sim')


-- Selecionar ingrediente com mais de 500
select Ingredientes.Nome,Ingredientes.unidadedeMedida,Ingredientes.Quantidade,Ingredientes.Disponivel
from Ingredientes
where Quantidade <= '500'


-- Selecionar produtos com estoque maior que 10
select Produto.idProduto,Produto.Nome,Produto.Preco, categoriaProduto.Nome,Produto.Estoque
from Produto
inner join categoriaProduto
on categoriaProduto.idCategoria = Produto.Categoria
where Produto.Estoque <= '10'
