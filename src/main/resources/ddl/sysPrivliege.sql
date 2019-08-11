CREATE TABLE `sys_privilege` (`id` INT(20) NOT null AUTO_INCREMENT,
`privilege_name` varchar(20) comment '权限名称',
`privilege_url` varchar(200) comment '权限URL',
 PRIMARY KEY(`id`)
)
