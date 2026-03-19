--Задача 1
SELECT p.name AS "Сыр"
FROM product p
JOIN type t ON p.type_id = t.id
WHERE t.name ILIKE 'сыр';

--Задача 2
SELECT* FROM product WHERE name ILIKE '%мороженое%';

--Задача 3
SELECT name, expired_date AS "Срок годности"
FROM product
WHERE expired_date > '2026-04-21';

--Задача 4
SELECT name, price
FROM product
WHERE price = (SELECT MAX(price) FROM product);

--Задача 5
SELECT t.name AS "Тип продукта", COUNT(p.name) AS "Количество"
FROM product p
JOIN type t ON p.type_id = t.id
GROUP BY t.id;

--Задача 6
SELECT p.name AS "Сыр и Молоко"
FROM product p
JOIN type t ON p.type_id = t.id
WHERE t.name ILIKE 'сыр' OR t.name ILIKE 'молоко';

--Задача 7
SELECT t.name AS "Тип продукта", COUNT(p.name) AS "Количество"
FROM product p
JOIN type t ON p.type_id = t.id
GROUP BY t.id
HAVING COUNT(p.name) < 10;

--Задача 8
SELECT p.name AS "Название", t.name AS "Тип продукта"
FROM product p
JOIN type t ON p.type_id = t.id
ORDER BY t.id;