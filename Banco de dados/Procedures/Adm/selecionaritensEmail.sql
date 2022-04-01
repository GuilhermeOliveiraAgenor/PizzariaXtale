use admPizzaria
go

if exists (select 1 from sysobjects where name = 'selecionarProdutos' and xType  = 'P')
drop procedure selecionarProdutos


create procedure selecionarProdutos

/*Se não existir produtos com estoque menor ou igual a 10 retorna erro*/
as 
if not exists (select Produto.idProduto,Produto.Nome,Produto.Preco, categoriaProduto.nomeCategoria,Produto.Estoque
from Produto
inner join categoriaProduto
on categoriaProduto.idCategoria = Produto.Categoria
where Produto.Estoque <= '10')
begin
raiserror ('Não tem produtos com o estoque baixo',16,1)
return - 1
end

begin tran

/*Declarar a variavel email que vai conter a página html do email*/
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
<h2>Olá. Tudo bem ? Estou aqui para te dar um aviso. </h2>
<br>
<h2>Os itens que estão acabando ou já acabaram são esses.</h2>
<h2>Itens</h2>
<h3>Produtos que estão em falta</h3>
<table>
  <thead>
		<tr>
			<th>Nome produto</th>
			<th>Preco</th>
			<th>Categoria</th>
			<th>Estoque</th>
		</tr>
   </thead>
   <tbody>' +
	CAST (
	( 
	/*select do email*/
	select
	td = Produto.Nome,'',
	td = Produto.Preco,'',
	td = categoriaProduto.nomeCategoria,'',
	td = Produto.Estoque
	from Produto
	inner join categoriaProduto
	on categoriaProduto.idCategoria = Produto.Categoria
	where Produto.Estoque <= '10'
	for XML PATH('tr'), type
	) as nvarchar(MAX) ) + '
	</tbody>
</table>
'
/*Procedure para enviar email*/
exec msdb.dbo.sp_send_dbmail
     @profile_name = 'Pizzaria_perfil',
     @recipients = @Email, 
	 @subject = 'Itens para prestar atenção - Falta',
	 @body = @HTML,
	 @body_format = 'html'
if @@ERROR <> ''
rollback tran
else
commit tran
go
	