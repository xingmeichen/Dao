#!/bin/bash

array=(A B C D)
echo ${array[@]}

for key in ${array[*]}
do
  echo $key
done

