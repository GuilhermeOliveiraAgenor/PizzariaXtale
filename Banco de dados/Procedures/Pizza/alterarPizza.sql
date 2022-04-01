use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarPizza' and xType  = 'P')
drop procedure alterarPizza

create procedure alterarPizza
/*Parâmetros*/
(
@idPizza int,
@Nome varchar(40),
@Preco decimal(8,2),
@tamanhoPizza varchar(20),
@Disponivel varchar(3)
)
as

/*Declarando variáveis*/
declare @Grande varchar(50)
select @Grande = Preco from Pizza where Nome = @Nome and tamanhoPizza = 'Grande'/*Vai selecionar os precos com o tamanho Grande*/

/*Declarando variáveis*/
declare @Medio varchar(50)
select @Medio = Preco from Pizza where Nome = @Nome and tamanhoPizza = 'Médio'/*Vai selecionar os precos com o tamanho Médio*/

declare @Pequeno varchar(50)
select @Pequeno = Preco from Pizza where Nome = @Nome and tamanhoPizza = 'Pequeno'/*Vai selecionar os precos com o tamanho Pequeno*/


if exists(select Nome from Pizza where Nome = @Nome and tamanhoPizza = @tamanhoPizza and idPizza != @idPizza)
begin /*Vai selecionar os Nomes das pizzas os nomes e tamanhos com o id diferente*/
raiserror ('A pizza com esse nome e tamanho já existe.',16,1)
return -1
end

if @tamanhoPizza = 'Grande' and @Preco <= @Medio/*Se o tamanho for igual a grande e o preco da pizza for menor que os precos dos tamanhos médio*/
begin
raiserror ('O preço da pizza deve ser menor do que outro tamanho.',16,1)
return -1
end

if @tamanhoPizza = 'Médio' and @Preco >= @Grande or @Preco <= @Pequeno
begin /*Se o tamanho for igual a médio e o preco da pizza for maior que os precos dos tamanhos grande e pequeno*/
raiserror ('O preço da pizza deve ser menor do que outro tamanho.',16,1)
return -1
end


if @tamanhoPizza = 'Pequeno' and @Preco >= @Medio
begin
raiserror ('O preço da pizza deve ser menor do que outro tamanho.',16,1)
return -1
end

/*Atualizar*/
begin tran


update Pizza set Nome = @Nome, Preco = @Preco, tamanhoPizza = @tamanhoPizza,Disponivel = @Disponivel where idPizza = @idPizza

if @@ERROR <> ''
rollback tran
else
commit tran
go