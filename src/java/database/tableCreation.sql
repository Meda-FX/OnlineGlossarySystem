use [master]     
DROP DATABASE [GlossaryDataBase]
CREATE DATABASE [GlossaryDataBase] 

use [GlossaryDataBase]


CREATE TABLE [dbo].[department](
	department_id int IDENTITY(1,1) PRIMARY KEY,
	name varchar (100) NOT NULL
	
	)
CREATE TABLE [dbo].[role](
	privilege_id int IDENTITY(1,1) PRIMARY KEY,
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
	privilege_id int NOT NULL,
	user_id Varchar(20) NOT NULL,
	CONSTRAINT FK_user_role_user_id FOREIGN KEY (user_id)
	REFERENCES [user](user_id),
	CONSTRAINT FK_user_role_privilege_id FOREIGN KEY (privilege_id)
	REFERENCES role(privilege_id)
	)


CREATE TABLE [dbo].[glossary_entry](
	glossary_entry varchar (40) NOT NULL PRIMARY KEY,  
	date_added datetime NOT NULL,
	made_by Varchar(20) NOT NULL,
	CONSTRAINT FK_glossary_entry_user_id FOREIGN KEY (made_by)
	REFERENCES [user](user_id)
	)

--activity_type:
--new entry: 1
CREATE TABLE [dbo].[glossary_entry_log](
        log_id int IDENTITY(1,1) PRIMARY KEY,
	glossary_entry varchar (40) NOT NULL,
	activity_by VARCHAR (20) NOT NULL,
	activity_date Varchar(20) NOT NULL,
        activity_type int NOT NULL,
	CONSTRAINT FK_glossary_entry_log_glossary_entry FOREIGN KEY (glossary_entry)
	REFERENCES glossary_entry(glossary_entry),
	CONSTRAINT FK_glossary_entry_activity_by FOREIGN KEY (activity_by)
	REFERENCES [user](user_id)
        )

CREATE TABLE [dbo].[definition](
	definition_uid int IDENTITY(1,1) PRIMARY KEY, 
	glossary_entry varchar (40) NOT NULL,   
        definition varchar (500),
        dictionary_definition varchar(500),
	date_created datetime NOT NULL,
	citation varchar(100) ,
	status varchar(30) NOT NULL,
        dictionary_citation varchar(100),
	made_by Varchar(20) NOT NULL,
	course_code varchar (20) NOT NULL,
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

--request_log_type:
--new account: 1
--login: 2
CREATE TABLE [dbo].[account_log](
	log_id int IDENTITY(1,1) PRIMARY KEY,
	activity_by Varchar(20) NOT NULL,
	activity_date datetime NOT NULL,
        activity_type int NOT NULL,
        CONSTRAINT FK_account_log_request_id FOREIGN KEY (activity_by)
        REFERENCES [user](user_id)
	)

--request_type:
--new account: 1
--forget password: 2
CREATE TABLE [dbo].[account_request](
	request_id Int NOT NULL,
	request_date datetime NOT NULL,
	salt varchar (256) NOT NULL,
 	request_by Varchar(20) NOT NULL,
        request_type int NOT NULL,
        CONSTRAINT FK_account_request_request_id FOREIGN KEY (request_by)
        REFERENCES [user](user_id)
	)
	
--activity_type:
--create new definition: 1
CREATE TABLE [dbo].[definition_log](
        log_id int IDENTITY(1,1) PRIMARY KEY,
	definition_uid Int NOT NULL,
	activity_by Varchar(20) NOT NULL,
	activity_date datetime NOT NULL ,
        activity_type int NOT NULL,
	CONSTRAINT FK_definition_log_definition_uid FOREIGN KEY (definition_uid)
	REFERENCES definition(definition_uid),
	CONSTRAINT FK_definition_log_activity_by FOREIGN KEY (activity_by)
	REFERENCES [user](user_id)
	) 
	
