SELECT * from categories;
DELETE FROM categories WHERE category_name='Comic';
DELETE FROM categories WHERE category_name='Wholesome';
DELETE FROM categories WHERE category_name='Memes';
DELETE FROM categories WHERE category_name='WTF';

SELECT * from categories;
INSERT INTO categories (created_on, category_name) VALUES (CURRENT_TIMESTAMP,'Comic');
INSERT INTO categories (created_on, category_name) VALUES (CURRENT_TIMESTAMP,'Wholesome');
INSERT INTO categories (created_on, category_name) VALUES (CURRENT_TIMESTAMP,'Memes');
INSERT INTO categories (created_on, category_name) VALUES (CURRENT_TIMESTAMP,'WTF');

SELECT * from categories;
