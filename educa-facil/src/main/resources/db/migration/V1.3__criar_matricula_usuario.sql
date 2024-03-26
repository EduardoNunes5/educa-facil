CREATE TABLE tb_enrollment
(
    usuario_id BIGINT,
    curso_id VARCHAR(10),
    data_matricula DATE        NOT NULL,
    CONSTRAINT primary key (usuario_id, curso_id),
    CONSTRAINT usuario_fk FOREIGN KEY (usuario_id) references tb_user(id),
    CONSTRAINT curso_fk FOREIGN KEY (curso_id) references tb_course(codigo)
);