-- Inserindo dados na tabela user_tb
INSERT INTO user_tb (name, username, email, password, role)
VALUES
  ('Usuário Teste 1', 'usuario1', 'usuario1@email.com', 'senhaSegura123', 'STUDENT'),
  ('Usuário Teste 2', 'usuario2', 'usuario2@email.com', 'senhaForte456', 'INSTRUCTOR'),
  ('Usuário Teste 3', 'usuario3', 'usuario3@email.com', 'passwordSegura789', 'ADMIN'),
  ('Usuário Teste 4', 'usuario4', 'usuario4@email.com', 'senhaMuitoForte012', 'STUDENT'),
  ('Usuário Teste 5', 'usuario5', 'usuario5@email.com', '123mudarsenha!', 'STUDENT');

-- Inserindo dados na tabela course_tb
INSERT INTO course_tb (name, code, instructor, description, status, creation_date)
VALUES
  ('Introdução à Programação', LEFT('DEV101', 10), 'Professor Fulano', 'Este curso é uma introdução aos conceitos básicos de programação.', 'ACTIVE', CURDATE()),
  ('Banco de Dados 1', LEFT('BD100', 10), 'Professor Beltrano', 'Aprenda os fundamentos de banco de dados relacional.', 'ACTIVE', CURDATE() - INTERVAL 1 MONTH),
  ('Inglês Instrumental', LEFT('INGL300', 10), 'Professora Sicrana', 'Melhore seu inglês para fins acadêmicos e profissionais.', 'ACTIVE', CURDATE() - INTERVAL 2 MONTH),
  ('Marketing Digital', LEFT('MKT202', 10), 'Professor Fulano', 'Aprenda estratégias de marketing para o mundo digital.', 'INACTIVE', CURDATE() - INTERVAL 3 MONTH),
  ('Gestão de Projetos', LEFT('GPJ401', 10), 'Professor Beltrano', 'Aprimore suas habilidades de gestão de projetos.', 'ACTIVE', CURDATE() - INTERVAL 4 MONTH),
    ('Desenvolvimento Web com JavaScript', LEFT('WEB203', 10), 'usuario2', 'Domine a linguagem JavaScript para criar sites interativos.', 'ACTIVE', CURDATE()),
    ('Criação de Aplicativos Android', LEFT('AND204', 10), 'usuario2', 'Aprenda a desenvolver apps Android com Java e Kotlin.', 'ACTIVE', CURDATE() - INTERVAL 1 WEEK),
    ('Desenvolvimento Web com Python e Django', LEFT('PYW305', 10), 'usuario2', 'Crie sites web dinâmicos com Python e Django.', 'ACTIVE', CURDATE() - INTERVAL 2 WEEK),
    ('Banco de Dados NoSQL com MongoDB', LEFT('BDN206', 10), 'usuario2', 'Armazene e gerencie dados não estruturados com MongoDB.', 'ACTIVE', CURDATE() - INTERVAL 3 MONTH),
    ('Segurança da Informação para Desenvolvedores', LEFT('SEG307', 10), 'usuario2', 'Proteja seus sistemas e dados contra ataques cibernéticos.', 'ACTIVE', CURDATE() - INTERVAL 4 MONTH),
    ('Desenvolvimento Web com React e Redux', LEFT('REACT308', 10), 'usuario2', 'Crie interfaces web modernas e eficientes com React e Redux.', 'INACTIVE', CURDATE() - INTERVAL 5 MONTH),
    ('Desenvolvimento Mobile com Flutter', LEFT('FLUTTER209', 10), 'usuario2', 'Crie apps multiplataforma com Flutter e Dart.', 'ACTIVE', CURDATE() - INTERVAL 6 MONTH),
    ('Análise de Dados com Python e Pandas', LEFT('PDAN210', 10), 'usuario2', 'Extraia insights valiosos de seus dados com Python e Pandas.', 'ACTIVE', CURDATE() - INTERVAL 7 MONTH),
    ('Desenvolvimento de Jogos com Unity', LEFT('UNITY211', 10), 'usuario2', 'Crie jogos 2D e 3D com a engine Unity.', 'ACTIVE', CURDATE() - INTERVAL 8 MONTH),
    ('Desenvolvimento Web com Angular', LEFT('ANGULAR212', 10), 'usuario2', 'Crie SPAs robustas e escaláveis com Angular.', 'ACTIVE', CURDATE() - INTERVAL 9 MONTH),
  ('Desenvolvimento Web com HTML5 e CSS3', LEFT('HTML5CSS3213', 10), 'usuario2', 'Domine as tecnologias básicas para criar websites.', 'ACTIVE', CURDATE() - INTERVAL 10 MONTH),
  ('Criação de Aplicativos iOS com Swift', LEFT('IOS214', 10), 'usuario2', 'Aprenda a desenvolver apps iOS com a linguagem Swift.', 'ACTIVE', CURDATE() - INTERVAL 11 MONTH),
  ('Desenvolvimento Back-end com Node.js e Express', LEFT('NODEJS215', 10), 'usuario2', 'Crie APIs RESTful com Node.js e Express.', 'ACTIVE', CURDATE() - INTERVAL 12 MONTH),
  ('Banco de Dados Orientados a Objetos com PostgreSQL', LEFT('POO216', 10), 'usuario2', 'Modele e gerencie seus dados com PostgreSQL.', 'ACTIVE', CURDATE() - INTERVAL 13 MONTH);




-- Inserindo dados na tabela enrollment_tb
INSERT INTO enrollment_tb (user_id, course_id, enrollment_date)
VALUES
  (1, 1, CURDATE() - INTERVAL 1 DAY),  -- Usuário 1 matriculado no curso DEV101
  (2, 2, CURDATE() - INTERVAL 2 WEEK),  -- Usuário 2 matriculado no curso BD100
  (3, 3, CURDATE() - INTERVAL 3 MONTH),  -- Usuário 3 matriculado no curso INGL300
  (1, 3, CURDATE()),                    -- Usuário 1 matriculado no curso INGL300 (válido para testar múltiplas matrículas)
  (4, 1, CURDATE() - INTERVAL 1 WEEK);   -- Usuário 4 matriculado no curso DEV101
