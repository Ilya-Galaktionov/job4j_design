CREATE TABLE login(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255)
);

CREATE TABLE phone_number(
	id SERIAL PRIMARY KEY,
	phone_number INT,
	login_id INT REFERENCES login(id) UNIQUE
);