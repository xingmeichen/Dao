# Mac

## Mac系统的环境变量
Mac系统的环境变量，加载顺序为：
/etc/profile /etc/paths ~/.bash_profile ~/.bash_login ~/.profile ~/.bashrc
/etc/profile: 系统级别，对所有用户生效
/etc/paths: 系统级别，对所有用户有效
~/.bash_profile: 用户级别，只对当前用户有效
后面3个按照从前往后的顺序读取，如果~/.bash_profile文件存在， 则后面的几个文件就会被忽略不读了，
如果~/.bash_profile文件不存在，才会以此类推读取后面的文件。
~/.bashrc没有上述规则，它是bash shell打开的时候载入的。

## 设置显示输入法的提示信息
pkill -f SCIM.app

## 设置偏好放开app允许所有来源
sudo spctl --master-disable

