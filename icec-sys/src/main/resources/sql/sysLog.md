sample
===
* 注释

	select #use("cols")# from sys_log where #use("condition")#

cols
===

	id,type,title,create_by,create_date,remote_addr,user_agent,request_uri,method,params,exception

updateSample
===

	`id`=#id#,`type`=#type#,`title`=#title#,`create_by`=#createBy#,`create_date`=#createDate#,`remote_addr`=#remoteAddr#,`user_agent`=#userAgent#,`request_uri`=#requestUri#,`method`=#method#,`params`=#params#,`exception`=#exception#

condition
===

	1 = 1  
	@if(!isEmpty(type)){
	 and `type`=#type#
	@}
	@if(!isEmpty(title)){
	 and `title`=#title#
	@}
	@if(!isEmpty(createBy)){
	 and `create_by`=#createBy#
	@}
	@if(!isEmpty(createDate)){
	 and `create_date`=#createDate#
	@}
	@if(!isEmpty(remoteAddr)){
	 and `remote_addr`=#remoteAddr#
	@}
	@if(!isEmpty(userAgent)){
	 and `user_agent`=#userAgent#
	@}
	@if(!isEmpty(requestUri)){
	 and `request_uri`=#requestUri#
	@}
	@if(!isEmpty(method)){
	 and `method`=#method#
	@}
	@if(!isEmpty(params)){
	 and `params`=#params#
	@}
	@if(!isEmpty(exception)){
	 and `exception`=#exception#
	@}
	
