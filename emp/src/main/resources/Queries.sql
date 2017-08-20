--DDL
create table tb_login(name varchar(20) not null,password varchar(20) not null,constraint login_pk primary key (name));
 
 
 
--DML
insert into tb_login values ('test','test');