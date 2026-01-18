#!/bin/bash

## tr 用于修改内容, 是Text replace 的缩写
## 将小写全部改成大写
echo 'Hello' | tr '[a-z]' '[A-Z]' ## HELLO

## 将字符i替换成e, 注意tr的替换是等长匹配字符替换，如果新的替换串比匹配串长，
## 那么只替换匹配串出现的位置，超长部分不会出现在新的内容中，可以看以下两个命令的结果
echo 'Hillo' | tr 'i' 'e' ## Hello
echo 'Hello name, how are you' | tr 'name' 'Peter' ## Hello Pete, how are you

## 删除匹配的字符，在这里是 :
echo 'A:B:C:Defg:h:' | tr -d ':' ## ABCDefgh