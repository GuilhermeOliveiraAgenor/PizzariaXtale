<%@ page language="java" contentType="text/html; charset=utf-8" 
	pageEncoding="utf-8"%>
	<%@page import="Model.Categoria"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<Categoria> listar = (ArrayList<Categoria>)

request.getAttribute("listarCategoria");

%>
<!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
    <meta charset="iso-8859-1"> <!--Lá no Eclipse o meta está como "Iso-8859-2"-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
    <link rel="Stylesheet" href="cadastrarListar.css"> <!--Declaração do meu CSS-->
    <title>Cadastrar Produto</title>
</head>
<body>
    <div>
    <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
    Voltar Para o Menu
</div>
    <form class="formulario" name = "formulario"action="inserirProduto">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"><!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/logo pizzaria xtale 3.jpeg" alt="">
                <h2 class="titulo">Cadastrar Produto</h2>
                <br>
                <span>
                   ${erro}<!--Adicionar o Span-->
                </span>
            </div>
            <br>
            <div class="p2-grupo">
                <label>Nome</label>
                <input type="text" name="Nome" id="Nome" placeholder="Digite o nome do produto" maxlength="40" pattern = "^([a-zA-Zà-úÀ-Ú0-9]|\s)+$" title = "Digite o nome com letras ou números" required autofocus>
            </div>
                <div class="p2-grupo">
                    <label>Preco</label>
                    <input type="text" name="Preco" id = "Preco" placeholder="Digite o preço do produto" maxlength="8" pattern = "[0-9]+([\.][0-9]+)" title = "Digite o preço com um número com um ponto, exemplo: 5.0" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Categoria</label>
                    <input type="text" name="Categoria" id = "Categoria" placeholder="Digite a categoria do produto" pattern="[0-9]+$" title="Digite o id da categoria" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Estoque</label>
                    <input type="text" name="Estoque" id = "Estoque" placeholder="Digite a quantidade do produto" pattern = "[0-9]+$" title ="Digite o numero do estoque que deve ser igual ou maior que 1 e sem ponto" required autofocus>
                </div>
                    <div class="p2-grupo">
                <button class="btn" type="submit" onclick="return verificarProduto()">CADASTRAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
        </div> <!--Essa div fecha a div class p1-->
    </form>
    <br>
    <br>
    <br>
	    <table id="customers">
        <thead>
        <tr>
            <th>Id categoria</th>	
            <th>Nome</th>
        </tr>
        </thead>
        <tbody>
        <%
			for (int i = 0; i < listar.size(); i++) {
			%>
			<tr>
				<td><%=listar.get(i).getIdCategoria()%></td>
				<td><%=listar.get(i).getNome()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
        </table>
        </body>
 <script type="text/javascript">
 
 function verificarProduto()
{

	 var estoque = formulario.Estoque.value;
	 var preco = formulario.Preco.value
	 
	 if(preco <= 0.0)
	{
	alert('O preco não pode ser 0. Verifique os campos e tente novamente')	 
	formulario.Preco.focus();
	return false;
	}	 
	 if(estoque <= 0)
		{
		alert('O estoque não pode ser 0. Verifique os campos e tente novamente')	 
		formulario.Estoque.focus();
		return false;
		}	 	 
	 
}
 
    </script>
</html>