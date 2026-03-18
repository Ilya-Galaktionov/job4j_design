CREATE TABLE fauna
(
    id SERIAL PRIMARY KEY,
    name TEXT,
    avg_age INT,
    discovery_date DATE
);

INSERT INTO fauna(name, avg_age, discovery_date) VALUES
('African Elephant', 23741, '1797-01-01'),
('Lion', 5113, '1758-01-01'),
('Emperor Penguin', 7305, '1844-01-01'),
('Red Kangaroo', 8400, '1822-01-01'),
('Common Dolphin', 9131, '1758-01-01'),
('Brown Bear', 10957, '1758-01-01'),
('Clownfish', 3652, '1730-01-01'),
('Swordfish', 5478, '1758-01-01'),
('Domestic Cat', 5478, null);

SELECT * FROM fauna WHERE name LIKE '%fish';
SELECT * FROM fauna WHERE avg_age BETWEEN 10000 AND 21000;
SELECT * FROM fauna WHERE discovery_date IS NULL;
SELECT * FROM fauna WHERE discovery_date < '1950-01-01';