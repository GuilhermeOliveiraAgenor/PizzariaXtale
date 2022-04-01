use admPizzaria
go

if exists (select 1 from sysobjects where name = 'excluirBorda' and xType  = 'P')
drop procedure excluirBorda

create procedure excluirBorda
/*Parametros para procedure*/
(
@idBorda int
)
as

/*excluir*/
begin tran

delete Borda from Borda where idBorda = @idBorda

if @@ERROR <> ''
rollback tran
else
commit tran
go


