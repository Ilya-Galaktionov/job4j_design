CREATE TABLE categories(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE states(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE roles(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE rules(
    id SERIAL PRIMARY KEY,
    name TEXT
);

CREATE TABLE roles_rules(
    id SERIAL PRIMARY KEY,
    roles_id INT INT REFERENCES roles(id),
    rules_id INT REFERENCES rules(id)
);

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    roles_id INT REFERENCES roles(id)
);

CREATE TABLE items(
    id SERIAL PRIMARY KEY,
    name TEXT,
    users_id INT REFERENCES users(id),
    categories_id INT REFERENCES categories(id),
    states_id INT REFERENCES states(id)
);

CREATE TABLE comments(
    id SERIAL PRIMARY KEY,
    name TEXT,
    items_id INT REFERENCES items(id)
);

CREATE TABLE attachs(
    id SERIAL PRIMARY KEY,
    name TEXT,
    items_id INT REFERENCES items(id)
);