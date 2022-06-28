insert into curso(nome, descrição, quantidade_vagas, carga_horaria, valor)
values ('Java', 'curso básico de java para iniciantes em programação.', 30, 200, 100.00)
;

insert into funcionario(nome, data_entrada , data_saída , cargo, cidade, logradouro, número, complemento, bairro, uf, cep)
values ('Thiago Antonio', PARSEDATETIME('02/01/2021', 'dd/MM/yyyy'), PARSEDATETIME('04/05/2022', 'dd/MM/yyyy'), 'rh', 'manaus','thi', '11','rua baixo', 'lirios','am','69038-050')
;