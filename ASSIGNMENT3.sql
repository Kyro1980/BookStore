CREATE DATABASE  IF NOT EXISTS assignment3;
use assignment3;

DROP TABLE IF EXISTS logInInf;

create table logInInf(
                      id int not null auto_increment,
                      userId varchar(20) not null,
                      firstName varchar(20) not null,
                      lastName varchar(20) not null,
                      paswr varchar(15) not null, 
                      primary key(id)
                      );

INSERT INTO logInInf(userId,firstName,lastName,paswr)
 VALUES ('Mary80','Mary','Public',"12345"),('Joen75','John','Doe','54321'),('Bill99','Bill','Neely','09876');

select * from logInInf;
