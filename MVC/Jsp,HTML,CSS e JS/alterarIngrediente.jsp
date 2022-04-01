<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
        <%@page import = "Model.Ingredientes"%>
<%@page import	 = "java.util.ArrayList"%>

<%

	ArrayList<Ingredientes> listar = (ArrayList<Ingredientes>)
	
	request.getAttribute("listarIngredientes");

%>
<!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
    <meta charset="utf-8"> <!--Lá no Eclipse o meta está como "Iso-8859-2"-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
    <link rel="Stylesheet" href="alterarListar.css"> <!--Declaração do meu CSS-->
    <title>Alterar Ingrediente</title>
</head>
<body onload="campos()">
    <div>
       <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" name="formulario">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"><!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/logo pizzaria xtale 3.jpeg" alt="">
                <h2 class="titulo">Alterar Ingrediente</h2>
                <span>
                    ${erro} <!--Adicionar o Span-->
                </span>
            </div>
            <div class="p2-grupo">
                <label>Idingrediente</label>
                <input type="text" name="idIngrediente" id="idIngrediente" value = "<%out.print(request.getAttribute("idIngrediente"));%>" readonly>
            </div>
                <div class="p2-grupo">
                    <label>Nome</label>
                    <input type="text" name="Nome" id="Nome" placeholder="Digite o nome do ingrediente" value = "<%out.print(request.getAttribute("Nome"));%>" pattern = "^([a-zA-Zà-úÀ-Ú0-9]|\s)+$" maxlength="50" title = "Digite o nome do ingrediente com letras ou números" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Quantidade</label>
                    <input type="text" name="Quantidade" id="Quantidade" placeholder="Digite a quantidade do ingrediente" value = "<%out.print(request.getAttribute("Quantidade"));%>"  maxlength="7" title = "Digite a quantidade sem ponto, exemplo 1000" pattern ="[0-9]+$" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Disponivel</label>
                    <select name ="Disponivel" id ="Disponivel">
                        <option><%out.print(request.getAttribute("Disponivel"));%></option>
                        <option disabled>-------</option>
                        <option value="Sim">Sim</option>
                        <option value= "Não">Não</option> 
                    </select>
                </div>
                <div class="p2-grupo">
                    <label>Unidade de medida</label>
					<select id="Unidadedemedida" name="Unidadedemedida">                      
                        <option><%out.print(request.getAttribute("Unidadedemedida"));%></option>
                        <option disabled>-------</option>
                        <option value="Grama">Grama</option>
                        <option value= "Mililitro">Mililitros</option>
                    </select>
                </div>
                    <div class="p2-grupo">
                <button class="btn" id="btn" type="submit" formaction = "editarIngrediente">ALTERAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
        </div> <!--Essa div fecha a div class p1-->
    </form>
    <div class="estoque">
        <label>Estoque</label>
        <input type="number" name="Numero2" id = "Numero2" placeholder="Digite a quantidade do ingrediente" required autofocus>
        <button class="btn2" id = "btn2" type="submit" onclick="somar()">ADICIONAR</button>
        <button class="btn2" id="btn2" type="submit" onclick="diminuir()">DIMINUIR</button><!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
    </div>
     <h1 class="h1">Listar Ingrediente</h1>
    <table id="customers">
        <thead>
        <tr>
            <th class = "th">Id ingrediente</th>
            <th class = "th">Nome</th>	
            <th class = "th">Unidade de medida</th>
            <th class = "th">Quantidade</th>
            <th class = "th">Disponível</th>
        </tr>
        </thead>
<tbody>
<%for (int i = 0; i < listar.size(); i++){ %>
<tr>
<td class = "td"><%=listar.get(i).getIdIngrediente()%> </td>
<td class = "td"><%=listar.get(i).getNome()%> </td>
<td class = "td"><%=listar.get(i).getUnidadedemedida()%></td>
<td class = "td"><%=listar.get(i).getQuantidade()%></td>
<td class = "td"><%=listar.get(i).getDisponivel()%> </td>
<td><a class ="botao" href = "selecionarIngrediente?idIngrediente=<%=listar.get(i).getIdIngrediente()%>" onclick= "campos()"> ALTERAR</a></td>
<td><a class = "botao" href="javascript: confirmar(<%=listar.get(i).getIdIngrediente()%>)" > EXCLUIR</a></td>
</tr>
<% } %>
</tbody>
</table>
<script type="text/javascript">

function confirmar(idIngrediente){

var resposta = confirm("Você deseja realmente excluir ?");

if(resposta === true){
	
	//alert(Cpf)
	window.location.href = "excluirIngrediente?idIngrediente=" + idIngrediente
}


}
	
function campos(){
	
	var idingrediente = formulario.idIngrediente.value;
	
	if(idingrediente == "null"){
		
	document.getElementById('idIngrediente').readOnly =  true;
		document.getElementById('idIngrediente').value=''; 
		document.getElementById('Nome').value=''; 
		document.getElementById('Quantidade').value=''; 
		document.getElementById('Disponivel').value=''; 
		document.getElementById('Unidadedemedida').value=''; 
		document.getElementById('Nome').readOnly = true;
		document.getElementById('Quantidade').readOnly = true;
		document.getElementById('Disponivel').disabled = true; 
		document.getElementById('Unidadedemedida').disabled = true; 
		document.getElementById('btn').disabled = true; 
		document.getElementById('btn2').disabled = true; 

		
}
	
}

function somar() {


	var n1 = parseInt(document.getElementById('Quantidade').value);
    var n2 = parseInt(document.getElementById('Numero2').value);
    var total = n1 + n2;
    document.getElementById('Quantidade').value = total;

	
	
}


function diminuir() {

    var n1 = parseInt(document.getElementById('Quantidade').value);
    var n2 = parseInt(document.getElementById('Numero2').value);
    var total = n1 - n2;
    document.getElementById('Quantidade').value = total;

}


</script>
</body>
</html>