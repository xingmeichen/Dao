#!/bin/bash

## sh [-nvx] {script_file}
## -n: 不执行script, 仅查询语法的问题
## -v: 在执行script前，先将scripts 的内容输出到屏幕上
## -x: 将使用到的script内容显示到屏幕上，这是很有用的参数

sh -n ./test.sh
sh -v ./test.sh
sh -x ./test.sh