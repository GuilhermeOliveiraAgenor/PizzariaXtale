<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="Model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%
ArrayList<Produto> listarproduto = (ArrayList<Produto>)

request.getAttribute("listar");
%>
<!DOCTYPE html>
<!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
<meta charset="iso-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http.equiv="X-UA-compatible" content="ie=edge" />
<link rel="shortcut icon" href="Imagens/fatia-de-pizza.png">
<!--Icone da página-->
<link rel="Stylesheet" href="listar.css">
<!--Declaração do meu CSS-->
<title>Listar Produto</title>
</head>
<body>
 <div>
       <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
	<h1 class="h1">Listar produto</h1>
	<table id="customers">
		<thead>
			<tr>
				<th class = "th">Id produto</th>
				<th class = "th">Nome</th>
				<th class = "th">Preço</th>
				<th class = "th">Categoria</th>
				<th class = "th">Estoque</th>
			</tr>

		</thead>
		<tbody>
			<%
			for (int i = 0; i < listarproduto.size(); i++) {
			%>
			<tr>
				<td class = "td"><%=listarproduto.get(i).getIdproduto()%></td>
				<td class = "td"><%=listarproduto.get(i).getNome()%></td>
				<td class = "td"><%=listarproduto.get(i).getPreco()%></td>
				<td class = "td"><%=listarproduto.get(i).getCategoria()%></td>
				<td class = "td"><%=listarproduto.get(i).getEstoque()%></td>
				<td><a class="botao"
					href="listarprodutoEscolher?Idproduto=<%=listarproduto.get(i).getIdproduto()%>">
						ALTERAR</a></td>
				<td><a class="botao"
					href="javascript: confirmar(<%=listarproduto.get(i).getIdproduto()%>)">
						EXCLUIR</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
<script>
	function confirmar(Idproduto) {

		var resposta = confirm("Você deseja realmente excluir ?");

		if (resposta === true) {

			//alert(Cpf)
			window.location.href = "excluirProduto?Idproduto=" + Idproduto
		}

	}
</script>
</html>