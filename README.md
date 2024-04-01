# API Rest para gerenciamento de Alunos e Cursos

Nesse sistema, é possível gerenciar usuários, cursos e matricular alunos em cursos.  
Os usuários podem ter um papel (estudante, instrutor ou administrador), cada papel tem níveis de autorização para cada funcionalidade do sistema.
---

## Funcionalidades e permissões

* **Gerenciamento de usuarios**
  * Cadastro de usuários (permissão livre)
  * Obter dados de um usuário por username (administrador)  
  
Restrições: Username deve conter apenas caracteres minúsculos, sem numerais e sem espaços.
Precisa ser um endereço de e-mail em um formato válido.
Pode apenas ter um usuário com o mesmo email/username.

* **Gerenciamento de cursos**
  * Cadastro de curso (apenas administradores podem cadastrar e apenas instrutores podem ser instrutores de curso)
  * Inativação de um curso (apenas administradores)
  * Listagem de cursos paginada por status (apenas administradores)  

Restrições: Pode apenas ter um curso com o mesmo código.
O código de um curso deve ser textual, sem espaços, nem caracteres numéricos, nem caracteres especiais, mas pode ser separado por - , exemplo: spring-boot-avancado.
Apenas usuários instrutores podem ser autores de um curso.
A data de inativação deve ser apenas definida quando o curso estiver desativado.

* **Gerenciamento de matrículas**
  * Realização de matrícula (qualquer usuário logado)

Restrições:
Um usuário não pode matricular-se mais de uma vez em um curso.
Podemos apenas nos matricular em cursos ativos.

---

A execução do projeto pode ser realizada via docker, com o comando:
```shell
docker compose up
```
Você pode executar também através de sua IDE de preferência ou comando maven, por exemplo.  
Para isso, deverão ser definidas as seguintes variáveis de ambiente caso queira utilizar um banco de dados mysql:
```shell
DATABASE_URL
DATABASE_USER
DATABASE_PASSWORD
JWT_SECRET
```
Caso contrário, pode definir a variável de ambiente `APP_PROFILE=test`, assim será utilizado o banco de dados h2 e o flyway será desabilitado. 

---  
Tecnologias Utilizadas:
* Java
* Spring Boot (Web, Data JPA, Security, Validation)
* Flyway
* Lombok
* Mapstruct
* MySQL
* Docker
* JWT
