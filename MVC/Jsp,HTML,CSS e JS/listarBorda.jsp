<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import = "Model.Borda"%>
<%@page import	 = "java.util.ArrayList"%>
<%
	ArrayList<Borda> listar = (ArrayList<Borda>)	

	request.getAttribute("listarBorda");

%>
<!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">'
<head>
    <meta charset="iso-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http.equiv="X-UA-compatible" content="ie=edge" />
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="Stylesheet" href="listar.css"> <!--Declaração do meu CSS-->
    <title>Listar Borda</title>
</head>
<body>
 <div>
       <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <h1 class="h1">Listar Borda</h1>
    <table id="customers">
    <thead>
        <tr>
            <th class = "th">Id borda</th>
            <th class = "th">Nome</th>
            <th class = "th">Preço</th>
        </tr>
</thead>
<tbody>
<%for (int i = 0; i < listar.size(); i++){ %>
<tr>
<td class = "td"><%=listar.get(i).getIdborda()%> </td>
<td class = "td"><%=listar.get(i).getNomeborda()%> </td>
<td class = "td"><%=listar.get(i).getPreco()%></td>
<td><a class = "botao" href = "selecionarbordAlterar?Idborda=<%=listar.get(i).getIdborda()%>"> ALTERAR</a></td>
<td><a class = "botao" href="javascript: confirmar(<%=listar.get(i).getIdborda()%>)" > EXCLUIR</a></td>
</tr>
<% } %>
</tbody>
</table>
<script>
function confirmar(Idborda){

var resposta = confirm("Você deseja realmente excluir ?");

if(resposta === true){
	
	//alert(Cpf)
	window.location.href = "excluirBorda?Idborda=" + Idborda
}

}
</script>
</body>
</html>