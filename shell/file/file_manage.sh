#!/bin/bash

## save & update ls -l command result
echo 'access permission, number of hard links, owner, group, size, date time last modified, file name' > ls_out.txt
ls -l . >> ls_out.txt
sed -i '' '2d' ls_out.txt

## the directory of the execution scrip
base_dir=$(dirname $0)
echo "base directory is: $base_dir"

## get current directory
current_dir=`pwd`
current_dir_another=$(pwd)
echo $current_dir
echo $current_dir_another
ls_out=(`ls`)
echo ${ls_out[@]}




