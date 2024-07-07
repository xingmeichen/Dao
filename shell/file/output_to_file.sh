#!/bin/bash

## >: standard output
## 1>: standard output, 与 > 等价
## >>: standard output append
## 1>>: standard output append, 与 >> 等价
## 2>: standard error output
## 2>>: standard error output append

cat < ./input.txt > output.txt
cat < ./input.txt >> output.txt
pwd > result.txt
pwd >> result.txt

