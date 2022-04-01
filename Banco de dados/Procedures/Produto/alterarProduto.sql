use admPizzaria
go

if exists (select 1 from sysobjects where name = 'alterarProduto' and xType  = 'P')
drop procedure alterarProduto

	create procedure alterarProduto
	/*Parâmetros*/
	(
	@idProduto int ,
	@Nome varchar(40),
	@Preco decimal(8,2),
	@Categoria int,
	@Estoque int

	)
	as	

	/*Se existir produtos com nomes iguais e id diferente retorna erro*/
	if exists (select idProduto,Nome from Produto where Nome = @Nome and idProduto != @idProduto)
	begin
	raiserror ('O nome do produto já existe.',16,1)
	return - 1
	end
	/*Se não existir a categoria retorna erro */
	if not exists (select idCategoria from categoriaProduto where idCategoria = @Categoria)
	begin
	raiserror ('A categoria nao existe.',16,1)
	return - 1
	end


	/*Atualizar*/
	begin tran

	update Produto set Nome = @Nome, Preco = @Preco, Categoria = @Categoria, Estoque = @Estoque where idProduto = @idProduto

	if @@ERROR <> ''
	rollback tran
	else
	commit tran
	go
