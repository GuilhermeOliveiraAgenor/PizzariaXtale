$(document).ready(function()
{
    var botao = $('.bt1'); //classe no a que vai ser clicado
    var dropDown = $('.ul-cadastrar');//classe do submenu do ul que vai abrir ou seja o que que eu quero que seja aberto
    botao.on('click', function(event)
    
    {
        dropDown.stop(true,true).slideToggle();
        event.stopPropagation();
    });
});

$(document).ready(function()
{
    var botao = $('.bt2'); //classe no a que vai ser clicado
    var dropDown = $('.ul-editar');//classe do submenu do ul que vai abrir ou seja o que que eu quero que seja aberto
    botao.on('click', function(event)
    
    {
        dropDown.stop(true,true).slideToggle();
        event.stopPropagation();
    });
});

$(document).ready(function()
{
    var botao = $('.bt3'); //classe no a que vai ser clicado
    var dropDown = $('.ul-relatorio');//classe do submenu do ul que vai abrir ou seja o que que eu quero que seja aberto
    botao.on('click', function(event)
    
    {
        dropDown.stop(true,true).slideToggle();
        event.stopPropagation();
    });
});