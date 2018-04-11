
insert into [department] (name) values ('RTSP');
insert into [department] (name) values ('European Law');
insert into [department] (name) values ('SAP XI');
insert into [department] (name) values ('GSLC');
insert into [department] (name) values ('DSDM');
insert into [department] (name) values ('Shipping');
insert into [department] (name) values ('MS Reporting Services');
insert into [department] (name) values ('MPEG');
insert into [department] (name) values ('BMX');
insert into [department] (name) values ('Inventory Control');
insert into [department] (name) values ('Home Care');
insert into [department] (name) values ('DWBI');
insert into [department] (name) values ('Shell Scripting');
insert into [department] (name) values ('Ethical Decision Making');
insert into [department] (name) values ('JMS');
insert into [department] (name) values ('Online Travel');
insert into [department] (name) values ('Rsync');
insert into [department] (name) values ('OSPF');
insert into [department] (name) values ('Kaspersky');
insert into [department] (name) values ('Management Due Diligence');
insert into [department] (name) values ('Staff Development');
insert into [department] (name) values ('Film Festivals');
insert into [department] (name) values ('Zoning');
insert into [department] (name) values ('MCT');
insert into [department] (name) values ('Documentation');
insert into [department] (name) values ('FP7');
insert into [department] (name) values ('GDP');
insert into [department] (name) values ('CGI');
insert into [department] (name) values ('Patient Education');
insert into [department] (name) values ('NSA-IAM');
insert into [department] (name) values ('PMO Services');
insert into [department] (name) values ('Mythology');
insert into [department] (name) values ('Language Teaching');
insert into [department] (name) values ('Xdebug');
insert into [department] (name) values ('Sage 300 ERP');
insert into [department] (name) values ('System Testing');
insert into [department] (name) values ('MySQLi');
insert into [department] (name) values ('Irrigation Management');
insert into [department] (name) values ('PMP');
insert into [department] (name) values ('Zoom');
insert into [department] (name) values ('Hair Cutting');
insert into [department] (name) values ('Guest Lecturing');
insert into [department] (name) values ('ERP Implementations');
insert into [department] (name) values ('Candidate Generation');
insert into [department] (name) values ('Multimedia');
insert into [department] (name) values ('Slip &amp; Fall');
insert into [department] (name) values ('Simulink');
insert into [department] (name) values ('NSIS');
insert into [department] (name) values ('BMC Patrol');
insert into [department] (name) values ('VAS');

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

INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-Z','1','course0');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-31-1','2','course1');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-32-2','3','course2');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-33-3','1','course3');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-34-4','2','course4');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-35-5','3','course5');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-36-6','1','course6');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-37-7','2','course7');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-38-8','3','course8');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-39-9','1','course9');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-310-10','2','course10');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-311-11','3','course11');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-312-12','1','course12');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-313-13','2','course13');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-314-14','3','course14');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-315-15','1','course15');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-316-16','2','course16');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-317-17','3','course17');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-318-18','1','course18');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-319-19','2','course19');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-320-20','3','course20');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-321-21','1','course21');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-322-22','2','course22');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-323-23','3','course23');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-324-24','1','course24');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-325-25','2','course25');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-326-26','3','course26');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-327-27','1','course27');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-328-28','2','course28');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-329-29','3','course29');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-330-30','1','course30');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-331-31','2','course31');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-332-32','3','course32');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-333-33','1','course33');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-334-34','2','course34');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-335-35','3','course35');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-336-36','1','course36');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-337-37','2','course37');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-338-38','3','course38');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-339-39','1','course39');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-340-40','2','course40');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-341-41','3','course41');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-342-42','1','course42');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-343-43','2','course43');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-344-44','3','course44');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-345-45','1','course45');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-346-46','2','course46');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-347-47','3','course47');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-348-48','1','course48');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-349-49','2','course49');

INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-348-48','1','2017-Fall');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-31-1','1','2017-Fal1');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-32-2','2','2017-Fal2');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-33-3','3','2017-Fal3');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-34-4','1','2017-Fal4');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-35-5','2','2017-Fal5');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-36-6','3','2017-Fal6');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-37-7','1','2017-Fal7');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-38-8','2','2017-Fal8');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-39-9','3','2017-Fal9');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-310-10','1','2017-Fal10');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-311-11','2','2017-Fal11');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-312-12','3','2017-Fal12');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-313-13','1','2017-Fal13');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-314-14','2','2017-Fal14');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-315-15','3','2017-Fal15');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-316-16','1','2017-Fal16');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-317-17','2','2017-Fal17');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-318-18','3','2017-Fal18');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-319-19','1','2017-Fal19');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-320-20','2','2017-Fal20');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-321-21','3','2017-Fal21');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-322-22','1','2017-Fal22');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-323-23','2','2017-Fal23');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-324-24','3','2017-Fal24');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-325-25','1','2017-Fal25');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-326-26','2','2017-Fal26');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-327-27','3','2017-Fal27');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-328-28','1','2017-Fal28');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-329-29','2','2017-Fal29');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-330-30','3','2017-Fal30');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-331-31','1','2017-Fal31');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-332-32','2','2017-Fal32');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-333-33','3','2017-Fal33');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-334-34','1','2017-Fal34');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-335-35','2','2017-Fal35');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-336-36','3','2017-Fal36');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-337-37','1','2017-Fal37');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-338-38','2','2017-Fal38');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-339-39','3','2017-Fal39');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-340-40','1','2017-Fal40');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-341-41','2','2017-Fal41');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-342-42','3','2017-Fal42');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-343-43','1','2017-Fal43');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-344-44','2','2017-Fal44');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-345-45','3','2017-Fal45');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-346-46','1','2017-Fal46');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-347-47','2','2017-Fal47');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-348-48','3','2017-Fal48');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-349-49','1','2017-Fal49');

insert into glossary_entry (glossary_entry, date_added, made_by) values ('Polynesian Heliotrope', '2017-05-22', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Orcutt''s Bristleweed', '2017-06-04', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Short-lobe Indian Paintbrush', '2017-10-18', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Pohnpei Syzygium', '2017-08-05', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Alpine Bedstraw', '2017-08-02', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Cryphaea Moss', '2017-11-01', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Dust Lichen', '2017-08-18', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Andreaea Moss', '2017-05-22', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Okra', '2017-12-26', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Theobroma', '2017-12-14', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Grassleaf Lettuce', '2017-11-10', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Cobwebby Thistle', '2017-07-09', 0);

INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Polynesian Heliotrope','def0','term0','2016-10-02','cite0','Published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Orcutt''s Bristleweed','def1','term1','2016-10-02','cite1','In Progress','www.link.com','1','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Short-lobe Indian Paintbrush','def2','term2','2016-10-02','cite2','Published','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Pohnpei Syzygium','def3','term3','2016-10-02','cite3','Published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Alpine Bedstraw','def4','term4','2016-10-02','cite4','Under Review','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Cryphaea Moss','def5','term5','2016-10-02','cite5','In Progress','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Dust Lichen','def6','term6','2016-10-02','cite6','Published','www.link.com','1','HH-201-B');


INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Andreaea Moss','Like a flower just uglier','term7','2016-10-02','Websters','Under Review','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Andreaea Moss','Grassland stuff','term7','2016-10-02','Smart people.','In Progress','www.link.com','2','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Andreaea Moss','Looks good in a swamp.','term7','2016-10-02','Plant book.','Published','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Andreaea Moss','Moss is soft.','term7','2016-10-02','University of Japan.','In Progress','www.link.com','0','HH-201-B');



INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Okra','Good green food.','term8','2016-10-02','cite8','Published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Okra','Lunch','term8','2016-10-02','cite8','Published','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Okra','Okra is from Africa I think','term8','2016-10-02','cite8','In Progress','www.link.com','3','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Okra','Okra is good with chicken.','term8','2016-10-02','cite8','Under Review','www.link.com','3','HH-201-B');




INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Theobroma','def9','term9','2016-10-02','cite9','Published','www.link.com','4','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Grassleaf Lettuce','def10','term10','2016-10-02','cite10','In Progress','www.link.com','0','HH-201-B');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Cobwebby Thistle','def11','term11','2016-10-02','cite11','Under Review','www.link.com','1','HH-201-B');


INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) VALUES ('Cobwebby Thistle','def11','term11','2016-10-02','cite11','Under Review','www.link.com','1','ITSC-330-30');
