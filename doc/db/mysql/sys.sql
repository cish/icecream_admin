-- 系统管理  相关的表

-- sys_area
/*
警告: 字段名可能非法 - type
*/
create table  `sys_area`
(
       `id`              VARCHAR(64) not null comment '编号',
       `parent_id`       VARCHAR(64) not null comment '父级编号',
       `parent_ids`      VARCHAR(2000) not null comment '所有父级编号',
       `name`            VARCHAR(100) not null comment '名称',
       `sort`            INT not null comment '排序',
       `code`            VARCHAR(100) comment '区域编码',
       `type`            VARCHAR(1) comment '区域类型',
       `create_by`       VARCHAR(64) not null comment '创建者',
       `create_date`     DATETIME not null comment '创建时间',
       `update_by`       VARCHAR(64) not null comment '更新者',
       `update_date`     DATETIME not null comment '更新时间',
       `remarks`         VARCHAR(255) comment '备注信息',
       `del_flag`        VARCHAR(1) default 0 not null comment '删除标记'
);
alter  table `sys_area`
       add constraint `PK_sys_area_id` primary key (`id`);
create index `IDX_sys_area_parent_id` on `sys_area`(`parent_id`);
create index `IDX_sys_area_del_flag` on `sys_area`(`del_flag`);
alter table `sys_area` comment= '区域表';

-- sys_dict
/*
警告: 字段名可能非法 - type
*/
create table  `sys_dict`
(
       `id`              VARCHAR(64) not null comment '编号',
       `value`           VARCHAR(100) not null comment '数据值',
       `label`           VARCHAR(100) not null comment '标签名',
       `type`            VARCHAR(100) not null comment '类型',
       `description`     VARCHAR(100) not null comment '描述',
       `sort`            INT not null comment '排序（升序）',
       `parent_id`       VARCHAR(64) default 0 comment '父级编号',
       `create_by`       VARCHAR(64) not null comment '创建者',
       `create_date`     DATETIME  not null comment '创建时间',
       `update_by`       VARCHAR(64) not null comment '更新者',
       `update_date`     DATETIME  not null comment '更新时间',
       `remarks`         VARCHAR(255) comment '备注信息',
       `del_flag`        VARCHAR(1) default 0 not null comment '删除标记'
);
alter  table `sys_dict`
       add constraint `PK_sys_dict_id` primary key (`id`);
create index `IDX_sys_dict_value` on `sys_dict`(`value`);
create index `IDX_sys_dict_label` on `sys_dict`(`label`);
create index `IDX_sys_dict_del_flag` on `sys_dict`(`del_flag`);
alter table `sys_dict` comment= '字典表';

-- sys_log
/*
警告: 字段名可能非法 - type
*/
create table  `sys_log`
(
       `id`              VARCHAR(64) not null comment '编号',
       `type`            VARCHAR(1) default 1 comment '日志类型',
       `title`           VARCHAR(255) comment '日志标题',
       `create_by`       VARCHAR(64) comment '创建者',
       `create_date`     DATETIME  comment '创建时间',
       `remote_addr`     VARCHAR(255) comment '操作IP地址',
       `user_agent`      VARCHAR(255) comment '用户代理',
       `request_uri`     VARCHAR(255) comment '请求URI',
       `method`          VARCHAR(5) comment '操作方式',
       `params`          LONGBLOB comment '操作提交的数据',
       `exception`       LONGBLOB comment '异常信息'
);
alter  table `sys_log`
       add constraint `PK_sys_log_id` primary key (`id`);
create index `IDX_sys_log_type` on `sys_log`(`type`);
create index `IDX_sys_log_create_by` on `sys_log`(`create_by`);
create index `IDX_sys_log_create_date` on `sys_log`(`create_date`);
create index `IDX_sys_log_request_uri` on `sys_log`(`request_uri`);
alter table `sys_log` comment= '日志表';

-- sys_mdict
create table  `sys_mdict`
(
       `id`              VARCHAR(64) not null comment '编号',
       `parent_id`       VARCHAR(64) not null comment '父级编号',
       `parent_ids`      VARCHAR(2000) not null comment '所有父级编号',
       `name`            VARCHAR(100) not null comment '名称',
       `sort`            INT not null comment '排序',
       `description`     VARCHAR(100) comment '描述',
       `create_by`       VARCHAR(64) not null comment '创建者',
       `create_date`     DATETIME  not null comment '创建时间',
       `update_by`       VARCHAR(64) not null comment '更新者',
       `update_date`     DATETIME  not null comment '更新时间',
       `remarks`         VARCHAR(255) comment '备注信息',
       `del_flag`        VARCHAR(1) default 0 not null comment '删除标记'
);
alter  table `sys_mdict`
       add constraint `PK_sys_mdict_id` primary key (`id`);
