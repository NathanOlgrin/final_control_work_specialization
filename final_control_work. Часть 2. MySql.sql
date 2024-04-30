CREATE DATABASE IF NOT EXISTS Human_Friends;
USE Human_Friends;

CREATE TABLE IF NOT EXISTS Parent_class (
	id INT PRIMARY KEY auto_increment,
    count_animals INT
    );
    
INSERT Parent_class(count_animals) 
VALUES 
(2), /*dogs*/
(2), /*cats*/
(2), /*hamsters*/
(2),  /*horses*/
(2),  /*camels*/
(2);  /*donkeys*/  

CREATE TABLE IF NOT EXISTS Pets(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_animal INT,
    name_type VARCHAR (50),
    FOREIGN KEY (id_animal) REFERENCES Parent_class (id) ON DELETE CASCADE
    );

CREATE TABLE IF NOT EXISTS Pack_animals(
	id INT PRIMARY KEY AUTO_INCREMENT,
    id_animal INT NOT NULL,
    name_type VARCHAR (50),
    FOREIGN KEY (id_animal) REFERENCES Parent_class (id) ON DELETE CASCADE
    );
    
INSERT INTO Pets(id_animal, name_type)
VALUES
(1, 'Овчарка'), 
(1, 'Лабрадор'),
(2, 'Британец'),
(2, 'Сибирская'),
(3, 'Обыкновенный'),
(3, 'Сирийский');

INSERT INTO Pack_animals (id_animal, name_type)
VALUES
(4, 'Арабский'),
(4, 'Бельгийский'),
(5, 'Казахский'),
(5, 'Монгольский'),
(6, 'Испанский'),
(6, 'Пиренейский');

CREATE TABLE IF NOT EXISTS Dogs(
	id INT PRIMARY KEY AUTO_INCREMENT, 
    id_animal_type INT NOT NULL, 
    name VARCHAR (20), 
    birthday DATE,
    command VARCHAR (50),
    FOREIGN KEY (id_animal_type) REFERENCES Pets (id) ON DELETE CASCADE
	);
CREATE TABLE IF NOT EXISTS Cats(
	id INT PRIMARY KEY AUTO_INCREMENT, 
    id_animal_type INT NOT NULL, 
    name VARCHAR (20), 
    birthday DATE,
    command VARCHAR (50),
    FOREIGN KEY (id_animal_type) REFERENCES Pets (id) ON DELETE CASCADE
	);
CREATE TABLE IF NOT EXISTS Hamsters(
	id INT PRIMARY KEY AUTO_INCREMENT, 
    id_animal_type INT NOT NULL, 
    name VARCHAR (20), 
    birthday DATE,
    command VARCHAR (50),
    FOREIGN KEY (id_animal_type) REFERENCES Pets (id) ON DELETE CASCADE
	);
CREATE TABLE IF NOT EXISTS Horses(
	id INT PRIMARY KEY AUTO_INCREMENT, 
    id_animal_type INT NOT NULL, 
    name VARCHAR (20), 
    birthday DATE,
    command VARCHAR (50),
    FOREIGN KEY (id_animal_type) REFERENCES Pack_animals (id) ON DELETE CASCADE
	);
CREATE TABLE IF NOT EXISTS Camels(
	id INT PRIMARY KEY AUTO_INCREMENT, 
    id_animal_type INT NOT NULL, 
    name VARCHAR (20), 
    birthday DATE,
    command VARCHAR (50),
    FOREIGN KEY (id_animal_type) REFERENCES Pack_animals (id) ON DELETE CASCADE
	);
CREATE TABLE IF NOT EXISTS Donkeys(
	id INT PRIMARY KEY AUTO_INCREMENT, 
    id_animal_type INT NOT NULL, 
    name VARCHAR (20), 
    birthday DATE,
    command VARCHAR (50),
    FOREIGN KEY (id_animal_type) REFERENCES Pack_animals (id) ON DELETE CASCADE
	);

INSERT INTO Dogs (id_animal_type, name, birthday, command)
VALUES 
(1, 'Рекс', "2015-07-23", 'сидеть, лежать, место'),
(2, 'Гибралтар', "2000-05-11", 'взять, апорт, догнать');

INSERT INTO Cats (id_animal_type, name, birthday, command)
VALUES 
(3, 'Пушок', "2016-08-07", 'meow-meow-meow'),
(4, 'Барсик', "2021-05-08", 'мяу-мяу-мяу');

INSERT INTO Hamsters (id_animal_type, name, birthday, command)
VALUES
(5, 'Черныш', "2023-08-12", 'пи-пи-пи'),
(6, 'Ами', "2024-01-24", 'تبول-تبول-تبول');

INSERT INTO Horses (id_animal_type, name, birthday, command)
VALUES 
(1, 'Виконт', "2010-07-05", 'рысь, хоп'),
(2, 'Жнец', "2013-09-07", 'шагом, тише');

INSERT INTO Camels (id_animal_type, name, birthday, command)
VALUES
(3, 'Диабар', "2008-09-06", 'лежать, подъем'),
(4, 'Визирь', "2007-03-08", 'подъем, лежать');

INSERT INTO Donkeys (id_animal_type, name, birthday, command)
VALUES
(5, 'Берти', "2021-01-01", 'лежать, подъем'),
(6, 'Дора', "2022-03-03", 'подъем, лежать');

DELETE FROM Parent_class WHERE id=5;

SELECT * FROM Horses UNION SELECT * FROM Donkeys;

CREATE TEMPORARY TABLE IF NOT EXISTS intermidate_table AS 
SELECT * FROM Dogs
UNION SELECT * FROM Cats
UNION SELECT * FROM Hamsters
UNION SELECT * FROM Horses
UNION SELECT * FROM Donkeys;

CREATE TABLE IF NOT EXISTS Young_animals AS
SELECT id_animal_type, name, birthday, command, TIMESTAMPDIFF(MONTH, birthday, CURDATE()) AS age FROM intermidate_table WHERE birthday BETWEEN ADDDATE(CURDATE(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);

SELECT Dogs.id_animal_type, Dogs.name, Dogs.birthday, Dogs.command, Young_animals.age FROM Dogs LEFT JOIN Young_animals ON Dogs.name = Young_animals.name LEFT JOIN Pets ON Pets.id=Dogs.id_animal_type
UNION SELECT Cats.id_animal_type, Cats.name, Cats.birthday, Cats.command, Young_animals.age FROM Cats LEFT JOIN Young_animals ON Cats.name = Young_animals.name LEFT JOIN Pets ON Pets.id=Cats.id_animal_type
UNION SELECT Hamsters.id_animal_type, Hamsters.name, Hamsters.birthday, Hamsters.command, Young_animals.age FROM Hamsters LEFT JOIN Young_animals ON Hamsters.name = Young_animals.name LEFT JOIN Pets ON Pets.id=Hamsters.id_animal_type
UNION SELECT Horses.id_animal_type, Horses.name, Horses.birthday, Horses.command, Young_animals.age FROM Horses LEFT JOIN Young_animals ON Horses.name = Young_animals.name LEFT JOIN Pack_animals ON Pack_animals.id=Horses.id_animal_type
UNION SELECT Donkeys.id_animal_type, Donkeys.name, Donkeys.birthday, Donkeys.command, Young_animals.age FROM Donkeys LEFT JOIN Young_animals ON Donkeys.name = Young_animals.name LEFT JOIN Pack_animals ON Pack_animals.id=Donkeys.id_animal_type;