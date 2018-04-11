INSERT INTO [user] (user_id, password, department_id, [name], email, activated)
VALUES ('000999123','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'John Johnson','john.johnson@sait.ca', 1); -- admin
INSERT INTO [user] 
VALUES ('000541125','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Bob Bobson','bob.bobson@sait.ca', 1); -- editor
INSERT INTO [user]
VALUES ('000985472','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Aron Alice','aron.alice@sait.ca', 1); -- instructor
INSERT INTO [user] 
VALUES ('000435323','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Stephon Curry','stephon.curry@sait.ca', 1); -- instructor
INSERT INTO [user] 
VALUES ('000435320','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Steve Hawkins','steve.hawkins@sait.ca', 1); -- instructor
INSERT INTO [user]
VALUES ('000412324', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 6, 'Mike Thomas', 'mike.thomas@edu.sait.ca', 1); -- student
INSERT INTO [user] 
VALUES ('000541625','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Don Chen','don.chen@edu.sait.ca', 1); -- student
INSERT INTO [user]
VALUES ('000985972','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Sam Lee','sam.lee@edu.sait.ca', 1); -- student
INSERT INTO [user] 
VALUES ('000435623','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Mary Mason','mary.mason@edu.sait.ca', 1); -- student
INSERT INTO [user]
VALUES ('000412024', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 6, 'Bella Nelson', 'bella.nelson@edu.sait.ca', 1); -- student
INSERT INTO [user]
VALUES ('000512324', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 6, 'Tim Higgins', 'tim.higgins@sait.ca', 1); -- student
INSERT INTO [user] 
VALUES ('000641625','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Emily Bell','emily.bell@edu.sait.ca', 1); -- student
INSERT INTO [user]
VALUES ('000085972','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Rodney Moore','rodney.moore@edu.sait.ca', 1); -- student
INSERT INTO [user] 
VALUES ('000535623','5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8',6,'Hether Sunderland','hether.sunderland@edu.sait.ca', 1); -- student
INSERT INTO [user]
VALUES ('000512024', '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8', 6, 'Elliot Williams', 'elliot.williams@edu.sait.ca', 1); -- student

INSERT INTO [user_role] (privilege_id,user_id)
VALUES (1, '000999123');
INSERT INTO [user_role]
VALUES (3, '000541125');
INSERT INTO [user_role]
VALUES (4, '000985472');
INSERT INTO [user_role]
VALUES (4, '000435323');
INSERT INTO [user_role]
VALUES (4, '000435320');
INSERT INTO [user_role]
VALUES (2, '000412324');
INSERT INTO [user_role]
VALUES (2, '000541625');
INSERT INTO [user_role]
VALUES (2, '000985972');
INSERT INTO [user_role]
VALUES (2, '000435623');
INSERT INTO [user_role]
VALUES (2, '000412024');
INSERT INTO [user_role]
VALUES (2, '000512324');
INSERT INTO [user_role]
VALUES (2, '000641625');
INSERT INTO [user_role]
VALUES (2, '000085972');
INSERT INTO [user_role]
VALUES (2, '000535623');
INSERT INTO [user_role]
VALUES (2, '000512024');

INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CMPS-307-Z','6','Computer Hardware');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-310-10','6','Software Security');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-311-11','6','Database Design');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-312-12','6','IT Foundations');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-313-13','6','Java Programming');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-314-14','6','Computer System Security');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-315-15','6','Database Programming');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-316-16','6','Communication and Presentation Skills');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('CPRG-317-17','6','Object-Oriented Programming');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('ITSC-318-18','6','Network Security');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('DBAD-319-19','6','Database Administration');
INSERT INTO [course] (course_code,department_id,course_name) VALUES ('MHIT-320-20','6','Business Dynamics');


INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-Z','000985472','2017-Fall');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-Z','000412324','2017-Fal1');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-Z','000541625','2017-Fal2');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CMPS-307-Z','000985972','2017-Fal3');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-310-10','000435323','2017-Fal4');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-310-10','000985972','2017-Fal5');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-310-10','000435623','2017-Fal6');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-310-10','000412024','2017-Fal7');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-311-11','000435320','2017-Fal8');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-311-11','000641625','2017-Fal9');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-311-11','000085972','2017-Fal10');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-311-11','000535623','2017-Fal11');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-312-12','000985472','2017-Fal12');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-312-12','000435320','2017-Fal12');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-312-12','000512024','2017-Fal13');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-312-12','000412324','2017-Fal14');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-312-12','000541625','2017-Fal15');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-313-13','000435323','2017-Fal16');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-313-13','000985972','2017-Fal17');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-313-13','000435623','2017-Fal18');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-313-13','000412024','2017-Fal19');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-314-14','000435320','2017-Fal20');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-314-14','000512324','2017-Fal21');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-314-14','000641625','2017-Fal22');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-314-14','000085972','2017-Fal23');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-315-15','000985472','2017-Fal24');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-315-15','000535623','2017-Fal25');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-315-15','000512024','2017-Fal26');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-315-15','000412324','2017-Fal27');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-316-16','000435323','2017-Fal28');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-316-16','000985472','2017-Fal28');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-316-16','000541625','2017-Fal29');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-316-16','000435623','2017-Fal30');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-316-16','000412024','2017-Fal31');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-317-17','000435320','2017-Fal32');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-317-17','000512324','2017-Fal33');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-317-17','000541625','2017-Fal34');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('CPRG-317-17','000085972','2017-Fal35');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-318-18','000985472','2017-Fal36');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-318-18','000985972','2017-Fal37');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-318-18','000412024','2017-Fal38');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('ITSC-318-18','000641625','2017-Fal39');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-319-19','000435323','2017-Fal40');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-319-19','000985972','2017-Fal41');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-319-19','000085972','2017-Fal42');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('DBAD-319-19','000512324','2017-Fal43');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-320-20','000435320','2017-Fal44');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-320-20','000435623','2017-Fal45');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-320-20','000641625','2017-Fal46');
INSERT INTO [user_course] (course_code,user_id,year) VALUES ('MHIT-320-20','000412324','2017-Fal47');

insert into glossary_entry (glossary_entry, date_added, made_by) values ('Java', '2017-05-22', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('JavaScript', '2017-06-04', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Rust', '2017-10-18', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Scala', '2017-08-05', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('python', '2017-08-02', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Ruby', '2017-11-01', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Perl', '2017-08-18', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('SQL', '2017-05-22', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('MySQL', '2017-12-26', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Csharp', '2017-12-14', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('Fsharp', '2017-11-10', 0);
insert into glossary_entry (glossary_entry, date_added, made_by) values ('SQL Server', '2017-07-09', 0);

INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('JavaScript',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus ullamcorper mi quam, in pharetra mi laoreet ut. Vivamus gravida purus vel venenatis tincidunt.',
    'Vivamus mattis leo sit amet arcu efficitur malesuada. Fusce dictum tempor mauris eget mollis.',
    '2018-01-02','https://example.com/aftermath/blade','Published','http://example.com/boat','000985472','MHIT-316-16');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Rust',
    'Sed convallis vehicula lorem, sit amet tincidunt magna porta nec. Nulla sit amet elit sed libero molestie sodales et sed nibh.',
    'Maecenas facilisis bibendum dui, eu semper ante fringilla eu. Pellentesque sit amet consectetur quam.',
    '2018-02-16','http://example.com/?action=apparel&bomb=breath','Published','http://www.example.com/appliance/bell','000985472','DBAD-315-15');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Scala',
    'Praesent pellentesque condimentum molestie. ',
    'Sed volutpat euismod leo ac maximus. Aliquam euismod est in commodo elementum. Cras gravida libero vitae lacus posuere dignissim.',
    '2018-03-14','http://example.com/animal/advertisement.aspx','Published','http://www.example.com/?bubble=bath&acoustics=belief','000435320','ITSC-314-14');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('python',
    'Aliquam eu cursus purus. Vivamus id velit a risus interdum congue.',
    'Quisque a diam luctus urna fringilla facilisis sed ut magna.',
    '2018-01-02','http://example.com/animal/advertisement.aspx','Published','https://www.example.com/aunt/believe.html','000435320','MHIT-312-12');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Ruby',
    'Fusce congue dictum sapien, sed feugiat ex elementum ut. ',
    'Ut malesuada turpis sit amet libero scelerisque pulvinar.',
    '2018-04-02','http://www.example.com/?boy=beginner&ants=baseball','Published','http://book.example.com/?actor=birds&box=adjustment','000435320','DBAD-311-11');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Perl',
    'Ut et dui vitae sapien semper sodales nec eu nisl.',
    'Nam semper aliquam mauris vitae cursus.term5',
    '2018-01-31','http://acoustics.example.com/','Published','http://bone.example.com/bell.html?achiever=box&blow=boundary','000985472','MHIT-312-12');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('MySQL',
    'Quisque congue sed metus id lobortis. Sed a dignissim mi, id sollicitudin mauris.',
    'Etiam eu sem ante. Nam convallis convallis euismod.',
    '2018-02-02','https://www.example.com/brake?bit=brass&bone=beginner','Published','https://example.net/art','000435320','ITSC-314-14');


INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Java',
    'Nulla quis dui dignissim, tincidunt justo sed, vestibulum nisi.',
    'Phasellus rhoncus lorem id dui auctor euismod. ',
    '2018-03-12','https://www.example.com/bee/agreement.aspx','Published','https://www.example.com/bird.aspx','000985472','ITSC-318-18');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Java',
    'Pellentesque pharetra consectetur massa, vitae ullamcorper dolor volutpat imperdiet.',
    'Donec lorem est, euismod eget dui nec, placerat congue mi.',
    '2018-04-02','http://www.example.net/beginner?border=air','Published','https://balance.example.com/appliance.htm','000435320','CPRG-317-17');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Java',
    'Looks good in a swamp.',
    'term7',
    '2018-03-15','https://www.example.com/#arithmetic','Published','http://example.org/airport/amusement.php','000435323','MHIT-316-16');


INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('SQL',
    'Sed molestie metus eu nulla tempor, a iaculis felis blandit.',
    'Ut placerat, est ac mollis scelerisque, eros massa laoreet enim, sed facilisis felis tellus eleifend diam. ',
    '2018-02-11','http://www.example.com/adjustment/afterthought','Published','https://www.example.com/alarm.html?acoustics=bikes','000985472','MHIT-312-12');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('SQL',
    'Nullam tristique ligula neque, in varius purus vulputate eu.',
    'Cras blandit felis eu mauris tempor blandit.',
    '2018-03-17','https://www.example.com/badge.html','Published','http://example.org/babies.htm','000435323','ITSC-310-10');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('SQL',
    'Aenean porttitor ligula in pulvinar tempus.',
    'In faucibus sodales fringilla. Praesent ac mollis risus.',
    '2018-01-08','https://basketball.example.com/','Published','http://www.example.com/angle?blow=bait&base=bell','000435320','MHIT-312-12');



INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('SQL Server',
    'Integer sit amet tristique neque.',
    'Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
    '2016-10-02','https://amount.example.net/blow.html?berry=boat','Published','https://example.com/agreement.php','000985472','DBAD-315-15');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Csharp',
    'In sagittis feugiat consequat. Proin eu ultrices urna.',
    'Aliquam erat volutpat. Cras quis purus pretium, ultrices dolor at, lobortis erat.',
    '2016-10-02','http://example.com/activity','Published','https://www.example.com/baseball/board','000435323','CPRG-313-13');
INSERT INTO [definition] (glossary_entry,definition,dictionary_definition, date_created,citation, status,dictionary_citation,made_by,course_code) 
VALUES ('Fsharp',
    'Quisque aliquet mauris turpis, eu tempor est laoreet id.',
    'Donec ut porttitor urna.',
    '2016-10-02','https://www.example.edu/bed?bell=bone&board=berry','Published','http://www.example.com/#authority','000435323','CPRG-313-13');

INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-1', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-1', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-1', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-1', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-2', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-2', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-2', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-3', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-3', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-4', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-4', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-4', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-4', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-4', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-4', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-5', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-6', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-6', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-6', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-7', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-7', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-7', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-7', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-7', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-7', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-8', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-8', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-8', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-9', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-9', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-9', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-10', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-10', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-11', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-11', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-11', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-11', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-12', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-12', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-13', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-13', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-13', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-13', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-14', 2);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-15', 2);

INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000999123', '2018-04-1', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000541125', '2018-04-2', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000985472', '2018-04-2', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000435323', '2018-04-2', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000435320', '2018-04-3', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000412324', '2018-04-3', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000541625', '2018-04-4', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000985972', '2018-04-5', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000435623', '2018-04-6', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000412024', '2018-04-6', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000512324', '2018-04-6', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000641625', '2018-04-7', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000085972', '2018-04-7', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000535623', '2018-04-7', 1);
INSERT INTO [account_log] (activity_by, activity_date, activity_type)
VALUES ('000512024', '2018-04-7', 1);