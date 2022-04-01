use admPizzaria
go

if exists (select 1 from sysobjects where name = 'inserirBorda' and xType  = 'P')
drop procedure inserirBorda

create procedure inserirBorda
(
@nomeBorda varchar(20),/*Declaração das variaveis*/
@Preco decimal(8,2)
)
as
if exists (select nomeBorda from Borda where nomeBorda = @nomeBorda)/*Se existir bordas com os nomes iguais*/
begin
raiserror ('O nome da borda já existe.',16,1)/*Retorna erro*/
return - 1
end

/*Insere a borda*/
begin tran

insert into Borda(nomeBorda,Preco) values (@nomeBorda,@Preco)

if @@ERROR <> ''
rollback tran
else
commit tran
go