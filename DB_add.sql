DROP DATABASE grapesrain_db;
-- CREATE DATABASE grapesrain_db charset=utf8;
CREATE DATABASE grapesrain_db;
USE grapesrain_db;

/*Create Tables*/
CREATE TABLE role (
				id INT AUTO_INCREMENT, 
                role VARCHAR(60) UNIQUE NOT NULL,
                PRIMARY KEY(id));
                
               
CREATE TABLE departament (
				id INT AUTO_INCREMENT,
                name VARCHAR(60) UNIQUE NOT NULL,
                version INT,
				PRIMARY KEY(id));
                
CREATE TABLE user (
				id INT AUTO_INCREMENT, 
                first_name VARCHAR(60) UNIQUE NOT NULL, 
                last_name VARCHAR(60) UNIQUE NOT NULL,
                login VARCHAR(60) NOT NULL,
                password VARCHAR(60) NOT NULL,
				email VARCHAR(60) UNIQUE NOT NULL,
                departament_id INT,
                version INT,
				PRIMARY KEY(id), 
                FOREIGN KEY (departament_id) REFERENCES departament(id));
                
CREATE TABLE user_card (
				id INT AUTO_INCREMENT, 
				user_id INT NOT NULL,
                first_model_device VARCHAR(60),
                first_mac_address VARCHAR(60),
                second_model_device VARCHAR(60),
                second_mac_address VARCHAR(60),
                pc_ownership VARCHAR(60),
                version INT,
				PRIMARY KEY(id), 
                FOREIGN KEY (user_id) REFERENCES user(id));
                        
CREATE TABLE users_roles (
				role_id INT NOT NULL,
                user_id INT NOT NULL,
                FOREIGN KEY (role_id) REFERENCES role(id),
                FOREIGN KEY (user_id) REFERENCES user(id),
                PRIMARY KEY(role_id, user_id));                        

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
                departament_id INT,
				PRIMARY KEY(id),
				FOREIGN KEY(creator_user_id) REFERENCES user(id),
                FOREIGN KEY (departament_id) REFERENCES departament(id),
				FOREIGN KEY(executor_user_id) REFERENCES user(id));
                    
CREATE TABLE requestanswer (
				id INT AUTO_INCREMENT, 
                request_id INT,
				body VARCHAR(1000),
				respondent_user_id INT,
                publicateDate DATETIME,
				PRIMARY KEY(id),
				FOREIGN KEY(respondent_user_id) REFERENCES user(id),
                FOREIGN KEY (request_id) REFERENCES request(id));
                
CREATE TABLE faq (
				id INT AUTO_INCREMENT, 
                request_id INT,
                title VARCHAR(100),
				body VARCHAR(1000),
                solution VARCHAR(1000),
				respondent_user_id INT,
                publicateDate DATETIME,
				PRIMARY KEY(id),
				FOREIGN KEY(respondent_user_id) REFERENCES user(id),
                FOREIGN KEY (request_id) REFERENCES request(id));
				
CREATE TABLE announcement (
				id INT AUTO_INCREMENT,
				title VARCHAR(120),
				body VARCHAR(1000),
				an_create DATETIME,
				begin DATETIME,
				end DATETIME,
                departament_id INT,
				creator_user_id INT,
				PRIMARY KEY(id),
                FOREIGN KEY (departament_id) REFERENCES departament(id),
				FOREIGN KEY(creator_user_id) REFERENCES user(id));
                    

                    
                    
/*first vales*/
INSERT INTO role (role) VALUES ('Admin');
INSERT INTO role (role) VALUES ('User');
INSERT INTO role (role) VALUES ('Secretary');
INSERT INTO role (role) VALUES ('Coordinator');
INSERT INTO role (role) VALUES ('Head of Department');


INSERT INTO departament (name, version) VALUES ('IT', 1);
INSERT INTO departament (name, version) VALUES ('Managers', 1);
INSERT INTO departament (name, version) VALUES ('Buildings', 1);
INSERT INTO departament (name, version) VALUES ('Development', 1);

INSERT INTO user (first_name, last_name, login, password, email, departament_id) 
	VALUES ('FAdmin', 'LAdmin', 'Admin', '$2a$10$udT6ECih3K62N/sd5lZFKeeN7bv3nSfs3y2gbNzoc5.4a4u0ZjC/2', 'admin@admin.by', 1);

