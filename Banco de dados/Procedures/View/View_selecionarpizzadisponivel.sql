use admPizzaria

create view vw_selecionarpizzasdisponivel
as

select *from Pizza where Disponivel = 'Sim'
go