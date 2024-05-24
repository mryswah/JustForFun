SELECT * from labels;
DELETE FROM labels WHERE label_name='rage comic';
DELETE FROM labels WHERE label_name='awesome';
DELETE FROM labels WHERE label_name='humour';
DELETE FROM labels WHERE label_name='random';

SELECT * from labels;
INSERT INTO labels (created_on, label_name) VALUES (CURRENT_TIMESTAMP,'rage comic');
INSERT INTO labels (created_on, label_name) VALUES (CURRENT_TIMESTAMP,'awesome');
INSERT INTO labels (created_on, label_name) VALUES (CURRENT_TIMESTAMP,'humour');
INSERT INTO labels (created_on, label_name) VALUES (CURRENT_TIMESTAMP,'random');

SELECT * from labels;
