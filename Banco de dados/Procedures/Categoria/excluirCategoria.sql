use admPizzaria
go

if exists (select 1 from sysobjects where name = 'excluirCategoria' and xType  = 'P')
drop procedure excluirCategoria


create procedure excluirCategoria
(
@idCategoria int
)
as

begin tran

delete categoriaProduto from categoriaProduto where idCategoria = @idCategoria

if @@ERROR <> ''
rollback tran
else
commit tran
go