create index `IDX_sys_mdict_parent_id` on `sys_mdict`(`parent_id`);
create index `IDX_sys_mdict_del_flag` on `sys_mdict`(`del_flag`);
alter table `sys_mdict` comment= '多级字典表';

-- sys_menu
create table  `sys_menu`
(
       `id`              VARCHAR(64) not null comment '编号',
       `parent_id`       VARCHAR(64) not null comment '父级编号',
       `parent_ids`      VARCHAR(2000) not null comment '所有父级编号',
       `name`            VARCHAR(100) not null comment '名称',
       `sort`            INT not null comment '排序',
       `href`            VARCHAR(2000) comment '链接',
       `target`          VARCHAR(20) comment '目标',
       `icon`            VARCHAR(100) comment '图标',
       `is_show`         VARCHAR(1) not null comment '是否在菜单中显示',
       `permission`      VARCHAR(200) comment '权限标识',
       `create_by`       VARCHAR(64) not null comment '创建者',
       `create_date`     DATETIME  not null comment '创建时间',
       `update_by`       VARCHAR(64) not null comment '更新者',
       `update_date`     DATETIME  not null comment '更新时间',
       `remarks`         VARCHAR(255) comment '备注信息',
       `del_flag`        VARCHAR(1) default 0 not null comment '删除标记'
);
alter  table `sys_menu`
       add constraint `PK_sys_menu_id` primary key (`id`);
create index `IDX_sys_menu_parent_id` on `sys_menu`(`parent_id`);
create index `IDX_sys_menu_del_flag` on `sys_menu`(`del_flag`);
alter table `sys_menu` comment= '菜单表';

-- sys_office
/*
警告: 字段名可能非法 - type
*/
create table  `sys_office`
(
       `id`              VARCHAR(64) not null comment '编号',
       `parent_id`       VARCHAR(64) not null comment '父级编号',
       `parent_ids`      VARCHAR(2000) not null comment '所有父级编号',
       `name`            VARCHAR(100) not null comment '名称',
       `sort`            INT not null comment '排序',
       `area_id`         VARCHAR(64) not null comment '归属区域',
       `code`            VARCHAR(100) comment '区域编码',
       `type`            VARCHAR(1) not null comment '机构类型',
       `grade`           VARCHAR(1) not null comment '机构等级',
       `address`         VARCHAR(255) comment '联系地址',
       `zip_code`        VARCHAR(100) comment '邮政编码',
       `master`          VARCHAR(100) comment '负责人',
       `phone`           VARCHAR(200) comment '电话',
       `fax`             VARCHAR(200) comment '传真',
       `email`           VARCHAR(200) comment '邮箱',
       `USEABLE`         VARCHAR(64) comment '是否启用',
       `PRIMARY_PERSON`  VARCHAR(64) comment '主负责人',
       `DEPUTY_PERSON`   VARCHAR(64) comment '副负责人',
       `create_by`       VARCHAR(64) not null comment '创建者',
       `create_date`     DATETIME  not null comment '创建时间',
       `update_by`       VARCHAR(64) not null comment '更新者',
       `update_date`     DATETIME  not null comment '更新时间',
       `remarks`         VARCHAR(255) comment '备注信息',
       `del_flag`        VARCHAR(1) default 0 not null comment '删除标记'
);
alter  table `sys_office`
       add constraint `PK_sys_office_id` primary key (`id`);
create index `IDX_sys_office_parent_id` on `sys_office`(`parent_id`);
create index `IDX_sys_office_type` on `sys_office`(`type`);
create index `IDX_sys_office_del_flag` on `sys_office`(`del_flag`);
alter table `sys_office` comment= '机构表';

