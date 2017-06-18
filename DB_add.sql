DROP DATABASE grapesrain_db;
CREATE DATABASE grapesrain_db;
USE grapesrain_db;

/*Create Tables*/
CREATE TABLE user_role (
				id INT AUTO_INCREMENT, 
                role VARCHAR(60) UNIQUE NOT NULL,
                PRIMARY KEY(id));
                
CREATE TABLE departament (
				id INT AUTO_INCREMENT,
                name VARCHAR(60) UNIQUE NOT NULL,
				PRIMARY KEY(id));
                
CREATE TABLE user (
				id INT AUTO_INCREMENT, 
                first_name VARCHAR(60) UNIQUE NOT NULL, 
                last_name VARCHAR(60) UNIQUE NOT NULL, 
                password VARCHAR(60) NOT NULL,
                phone_number INT,
				email VARCHAR(60) UNIQUE NOT NULL,
                user_role_id INT  NOT NULL, 
                departament_id INT,
				PRIMARY KEY(id), 
                FOREIGN KEY (user_role_id) REFERENCES user_role(id),
                FOREIGN KEY (departament_id) REFERENCES departament(id));
                        
CREATE TABLE request (
				id INT AUTO_INCREMENT, 
				title VARCHAR(120),
				body VARCHAR(1000),
				req_create DATETIME,
				req_close DATETIME,
				status VARCHAR(60),
				prioritet VARCHAR(60),
				creator INT,
				executor INT,
				PRIMARY KEY(id),
				FOREIGN KEY(creator) REFERENCES user(id),
				FOREIGN KEY(executor) REFERENCES user(id));
                    
CREATE TABLE announcement (
				id INT AUTO_INCREMENT,
				title VARCHAR(120),
				body VARCHAR(1000),
				an_create DATETIME,
				begin DATETIME,
				end DATETIME,
				creator INT,
				PRIMARY KEY(id),
				FOREIGN KEY(creator) REFERENCES user(id));
                    

                    
                    
/*first vales*/
INSERT INTO user_role (role) VALUES ('Admin');
INSERT INTO user_role (role) VALUES ('User');
INSERT INTO user_role (role) VALUES ('Secretary');
INSERT INTO user_role (role) VALUES ('Coordinator');
INSERT INTO user_role (role) VALUES ('Head of Department');