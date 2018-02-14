use [master]     
DROP DATABASE [GlossaryDataBase]
CREATE DATABASE [GlossaryDataBase] 

use [GlossaryDataBase]


CREATE TABLE [dbo].[department](
	department_id int NOT NULL PRIMARY KEY,
	name varchar (100) NOT NULL
	
	)
CREATE TABLE [dbo].[role](
	priviledge_id int NOT NULL PRIMARY KEY,
	description varchar (40) NOT NULL
	)
		

CREATE TABLE [dbo].[user] (
	user_id Varchar(20) NOT NULL PRIMARY KEY,
	password varchar (40) NOT NULL,
	department_id int NOT NULL,
	name varchar (40) NOT NULL,
	email varchar (40) NOT NULL,
	activated bit NOT NULL,
	CONSTRAINT FK_user_department_id FOREIGN KEY (department_id)
        REFERENCES department(department_id)
	)

CREATE TABLE [dbo].[user_role] (
	priviledge_id int NOT NULL,
	user_id Varchar(20) NOT NULL,
	CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id)
	REFERENCES [user](user_id),
	CONSTRAINT FK_user_role_priviledge_id FOREIGN KEY (priviledge_id)
	REFERENCES role(priviledge_id),
        PRIMARY KEY (priviledge_id,user_id)
	)


CREATE TABLE [dbo].[glossary_entry](
	glossary_entry varchar (40) NOT NULL PRIMARY KEY,  
	date_added date NOT NULL,
	made_by Varchar(20) NOT NULL,
	CONSTRAINT FK_glossary_entry_user_id FOREIGN KEY (made_by)
	REFERENCES [user](user_id)
	)

    CREATE TABLE [dbo].[glossary_entry_log](
	glossary_entry varchar (40) NOT NULL,
	accessed date NOT NULL,
	accessed_by Varchar(20) NOT NULL,
	CONSTRAINT FK_glossary_entry_log_glossary_entry FOREIGN KEY (glossary_entry)
	REFERENCES glossary_entry(glossary_entry),
	CONSTRAINT FK_glossary_entry_accessed_by FOREIGN KEY (accessed_by)
	REFERENCES [user](user_id),
        PRIMARY KEY(glossary_entry,accessed,accessed_by)
	)

CREATE TABLE [dbo].[definition](
	definition_uid int NOT NULL PRIMARY KEY, 
	glossary_entry varchar (40) NOT NULL,   
        definition varchar (500) NOT NULL,
	date_created date NOT NULL,
	citation varchar(100) ,
	made_by Varchar(20) NOT NULL,
	course_code varchar (20),
	[type] char(1) NOT NULL,
        CONSTRAINT FK_definition_made_by FOREIGN KEY (made_by)
	REFERENCES [user](user_id),
        CONSTRAINT FK_definition_glossary_entry FOREIGN KEY (glossary_entry)
        REFERENCES [glossary_entry](glossary_entry)
	)
 
CREATE TABLE [dbo].[course](
	course_code varchar (20) NOT NULL PRIMARY KEY,
	department_id Int NOT NULL,
	course_name varchar (100) NOT NULL,
	CONSTRAINT FK_course_department_id FOREIGN KEY (department_id)
	REFERENCES  department(department_id)
	)
CREATE TABLE [dbo].[user_course](
	course_code varchar (20) NOT NULL,
	user_id Varchar(20) NOT NULL,
	[year] varchar(20) NOT NULL,
	CONSTRAINT FK_user_course_course_code FOREIGN KEY (course_code)
	REFERENCES course(course_code),
	CONSTRAINT FK_user_course_user_id FOREIGN KEY (user_id)
	REFERENCES [user](user_id),
        PRIMARY KEY(course_code,user_id,[year])
	)

CREATE TABLE [dbo].[password_request_log](
	request_id int NOT NULL,
	request_date date NOT NULL,
	request_by Varchar(20) NOT NULL,
        CONSTRAINT FK_password_request_log_request_id FOREIGN KEY (request_by)
        REFERENCES [user](user_id)
	)

CREATE TABLE [dbo].[password_request](
	request_id Int NOT NULL,
	request_date date NOT NULL,
	salt varchar (256) NOT NULL,
 	request_by Varchar(20) NOT NULL,
        CONSTRAINT FK_password_request_request_id FOREIGN KEY (request_by)
        REFERENCES [user](user_id)
	)
	
CREATE TABLE [dbo].[definition_activity_log](
	definition_uid Int NOT NULL,
	accessed_by Varchar(20) NOT NULL,
	date_accessed date NOT NULL ,
	CONSTRAINT FK_definition_activity_log_definition_uid FOREIGN KEY (definition_uid)
	REFERENCES definition(definition_uid),
	CONSTRAINT FK_definition_activity_log_accessed_by FOREIGN KEY (accessed_by)
	REFERENCES [user](user_id),
        PRIMARY KEY(definition_uid,accessed_by,date_accessed)
	) 
CREATE TABLE [dbo].[definition_edit_log](
	edit_date date NOT NULL,
	definition_uid Int NOT NULL,
	edit_by Varchar(20) NOT NULL,
	CONSTRAINT FK_definition_edit_log_definition_uid FOREIGN KEY (definition_uid)
	REFERENCES definition(definition_uid),
	CONSTRAINT FK_definition_edit_log_edit_by FOREIGN KEY (edit_by)
	REFERENCES [user](user_id),
        PRIMARY KEY(edit_Date,definition_uid,edit_by)
	)
	