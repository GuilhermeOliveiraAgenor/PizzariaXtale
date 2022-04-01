use admPizzaria
go

if exists (select 1 from sysobjects where name = 'inserirProduto' and xType  = 'P')
drop procedure inserirProduto

create procedure inserirProduto
/*Par�metros*/
(
@Nome varchar(40),
@Preco decimal(8,2),
@Categoria int,
@Estoque int
)
as

/*Se existir nomes iguais ao existentes retorna erro*/
if exists (select Nome from Produto where Nome = @Nome)	
begin
raiserror ('O nome do produto j� existe.',16,1)
return - 1
end

/*Se selecionar categoria que n�o existem*/
if not exists (select idCategoria from categoriaProduto where idCategoria = @Categoria)	
begin
raiserror ('A categoria n�o existe.',16,1)
return - 1
end

/*Insere*/
begin tran

insert into Produto (Nome,Preco,Categoria,Estoque) values (@Nome,@Preco,@Categoria,@Estoque)

if @@ERROR <> ''
rollback tran
else
commit tran
go


