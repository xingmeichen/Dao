# MySQL (基于8.0 版本) 

## 启动数据库
sudo {mysql_home}/support-files/mysql.server start
{mysql_home}/support-files/mysql.server start

## 停止数据库
sudo {mysql_home}/support-files/mysql.server stop 
{mysql_home}/support-files/mysql.server stop

## 连接数据库 （进入mysql命令行 mysql>）
mysql -h{host} -P{port} -u{user_name} -p{password}
mysql -h{host} -P{port} -u{user_name} -p 
mysql -u{user_name} -p

## 退出命令行
exit;