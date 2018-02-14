use [master]     
DROP DATABASE [GlossaryDataBase]
CREATE DATABASE [GlossaryDataBase] 

use [GlossaryDataBase]


CREATE TABLE [dbo].[department](
	department_id varchar (20) NOT NULL PRIMARY KEY,
	name varchar (100) NOT NULL
	
	)
CREATE TABLE [dbo].[role](
	priviledge_id Int NOT NULL PRIMARY KEY,
	description varchar (40) NOT NULL
	)
		

CREATE TABLE [dbo].[user] (
	user_id varchar (20) NOT NULL PRIMARY KEY,
	password varchar (40) NOT NULL,
	department_id varchar (20) NOT NULL,
	name varchar (40) NOT NULL,
	email varchar (40) NOT NULL,
	activated bit NOT NULL,
	CONSTRAINT FK_user_department_id FOREIGN KEY (department_id)
        REFERENCES department(department_id)
	)

CREATE TABLE [dbo].[user_role] (
	priviledge_id int NOT NULL,
	user_id varchar (20) NOT NULL,
	CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id)
	REFERENCES [user](user_id),
	CONSTRAINT FK_user_role_priviledge_id FOREIGN KEY (priviledge_id)
	REFERENCES role(priviledge_id)
	)

CREATE TABLE [dbo].[definition](
	definition_uid varchar (20) NOT NULL PRIMARY KEY, 
	glossary_entry varchar (40) NOT NULL,
	date_created date NOT NULL,
	citation varchar(100) NOT NULL,
	made_by varchar (20) NOT NULL,
	course_id varchar (20) NOT NULL,
	[type] char(1) NOT NULL,
        CONSTRAINT FK_definition_definition_id FOREIGN KEY (made_by)
	REFERENCES [user](user_id)
	)
CREATE TABLE [dbo].[glossary_entry](
	glossary_entry varchar (40) NOT NULL PRIMARY KEY,  
	date_added date NOT NULL,
	made_by varchar (20) NOT NULL,
	CONSTRAINT FK_glossary_entry_user_id FOREIGN KEY (made_by)
	REFERENCES [user](user_id)
	)
    CREATE TABLE [dbo].[glossary_entry_log](
	glossary_entry varchar (40) NOT NULL,
	accessed date NOT NULL,
	accessed_by varchar(20) NOT NULL,
	CONSTRAINT FK_glossary_entry_log_glossary_entry FOREIGN KEY (glossary_entry)
	REFERENCES glossary_entry(glossary_entry),
	CONSTRAINT FK_glossary_entry_accessed_by FOREIGN KEY (accessed_by)
	REFERENCES [user](user_id)
	)
 
CREATE TABLE [dbo].[course](
	course_code varchar (20) NOT NULL PRIMARY KEY,
	department_id varchar (20) NOT NULL,
	course_name varchar (100) NOT NULL,
	CONSTRAINT FK_course_department_id FOREIGN KEY (department_id)
	REFERENCES  department(department_id)
	)
CREATE TABLE [dbo].[user_course](
	course_code varchar (20) NOT NULL,
	user_id varchar (20) NOT NULL,
	[year] int NOT NULL,
	CONSTRAINT FK_user_course_course_code FOREIGN KEY (course_code)
	REFERENCES course(course_code),
	CONSTRAINT FK_user_course_user_id FOREIGN KEY (user_id)
	REFERENCES [user](user_id)
	)

CREATE TABLE [dbo].[password_request_log](
	request_id int NOT NULL,
	request_date date NOT NULL,
	request_by varchar (20) NOT NULL,
        CONSTRAINT FK_password_request_log_request_id FOREIGN KEY (request_by)
        REFERENCES [user](user_id)
	)

CREATE TABLE [dbo].[password_request](
	request_id varchar (256) NOT NULL,
	request_date date NOT NULL,
	salt varchar (256) NOT NULL,
 	request_by varchar (20) NOT NULL,
        CONSTRAINT FK_password_request_request_id FOREIGN KEY (request_by)
        REFERENCES [user](user_id)
	)
	
CREATE TABLE [dbo].[definition_activity_log](
	definition_uid varchar (20) NOT NULL,
	accessed_by varchar(20) NOT NULL,
	date_accessed date NOT NULL ,
	CONSTRAINT FK_definition_activity_log_definition_uid FOREIGN KEY (definition_uid)
	REFERENCES definition(definition_uid),
	CONSTRAINT FK_definition_activity_log_accessed_by FOREIGN KEY (accessed_by)
	REFERENCES [user](user_id)
	) 
CREATE TABLE [dbo].[definition_edit_log](
	edit_date date NOT NULL,
	definition_uid varchar (20) NOT NULL,
	edit_by varchar (20) NOT NULL,
	CONSTRAINT FK_definition_edit_log_definition_uid FOREIGN KEY (definition_uid)
	REFERENCES definition(definition_uid),
	CONSTRAINT FK_definition_edit_log_edit_by FOREIGN KEY (edit_by)
	REFERENCES [user](user_id)
	)
	