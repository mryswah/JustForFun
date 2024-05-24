SELECT * from roles;
DELETE FROM roles WHERE name='ADMIN';
DELETE FROM roles WHERE name='USER';

SELECT * from roles;
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');

SELECT * from roles;
