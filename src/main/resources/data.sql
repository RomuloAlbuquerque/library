insert into tb_book (id, author, title, description, publishing_company, number_pages, category, publication_date, registration_instant, img) values (001, 'John Green', 'A Culpa É Das Estrelas', 'Inspirador, corajoso, irreverente e brutal, A culpa é das estrelas é a obra mais ambiciosa e emocionante de John Green, sobre a alegria e a tragédia que é viver e amar.', 'Intrínseca', 288, 'Romance', TIMESTAMP WITH TIME ZONE '2012-07-09T00:00:00.00Z', TIMESTAMP WITH TIME ZONE '2021-11-25T00:00:00.00Z', 'https://raw.githubusercontent.com/RomuloAlbuquerque/library/desafio-techlead/img/capa-livro-a-culpa-e-das-estrelas.jpg');

insert into tb_user (id, first_name, last_name, email, password) values (1, 'Romulo', 'Albuquerque', 'romulo.albuquerque@techlead.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
insert into tb_user (id, first_name, last_name, email, password) values (2, 'Leonardo', 'Falcão', 'leonardo.falcao@techlead.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

insert into tb_role (id, authority) values (1, 'ROLE_ADMIN');
insert into tb_role (id, authority) values (2, 'ROLE_CLIENT');

insert into tb_user_role (user_id, role_id) values (1, 1);
insert into tb_user_role (user_id, role_id) values (2, 2);