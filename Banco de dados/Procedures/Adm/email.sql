execute sp_configure 'Show Advanced Options', 1
reconfigure
execute sp_configure 'Database Mail XPs', 1
reconfigure

execute msdb.dbo.sysmail_add_account_sp
--Dados fixos
@mailserver_name = 'smtp.gmail.com',/*Servidor do email*/
@port = 587,/*Porta do servidor*/
@enable_ssl = 1,
/*Dados da minha conta*/
@account_name = 'Emailpizzaria',
@display_name = 'Pizzaria Xtale',
@email_address = 'pizzzariaxtale@gmail.com',
@username = 'pizzzariaxtale@gmail.com',
@password = 'guizinho004'
/*Adicionar perfil*/
execute msdb.dbo.sysmail_add_profile_sp
@profile_name = 'Pizzaria_perfil',
@description = 'Perfil para	enviar o pagamento'
/*Perfil na conta*/
execute msdb.dbo.sysmail_add_profileaccount_sp
@profile_name = 'Pizzaria_perfil',
@account_name = 'Emailpizzaria',
@sequence_number = 1

execute msdb.dbo.sp_send_dbmail
@profile_name = 'Pizzaria_perfil',
@recipients = 'mandrakeguizao@gmail.com',/*Email que vai ser enviado*/
@subject = 'Esse email � um teste',/*Titulo do texto*/
@body = 'Ola' /*Mensagem do texto*/