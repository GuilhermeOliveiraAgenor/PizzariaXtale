use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarBorda' and xType  = 'P')
drop procedure alterarBorda

create procedure alterarBorda
/*Passa os par�metros*/
(
@idBorda int,
@nomeBorda varchar(20),
@Preco decimal(8,2)
)
as

/*Se o nome da borda for igual a nomes j� existente com outro idBorda ir� retornar erro*/
if exists (select nomeBorda from Borda where nomeBorda = @nomeBorda and idBorda != @idBorda )
begin
raiserror ('O nome da borda j� existe.',16,1)
return - 1
end

/*Atualizar*/
begin tran

update Borda set nomeBorda = @nomeBorda,Preco = @Preco  where idBorda = @idBorda 

if @@ERROR <> ''
rollback tran
else
commit tran
go



