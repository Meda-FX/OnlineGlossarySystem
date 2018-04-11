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
    ('administrator');
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
    ('MacPhail School of Energy');
INSERT INTO [GlossaryDataBase].[dbo].[department] 
    ( name)
VALUES 
    ('School of Business');
INSERT INTO [GlossaryDataBase].[dbo].[department] 
    ( name)
VALUES 
    ('School of Construction');
INSERT INTO [GlossaryDataBase].[dbo].[department] 
    (name)
VALUES 
    ('School of Health and Public Safety');
INSERT INTO [GlossaryDataBase].[dbo].[department] 
    ( name)
VALUES 
    ('School of Hospitality and Tourism');
INSERT INTO [GlossaryDataBase].[dbo].[department] 
    ( name)
VALUES 
    ('School of Information and Communications Technologies');
INSERT INTO [GlossaryDataBase].[dbo].[department] 
    (name)
VALUES 
    ('School of Manufacturing and Automation');
INSERT INTO [GlossaryDataBase].[dbo].[department] 
    ( name)
VALUES 
    ('School of Transportation');

INSERT INTO [GlossaryDataBase].[dbo].[user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000001','password',1,'Energy Default Admin','energy.admin@sait.ca', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000002','password',2,'Business Default Admin','business.admin@sait.ca', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000003','password',3,'Construction Default Admin','construction.admin@sait.ca', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000004','password',4,'HPS Default Admin','hps.admin@sait.ca', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000005','password',5,'Hospitality Default Admin','hospitality.admin@sait.ca', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000006','password',6,'ICT Default Admin','ict.admin@sait.ca', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user]
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000007','password',7,'MA Default Admin','ma.admin@sait.ca', 1);
INSERT INTO [GlossaryDataBase].[dbo].[user] 
    (user_id, password, department_id, [name], email, activated)
VALUES
    ('xxx000008','password',8,'Transportation Default Admin','transportation.admin@sait.ca', 1);

INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000001',1);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000002',1);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000003',1);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000004',1);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000005',1);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000006',1);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000007',1);
INSERT INTO [GlossaryDataBase].[dbo].[user_role]
    (user_id, privilege_id)
VALUES
    ('xxx000008',1);