use admPizzaria
go

if exists (select 1 from sysobjects where name = 'excluirPizza' and xType  = 'P')
drop procedure excluirPizza

create procedure excluirPizza
/*Parâmetros*/
(
@idPizza int
)
as

/*Excluir*/
begin tran

delete Pizza from Pizza where idPizza = @idPizza

if @@ERROR <> ''
rollback tran
else
commit tran
go

