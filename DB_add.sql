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
                login VARCHAR(60) NOT NULL,
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
				creator_user_id INT,
				executor_user_id INT,
				PRIMARY KEY(id),
				FOREIGN KEY(creator_user_id) REFERENCES user(id),
				FOREIGN KEY(executor_user_id) REFERENCES user(id));
                    
CREATE TABLE announcement (
				id INT AUTO_INCREMENT,
				title VARCHAR(120),
				body VARCHAR(1000),
				an_create DATETIME,
				begin DATETIME,
				end DATETIME,
				creator_user_id INT,
				PRIMARY KEY(id),
				FOREIGN KEY(creator_user_id) REFERENCES user(id));
                    

                    
                    
/*first vales*/
INSERT INTO user_role (role) VALUES ('Admin');
INSERT INTO user_role (role) VALUES ('User');
INSERT INTO user_role (role) VALUES ('Secretary');
INSERT INTO user_role (role) VALUES ('Coordinator');
INSERT INTO user_role (role) VALUES ('Head of Department');

INSERT INTO user (first_name, last_name, login, password, email, user_role_id, phone_number) VALUES ('FAdmin', 'LAdmin', 'Admin', '12345', 'admin@admin.by', 1, 12345);
INSERT INTO user (first_name, last_name, login, password, email, user_role_id, phone_number) VALUES ('FUser', 'LUser', 'User', '12345', 'user@user.by', 2, 12345);