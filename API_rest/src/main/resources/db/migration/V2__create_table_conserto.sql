create table consertos (
    id bigint not null auto_increment,
    data_entrada varchar(10) not null,
    data_saida varchar(10),
    mecanico_nome varchar(100) not null,
    mecanico_anos_de_experiencia varchar(100) not null,
    veiculo_marca varchar(7) not null,
    veiculo_modelo varchar(100) not null,
    veiculo_ano int not null,
    veiculo_cor varchar(50),
    primary key(id)
);
