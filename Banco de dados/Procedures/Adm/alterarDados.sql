use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarDados' and xType  = 'P')
drop procedure alterarDados

create procedure alterarDados
/*Par�metros*/
(
@Nome varchar(90),
@Email varchar(50),
@Senha varchar(10)
)
as

/*Vari�vel com o cpf do Adm*/
declare @Cpf varchar(50);
select @Cpf = Cpf from Administrador

if(@Nome = '')
begin
raiserror ('O nome do n�o pode ser nulo.',16,1)
return - 1
end

if(@Email = '')
begin
raiserror ('O email n�o pode ser nulo.',16,1)
return - 1
end

if(@Senha = '')
begin
raiserror ('A senha n�o pode ser nula.',16,1)
return - 1
end

/*Atualizar*/
begin tran

update Administrador set Nome = @Nome, Email = @Email, Senha = @Senha where Cpf = @Cpf

if @@ERROR <> ''
rollback tran
else
commit tran
go

