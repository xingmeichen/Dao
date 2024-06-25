# MYSQL 的查询语句
CREATE TABLE `t_query` (
`v` int(11) DEFAULT NULL,
`c1` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

## Select
### 查询并过滤重复值
select distinct {column_name} from {table_name}
eg.
select distinct c1 from t_query;

### 查询某个列的值重复出现过两次以上的记录
select {column_name} from {table_name} group by {column_name} having count({column_name}) > 2;
eg.
select c1 from t_query group by c1 having count(c1) > 2;
Note: 这里查询的列，以及group by的列和 having count 的列应该是必须保持一致的(如果这个结果不正确，之后再订正。。。)

### 分页查询 (offset从0开始)
select * from {table_name} limit off_set, count;
eg.
select * from t_query limit 0, 5; -- 表示查询符合条件的数据，并返回数据从第一条记录(0)开始，共5条数据

## Insert Into
insert into {table_name}({column1}, {column2}) values(v1, v2),(v1, v2),(v1, v2)...
insert into {table_name} values(),(),()... ## 这种方式的插入值，它没有把列名写出来，所以需要为所有列设置值
eg.
insert into t_query(c1) values(5),(4),(6);
insert into t_query values(7, 7),(8,88),(9,999);

## Update
update {table_name} set {column_name} = {your_value} where {where_condition}
eg.
update t_query set c1 = 4 where v1 > 3;

## Delete
delete from {table_name} where {where_condition}
eg.
delete from t_query where c1 > 3;


