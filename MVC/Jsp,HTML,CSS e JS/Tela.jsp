<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <title>Mensagem de pizza</title>
</head>
<body>
    <form action = "paginalterarPizza">
        <button class="btn"  type="submit">VOLTAR PARA A TABELA</button>
</form>
    <h1 class="h1">${erro}</h1>
</body>
</html>