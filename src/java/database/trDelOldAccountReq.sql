/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  684243
 * Created: Mar 1, 2018
 */


CREATE TRIGGER TR_acc_req_insert_del_old
ON account_request
AFTER INSERT AS
BEGIN
declare @a varchar (20)
SET IDENTITY_INSERT dbo.account_request ON
select @a = request_by from deleted
DELETE FROM account_request
where request_by = @a
SET IDENTITY_INSERT dbo.account_request OFF
END