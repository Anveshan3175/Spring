--Oracle
CREATE TABLE Person ( id number NOT NULL , name varchar(80) NOT NULL , country varchar(50), PRIMARY KEY (id));

CREATE TABLE Person ( id number NOT NULL , name varchar(80) NOT NULL , country varchar(50), PRIMARY KEY (id));
alter table person add (occupation VARCHAR2(80),age NUMBER);
CREATE TABLE Login ( name varchar(20) NOT NULL,password varchar(20) NOT NULL, PRIMARY KEY (name));

--Mysql
CREATE TABLE Person ( id int(11) unsigned NOT NULL, name varchar(20) NOT NULL,country varchar(20) DEFAULT NULL, PRIMARY KEY (id));

insert into Person values (1,'Ravi','India',23,'IT');
insert into Person values (2,'Anvesh','India',50,'Carpenter');
insert into Person values (3,'Harry','UK',43,'Doctor');

CREATE TABLE Login ( name varchar(20) NOT NULL,password varchar(20) NOT NULL, PRIMARY KEY (name));

insert into Login values ('test','welcome');
insert into Login values ('foo','password');