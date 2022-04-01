<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
    <meta charset="iso-8859-1"> <!--Lá no Eclipse o meta está como "Iso-8859-1"-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
    <link rel="Stylesheet" href="alterar.css"> <!--Declaração do meu CSS-->
    <title>Alterar Borda</title>
</head>
<body onload = "campos()">
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" name ="formulario" action="editarBorda">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"><!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/logo pizzaria xtale 3.jpeg" alt="">
                <h2 class="titulo">Alterar Borda</h2>
                <br>
                <span>
                    ${erro}<!--Adicionar o Span-->
                </span>
            	<br>
            </div>
            <div class="p2-grupo">
                <label>Idborda</label>
                <input type="text" name="Idborda" id = "Idborda" value ="<%out.print(request.getAttribute("Idborda"));%>" readonly>
            </div>
                <div class="p2-grupo">
                    <label>Nome</label>
                    <input type="text" name="Nome" id = "Nome"placeholder="Digite o nome da borda" maxlength="20" pattern="^([a-zA-Zà-úÀ-Ú]|\s)+$" value ="<%out.print(request.getAttribute("Nome"));%>" title="Digite o nome da borda com letras" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Preço</label>
                    <input type="text" name="Preco" id = "Preco" placeholder="Digite o preco da borda" maxlength="8" pattern = "[0-9]+([\.][0-9]+)" title= "Digite o preço da borda com ponto, por exemplo 5.0" value ="<%out.print(request.getAttribute("Preco"));%>" required autofocus>
                </div>
                    <div class="p2-grupo">
                <button class="btn" type="submit" id = "btn">ALTERAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
            <form>
            <div class="p2-grupo">
                <button class="btn" type="submit" formaction = "listarBorda">VOLTAR PARA A TABELA</button>
            </div>
        </form>
        </div> <!--Essa div fecha a div class p1-->
    </form>
</body>
<script type="text/javascript">

function campos(){
	
		var idBorda = formulario.Idborda.value;
		if(idBorda == "null"){
			
			document.getElementById('Idborda').value=''; 
			document.getElementById('Nome').value=''; 
			document.getElementById('Nome').readOnly = true;
			document.getElementById('Preco').value=''; 
			document.getElementById('Preco').readOnly = true;
			document.getElementById('btn').disabled = true; 
	}
	
}
</script>
</html>