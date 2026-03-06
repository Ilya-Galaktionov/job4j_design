INSERT INTO users(name, roles_id) VALUES ('Иванов', 1);
INSERT INTO roles(name) VALUES ('Админ');
INSERT INTO rules(name) VALUES ('Полный доступ');
INSERT INTO roles_rules(roles_id, rules_id) VALUES (1, 1);
INSERT INTO items(name, user_id, categories_id, states_id) VALUES ('Настройка', 1, 1);
INSERT INTO comments(name, items_id) VALUES ('Нужно уточнение ошибки', 1);
INSERT INTO attachs(name, items_id) VALUES ('error.jpg', 1);
INSERT INTO categories(name) VALUES ('Техподдержка');
INSERT INTO states(name) VALUES ('В работе');
