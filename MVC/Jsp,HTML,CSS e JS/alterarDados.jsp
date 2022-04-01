<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
    <meta charset="iso-8859-1"> <!--Lá no Eclipse o meta está como "Iso-8859-2"-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Tangerine"> <!--chama a biblioteca do google-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
    <link rel="Stylesheet" href="alterar.css"> <!--Declaração do meu CSS-->
    <title>Alterar Dados</title>
</head>
<body>
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <form class="formulario" action="editarDados">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"> <!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/icone.ico" alt="">
                <h2 class="titulo">Alterar Dados</h2>
                <span>
                    <!--Adicionar o Span-->
                </span>
            </div>
            <div class="p2-grupo">
                <label>Nome</label>
                <input type="text" name="Nome" id = "Nome"placeholder="Digite o nome"  pattern = "^([a-zA-Zà-úÀ-Ú]|\s)+$" value ="<%out.print(request.getAttribute("Nome"));%>" title = "Digite apenas letras no nome" maxlength="90" autofocus>
            </div>
                <div class="p2-grupo">
                    <label>Email</label>
                    <input type="email" name="Email" id="Email" placeholder="Digite o email" value ="<%out.print(request.getAttribute("Email"));%>" title = "Digite o email com @" maxlength="50" autofocus>
                </div>
                <div class="p2-grupo">
                    <label>CPF</label>
                    <input type="text" name="Cpf" id = "Cpf" value ="<%out.print(request.getAttribute("Cpf"));%>" readonly>
                </div>
                <div class="p2-grupo">
                    <label>Senha</label>
                    <input type="text" name="Senha" id="Senha" placeholder="Digite a Senha" maxlength="10" value ="<%out.print(request.getAttribute("Senha"));%>"  pattern ="[0-9]{2}[a-zA-Zà-úÀ-Ú0-9!@#$%^&*()_+\-=\[\]{};'^~:\\|,.<>\/?]{1,}" title = "Digite a senha com dois números no começo" required autofocus>
                </div>	
                    <div class="p2-grupo">
                <button class="btn" id ="botaoalterar" type="submit" >CONFIRMAR</button> <!--O submit serve para indicar que esse botão vai ter a ação de fazer o envio dos dados do formulário-->
            </div>
        </div> <!--Essa div fecha a div class p1-->
    </form>
</body>
</html>