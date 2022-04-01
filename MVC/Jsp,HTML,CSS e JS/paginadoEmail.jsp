<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="iso-8859-1"> <!--Lá no Eclipse o meta está como "Iso-8859-2"-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Quicksand:wght@600&display=swap" rel="stylesheet">   
    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png">
    <link rel="Stylesheet" href="mensagem.css">
    <title>Mensagem de Email</title>
</head>
<body>
    <br>
    <br>
    <br>
    <div>
        <a href="menuGeral.html"><i class="material-icons"></i></a><!--Aqui está o icone que eu peguei do google-->
        Voltar Para o Menu
    </div>
    <div>
        <h1 class="h1">Um relatório foi enviado para o seu Email</h1>
        <p class="p">${erro}</p>
    </div>
</body>
</html>