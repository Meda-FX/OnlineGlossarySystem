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
    ( description)
VALUES 
    ('admin');
INSERT INTO role
    (description)
VALUES 
    ('student');
INSERT INTO role
    (description)
VALUES 
    ('editor');


INSERT INTO department 
    (name)
VALUES 
    ('Information Technology');

INSERT INTO department 
    ( name)
VALUES 
    ('Culinary Arts');

INSERT INTO department 
    ( name)
VALUES 
    ('Hosptiality');


INSERT INTO [user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('0','password',1,'John Johnson','johnjohnson@gmail.com', 1);

INSERT INTO [user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('1','password',1,'Bob Bobson','bobBobson@gmail.com', 1);

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-307-A','1','Databasing');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-311-A','1','Web Application');


INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-352-A','1','Advanced Object Orientated Programming');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('PNB-101-B','2','Pastries and Bread');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('MC-101-B','2','Meat Cutting');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('SS-181-B','2','Soups and Sauces');


INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('HH-201-B','3','Hotel Hospitality');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('MH-301-B','3','Motel Hospitality');

INSERT INTO course
    (course_code,department_id,course_name)
VALUES 
    ('BNBH-201-B','3','Bed and Breakfast Hospitality');



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
    ('Java','2016-06-03','0');
INSERT INTO glossary_entry
    (glossary_entry,date_added,made_by)
VALUES
    ('Cookie','2016-06-03','0');


INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Java','A cup of coffee','2017-10-02',null,'0','HH-201-B','I');
INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Java','A drink you dunk biscuits in','2017-08-01',null,'0','PNB-101-B','I');
INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Java','A programming language','2017-06-03',null,'0','CMPS-352-A', 'I');
INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Java','Coffee','2016-06-03','https://www.merriam-webster.com/dictionary/java','0',null, 'D');


INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Cookie','Put out beside coffee','2017-12-01',null,'0','HH-201-B','I');
INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Cookie','A dessert disk','2017-08-01',null,'0','PNB-101-B','I');
INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Cookie','A way for browsers to store information','2017-06-03',null,'0','CMPS-352-A', 'I');
INSERT INTO definition 
    (glossary_entry,definition, date_created,citation,made_by,course_code,[type])
VALUES
    ('Cookie','A round sweet treat','2016-06-03','https://www.merriam-webster.com/dictionary/java','0',null, 'D');
