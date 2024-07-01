#!/bin/bash

## echo -n {content}: -n这个参数表示打印信息后不换行

echo -n "Server [localhost]: "
read SERVER
echo $SERVER

echo -n "Port [5432]: "
read PORT
echo $PORT


