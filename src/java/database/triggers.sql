/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  684243
 * Created: Mar 1, 2018
 */

CREATE TRIGGER TR_acc_req_insert_log
ON account_request
AFTER INSERT AS
BEGIN
SET IDENTITY_INSERT dbo.account_request_log ON
INSERT INTO account_request_log(request_id,request_date,request_by,request_log_type)
select request_id,request_date,request_by,request_type from INSERTED
SET IDENTITY_INSERT dbo.account_request_log OFF
END



