CREATE TABLE type
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255)
);

CREATE TABLE product
(
    id    SERIAL PRIMARY KEY,
    name  VARCHAR(255),
    type_id INT REFERENCES type(id),
    expired_date DATE,
    price DECIMAL(10, 2)
);