CREATE TABLE IF NOT EXISTS Employee(
ID INTEGER NOT NULL AUTO_INCREMENT,
 
Fistname VARCHAR(255),
 
Secondname VARCHAR(255),

Phonenumber  VARCHAR(255),
Salary INTEGER,
id_department INTEGER,
FOREIGN KEY (id_department) REFERENCES department(ID),
PRIMARY KEY (ID)
);

