use admPizzaria
go

if exists (select 1 from sysobjects where name = 'excluirProduto' and xType  = 'P')
drop procedure excluirProduto

create procedure excluirProduto
/*Parâmetros*/
(
@idProduto int
)
as

/*Excluir*/
begin tran

delete Produto from Produto where idProduto = @idProduto

if @@ERROR <> ''
rollback tran
else
commit tran
go

