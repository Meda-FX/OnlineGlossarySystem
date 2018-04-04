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
INSERT INTO [department] (name) VALUES ('Information0');
INSERT INTO [department] (name) VALUES ('Information1');
INSERT INTO [department] (name) VALUES ('Information2');
INSERT INTO [department] (name) VALUES ('Information3');
INSERT INTO [department] (name) VALUES ('Information4');
INSERT INTO [department] (name) VALUES ('Information5');
INSERT INTO [department] (name) VALUES ('Information6');
INSERT INTO [department] (name) VALUES ('Information7');
INSERT INTO [department] (name) VALUES ('Information8');
INSERT INTO [department] (name) VALUES ('Information9');
INSERT INTO [department] (name) VALUES ('Information10');
INSERT INTO [department] (name) VALUES ('Information11');
INSERT INTO [department] (name) VALUES ('Information12');
INSERT INTO [department] (name) VALUES ('Information13');
INSERT INTO [department] (name) VALUES ('Information14');
INSERT INTO [department] (name) VALUES ('Information15');
INSERT INTO [department] (name) VALUES ('Information16');
INSERT INTO [department] (name) VALUES ('Information17');
INSERT INTO [department] (name) VALUES ('Information18');
INSERT INTO [department] (name) VALUES ('Information19');
INSERT INTO [department] (name) VALUES ('Information20');
INSERT INTO [department] (name) VALUES ('Information21');
INSERT INTO [department] (name) VALUES ('Information22');
INSERT INTO [department] (name) VALUES ('Information23');
INSERT INTO [department] (name) VALUES ('Information24');
INSERT INTO [department] (name) VALUES ('Information25');
INSERT INTO [department] (name) VALUES ('Information26');
INSERT INTO [department] (name) VALUES ('Information27');
INSERT INTO [department] (name) VALUES ('Information28');
INSERT INTO [department] (name) VALUES ('Information29');
INSERT INTO [department] (name) VALUES ('Information30');
INSERT INTO [department] (name) VALUES ('Information31');
INSERT INTO [department] (name) VALUES ('Information32');
INSERT INTO [department] (name) VALUES ('Information33');
INSERT INTO [department] (name) VALUES ('Information34');
INSERT INTO [department] (name) VALUES ('Information35');
INSERT INTO [department] (name) VALUES ('Information36');
INSERT INTO [department] (name) VALUES ('Information37');
INSERT INTO [department] (name) VALUES ('Information38');
INSERT INTO [department] (name) VALUES ('Information39');
INSERT INTO [department] (name) VALUES ('Information40');
INSERT INTO [department] (name) VALUES ('Information41');
INSERT INTO [department] (name) VALUES ('Information42');
INSERT INTO [department] (name) VALUES ('Information43');
INSERT INTO [department] (name) VALUES ('Information44');
INSERT INTO [department] (name) VALUES ('Information45');
INSERT INTO [department] (name) VALUES ('Information46');
INSERT INTO [department] (name) VALUES ('Information47');
INSERT INTO [department] (name) VALUES ('Information48');
INSERT INTO [department] (name) VALUES ('Information49');

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
INSERT INTO [user]
VALUES ('4', 'password', 1, 'Javen Liang', 'javenliang.sait@gmail.com', 1);


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
INSERT INTO user_role
VALUES ('4', 1);

INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-0','1','course0');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-1','1','course1');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-2','1','course2');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-3','1','course3');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-4','1','course4');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-5','1','course5');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-6','1','course6');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-7','1','course7');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-8','1','course8');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-9','1','course9');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-10','1','course10');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-11','1','course11');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-12','1','course12');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-13','1','course13');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-14','1','course14');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-15','1','course15');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-16','1','course16');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-17','1','course17');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-18','1','course18');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-19','1','course19');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-20','1','course20');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-21','1','course21');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-22','1','course22');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-23','1','course23');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-24','1','course24');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-25','1','course25');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-26','1','course26');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-27','1','course27');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-28','1','course28');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-29','1','course29');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-30','1','course30');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-31','1','course31');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-32','1','course32');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-33','1','course33');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-34','1','course34');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-35','1','course35');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-36','1','course36');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-37','1','course37');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-38','1','course38');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-39','1','course39');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-40','1','course40');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-41','1','course41');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-42','1','course42');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-43','1','course43');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-44','1','course44');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-45','1','course45');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-46','1','course46');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-47','1','course47');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-48','1','course48');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-49','1','course49');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-0','1','2017-Fal0');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-1','1','2017-Fal1');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-2','1','2017-Fal2');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-3','1','2017-Fal3');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-4','1','2017-Fal4');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-5','1','2017-Fal5');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-6','1','2017-Fal6');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-7','1','2017-Fal7');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-8','1','2017-Fal8');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-9','1','2017-Fal9');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-10','1','2017-Fal10');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-11','1','2017-Fal11');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-12','1','2017-Fal12');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-13','1','2017-Fal13');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-14','1','2017-Fal14');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-15','1','2017-Fal15');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-16','1','2017-Fal16');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-17','1','2017-Fal17');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-18','1','2017-Fal18');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-19','1','2017-Fal19');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-20','1','2017-Fal20');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-21','1','2017-Fal21');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-22','1','2017-Fal22');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-23','1','2017-Fal23');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-24','1','2017-Fal24');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-25','1','2017-Fal25');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-26','1','2017-Fal26');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-27','1','2017-Fal27');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-28','1','2017-Fal28');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-29','1','2017-Fal29');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-30','1','2017-Fal30');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-31','1','2017-Fal31');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-32','1','2017-Fal32');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-33','1','2017-Fal33');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-34','1','2017-Fal34');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-35','1','2017-Fal35');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-36','1','2017-Fal36');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-37','1','2017-Fal37');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-38','1','2017-Fal38');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-39','1','2017-Fal39');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-40','1','2017-Fal40');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-41','1','2017-Fal41');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-42','1','2017-Fal42');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-43','1','2017-Fal43');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-44','1','2017-Fal44');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-45','1','2017-Fal45');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-46','1','2017-Fal46');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-47','1','2017-Fal47');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-48','1','2017-Fal48');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-49','1','2017-Fal49');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog0','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog1','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog2','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog3','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog4','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog5','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog6','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog7','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog8','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog9','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog10','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog11','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog12','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog13','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog14','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog15','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog16','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog17','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog18','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog19','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog20','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog21','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog22','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog23','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog24','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog25','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog26','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog27','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog28','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog29','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog30','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog31','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog32','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog33','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog34','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog35','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog36','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog37','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog38','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog39','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog40','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog41','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog42','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog43','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog44','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog45','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog46','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog47','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog48','2016-06-03','0');
INSERT INTO [glossary_entry] (glossary_entry,date_added,made_by) VALUES ('dog49','2016-06-03','0');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog0','def0','term0','2016-10-02','cite0','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog1','def1','term1','2016-10-02','cite1','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog2','def2','term2','2016-10-02','cite2','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog3','def3','term3','2016-10-02','cite3','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog4','def4','term4','2016-10-02','cite4','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog5','def5','term5','2016-10-02','cite5','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog6','def6','term6','2016-10-02','cite6','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog7','def7','term7','2016-10-02','cite7','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog8','def8','term8','2016-10-02','cite8','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog9','def9','term9','2016-10-02','cite9','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog10','def10','term10','2016-10-02','cite10','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog11','def11','term11','2016-10-02','cite11','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog12','def12','term12','2016-10-02','cite12','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog13','def13','term13','2016-10-02','cite13','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog14','def14','term14','2016-10-02','cite14','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog15','def15','term15','2016-10-02','cite15','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog16','def16','term16','2016-10-02','cite16','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog17','def17','term17','2016-10-02','cite17','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog18','def18','term18','2016-10-02','cite18','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog19','def19','term19','2016-10-02','cite19','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog20','def20','term20','2016-10-02','cite20','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog21','def21','term21','2016-10-02','cite21','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog22','def22','term22','2016-10-02','cite22','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog23','def23','term23','2016-10-02','cite23','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog24','def24','term24','2016-10-02','cite24','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog25','def25','term25','2016-10-02','cite25','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog26','def26','term26','2016-10-02','cite26','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog27','def27','term27','2016-10-02','cite27','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog28','def28','term28','2016-10-02','cite28','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog29','def29','term29','2016-10-02','cite29','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog30','def30','term30','2016-10-02','cite30','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog31','def31','term31','2016-10-02','cite31','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog32','def32','term32','2016-10-02','cite32','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog33','def33','term33','2016-10-02','cite33','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog34','def34','term34','2016-10-02','cite34','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog35','def35','term35','2016-10-02','cite35','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog36','def36','term36','2016-10-02','cite36','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog37','def37','term37','2016-10-02','cite37','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog38','def38','term38','2016-10-02','cite38','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog39','def39','term39','2016-10-02','cite39','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog40','def40','term40','2016-10-02','cite40','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog41','def41','term41','2016-10-02','cite41','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog42','def42','term42','2016-10-02','cite42','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog43','def43','term43','2016-10-02','cite43','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog44','def44','term44','2016-10-02','cite44','published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog45','def45','term45','2016-10-02','cite45','published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog46','def46','term46','2016-10-02','cite46','published','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog47','def47','term47','2016-10-02','cite47','published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog48','def48','term48','2016-10-02','cite48','published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('dog49','def49','term49','2016-10-02','cite49','published','www.link.com','4','HH-201-B');
