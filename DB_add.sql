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
				priority VARCHAR(60),
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


INSERT INTO departament (name) VALUES ('IT');
INSERT INTO departament (name) VALUES ('Managers');
INSERT INTO departament (name) VALUES ('Buildings');
INSERT INTO departament (name) VALUES ('Development');

INSERT INTO user (first_name, last_name, login, password, email, user_role_id) VALUES ('FAdmin', 'LAdmin', 'Admin', '12345', 'admin@admin.by', 1);
INSERT INTO user (first_name, last_name, login, password, email, user_role_id) VALUES ('FUser', 'LUser', 'User', '12345', 'user@user.by', 2);

INSERT INTO user (first_name, last_name, login, password, email, user_role_id, departament_id) VALUES ('Иван', 'Иванов', 'IvanivI', '12345', 'IvanivI@user.by', 4, 1);
INSERT INTO user (first_name, last_name, login, password, email, user_role_id, departament_id) VALUES ('Петр', 'Петров', 'PetrovP', '12345', 'PetrovP@user.by', 5, 1);
INSERT INTO user (first_name, last_name, login, password, email, user_role_id, departament_id) VALUES ('Бендер', 'Радригес', 'BenderR', '12345', 'BenderR@user.by', 2, 1);
INSERT INTO user (first_name, last_name, login, password, email, user_role_id, departament_id) VALUES ('Сергей', 'Сидоров', 'SidorovS', '12345', 'SidorovS@user.by', 2, 3);

INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('Ничего не работает', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'VERYHIGH', 1, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('Отвалился конфиг', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'MEDIUM', 1, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('Шариков не дали', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'LOW', 1, 1);

INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('WEB не работает', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'MEDIUM', 1, 2);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('Фильтры', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'ACTIVE', 'MEDIUM', 1, 2);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('Принтер', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'CLOSED', 'MEDIUM', 1, 2);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id) VALUES ('Дедлайн близко', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'WAITING', 'MEDIUM', 1, 2);

INSERT INTO request (title, body, req_create, status, priority, creator_user_id) VALUES ('Вот и лето прошло', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'MEDIUM', 1);