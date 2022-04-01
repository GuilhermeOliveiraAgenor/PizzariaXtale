	<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
    <link rel="Stylesheet" href="cadastrar.css"> <!--Declaração do meu CSS-->
    <title>Cadastrar Borda</title>
</head>
<body>
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" name = "formulario" action="inserirBorda">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"><!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/logo pizzaria xtale 3.jpeg" alt="">
                <h2 class="titulo">Cadastrar Borda</h2>
                <br>
                <span>
                 ${erro}   <!--Adicionar o Span-->
                </span>
            </div>
            <br>
            <div class="p2-grupo">
                <label>Nome</label>
                <input type="text" name="Nome" placeholder="Digite o nome da borda" maxlength="20" pattern="^([a-zA-Zà-úÀ-Ú]|\s)+$" title="Digite o nome da borda com apenas letras"required autofocus>
            </div>
                <div class="p2-grupo">
                    <label>Preco</label>
                    <input type="text" name="Preco" placeholder="Digite o preço da borda" maxlength="8" pattern = "[0-9]+([\.][0-9]+)" title= "Digite o preço da borda com ponto, por exemplo 5.0"required autofocus>
                </div>
                    <div class="p2-grupo">
                <button class="btn" type="submit">CADASTRAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
        </div> <!--Essa div fecha a div class p1-->
    </form>
</body>
</html>