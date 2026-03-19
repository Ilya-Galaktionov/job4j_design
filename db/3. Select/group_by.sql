CREATE TABLE devices
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255),
    price FLOAT
);

CREATE TABLE people
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE devices_people
(
    id        SERIAL PRIMARY KEY,
    device_id INT REFERENCES devices (id),
    people_id INT REFERENCES people (id)
);

INSERT INTO devices (name, price) VALUES
('Принтер', 3000),
('Принтер', 3300),
('Принтер', 4750),
('Принтер', 5000),
('Принтер', 6500),
('Принтер', 7500),

('Монитор', 5750),
('Монитор', 6150),
('Монитор', 6300),
('Монитор', 6300),
('Монитор', 8000),
('Монитор', 9500),

('Клавиатура', 1500),
('Клавиатура', 4500),
('Клавиатура', 5750),
('Клавиатура', 6200),
('Клавиатура', 8600),
('Клавиатура', 10500);

INSERT INTO people (name) VALUES
('Сергей'),
('Иван'),
('Николай');

INSERT INTO devices_people (device_id, people_id) VALUES
(1, 1),
(2, 1),
(9, 1),
(10, 1),
(17, 1),
(18, 1),

(3, 2),
(4, 2),
(7, 2),
(8, 2),
(14, 2),
(15, 2),

(5, 3),
(6, 3),
(11, 3),
(12, 3),
(13, 3),
(16, 3);

SELECT name AS "Название устройства", AVG(price) AS "Средняя цена"
FROM devices
GROUP BY name;

SELECT p.name, AVG(d.price) AS "Средняя цена"
FROM people p
JOIN devices_people dp ON p.id = dp.people_id
JOIN devices d ON dp.device_id = d.id
GROUP BY p.name;

SELECT p.name, AVG(d.price) AS "Средняя цена"
FROM people p
JOIN devices_people dp ON p.id = dp.people_id
JOIN devices d ON dp.device_id = d.id
GROUP BY p.name,
HAVING AVG(d.price) > 5000;