CREATE TABLE tb_curso(
    codigo          VARCHAR(10) PRIMARY KEY,
    nome            VARCHAR(100),
    instrutor_id    BIGINT,
    descricao       VARCHAR(200),
    status          boolean,
    created_at      DATE NOT NULL DEFAULT (curdate()),
    data_inativacao date,
    CONSTRAINT check_no_space_codigo CHECK (codigo NOT LIKE '% %'),
    CONSTRAINT check_codigo_valido CHECK (codigo REGEXP '^[a-zA-Z-]*$')
);