INSERT INTO user (first_name, last_name, login, password, email, departament_id) 
	VALUES ('FUser', 'LUser', 'User', '$2a$10$udT6ECih3K62N/sd5lZFKeeN7bv3nSfs3y2gbNzoc5.4a4u0ZjC/2', 'user@user.by', 4);
INSERT INTO user (first_name, last_name, login, password, email, departament_id) 
	VALUES ('Иван', 'Иванов', 'IvanivI', '$2a$10$udT6ECih3K62N/sd5lZFKeeN7bv3nSfs3y2gbNzoc5.4a4u0ZjC/2', 'IvanivI@user.by', 1);
INSERT INTO user (first_name, last_name, login, password, email, departament_id) 
	VALUES ('Петр', 'Петров', 'PetrovP', '$2a$10$udT6ECih3K62N/sd5lZFKeeN7bv3nSfs3y2gbNzoc5.4a4u0ZjC/2', 'PetrovP@user.by', 1);
INSERT INTO user (first_name, last_name, login, password, email, departament_id) 
	VALUES ('Бендер', 'Радригес', 'BenderR', '$2a$10$udT6ECih3K62N/sd5lZFKeeN7bv3nSfs3y2gbNzoc5.4a4u0ZjC/2', 'BenderR@user.by', 1);
INSERT INTO user (first_name, last_name, login, password, email, departament_id)
	VALUES ('Сергей', 'Сидоров', 'SidorovS', '$2a$10$udT6ECih3K62N/sd5lZFKeeN7bv3nSfs3y2gbNzoc5.4a4u0ZjC/2', 'SidorovS@user.by', 4);

INSERT INTO users_roles (role_id, user_id) VALUES (1, 1);
INSERT INTO users_roles (role_id, user_id) VALUES (2, 2);
INSERT INTO users_roles (role_id, user_id) VALUES (4, 2);
INSERT INTO users_roles (role_id, user_id) VALUES (2, 3);
INSERT INTO users_roles (role_id, user_id) VALUES (2, 4);
INSERT INTO users_roles (role_id, user_id) VALUES (2, 5);
INSERT INTO users_roles (role_id, user_id) VALUES (3, 5);
INSERT INTO users_roles (role_id, user_id) VALUES (2, 6);
INSERT INTO users_roles (role_id, user_id) VALUES (5, 6);


INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);

INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id)
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
		VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Не работает dao', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'HIGH', 1, 2, 1);

INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Ничего не работает', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'VERYHIGH', 1, 1, 1);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Отвалился конфиг', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'MEDIUM', 1, 1, 4);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Шариков не дали', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'LOW', 1, 1, 1);

INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('WEB не работает', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'MEDIUM', 1, 2, 2);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Фильтры', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'ACTIVE', 'MEDIUM', 1, 2, 3);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Принтер', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'CLOSED', 'MEDIUM', 1, 2, 2);
INSERT INTO request (title, body, req_create, status, priority, creator_user_id, executor_user_id, departament_id) 
	VALUES ('Дедлайн близко', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'WAITING', 'MEDIUM', 1, 2, 2);

INSERT INTO request (title, body, req_create, status, priority, creator_user_id, departament_id) 
	VALUES ('Вот и лето прошло', 'В dao методы не работают, всё крышится, всё очень плохо', '2017-01-11', 'OPEN', 'MEDIUM', 1, 1);


INSERT INTO requestanswer (request_id, body, respondent_user_id, answerDate) VALUES (1, 'Вы выключали и включали компьютер ?', 1, '2017-01-11');
INSERT INTO requestanswer (request_id, body, respondent_user_id, answerDate) VALUES (1, 'Попробуйте постучать по колёсам и протереть стёкла', 2, '2017-01-11');
INSERT INTO requestanswer (request_id, body, respondent_user_id, answerDate) VALUES (1, 'Сколько вы видите клавишь на клавиатуре ?', 1, '2017-01-11');
INSERT INTO requestanswer (request_id, body, respondent_user_id, answerDate) VALUES (2, 'Тук тук нео ...', 1, '2017-01-11');