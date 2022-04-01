<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import = "Model.Pizza"%>
<%@page import	 = "java.util.ArrayList"%>
<%

	ArrayList<Pizza> listar = (ArrayList<Pizza>)
	
	request.getAttribute("listarPizza");

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
    <link rel="Stylesheet" href="alterarListar.css"> <!--Declaração do meu CSS-->
    <title>Alterar Pizza</title>
</head>
<body onload = "campos()">
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" name="formulario" action = "editarPizza">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"><!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/logo pizzaria xtale 3.jpeg" alt="">
                <h2 class="titulo">Alterar Pizza</h2>
                <br>
                <span>
                    ${erro}<!--Adicionar o Span-->
                </span>
                <br>
            </div>
            <div class="p2-grupo">
                <label>Idpizza</label>
                <input type="text" name="Idpizza" id="Idpizza" value = "<%out.print(request.getAttribute("Idpizza"));%>" readonly>
            </div>
                <div class="p2-grupo">
                    <label>Nome</label>
                    <input type="text" name="Nome" id="Nome" placeholder="Digite o nome da pizza"  maxlength="40" value = "<%out.print(request.getAttribute("Nome"));%>" pattern = "^([a-zA-Zà-úÀ-Ú0-9]|\s)+$" title = "Digite o nome da pizza com letras ou números" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Preco</label>
                    <input type="text" name="Preco" id="Preco" placeholder="Digite o preço da pizza"  maxlength="8" value = "<%out.print(request.getAttribute("Preco"));%>" pattern = "[0-9]+([\.][0-9]+)" title = "Digite o preço com ponto, exemplo 5.0" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Tamanho</label>
                    <select name="Tamanhopizza" id="Tamanhopizza">
                        <option><%out.print(request.getAttribute("Tamanhopizza"));%></option>
                       	<option disabled>-------</option>
                        <option value="Grande">Grande</option>
                        <option value="Médio">Médio</option>
                        <option value= "Pequeno">Pequeno</option>
                    </select>
                </div>
                <div class="p2-grupo">
                    <label>Disponivel</label>
				    <select name="Disponivel" id="Disponivel">
                    <option><%out.print(request.getAttribute("Disponivel"));%></option>
					<option disabled>------</option>
					<option value = "Sim">Sim</option>
					<option value = "Não" >Não</option>
                       </select>
                </div>
                    <div class="p2-grupo">
                <button class="btn" id="btn" type="submit" onclick="return verificarPizza()">ALTERAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
        </div> <!--Essa div fecha a div class p1-->
    </form>
<h1 class="h1">Listar Pizza</h1>
    <table id="customers">
        <thead>
        <tr>
            <th class = "th">Id pizza</th>
            <th class = "th">Nome</th>
            <th class = "th">Preço</th>
            <th class = "th">Tamanho</th>
            <th class = "th">Disponivel</th>
        </tr>
	</thead>
<tbody>
<%for (int i = 0; i < listar.size(); i++){ %>
<tr>
<td class = "td"><%=listar.get(i).getIdpizza()%> </td>
<td class = "td"><%=listar.get(i).getNome()%> </td>
<td class = "td"><%=listar.get(i).getPreco()%></td>
<td class = "td"><%=listar.get(i).getTamanhopizza()%></td>
<td class = "td"><%=listar.get(i).getDisponivel()%> </td>
<td><a class = "botao" href = "selecionarpizzAlterar?Idpizza=<%=listar.get(i).getIdpizza()%>"> ALTERAR</a></td>
<td><a class = "botao"href="javascript: confirmar(<%=listar.get(i).getIdpizza()%>)" > EXCLUIR</a></td>
</tr>
<% } %>
</tbody>
</table>
<script type="text/javascript">

function confirmar(Idpizza){

var resposta = confirm("Você deseja realmente excluir ?");

if(resposta === true){
	
	//alert(Cpf)
	window.location.href = "excluirPizza?Idpizza=" + Idpizza
}


}

function campos(){
	
		var Idpizza = formulario.Idpizza.value;
		if(Idpizza == "null"){
			
			
			document.getElementById('Idpizza').readOnly =  true;
			document.getElementById('Idpizza').value=''; 
			document.getElementById('Nome').value=''; 
			document.getElementById('Preco').value=''; 
			document.getElementById('Disponivel').value=''; 
			document.getElementById('Tamanhopizza').value=''; 
			document.getElementById('Nome').readOnly = true;
			document.getElementById('Preco').readOnly = true;
			document.getElementById('Tamanhopizza').disabled= true; 
			document.getElementById('Disponivel').disabled= true; 
			document.getElementById('btn').disabled = true; 

	}
	
}


function verificarPizza()
{

	 var preco = formulario.Preco.value;
	 
	 if(preco <= 0.0)
	{
	alert('O preco não pode ser 0. Verifique os campos e tente novamente')	 
    formulario.Preco.focus();
	return false;
	}	 
	
}
</script>
</body>
</html>