-- sys_role
create table  `sys_role`
(
       `id`              VARCHAR(64) not null comment '编号',
       `office_id`       VARCHAR(64) comment '归属机构',
       `name`            VARCHAR(100) not null comment '角色名称',
       `enname`          VARCHAR(255) comment '英文名称',
       `role_type`       VARCHAR(255) comment '角色类型',
       `data_scope`      VARCHAR(1) comment '数据范围',
       `is_sys`          VARCHAR(64) comment '是否系统数据',
       `useable`         VARCHAR(64) comment '是否可用',
       `create_by`       VARCHAR(64) not null comment '创建者',
       `create_date`     DATETIME  not null comment '创建时间',
       `update_by`       VARCHAR(64) not null comment '更新者',
       `update_date`     DATETIME  not null comment '更新时间',
       `remarks`         VARCHAR(255) comment '备注信息',
       `del_flag`        VARCHAR(1) default 0 not null comment '删除标记'
);
alter  table `sys_role`
       add constraint `PK_sys_role_id` primary key (`id`);
create index `IDX_sys_role_enname` on `sys_role`(`enname`);
create index `IDX_sys_role_del_flag` on `sys_role`(`del_flag`);
alter table `sys_role` comment= '角色表';

-- sys_role_menu
create table  `sys_role_menu`
(
       `role_id`         VARCHAR(64) not null comment '角色编号',
       `menu_id`         VARCHAR(64) not null comment '菜单编号'
);
alter  table `sys_role_menu`
       add constraint `PK_sys_role_menu_role_id` primary key (`role_id`,`menu_id`);
alter table `sys_role_menu` comment= '角色-菜单';

-- sys_role_office
create table  `sys_role_office`
(
       `role_id`         VARCHAR(64) not null comment '角色编号',
       `office_id`       VARCHAR(64) not null comment '机构编号'
);
alter  table `sys_role_office`
       add constraint `PK_sys_role_office_role_id` primary key (`role_id`,`office_id`);
alter table `sys_role_office` comment= '角色-机构';

-- sys_user
/*
警告: 字段名可能非法 - password
警告: 字段名可能非法 - no
*/
create table  `sys_user`
(
       `id`              VARCHAR(64) not null comment '编号',
       `company_id`      VARCHAR(64) not null comment '归属公司',
       `office_id`       VARCHAR(64) not null comment '归属部门',
       `login_name`      VARCHAR(100) not null comment '登录名',
       `password`        VARCHAR(100) not null comment '密码',
       `no`              VARCHAR(100) comment '工号',
       `name`            VARCHAR(100) not null comment '姓名',
       `email`           VARCHAR(200) comment '邮箱',
       `phone`           VARCHAR(200) comment '电话',
       `mobile`          VARCHAR(200) comment '手机',
       `user_type`       VARCHAR(1) comment '用户类型',
       `photo`           VARCHAR(1000) comment '用户头像',
       `login_ip`        VARCHAR(100) comment '最后登陆IP',
       `login_date`      DATETIME  comment '最后登陆时间',
       `login_flag`      VARCHAR(64) comment '是否可登录',
       `create_by`       VARCHAR(64) not null comment '创建者',
       `create_date`     DATETIME  not null comment '创建时间',
       `update_by`       VARCHAR(64) not null comment '更新者',
       `update_date`     DATETIME  not null comment '更新时间',
       `remarks`         VARCHAR(255) comment '备注信息',
       `del_flag`        VARCHAR(1) default 0 not null comment '删除标记'
);
alter  table `sys_user`
       add constraint `PK_sys_user_id` primary key (`id`);
create index `IDX_sys_user_company_id` on `sys_user`(`company_id`);
create index `IDX_sys_user_office_id` on `sys_user`(`office_id`);
create index `IDX_sys_user_login_name` on `sys_user`(`login_name`);
create index `IDX_sys_user_update_date` on `sys_user`(`update_date`);
create index `IDX_sys_user_del_flag` on `sys_user`(`del_flag`);
alter table `sys_user` comment= '用户表';

-- sys_user_role
create table  `sys_user_role`
(
       `user_id`         VARCHAR(64) not null comment '用户编号',
       `role_id`         VARCHAR(64) not null comment '角色编号'
);
alter  table `sys_user_role`
       add constraint `PK_sys_user_role_user_id` primary key (`user_id`,`role_id`);
alter table `sys_user_role` comment= '用户-角色';

-- data

INSERT INTO `sys_user` VALUES ('1', '1', '1', 'admin', '$2a$10$iyy/9WyGecm9MqeSyGaxauYXcz79foBFA047EtQlrPJbau5OPBpMm', '1', '管理员', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '1', '1', '2017-10-21 17:12:38', '1', '2017-10-21 17:13:12', NULL, '0');