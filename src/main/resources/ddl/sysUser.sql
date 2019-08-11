CREATE TABLE `sys_user` (`id` INT(20) NOT null AUTO_INCREMENT,
`user_name` VARCHAR(50),
`user_password` VARCHAR(50),
`user_email` VARCHAR(50),
`user_info` text,
`user_img` blob,
`create_time` datetime,
 PRIMARY KEY(`id`)
)
