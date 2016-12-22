CREATE DATABASE  IF NOT EXISTS assignment3;
use assignment3;

DROP TABLE IF EXISTS books;

create table books(
                      id int not null auto_increment,
                      nameOfBook varchar(40) not null,
                      author varchar(20) not null,
                      price double not null, 
                      primary key(id)
                      );

INSERT INTO books(nameOfBook, author, price )
 VALUES ('Head First SQL',' Lynn Beighley',49.67),('Java Servlets and JSP','Michael Urban',57.67),('Head First Servlets and JSP','Kathy Sierra',39.84),('CCNA Cisco Certified Network Associate',' Todd Lammle',46.04);

select * from books;