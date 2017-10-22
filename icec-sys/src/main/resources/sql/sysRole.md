queryRole
===
* 角色查询
	
	select
 	@pageTag(){
 	* 
 	@}
 	from sys_role 
 	where 1=1
 	@if(!isEmpty(name)){
	 and `name` like #'%'+name+'%'#
	@}
 	order by id 

sample
===
* 注释

	select #use("cols")# from sys_role where #use("condition")#

cols
===

	id,office_id,name,enname,role_type,data_scope,is_sys,useable,create_by,create_date,update_by,update_date,remarks,del_flag

updateSample
===

	`id`=#id#,`office_id`=#officeId#,`name`=#name#,`enname`=#enname#,`role_type`=#roleType#,`data_scope`=#dataScope#,`is_sys`=#isSys#,`useable`=#useable#,`create_by`=#createBy#,`create_date`=#createDate#,`update_by`=#updateBy#,`update_date`=#updateDate#,`remarks`=#remarks#,`del_flag`=#delFlag#

condition
===

	1 = 1  
	@if(!isEmpty(officeId)){
	 and `office_id`=#officeId#
	@}
	@if(!isEmpty(name)){
	 and `name`=#name#
	@}
	@if(!isEmpty(enname)){
	 and `enname`=#enname#
	@}
	@if(!isEmpty(roleType)){
	 and `role_type`=#roleType#
	@}
	@if(!isEmpty(dataScope)){
	 and `data_scope`=#dataScope#
	@}
	@if(!isEmpty(isSys)){
	 and `is_sys`=#isSys#
	@}
	@if(!isEmpty(useable)){
	 and `useable`=#useable#
	@}
	@if(!isEmpty(createBy)){
	 and `create_by`=#createBy#
	@}
	@if(!isEmpty(createDate)){
	 and `create_date`=#createDate#
	@}
	@if(!isEmpty(updateBy)){
	 and `update_by`=#updateBy#
	@}
	@if(!isEmpty(updateDate)){
	 and `update_date`=#updateDate#
	@}
	@if(!isEmpty(remarks)){
	 and `remarks`=#remarks#
	@}
	@if(!isEmpty(delFlag)){
	 and `del_flag`=#delFlag#
	@}
	
