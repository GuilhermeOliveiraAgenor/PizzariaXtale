use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarCategoria' and xType  = 'P')
drop procedure alterarCategoria


create procedure alterarCategoria
/*Parâmetros*/
(
@idCategoria int,
@Nome varchar(50)
)
as

/*Se existir nomes iguais com id diferentes dos já existentes retorna erro*/
if exists (select nomeCategoria from categoriaProduto where nomeCategoria = @Nome and idCategoria != @idCategoria )
begin
raiserror ('O nome da categoria já existe.',16,1)
return - 1
end

/*Atualizar*/
begin tran

update categoriaProduto set nomeCategoria = @Nome where idCategoria = @idCategoria

if @@ERROR <> ''
rollback tran
else
commit tran
go

