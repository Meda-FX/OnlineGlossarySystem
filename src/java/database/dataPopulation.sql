/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  684243
 * Created: Feb 13, 2018
 */

INSERT INTO [GlossaryDataBase].[dbo].[role]
    ( description)
VALUES 
    ('admin');
INSERT INTO [GlossaryDataBase].[dbo].[role]
    (description)
VALUES 
    ('student');
INSERT INTO [GlossaryDataBase].[dbo].[role]
    (description)
VALUES 
    ('editor');
INSERT INTO [GlossaryDataBase].[dbo].[role]
    (description)
VALUES
    ('instructor');


INSERT INTO [GlossaryDataBase].[dbo].[department] 
    (name)
VALUES 
    ('Information Technology');

INSERT INTO [GlossaryDataBase].[dbo].[department] 
    ( name)
VALUES 
    ('Culinary Arts');

INSERT INTO [GlossaryDataBase].[dbo].[department] 
    ( name)
VALUES 
    ('Hosptiality');


INSERT INTO [GlossaryDataBase].[dbo].[user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('0','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',1,'John Johnson','johnjohnson@gmail.com', 1);

INSERT INTO [GlossaryDataBase].[dbo].[user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('1','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',1,'Bob Bobson','bobBobson@gmail.com', 1);

INSERT INTO [GlossaryDataBase].[dbo].[user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('2','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',1,'Aron Alice','aronAlice@gmail.com', 1);

INSERT INTO [GlossaryDataBase].[dbo].[user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('3','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',1,'Stephon Curry','stephonCurry@gmail.com', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user]
VALUES ('4', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 1, 'Javen Liang', 'javenliang.sait@gmail.com', 1);


INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);


INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('2',3);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('3',4);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('0',1);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('1',2);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id,privilege_id)
VALUES
    ('0',3);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
VALUES ('4', 1);

INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-307-A','1','Databasing');

INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-311-A','1','Web Application');


INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('CMPS-352-A','1','Advanced Object Orientated Programming');

INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('PNB-101-B','2','Pastries and Bread');

INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('MC-101-B','2','Meat Cutting');

INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('SS-181-B','2','Soups and Sauces');


INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('HH-201-B','3','Hotel Hospitality');

INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('MH-301-B','3','Motel Hospitality');

INSERT INTO [GlossaryDataBase].[dbo].[course]
    (course_code,department_id,course_name)
VALUES 
    ('BNBH-201-B','3','Bed and Breakfast Hospitality');




INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('MH-301-B','1', '2017-Fall');
INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('CMPS-307-A','2', '2017-Fall');
INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('CMPS-352-A','2', '2017-Fall');
INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('BNBH-201-B','1', '2017-Fall');

INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('HH-201-B','0', '2017-Fall');

INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('SS-181-B','1', '2017-Fall');
INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('MC-101-B','1', '2017-Fall');
INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('PNB-101-B','1', '2017-Fall');

INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('SS-181-B','3', '2017-Fall');
INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('MC-101-B','3', '2017-Fall');
INSERT INTO [GlossaryDataBase].[dbo].[user_course]
    (course_code,user_id,year)
VALUES
    ('PNB-101-B','3', '2017-Fall');

INSERT INTO [GlossaryDataBase].[dbo].[glossary_entry]
    (glossary_entry,date_added,made_by)
VALUES
    ('Java','2016-06-03','0');
INSERT INTO [GlossaryDataBase].[dbo].[glossary_entry]
    (glossary_entry,date_added,made_by)
VALUES
    ('Cookie','2016-06-03','0');
INSERT INTO [GlossaryDataBase].[dbo].[glossary_entry]
    (glossary_entry,date_added,made_by)
VALUES
    ('JavaScript','2016-06-03','0');


INSERT INTO [GlossaryDataBase].[dbo].[definition] 
    (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code)
VALUES
    ('Java','Java is a widely used programming language expressly designed for use in the distributed environment of the internet. It is the most popular programming language for Android smartphone applications and is among the most favored for edge device and internet of things development.','COFFEE','2017-10-02','Cited here','Published','https://www.merriam-webster.com/dictionary/java?src=search-dict-box','1','HH-201-B');
INSERT INTO [GlossaryDataBase].[dbo].[definition] 
    (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code)
VALUES
    ('Java','Java was designed to have the look and feel of the C++ language, but it is simpler to use than C++ and enforces an object-oriented programming model. Java can be used to create complete applications that may run on a single computer or be distributed among servers and clients in a network. It can also be used to build a small application module or applet for use as part of a webpage.','COFFEE','2017-08-01','cited there', 'Under Review','https://www.merriam-webster.com/dictionary/java?src=search-dict-box','1','PNB-101-B')
INSERT INTO [GlossaryDataBase].[dbo].[definition]
    (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code)
VALUES
    ('JavaScript','JavaScript, often abbreviated as JS, is a high-level, interpreted programming language. It is a language which is also characterized as dynamic, weakly typed, prototype-based and multi-paradigm','COFFEE','2017-08-01','Wikipedia', 'In Progress','https://www.merriam-webster.com/dictionary/java?src=search-dict-box','1','PNB-101-B');



INSERT INTO [GlossaryDataBase].[dbo].[definition]
    (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code)
VALUES
    ('Cookie','Put out beside coffee',' a small flat or slightly raised cake ','2017-12-01','I used Google','Published','https://www.merriam-webster.com/dictionary/cookie','1','HH-201-B');
INSERT INTO [GlossaryDataBase].[dbo].[definition]
    (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code)
VALUES
    ('Cookie','A dessert disk','a small flat or slightly raised cake ','2017-08-01','DuckDuckGo for the win','Published','https://www.merriam-webster.com/dictionary/cookie','1','PNB-101-B');
INSERT INTO [GlossaryDataBase].[dbo].[definition]
    (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code)
VALUES
    ('Cookie','A way for browsers to store information','a small flat or slightly raised cake ','2017-06-03','Bing?','Published','https://www.merriam-webster.com/dictionary/cookie','0','CMPS-352-A');

INSERT INTO [GlossaryDataBase].[dbo].[definition]
    (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code)
VALUES
    ('Java','A way for browsers to store information','a small flat or slightly raised cake ','2017-06-03','Bing?','Published','https://www.merriam-webster.com/dictionary/cookie','0','CMPS-307-A');

