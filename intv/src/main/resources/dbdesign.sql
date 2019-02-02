--DDL
create database intv;
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'anvesh';

create table tb_user_login (
	userid int, 
	username varchar(80) unique not null, 
	password varchar(80) not null,
	PRIMARY KEY (userid));
	
create table tb_questions_category(
	category_id int,
	category_name varchar(40) unique not null,
	category_desc varchar(100),
	PRIMARY KEY (category_id));
	
create table tb_questions (
	question_id int,
	question_category_id int not null, 
	question_desc varchar(400) not null, 
	question_ans varchar(1000),
	PRIMARY KEY (question_id),
	FOREIGN KEY (question_category_id) REFERENCES tb_questions_category(category_id));
	
create table tb_candidate_details(
	candidate_id int,
	candidate_name varchar(40) not null,
	candidate_primary_phone int unique,
	candidate_secondary_phone int,
	candidate_email varchar(100) not null,
	PRIMARY KEY (candidate_id));
	
create table tb_interviews(
	interview_id int,
	interview_mode varchar(40) not null,
	interview_requestor varchar(40) not null,
	interview_desc varchar(100),
	PRIMARY KEY (interview_id));
	
create table tb_candidate_interview(
	candidate_id int,
	interview_id int,
	interview_time date,
	interview_result varchar(40),
	FOREIGN KEY (candidate_id) REFERENCES tb_candidate_details(candidate_id),
	FOREIGN KEY (interview_id) REFERENCES tb_interviews(interview_id));
	
create table tb_candidate_interview_questions(
	question_id int,
	candidate_id int,
	interview_id int,
	candidate_ans varchar(1000),
	FOREIGN KEY (question_id) REFERENCES tb_questions(question_id),
	FOREIGN KEY (candidate_id) REFERENCES tb_candidate_details(candidate_id),
	FOREIGN KEY (interview_id) REFERENCES tb_interviews(interview_id));
	
---------
drop table tb_candidate_interview_questions;
drop table tb_candidate_interview;
drop table tb_interviews;
drop table tb_candidate_details;
drop table tb_questions;
drop table tb_questions_category;
---------

-- DML
insert into tb_user_login values (1000,'tester','admin');

---------