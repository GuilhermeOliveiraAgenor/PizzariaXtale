<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="Model.Produto" %>
<%@page import="java.util.ArrayList"%>
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
    <link rel="Stylesheet" href="alterar.css"> <!--Declaração do meu CSS-->
    <title>Alterar Produto</title>
</head>
<body onload ="campos()">
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" name="formulario">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"><!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/logo pizzaria xtale 3.jpeg" alt="">
                <h2 class="titulo">Alterar Produto</h2>
                <br>
                <span>
                 ${erro}   <!--Adicionar o Span-->
                </span>
                <br>
            </div>
            <div class="p2-grupo">
                <label>Idproduto</label>
                <input type="text" name="Idproduto" id="Idproduto" value="<%out.print(request.getAttribute("Idproduto"));%>" readonly>
            </div>
                <div class="p2-grupo">
                    <label>Nome</label>
                    <input type="text" name="Nome" id = "Nome" placeholder="Digite o nome do produto" maxlength="40" pattern="^([a-zA-Zà-úÀ-Ú0-9]|\s)+$" value="<%out.print(request.getAttribute("Nome"));%>" title="Digite o nome com apenas letras" required autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Preco</label>
                    <input type="text" name="Preco" id = "Preco" value="<%out.print(request.getAttribute("Preco"));%>" placeholder="Digite o preço do produto" maxlength="8" pattern="[0-9]+([\.][0-9]+)" title="Digite o preço com um número com um ponto, exemplo: 5.0" required >
                </div>
                <div class="p2-grupo">
                    <label>Categoria</label>
                    <input type="text" name="Categoria" id="Categoria"
					placeholder="Categoria"
					value="<%out.print(request.getAttribute("Categoria"));%>"
					pattern="[0-9]+$" title="Digite o id da categoria" required
					autofocus>
                </div>
                <div class="p2-grupo">
                    <label>Estoque</label>
                    <input type="text" name="Estoque" id="Estoque" placeholder="Digite a quantidade do produto" pattern="[0-9]+$" value="<%out.print(request.getAttribute("Estoque"));%>" title="Digite o numero do estoque que deve ser igual ou maior que 1 e sem ponto" required autofocus>
                </div>
                    <div class="p2-grupo">
                <button class="btn" id = "btn" type="submit" formaction="editarProduto"
					onclick=" return verificarPreco()">ALTERAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
            <form>
                <div class="p2-grupo">
                    <button class="btn" type="submit" formaction = "listarProduto">VOLTAR PARA A TABELA</button>
                </div>
            </form>
        </div> <!--Essa div fecha a div class p1-->
    </form>
    <div class="estoque">
        <label>Estoque</label>
        <input type="text" name="Numero2" id="Numero2" placeholder="Digite a quantidade do produto" pattern="[0-9]+$" required autofocus>
        <button class="btn2" type = "submit" id="btn2" onclick = "somar()">ADICIONAR</button>
        <button class="btn2" id = "btn2" type = "submit" onclick = "diminuir()">DIMINUIR</button><!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
    </div>
</body>
<script>
	function verificarPreco() {

		var idproduto = formulario.Idproduto.value;
		var nome = formulario.Nome.value;
		var preco = formulario.Preco.value;
		var categoria = formulario.Categoria.value;
		var estoque = formulario.Estoque.value;

		if (preco <= 0.0) {

			alert('O preco não pode ser 0. Verifique os campos e tente novamente')
			formulario.Preco.focus();
			return false;
		}

	}

	function somar() {
	
		var n1 = parseInt(document.getElementById('Estoque').value);
		var n2 = parseInt(document.getElementById('Numero2').value);
		var total = n1 + n2;
		document.getElementById('Estoque').value = total;
	
	}

	function diminuir() {

		var n1 = parseInt(document.getElementById('Estoque').value);
		var n2 = parseInt(document.getElementById('Numero2').value);
		var total = n1 - n2;
		document.getElementById('Estoque').value = total;

	}
	
	function campos(){
		
		var Idproduto= formulario.Idproduto.value;
		
		if(Idproduto == "null"){
			
		document.getElementById('Idproduto').readOnly =  true;
			document.getElementById('Idproduto').value=''; 
			document.getElementById('Nome').value=''; 
			document.getElementById('Preco').value=''; 
			document.getElementById('Categoria').value=''; 
			document.getElementById('Estoque').value=''; 
			document.getElementById('Nome').readOnly = true;
			document.getElementById('Preco').readOnly = true;
			document.getElementById('Categoria').readOnly = true; 
			document.getElementById('Estoque').readOnly= true; 
			document.getElementById('btn').disabled = true; 
			document.getElementById('btn2').disabled = true; 
		
	}
	}
	
</script>

</html>