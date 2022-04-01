<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html> <!--Estrutura Básica Html-->
<html lang="pt-br">
<head>
    <meta charset="iso-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http.equiv="X-UA-compatible" content="ie=edge" />
    <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png"> <!--Icone da página-->
    <link rel="Stylesheet" href="login.css"> <!--Declaração do meu CSS-->
    <title>login</title>
</head>
<body>
    <h1 class="h1">Bem vindo a pizzaria Xtale!!</h1>
    <form class="formulario" action="Login">
        <div class="p1"> <!--Essa classe serve para estilizar o meu formulário-->
            <div class="p1-topo"> <!--Nessa classe é aonde vais estar todos os elementos da parte de cima do formulário que estilizada no meu css-->
                <img class="icone" src="Imagens/icone.ico" alt="">
                <h2 class="titulo">Login</h2>
              <br>
                  <span>${erro}</span>	
            </div>
            <br>
            <div class="p2-grupo">
                <label>CPF</label>
	                <input type="text" name="Cpf" placeholder="Digite o seu CPF" maxlength="11" pattern = "[0-9]+$" title = "Digite somente os numeros no cpf"required autofocus>
            </div>
                <div class="p2-grupo">
                    <label>Senha</label>
                    <input type="password" name="Senha" placeholder="Digite a sua senha" maxlength="10" pattern ="[0-9]{2}[a-zA-Zà-úÀ-Ú0-9!@#$%^&*()_+\-=\[\]{};'^~:\\|,.<>\/?]{1,}" required autofocus>
                </div>
                    <div class="p2-grupo">
                <button class="btn" type="submit">ACESSAR</button>
            </div>
        </div>
    </form>
</body>
</html>
