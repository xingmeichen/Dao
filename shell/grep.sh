#!/bin/bash

# usage:
## grep [-nvi] [-A] [-B] [--color=auto] '{matching}' {file}
## -n: 表示输出结果显示行号
## -v: 表示反向选择 （也就是搜索不包括匹配串的行）
## -i: 表示忽略大小写
## {std_out} | grep [-A] [-B] '{matching}'
## -A(after): 后面跟数字，表示结果除了匹配行以外，也输出后续的n行
## -B(befer?): 后面跟数字，表示结果除了匹配行以外，也输出前面的n行
## --color=auto: 匹配内容用颜色标记
## matching: 匹配串或者是正则表达式
## file: 搜索的文件
## 在正则表达式中，^ 是一个比较特殊的符号，直接跟字符表示行首，在[]表示非，例如^the, 表示the在行首，[^the] 表示不是the这个字符串


## 从a.txt 文件中搜索 next 这个字符串（结果将会输出所有包含next的行）
grep -n --color=auto 'next' a.txt
grep -n 'next' a.txt
cat a.txt | grep -n 'next'
echo '--------------'

## 从a.txt 文件中搜索 next 这个字符串, 并且列出匹配行后续的两行
grep -n -A 2 'next' a.txt
cat a.txt | grep -n -A 2 'next'
echo '--------------'

## 从a.txt 文件中搜索 next 这个字符串, 并且列出匹配行前面的两行
grep -n -B 2 'next' a.txt
cat a.txt | grep -n -B 2 'next'
echo '--------------'

## 从a.txt 文件中搜索 next 这个字符串, 并且列出匹配行前面的两行和后面的两行
grep -n -A2 -B 2 --color=auto 'next' a.txt
echo '--------------'

## 从 a.txt 文件中搜索不含有 "are" 字符串的所有行
grep -nv 'are' a.txt

## 从 a.txt 文件中搜索含有 "h" 字符串的所有行，且忽略大小写（-i）
grep -ni 'h' a.txt

## 从 a.txt 文件中搜索含有 "test" 和 "tast" 字符串的所有行，且忽略大小写（-i）
grep -n 't[ea]st' a.txt

## 从 a.txt 文件中搜索含有 'oo'字符串，且字符串的前面一个字符不是'g'
grep -n --color=auto '[^g]oo' a.txt

## 从 a.txt 文件中搜索含有 'oo'字符串，且字符串的前面一个字符不是'g'或者G
grep -n --color=auto '[^gG]oo' a.txt

## 从 a.txt 文件中搜索含有 'oo'字符串，且字符串的前面一个字符不是任何的小写字母
grep -n --color=auto '[^a-z]oo' a.txt

## 搜索a.txt 文件，找出行首是'the'的行
grep -n --color=auto '^the' a.txt

## 搜索a.txt 文件，找出行首不是字母的行
grep -n --color=auto '^[^a-zA-Z]' a.txt