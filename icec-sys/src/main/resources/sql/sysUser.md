queryUser
===
 
 	select
 	@pageTag(){
 	* 
 	@}
 	from sys_user 
 	where 1=1
 	@if(!isEmpty(loginName)){
	 and `login_name` like #'%'+loginName+'%'#
	@}
 	@if(!isEmpty(name)){
	 and `name` like #'%'+name+'%'#
	@}
 	
 	order by id 
 

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
	