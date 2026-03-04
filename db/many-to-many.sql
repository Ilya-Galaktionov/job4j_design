CREATE TABLE readers(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE books(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE readers_books(
	id SERIAL PRIMARY KEY,
	readers_id INT REFERENCES readers(id),
	books_id INT REFERENCES books(id)
);
