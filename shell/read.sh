#!/bin/bash

## read 从键盘输入读取内容
## echo -n {content}: -n这个参数表示打印信息后不换行


echo -n "Server [localhost]: "
read SERVER
echo $SERVER

echo -n "Port [5432]: "
read PORT
echo $PORT


