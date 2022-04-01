use admPizzaria
go

if exists (select 1 from sysobjects where name = 'inserirIngrediente' and xType  = 'P')
drop procedure inserirIngrediente


create procedure inserirIngrediente
/*Par�metros*/
(
@Nome varchar(50),
@unidadedeMedida varchar(10),
@Quantidade  int
)
as

/*Se existir nomes iguais aos nomes j� existentes vai retornar erro*/
if exists (select Nome from Ingredientes where Nome = @Nome)
begin
raiserror ('O nome do ingrediente j� existe.',16,1)
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

