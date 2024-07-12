# Linux

## Base64
### decode
echo {your_encrypted_text} | base64 -d

## Compare
diff {folder1} {folder2}
diff {file1} {file2}

## netstat
### netstat -ano
### netstat -aon | findstr "{your_port}"

## kill
taskkill -pid {pid} -f

## curl
eg.
curl -k -vv --proxy {proxy_host}:{proxy_port} --location --request \
POST "{request_url}" \
--header 'Authorization: Basic xxxxxxx' \
--header 'Content-Length: 0' \
--header 'Content-Type: application/json'

## split 命令用于对文件进行分区，可以将大文件分成小文件
split [-dl] {file} {prefix}
-b: 后面可以接欲分区成的文件大小，可以加单位，例如b, k, m等
-l: 后面接数字，以行数来进行分区
file: 需要拆分的文件
prefix: 代表前导符，可以作为分区文件名称的的前导文字
分区后生成的文件名像这样 aa, ab, ac, ad ... ，如果设置了前导符，则文件名就会是以前导符开头再加上这些自动生成的文件名
eg. 
### 将文件a.txt进行分区操作，每100行一个文件
split -l 100 a.txt 
### 将文件a.txt进行分区操作，每30k大小为一个文件, 且文件名都是以 test_ 开头
split -b 10k a.txt test_

## last 命令用于显示用户最近登录信息
单独执行last, 它会读取位于 /var/log/目录下，名称为wtmp的文件，并把该文件记录登录的用户名全部显示出来
