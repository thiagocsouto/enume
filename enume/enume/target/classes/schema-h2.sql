create table curso(id integer auto_increment, nome varchar(60), descrição varchar(200), quantidade_vagas varchar(2), carga_horaria varchar(5), valor varchar(20));  

create table funcionario(id integer auto_increment, nome varchar(60), data_entrada date, data_saída date, cargo varchar(60), cidade varchar(60),
logradouro varchar(30), número varchar(30), complemento varchar(60), bairro varchar(60), uf varchar(60), cep varchar(40));