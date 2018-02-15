/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  684243
 * Created: Feb 13, 2018
 */

INSERT INTO role
    (priviledge_id, description)
VALUES 
    (0,'admin');
INSERT INTO role
    (priviledge_id, description)
VALUES 
    (1,'student');
INSERT INTO role
    (priviledge_id, description)
VALUES 
    (2,'editor');


INSERT INTO department 
    (department_id, name)
VALUES 
    (0,'Information Technology');

INSERT INTO department 
    (department_id, name)
VALUES 
    (1,'Culinary Arts');

INSERT INTO department 
    (department_id, name)
VALUES 
    (2,'Hosptiality');


INSERT INTO [user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('0','password',0,'John Johnson','johnjohnson@gmail.com', 1);

INSERT INTO [user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('1','password',0,'Bob Bobson','bobBobson@gmail.com', 1);

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-307-A',0,'Databasing');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-311-A',0,'Web Application');


INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-352-A',0,'Advanced Object Orientated Programming');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('PNB-101-B',1,'Pastries and Bread');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('MC-101-B',1,'Meat Cutting');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('SS-181-B',1,'Soups and Sauces');


INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('HH-201-B',2,'Hotel Hospitality');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('MH-301-B',2,'Motel Hospitality');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('BNBH-201-B',2,'Bed and Breakfast Hospitality');



INSERT INTO user_course
    (course_code,user_id,year)
VALUES
    ('MH-301-B','1', '2017-Fall');
INSERT INTO user_course
    (course_code,user_id,year)
VALUES
    ('BNBH-201-B','1', '2017-Fall');

INSERT INTO user_course
    (course_code,user_id,year)
VALUES
    ('HH-201-B','0', '2017-Fall');

INSERT INTO user_course
    (course_code,user_id,year)
VALUES
    ('SS-181-B','1', '2017-Fall');
INSERT INTO user_course
    (course_code,user_id,year)
VALUES
    ('MC-101-B','1', '2017-Fall');
INSERT INTO user_course
    (course_code,user_id,year)
VALUES
    ('PNB-101-B','1', '2017-Fall');


INSERT INTO glossary_entry
    (glossary_entry,date_added,made_by)
VALUES
    ('Java','2016-06-03',0);

INSERT INTO definition 
    (definition_uid,glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    (0,'Java','A cup of coffee. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which dont look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isnt anything embarrassing hidden in the middle of text.','2017-10-02',null,'0','HH-201-B','I');
INSERT INTO definition 
    (definition_uid,glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    (1,'Java','A drink you dunk biscuits in. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which dont look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isnt anything embarrassing hidden in the middle of text.','2017-08-01',null,'0','PNB-101-B','I');
INSERT INTO definition 
    (definition_uid,glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    (2,'Java','A programming language. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which dont look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isnt anything embarrassing hidden in the middle of text.','2017-06-03',null,'0','CMPS-352-A', 'I');
INSERT INTO definition 
    (definition_uid,glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    (3,'Java','Coffee. There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which dont look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isnt anything embarrassing hidden in the middle of text.','2016-06-03','https://www.merriam-webster.com/dictionary/java','0',null, 'D');


