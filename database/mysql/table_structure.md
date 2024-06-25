## 数据表的结构
### 创建一个表 
create table {table_name}(
 {attribute_name} {attribute_type} [完整性约束]
);
note: [完整性约束] 表示完整性约束不是必须的
eg.
CREATE TABLE `user` (
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
`user_name` varchar(30) NOT NULL DEFAULT '',
`password` varchar(100) NOT NULL DEFAULT '',
`phone` varchar(18) NOT NULL DEFAULT '',
`email` varchar(100) NOT NULL DEFAULT '',
`name` varchar(50) NOT NULL DEFAULT '',
`id_code` varchar(18) NOT NULL DEFAULT '',
`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
`latest_login_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
`disabled` tinyint(1) NOT NULL DEFAULT '0',
PRIMARY KEY (`id`),
UNIQUE KEY `nickname` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

### 修改表中的字段类型
alter table {table_name} alter column {column_name} {new_type} [完整性约束];