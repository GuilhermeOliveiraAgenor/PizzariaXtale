<%@ page language="java" contentType="text/html; charset=utf-8"
		pageEncoding="utf-8" isErrorPage = "true" %>
	<!DOCTYPE html>
	<html lang="pt-br">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <link rel="shortcut icon" href="Imagens/fatia-de-pizza.png">
	    <link rel="Stylesheet" href="mensagem.css">
	    <title>Erro</title>
	</head>
	<body>
	    <h1 class="h1">OPS. OCORREU UM ERRO</h1>
	    <label class="label">Erro <%=exception.getMessage() %></label>
	</body>
	</html>