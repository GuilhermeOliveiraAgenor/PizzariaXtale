<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
    <meta charset="UTF-8"> <!--Lá no Eclipse o meta está como "Iso-8859-2"-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine">
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
    <link rel="Stylesheet" href="meusDados.css"> <!--Declaração do meu CSS-->
    <title>Meus Dados</title>
</head>
<body>
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" action="paginaDados">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"> <!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/icone.ico" alt="">
                <h2 class="titulo">Pizzaria Xtale</h2>
                <p>Meus Dados</p>
            </div>
            <div class="p2-grupo">
                <label>Nome:</label>
                <input type="text" name="Nome" id="Nome" value ="<%out.print(request.getAttribute("Nome"));%>" value =""readonly>
            </div>
                <div class="p2-grupo">
                    <label>Email:</label>
                   <input type="text" name="Email" id="Email" value ="<%out.print(request.getAttribute("Email"));%>" readonly>
                </div>
                <div class="p2-grupo">
                    <label>CPF:</label>
                    <input type="text" name="Cpf" id="Cpf" value ="<%out.print(request.getAttribute("Cpf"));%>" readonly>
                </div>
                <div class="p2-grupo">
                    <label>Senha:</label>
                    <input type="text" name="Senha" id="Senha" value ="<%out.print(request.getAttribute("Senha"));%>" readonly>
                </div>
                    <div class="p2-grupo">
                <button class="btn" id = "botao" type="submit">ALTERAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
        </div> <!--Essa div fecha a div class p1-->
    </form>
    </body>
</html>
    