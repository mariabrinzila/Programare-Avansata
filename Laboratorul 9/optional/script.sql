DROP TABLE Movie

DROP TABLE Genre

DROP TABLE GenreForMovie

DROP TABLE Person

DROP TABLE PersonForMovie

DROP TABLE Chart

DROP TABLE MovieForChart

CREATE TABLE Movie 
(
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    release_date DATE NOT NULL,
    duration NUMBER NOT NULL,
    score INT
)

CREATE TABLE Genre 
(
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR2(30) NOT NULL
)

CREATE TABLE GenreForMovie
(
    movieId INT NOT NULL,
    genreId INT NOT NULL,
    PRIMARY KEY(movieId, genreId),
    CONSTRAINT fk_GenreForMovie_movieId FOREIGN KEY (movieId) REFERENCES Movie(id),
    CONSTRAINT fk_GenreForMovie_genreId FOREIGN KEY (genreId) REFERENCES Genre(id)
)

CREATE TABLE Person
(
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    birthdate DATE NOT NULL,
    deathdate DATE,
    age NUMBER NOT NULL,
    nationality VARCHAR2(20) NOT NULL,
    rank INT
)

CREATE TABLE PersonForMovie
(
    job VARCHAR2(20) NOT NULL, /* actor or director */
    movieId INT NOT NULL,
    personId INT NOT NULL,
    PRIMARY KEY(movieId, personId),
    CONSTRAINT fk_PersonForMovie_movieId FOREIGN KEY (movieId) REFERENCES Movie(id),
    CONSTRAINT fk_PersonForMovie_personId FOREIGN KEY (personId) REFERENCES Person(id)
)

CREATE TABLE Chart
(
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR2(50) NOT NULL,
    creation DATE NOT NULL
)

CREATE TABLE MovieForChart
(
    movieId INT NOT NULL,
    chartId INT NOT NULL,
    PRIMARY KEY(movieId, chartId)
)

INSERT INTO Movie VALUES(1, 'Pirates of the Caribbean', TO_DATE('10/08/2019', 'dd/mm/yyyy'), 120, 30);
INSERT INTO Movie VALUES(2, 'Bombshell', TO_DATE('22/04/2020', 'dd/mm/yyyy'), 123, 40);
INSERT INTO Movie VALUES(3, 'Gone with the wind', TO_DATE('4/05/2018', 'dd/mm/yyyy'), 130, 25);
INSERT INTO Movie VALUES(4, 'Divergent', TO_DATE('28/03/2021', 'dd/mm/yyyy'), 103, 50);
INSERT INTO Movie VALUES(5, 'Dynasty', TO_DATE('31/01/2017', 'dd/mm/yyyy'), 103, 50);

INSERT INTO Genre VALUES(10, 'Action');
INSERT INTO Genre VALUES(11, 'Fantasy');
INSERT INTO Genre VALUES(12, 'Comedy');
INSERT INTO Genre VALUES(13, 'Mystery');
INSERT INTO Genre VALUES(14, 'Romance');
INSERT INTO Genre VALUES(15, 'Family');

INSERT INTO GenreForMovie VALUES(1, 14);
INSERT INTO GenreForMovie VALUES(2, 11);
INSERT INTO GenreForMovie VALUES(3, 10);
INSERT INTO GenreForMovie VALUES(4, 15);
INSERT INTO GenreForMovie VALUES(5, 12);

INSERT INTO Person VALUES(20, 'Johnny Depp', TO_DATE('9/06/1963', 'dd/mm/yyyy'), NULL, 58, 'american', 9);
INSERT INTO Person VALUES(21, 'Charlize Theron', TO_DATE('7/08/1975', 'dd/mm/yyyy'), NULL, 46, 'african', 5);
INSERT INTO Person VALUES(22, 'Tom Cruise', TO_DATE('3/07/1962', 'dd/mm/yyyy'), NULL, 59, 'american', 8);
INSERT INTO Person VALUES(23, 'Vivien Leigh', TO_DATE('5/11/1913', 'dd/mm/yyyy'), TO_DATE('8/07/1967', 'dd/mm/yyyy'), 53, 'indian', 10);
INSERT INTO Person VALUES(24, 'Tom Hanks', TO_DATE('9/07/1956', 'dd/mm/yyyy'), NULL, 58, 'american', 10);
INSERT INTO Person VALUES(25, 'Kate Winslet', TO_DATE('5/10/1975', 'dd/mm/yyyy'), NULL, 46, 'british', 9);
INSERT INTO Person VALUES(26, 'Rob Marshall', TO_DATE('17/10/1960', 'dd/mm/yyyy'), NULL, 61, 'american', 7);
INSERT INTO Person VALUES(27, 'Victor Fleming', TO_DATE('23/02/1889', 'dd/mm/yyyy'), TO_DATE('6/01/1949', 'dd/mm/yyyy'), 60, 'american', 10);
INSERT INTO Person VALUES(28, 'Neil Burger', TO_DATE('18/12/1963', 'dd/mm/yyyy'), NULL, 58, 'american', 8);
INSERT INTO Person VALUES(29, 'Stephanie Savage', TO_DATE('29/04/1969', 'dd/mm/yyyy'), NULL, 52, 'canadian', 6);
INSERT INTO Person VALUES(30, 'Martin Scorsese', TO_DATE('17/11/1942', 'dd/mm/yyyy'), NULL, 79, 'american', 9);

INSERT INTO PersonForMovie VALUES('actor', 1, 20);
INSERT INTO PersonForMovie VALUES('actor', 2, 21);
INSERT INTO PersonForMovie VALUES('actor', 3, 22);
INSERT INTO PersonForMovie VALUES('actor', 4, 25);
INSERT INTO PersonForMovie VALUES('director', 1, 26);
INSERT INTO PersonForMovie VALUES('director', 2, 27);
INSERT INTO PersonForMovie VALUES('director', 3, 28);

INSERT INTO Chart VALUES(1, 'Liked Movies', SYSDATE);
INSERT INTO Chart VALUES(2, 'Disliked Movies', TO_DATE('14/04/2020', 'dd/mm/yyyy'));

INSERT INTO MovieForChart VALUES(1, 1);
INSERT INTO MovieForChart VALUES(1, 3);
INSERT INTO MovieForChart VALUES(1, 4);
INSERT INTO MovieForChart VALUES(2, 3);
INSERT INTO MovieForChart VALUES(2, 1);

SELECT * FROM MovieForChart;

SELECT * FROM Person;

/* every movie and every actor that starred in each movie in the database */
SELECT title, fullName FROM Movie m
    JOIN PersonForMovie pm ON m.id = pm.movieId
    JOIN Person p ON p.id = pm.personId
    WHERE pm.job = 'actor';