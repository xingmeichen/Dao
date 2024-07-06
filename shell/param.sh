#!/bin/bash

## The number of parameters passed in during script execution, the script file itself is exclusive
## 执行脚本的时候传入的参数数量，不包括脚本本身，
## 例如 ./my.shell a b c 这个命令，参数为a, b, c, 所以参数数量为3
param_count=$#
echo "The number of parameters（参数数量）: $param_count"

whole_param=$*
echo "The whole parameters（所有参数，参数被看作一个整体）: $whole_param"

every_param=$@
echo "Every parameter(每一个参数，参数被看作每个独立的值): $every_param"

current_pid=$$
echo "Current pid(当前pid): $current_pid"

last_current_pid=$!
echo "Last current pid（上一个当前pid）: $last_current_pid"

last_execution_return=$?
echo "Last execution return(上一个命令执行的结果): $last_execution_return"



