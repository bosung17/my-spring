DROP DATABASE IF EXISTS spring_test;	-- spring_test라는 db가 이미 존재하면 없애기
CREATE DATABASE spring_test;	-- spring_test db 만들기
USE spring_test;	-- spring_test db 사용

CREATE TABLE specialty (	-- specialty 테이블 만들기
    specialty_code INT PRIMARY KEY, 	-- 고유키로 specialty_code column 만들기
    specialty_name VARCHAR(100) NOT NULL  	-- NOT NULL인 column specialty_name 만들기
);

CREATE TABLE doctor (
    doctor_id INT PRIMARY KEY, 
    name VARCHAR(100) NOT NULL, 
    age INT NOT NULL, 
    specialty_code INT, 
    experience_years INT, 
    FOREIGN KEY (specialty_code) REFERENCES specialty(specialty_code) 	-- 외래키로 specialty 테이블에 있는 specialty_code 사용
);