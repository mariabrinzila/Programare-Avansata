DROP TABLE Movie

DROP TABLE Genre

DROP TABLE GenreForMovie

CREATE TABLE Movie 
(
    id INT NOT NULL PRIMARY KEY,
    title VARCHAR2(30) NOT NULL,
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

INSERT INTO Movie VALUES(1, 'After', TO_DATE('10/08/2019', 'dd/mm/yyyy'), 120, 30);
INSERT INTO Movie VALUES(2, 'After we collided', TO_DATE('22/04/2020', 'dd/mm/yyyy'), 123, 40);
INSERT INTO Movie VALUES(3, 'Suicide Squad', TO_DATE('4/05/2018', 'dd/mm/yyyy'), 130, 25);
INSERT INTO Movie VALUES(4, 'Yes Day', TO_DATE('28/03/2021', 'dd/mm/yyyy'), 103, 50);
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