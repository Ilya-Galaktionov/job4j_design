CREATE TABLE movie(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    genre VARCHAR (255),
    release_year INT
);

CREATE TABLE director(
    id SERIAL PRIMARY KEY,
    name VARCHAR (255),
    movie_id INT REFERENCES movie(id) UNIQUE
);

INSERT INTO movie (name, genre, release_year) VALUES
('Интерстеллар', 'Научная фантастика', 2014),
('Криминальное чтиво', 'Криминал', 1994),
('Отель «Гранд Будапешт»', 'Комедия', 2014),
('Унесённые призраками', 'Аниме', 2001),
('Паразиты', 'Триллер', 2019);

INSERT INTO director (name, movie_id) VALUES
('Кристофер Нолан', 1),
('Квентин Тарантино', 2),
( 'Уэс Андерсон', 3),
('Хаяо Миядзаки', 4),
('Пон Джун-хо', 5);

SELECT d.name, m.name, m.genre
FROM director AS d JOIN movie AS m ON d.movie_id = m.id;

SELECT d.name AS Режиссер, m.name AS Название_фильма, m.release_date AS Год_выхода
FROM director AS d JOIN movie AS m ON d.movie_id = m.id;

SELECT d.name AS Режиссер, m.name AS Название_фильма, m.genre AS Жанр
FROM director AS d JOIN movie AS m ON d.movie_id = m.id;