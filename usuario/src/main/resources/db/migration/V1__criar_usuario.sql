CREATE TABLE tb_user(
    id SERIAL primary key,
    name VARCHAR(100),
    username VARCHAR(20),
    email VARCHAR(100),
    password VARCHAR(20),
    created_at timestamp default current_timestamp,
    user_role enum ('ESTUDANTE', 'INSTRUTOR', 'ADMIN')
);
