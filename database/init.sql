CREATE TABLE IF NOT EXISTS movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    language VARCHAR(50) NOT NULL,
    genre VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS bookings (
    id BIGINT PRIMARY KEY,
    customer_name VARCHAR(100) NOT NULL,
    movie_id INT NOT NULL,
    number_of_tickets INT NOT NULL
);

INSERT INTO movies (name, language, genre)
SELECT 'Avengers', 'English', 'Action'
WHERE NOT EXISTS (
    SELECT 1 FROM movies WHERE name = 'Avengers'
);

INSERT INTO movies (name, language, genre)
SELECT 'RRR', 'Telugu', 'Action'
WHERE NOT EXISTS (
    SELECT 1 FROM movies WHERE name = 'RRR'
);

INSERT INTO movies (name, language, genre)
SELECT 'Leo', 'Tamil', 'Action'
WHERE NOT EXISTS (
    SELECT 1 FROM movies WHERE name = 'Leo'
);

INSERT INTO bookings
(id, customer_name, movie_id, number_of_tickets)
SELECT 1, 'Lokesh', 1, 2
WHERE NOT EXISTS (
    SELECT 1 FROM bookings WHERE id = 1
);
