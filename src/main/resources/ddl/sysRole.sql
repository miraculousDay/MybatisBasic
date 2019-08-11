CREATE TABLE `sys_role` (`id` INT(20) NOT null AUTO_INCREMENT,
`role_name` VARCHAR(50),
`enabled` int,
`create_user` bigint,
`create_time` datetime,
 PRIMARY KEY(`id`)
)
