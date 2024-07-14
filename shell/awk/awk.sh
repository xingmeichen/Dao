#!/bin/bash

## awk
## awk 用于处理文件中的行，一行当中分成多个字段（默认分隔符是空格），&0 表示一整行，&1表示第一段，依此类推
## 语法：awk 'condition1{action1} condition2{action2} ...' my_file
## awk 之后接 '', action 必须写在{} 内
## condition 表示自定义的条件
## action表示shell命令，{}中可以包含多个命令, 多个命令用;隔开
## 注意：这里的{} 是awk 命令的组成部分，跟我之前一贯的用来表示引用需要的输入内容不是一回事
## awk 内建变量如下：
###  NF: 每一行的字段总数，
###  NR: aws处理到的当前行数（从）
###  FS: 分隔符，默认是空格键

## 打印出 table.txt 文件中的第一栏和第3栏，中间用\t 分隔
cat table.txt | awk '{print $1 "\t" $3}'
echo '------------------'

## 打印出 table.txt 文件的行号，以及第一栏和第3栏，中间用\t 分隔
awk '{print NR "\t" $1 "\t" $3}' table.txt
echo '-----------------'

## 处理table, 计算出每个人的总分，并把整个表格打印出来
awk 'NR==1{print $1 "\t" $2 "\t" $3 "\t" $4 "\t" $5 "\t" "Total"}
     NR>=2{total=$2 + $3 + $4; print $1 "\t" $2 "\t" $3 "\t" $4 "\t" $5 "\t" total}' table.txt
echo '-----------------'



