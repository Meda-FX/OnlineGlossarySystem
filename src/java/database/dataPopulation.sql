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
INSERT INTO ROLE
    (description)
VALUES
    ('instructor');


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

INSERT INTO [user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('2','password',1,'Aron Alice','aronAlice@gmail.com', 1);

INSERT INTO [user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('3','password',1,'Stephon Curry','stephonCurry@gmail.com', 1);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);
INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('2',3);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('3',4);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);
INSERT INTO user_role
    (user_id,privilege_id)
VALUES
    ('0',3);

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
INSERT INTO glossary_entry
    (glossary_entry,date_added,made_by)
VALUES
    ('JavaScript','2016-06-03','0');


INSERT INTO definition 
    (glossary_entry,definition,dictionary_definition, date_created,citation, dictionary_citation,made_by,course_code)
VALUES
    ('Java','A cup of coffee','COFFEE','2017-10-02',null,'https://www.merriam-webster.com/dictionary/java?src=search-dict-box','0','HH-201-B');
INSERT INTO definition 
    (glossary_entry,definition,dictionary_definition, date_created,citation, dictionary_citation,made_by,course_code)
VALUES
    ('Java','A drink you dunk biscuits in','COFFEE','2017-08-01',null,'https://www.merriam-webster.com/dictionary/java?src=search-dict-box','0','PNB-101-B');



INSERT INTO definition 
    (glossary_entry,definition,dictionary_definition, date_created,citation, dictionary_citation,made_by,course_code)
VALUES
    ('Cookie','Put out beside coffee',' a small flat or slightly raised cake ','2017-12-01',null,'https://www.merriam-webster.com/dictionary/cookie','0','HH-201-B');
INSERT INTO definition 
    (glossary_entry,definition,dictionary_definition, date_created,citation, dictionary_citation,made_by,course_code)
VALUES
    ('Cookie','A dessert disk','a small flat or slightly raised cake ','2017-08-01',null,'https://www.merriam-webster.com/dictionary/cookie','0','PNB-101-B');
INSERT INTO definition 
    (glossary_entry,definition,dictionary_definition, date_created,citation, dictionary_citation,made_by,course_code)
VALUES
    ('Cookie','A way for browsers to store information','a small flat or slightly raised cake ','2017-06-03',null,'https://www.merriam-webster.com/dictionary/cookie','0','CMPS-352-A');


