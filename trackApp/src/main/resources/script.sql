--Oracle
conn / as sysdba;
create user trackapp identified by trackapp;
grant create session to trackapp;
create tablespace tap_tablespace  datafile 'tap_tablespace.dat'  size 50M autoextend on;
create temporary tablespace tap_tablespace_temp  tempfile 'tap_tablespace_temp.dat'  size 5M autoextend on;
grant create table to trackapp;
grant unlimited tablespace to trackapp;
GRANT create view TO trackapp;
GRANT create any trigger TO trackapp;
GRANT create any procedure TO trackapp;
GRANT create sequence TO trackapp;
GRANT create synonym TO trackapp;

create table tb_user_login (userid number,username varchar(80) unique, password varchar(80) not null, salt varchar(20), PRIMARY KEY (userid));
insert into tb_user_login values (100,'test','tester',null);
insert into tb_user_login values (101,'admin','admin',null);

CREATE TABLE tb_customer_personal_dtls ( custid number , firstname varchar(255) NOT NULL ,lastname varchar(255), phone number,email varchar(255),city varchar(255), PRIMARY KEY (custid));
insert into tb_customer_personal_dtls values (1000,'testFName','testLName', 999999999,'abc@gmail.com','testCity');
insert into tb_customer_personal_dtls values (1001,'sampleFName','sampeLName', 999999999,'ced@gmail.com','sampleCity');


--Mysql