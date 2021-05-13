DROP TABLE person;

CREATE TABLE person
(
	id integer NOT NULL PRIMARY KEY,
	name varchar(100) NOT NULL
)

INSERT INTO person (id, name) VALUES (1, 'Maria Brinzila');

SELECT * FROM person;