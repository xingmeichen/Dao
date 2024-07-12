#!/bin/bash

## 正则表达式， 部分内容可以查看 grep.sh 文件
## 在正则表达式中，^ 是一个比较特殊的符号，直接跟字符表示行首，在[]中表示非，例如^the, 表示the在行首，[^the] 表示不是the这个字符串
## $ 表示行尾, {matching}$

## 找出行首是'the'的行
grep -n --color=auto '^the' a.txt

## 找出行首不是字母的行
grep -n --color=auto '^[^a-zA-Z]' a.txt

## 找出以"the"结尾的行
grep -n --color=auto 'the$' a.txt

## 找出空白行
grep -n '^$' a.txt


