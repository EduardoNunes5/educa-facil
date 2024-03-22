CREATE TABLE tb_user(
    id SERIAL primary key,
    name VARCHAR(100),
    username VARCHAR(20) UNIQUE,
    email VARCHAR(100) UNIQUE ,
    password VARCHAR(20),
    created_at timestamp default current_timestamp,
    user_role enum ('ESTUDANTE', 'INSTRUTOR', 'ADMIN') DEFAULT 'ESTUDANTE',
    CONSTRAINT check_lower_case_username CHECK (username = LOWER(username)),
    CONSTRAINT check_no_space_username CHECK (username NOT LIKE '% %'),
    CONSTRAINT check_no_number_username CHECK (username LIKE '%[^0-9]%')

);