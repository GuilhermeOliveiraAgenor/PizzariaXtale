use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarBorda' and xType  = 'P')
drop procedure alterarBorda

create procedure alterarBorda
/*Passa os parâmetros*/
(
@idBorda int,
@nomeBorda varchar(20),
@Preco decimal(8,2)
)
as

/*Se o nome da borda for igual a nomes já existente com outro idBorda irá retornar erro*/
if exists (select nomeBorda from Borda where nomeBorda = @nomeBorda and idBorda != @idBorda )
begin
raiserror ('O nome da borda já existe.',16,1)
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



