--Oracle
conn / as sysdba;
create user cts identified by cts;
grant create session to cts;
create tablespace cts_tablespace  datafile 'cts_tablespace.dat'  size 50M autoextend on;
create temporary tablespace cts_tablespace_temp  tempfile 'cts_tablespace_temp.dat'  size 5M autoextend on;
grant create table to cts;
grant unlimited tablespace to cts;
GRANT create view TO cts;
GRANT create any trigger TO cts;
GRANT create any procedure TO cts;
GRANT create sequence TO cts;
GRANT create synonym TO cts;
------------------DDL---------------------
-- tables
create table tb_user_login (userid number,username varchar(80) unique, password varchar(80) not null, salt varchar(20), PRIMARY KEY (userid));
create table tb_candidate_dtls (id number, name varchar(80) not null unique,email varchar(80) unique, mobile number,experience number,city varchar(80), company varchar(50),noticeperiod number, PRIMARY KEY (id));
create table tb_skills (id number,name varchar(80) not null unique ,description varchar(500),PRIMARY KEY (id));
create table tb_candidate_skills (candidateid number,skillid number, CONSTRAINT fk_cid_category FOREIGN KEY (candidateid) REFERENCES tb_candidate_dtls (id),CONSTRAINT fk_sid_category FOREIGN KEY (skillid) REFERENCES tb_skills (id));
-- sequence
CREATE SEQUENCE candidate_seq START WITH 1000 INCREMENT BY   1 NOCACHE NOCYCLE;

------------------DDL---------------------

------------------DML---------------------
insert into tb_user_login values (100,'test','tester',null);
insert into tb_user_login values (101,'admin','admin',null);

insert into tb_skills values (1,'JAVA','Java Lanaguage');
insert into tb_skills values (2,'J2EE','J2EE Lanaguage');
insert into tb_skills values (3,'ORACLE','ORACLE Lanaguage'); 
insert into tb_skills values (4,'SALESFORCE','SALESFORCE Lanaguage');
insert into tb_skills values (5,'ADF','ADF Lanaguage');
insert into tb_skills values (6,'BI','BI Lanaguage');

------------------DML---------------------