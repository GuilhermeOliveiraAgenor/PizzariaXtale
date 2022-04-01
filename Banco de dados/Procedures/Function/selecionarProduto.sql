use admPizzaria
go

create function selecionarProduto
(

@idCategoria int

)
returns table
as 
return

select Produto.Nome,Produto.Preco,categoriaProduto.nomeCategoria from Produto
inner join categoriaProduto
on categoriaProduto.idCategoria =  Produto.Categoria
where idCategoria = @idCategoria

go

select *from selecionarproduto(1)