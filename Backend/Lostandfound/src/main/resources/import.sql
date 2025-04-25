INSERT INTO tb_user_app (name, email, password, pornumber, birth_date) VALUES ('Helio Silva', 'heliosilva@mail.com', '12345', '0242526', '1984-03-17');
INSERT INTO phone_number (userapp_id, phone_number) VALUES (1, '912345678'), (1, '934567890');

INSERT INTO tb_user_app (name, email, password, pornumber, birth_date) VALUES ('Fábio Costa', 'Fabiocosta@mail.com', '12345', '0242527', '1984-03-18');
INSERT INTO phone_number (userapp_id, phone_number) VALUES (2, '912345679');



INSERT INTO tb_user_app (name, email, password, pornumber, birth_date) VALUES ('David Morgado', 'davidmorgado@mail.com', '12345', '0242528', '1984-03-19');
INSERT INTO phone_number (userapp_id, phone_number) VALUES (3, '912345680');

INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES ( true, 1, 'Piso 2 WC Masculino', 'Visitante Maria Fernandes', 'Carteira de couro preta com documentos', '2025-04-01', 'https://example.com/img/carteira.jpg');
INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES ( true, 1, 'Piso -1 Parque Verde Lugar 32589 ', 'Visitante Desconhecido', 'Conjunto chaves viagtura Ford com chaves de casa ', '2025-04-01', 'https://example.com/img/chavesViaturaFord.jpg');
INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES ( true, 2, 'Elevador n-4 piso 2', 'Visitante Desconhecido', 'Guarda chuvas Amarelo', '2025-04-02', 'https://example.com/img/guardachuvaamarelo.jpg');
INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES (true, 1, 'Receção principal', 'Joana Ribeiro', 'Carteira azul com documentos e cartões', '2025-03-28', 'https://example.com/img/carteiraazul.jpg');
INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES (true, 1, 'Auditório B1', 'Funcionário da limpeza', 'Chaves com porta-chaves da Marvel', '2025-04-01', 'https://example.com/img/chavesmarvel.jpg');
INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES (true, 2, 'Cantina', 'Estudante Anónimo', 'Mochila preta com livros de matemática', '2025-03-30', 'https://example.com/img/mochilapreta.jpg');
INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES (true, 1, 'WC Feminino piso 1', 'Segurança', 'Telemóvel Samsung com ecrã partido', '2025-04-10', 'https://example.com/img/telemovelsamsung.jpg');
INSERT INTO tb_item_lost (status, type, location, who_find, description, data_found, img_url) VALUES (true, 2, 'Biblioteca', 'Funcionário da biblioteca', 'Óculos de leitura em estojo azul', '2025-04-05', 'https://example.com/img/oculos.jpg');


-- Associar o item 1 (Carteira preta) ao utilizador 1 (Hélio Silva)
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (1, 1);

-- Associar o item 2 (Chaves viatura Ford) ao utilizador 2 (Fábio Costa)
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (2, 2);

-- Associar o item 3 (Guarda-chuva amarelo) ao utilizador 3 (David Morgado)
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (3, 3);

-- Associar o item 4 (Carteira azul) ao utilizador 1
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (4, 1);

-- Associar o item 5 (Chaves com porta-chaves Marvel) ao utilizador 2
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (5, 2);

-- Associar o item 6 (Mochila preta) ao utilizador 3
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (6, 3);

-- Associar o item 7 (Telemóvel Samsung) ao utilizador 1
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (7, 1);

-- Associar o item 8 (Óculos) ao utilizador 2
INSERT INTO item_lost_user_app (item_lost_id, user_app_id) VALUES (8, 2);
