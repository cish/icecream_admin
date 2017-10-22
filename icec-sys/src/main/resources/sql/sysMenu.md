query
===
* 角色查询
	
	select
 	@pageTag(){
 	* 
 	@}
 	from sys_menu 
 	where del_flag=0 
 	@if(!isEmpty(name)){
	 and `name` like #'%'+name+'%'#
	@}
 	order by id 

sample
===
* 注释

	select #use("cols")# from sys_menu where #use("condition")#

cols
===

	id,parent_id,parent_ids,name,sort,href,target,icon,is_show,permission,create_by,create_date,update_by,update_date,remarks,del_flag

updateSample
===

	`id`=#id#,`parent_id`=#parentId#,`parent_ids`=#parentIds#,`name`=#name#,`sort`=#sort#,`href`=#href#,`target`=#target#,`icon`=#icon#,`is_show`=#isShow#,`permission`=#permission#,`create_by`=#createBy#,`create_date`=#createDate#,`update_by`=#updateBy#,`update_date`=#updateDate#,`remarks`=#remarks#,`del_flag`=#delFlag#

condition
===

	1 = 1  
	@if(!isEmpty(parentId)){
	 and `parent_id`=#parentId#
	@}
	@if(!isEmpty(parentIds)){
	 and `parent_ids`=#parentIds#
	@}
	@if(!isEmpty(name)){
	 and `name`=#name#
	@}
	@if(!isEmpty(sort)){
	 and `sort`=#sort#
	@}
	@if(!isEmpty(href)){
	 and `href`=#href#
	@}
	@if(!isEmpty(target)){
	 and `target`=#target#
	@}
	@if(!isEmpty(icon)){
	 and `icon`=#icon#
	@}
	@if(!isEmpty(isShow)){
	 and `is_show`=#isShow#
	@}
	@if(!isEmpty(permission)){
	 and `permission`=#permission#
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
	
