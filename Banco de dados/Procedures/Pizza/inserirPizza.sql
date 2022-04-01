use admPizzaria
go

if exists (select 1 from sysobjects where name = 'inserirPizza' and xType  = 'P')
drop procedure inserirPizza

create procedure inserirPizza
/*Parâmetros*/
(
@Nome varchar(40),
@Preco decimal(8,2),
@tamanhoPizza varchar(20)
)
as

/*Se existir pizzas com nomes e tamanhos iguais retorna erro*/
if exists(select Nome from Pizza where Nome = @Nome and tamanhoPizza = @tamanhoPizza)
begin
raiserror ('A pizza com esse nome e tamanho já existe.',16,1)
return -1
end

/*Se o preço da pizza for maior que o outro tamanho retorna erro*/
if exists(select Preco from Pizza where Nome = @Nome and tamanhoPizza != @tamanhoPizza and Preco <= @Preco)
begin
raiserror ('O preço da pizza deve ser menor do que outro tamanho.',16,1)
return -1
end


/*Insere*/
begin tran


insert into Pizza (Nome,Preco,tamanhoPizza,Disponivel) values (@Nome,@Preco,@tamanhoPizza,'Sim')

if @@ERROR <> ''
rollback tran
else
commit tran
go
