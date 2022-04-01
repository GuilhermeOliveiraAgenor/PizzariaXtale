use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarIngrediente' and xType  = 'P')
drop procedure alterarIngrediente

create procedure alterarIngrediente
/*Parâmetros*/
(
@idIngrediente int ,
@Nome varchar(50),
@unidadedeMedida varchar(10),
@Quantidade  int,
@Disponivel varchar(3)
)
as

/*Se a quantidade for 0 vai atulizar para não*/
if (@Quantidade = 0)
set @Disponivel = 'Não'

/*Se existir nomes iguais já existente com id diferente retorna erro*/
if exists (select Nome from Ingredientes where Nome = @Nome and idIngrediente != @idIngrediente)
begin
raiserror ('O nome do ingrediente já existe.',16,1)
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
