use admPizzaria
go

if exists (select 1 from sysobjects where name = 'inserirCategoria' and xType  = 'P')
drop procedure inserirCategoria

create procedure inserirCategoria
/*Parâmetros*/
(
@Nome varchar(50)
)
as

/*Se o nome da categoria for igual aos nomes já existente no banco retorna erro*/
if exists (select nomeCategoria from categoriaProduto where nomeCategoria = @Nome)
begin
raiserror ('O nome da categoria já existe.',16,1)
return - 1
end

/*Insere*/
begin tran

insert into categoriaProduto(nomeCategoria) values (@Nome)

if @@ERROR <> ''
rollback tran
else
commit tran
go

