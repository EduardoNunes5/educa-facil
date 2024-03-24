CREATE TABLE tb_curso(
    codigo          VARCHAR(10) PRIMARY KEY,
    nome            VARCHAR(100),
    instrutor_id    BIGINT,
    descricao       VARCHAR(200),
    status          boolean,
    created_at      date default current_date not null,
    data_inativacao date,
    CONSTRAINT check_no_space_codigo CHECK (username NOT LIKE '% %'),
    CONSTRAINT check_codigo_valido CHECK (username REGEXP '^[a-zA-Z-]*$')
);