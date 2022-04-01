use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarIngrediente' and xType  = 'P')
drop procedure alterarIngrediente

create procedure alterarIngrediente
/*Par�metros*/
(
@idIngrediente int ,
@Nome varchar(50),
@unidadedeMedida varchar(10),
@Quantidade  int,
@Disponivel varchar(3)
)
as

/*Se a quantidade for 0 vai atulizar para n�o*/
if (@Quantidade = 0)
set @Disponivel = 'N�o'

/*Se existir nomes iguais j� existente com id diferente retorna erro*/
if exists (select Nome from Ingredientes where Nome = @Nome and idIngrediente != @idIngrediente)
begin
raiserror ('O nome do ingrediente j� existe.',16,1)
return - 1
end

/*Atualizar*/
begin tran

update Ingredientes set Nome = @Nome,unidadedeMedida = @unidadedeMedida,Quantidade = @Quantidade,Disponivel = @Disponivel where idIngrediente = @idIngrediente

if @@ERROR <> ''
rollback tran
else
commit tran
go


select *from Ingredientes
