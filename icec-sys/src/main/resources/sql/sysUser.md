findById
===
 
	SELECT a.*,b.name companyName,c.name officeName
	FROM sys_user a
       LEFT JOIN sys_office b 
        ON a.company_id=b.id
        LEFT JOIN sys_office c 
        ON a.office_id=c.id where a.id=#id#

queryUser
===
 
 	select
 	@pageTag(){
 	a.* 
 	@}
 	from sys_user a LEFT JOIN sys_office  b on a.office_id=b.id
 	where a.del_flag=0
 	@if(!isEmpty(loginName)){
	 and a.`login_name` like #'%'+loginName+'%'#
	@}
 	@if(!isEmpty(name)){
	 and a.`name` like #'%'+name+'%'#
	@}
 	@if(!isEmpty(officeId)){
	 and  CONCAT(CONCAT(b.parent_ids,b.id),',') like #officeId+'%'#
	@}
 	order by a.id 
 

sample
===
* 注释

	select #use("cols")# from sys_user where #use("condition")#

cols
===

	id,login_name,password,name,phone,email,enabled

updateSample
===

	`id`=#id#,`login_name`=#loginName#,`password`=#password#,`name`=#name#,`phone`=#phone#,`email`=#email#,`enabled`=#enabled#

condition
===

	1 = 1  
	@if(!isEmpty(loginName)){
	 and `login_name`=#loginName#
	@}
	@if(!isEmpty(password)){
	 and `password`=#password#
	@}
	@if(!isEmpty(name)){
	 and `name`=#name#
	@}
	@if(!isEmpty(phone)){
	 and `phone`=#phone#
	@}
	@if(!isEmpty(email)){
	 and `email`=#email#
	@}
	@if(!isEmpty(enabled)){
	 and `enabled`=#enabled#
	@}
	
