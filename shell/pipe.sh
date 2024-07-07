#!/bin/bash

## Pine: 管道
## 语法： command1 | command2 | command3
## pipe 是将上一个命令的输出作为下一命令的输入从左往右依次执行
## pipe 之后的命令必须能够接受standard input， 这样的命令才可以是管道命令
## 管道命令仅仅会处理standard output, 对于standard error ouput 则会忽略
## 管道命令必须要能够接受来自前一个命令的数据成为standard input 继续处理才行

## 将 PATH 变量取出，找出第五个路径
echo $PATH | cut -d ':' -f 5

