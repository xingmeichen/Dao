#!/bin/bash

## tee 会同时将数据流分送到文件和屏幕
## 语法: tee {file}， 通常会与管道配合使用

## ls -l 的结果保存到ls_out.txt 文件中且输出到屏幕上
ls -l | tee ls_out.txt
