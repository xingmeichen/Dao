# create table t1
create table t1 (
  id int(11) unsigned primary key auto_increment;
  name varchar(32) not null default ''
  add_dt timestamp not null default current_timestamp,
  update_dt timestamp not null default current_timestamp on update current_timestamp
) engine=InnoDB auto_increment=1 default charset=utf8mb4;

insert into t1 (name) values ("user1"), ("user2"), ("user3");