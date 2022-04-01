use admPizzaria
go

if exists (select 1 from sysobjects where name = 'inserirIngrediente' and xType  = 'P')
drop procedure inserirIngrediente


create procedure inserirIngrediente
/*Parâmetros*/
(
@Nome varchar(50),
@unidadedeMedida varchar(10),
@Quantidade  int
)
as

/*Se existir nomes iguais aos nomes já existentes vai retornar erro*/
if exists (select Nome from Ingredientes where Nome = @Nome)
begin
raiserror ('O nome do ingrediente já existe.',16,1)
return - 1
end

/*Insere*/
begin tran

insert into Ingredientes(Nome,unidadedeMedida,Quantidade,Disponivel) values (@Nome,@unidadedeMedida,@Quantidade,'Sim')

if @@ERROR <> ''
rollback tran
else
commit tran
go


select*from Ingredientes

