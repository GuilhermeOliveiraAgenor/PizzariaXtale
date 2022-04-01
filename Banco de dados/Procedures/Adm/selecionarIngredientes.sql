use admPizzaria
go

if exists (select 1 from sysobjects where name = 'selecionarIngredientes' and xType  = 'P')
drop procedure selecionarIngredientes


create procedure selecionarIngredientes


as 
/*Se n�o existir ingredientes com a quantidade menor ou igual a 1000 retorna erro*/
if not exists (select Ingredientes.Nome,Ingredientes.unidadedeMedida,Ingredientes.Quantidade,Ingredientes.Disponivel
	from Ingredientes
	where Quantidade <= '1000')
begin
raiserror ('N�o tem ingredientes com o estoque baixo',16,1)
return - 1
end



begin tran

/*Declara a variavel que vai conter o html*/
Declare @Email varchar(50);
select @Email = Email from Administrador
Declare @HTML varchar(MAX);
set @HTML = '
<html>
<head>
	<title>Itens</title>
	<style type="text/css">
         table { padding:0; border-spacing: 0; border-collapse: collapse; color:black;}
        thead { background: #48D1CC; border: 1px solid #ddd; color:black;}
        th { padding: 10px; font-weight: bold; border: 1px solid ; color: yellow; background-color: black;}
        tr { padding: 0; }
        td { padding: 5px; border: 1px solid #cacaca; margin:0; color:black; text-align: center; }
	</style>
</head>
<h2>Ol�. Tudo bem ? Estou aqui para te dar um aviso. </h2>
<h2>Eitaa. T� quase no final ou j� acabou. Corre pra n�o acabar. </h2>
Os itens que est�o acabando ou j� acabaram s�o esses.<br>
Fique atento para eles n�o acabarem, hein ?<br>
<h2>Itens</h2>
<h3>Os ingredientes em falta s�o esses aqui</h3>
<table>
  <thead>
		<tr>
			<th>Nome</th>
			<th>Unidade de medida</th>
			<th>Quantidade</th>
			<th>Disponivel</th>
		</tr>
   </thead>
   <tbody>' +
	CAST (
	( 
	/*select do email*/
	select 
	td = Ingredientes.Nome,'',
	td = Ingredientes.unidadedeMedida,'',
	td = Ingredientes.Quantidade,'',
	td = Ingredientes.Disponivel
	from Ingredientes
	where Ingredientes.Quantidade <= '1000'
	for XML PATH('tr'), type
	) as nvarchar(MAX) ) + '
	</tbody>
</table>
'
/*Procedure de enviar email*/
exec msdb.dbo.sp_send_dbmail
     @profile_name = 'Pizzaria_perfil',
     @recipients = @Email, 
	 @subject = 'Itens para prestar aten��o - Falta',
	 @body = @HTML,
	 @body_format = 'html'
if @@ERROR <> ''
rollback tran
else
commit tran
go

exec selecionarIngredientes
