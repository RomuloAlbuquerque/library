insert into tb_book (id, author, title, description, publishing_company, number_pages, category, publication_date, registration_instant) values (001, 'John Green', 'A Culpa É Das Estrelas', 'Inspirador, corajoso, irreverente e brutal, A culpa é das estrelas é a obra mais ambiciosa e emocionante de John Green, sobre a alegria e a tragédia que é viver e amar.', 'Intrínseca', 288, 'Romance', TIMESTAMP WITH TIME ZONE '2012-07-09T00:00:00.00Z', TIMESTAMP WITH TIME ZONE '2021-11-25T00:00:00.00Z');

insert into tb_user (first_name, last_name, email, password) values ('Alex', 'Brown', 'alex@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
insert into tb_user (first_name, last_name, email, password) values ('Maria', 'Green', 'maria@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

insert into tb_role (authority) values ('ROLE_CLIENT');
insert into tb_role (authority) values ('ROLE_ADMIN');

insert into tb_user_role (user_id, role_id) values (1, 1);
insert into tb_user_role (user_id, role_id) values (2, 1);
insert into tb_user_role (user_id, role_id) values (2, 2);