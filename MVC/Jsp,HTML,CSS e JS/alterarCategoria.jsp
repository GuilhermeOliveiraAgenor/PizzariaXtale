<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
    <meta charset="iso-8859-1"> <!--Lá no Eclipse o meta está como "Iso-8859-2"-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
    <link rel="Stylesheet" href="alterar.css"> <!--Declaração do meu CSS-->
    <title>Alterar Categoria</title>
</head>
<body onload="campos()">
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" name="formulario" action="editarCategoria">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"><!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/logo pizzaria xtale 3.jpeg" alt="">
                <h2 class="titulo">Alterar Categoria</h2>
               	<br> 
                <span>
                    ${erro}
                </span>
            	<br>
            </div>
            <br>
            <br>
            <div class="p2-grupo">
                <label>Idcategoria</label>
                <input type="text" name = "idCategoria" id = "idCategoria" value ="<%out.print(request.getAttribute("idCategoria"));%>" readonly>
            </div>
                <div class="p2-grupo">
                    <label>Nome</label>
                    <input type="text" name = "Nome" id ="Nome" value ="<%out.print(request.getAttribute("Nome"));%>"placeholder ="Digite o nome da categoria"  maxlength="40"  pattern="^([a-zA-Zà-úÀ-Ú]|\s)+$" title="Digite a categoria apenas com letras" autofocus>
                </div>
                    <div class="p2-grupo">
                <button class="btn" id="btn" type="submit">ALTERAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
            <form>
                <div class="p2-grupo">
                    <button formaction = "listarCategoria" class="btn" type="submit">VOLTAR PARA A TABELA</button>
                </div>
            </form>
        </div> <!--Essa div fecha a div class p1-->	
    </form>
</body>

<script type="text/javascript">


function campos(){
	
		var idCategoria = formulario.idCategoria.value;
		if(idCategoria == "null"){
			
			document.getElementById('idCategoria').readOnly =  true;
			document.getElementById('idCategoria').value=''; 
			document.getElementById('Nome').value=''; 
			document.getElementById('Nome').readOnly = true;
			document.getElementById('btn').disabled = true; 
	}
	
}

</script>

</html>	