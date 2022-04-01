use admPizzaria
go

if exists (select 1 from sysobjects where name = 'excluirIngrediente' and xType  = 'P')
drop procedure excluirIngrediente

create procedure excluirIngrediente
/*Parâmetros*/
(
@idIngrediente int 
)
as

/*Deletar*/
begin tran

delete Ingredientes from Ingredientes where idIngrediente = @idIngrediente

if @@ERROR <> ''
rollback tran
else
commit tran
go

