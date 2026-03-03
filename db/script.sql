CREATE TABLE cars(
	id serial primary key,
	car_brand VARCHAR(255),
	horsepower INTEGER,
	AWD BOOLEAN
);

insert into cars(car_brand, horsepower, AWD) values('Volvo XC90', '249', false);

UPDATE cars SET AWD = true;

SELECT * from cars;

DELETE from cars;

