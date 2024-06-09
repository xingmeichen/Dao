#!/bin/bash

arr=(1 2 3 4 5)
for item in ${arr[*]}
do
  echo $item
done
echo "--------------------------"

for item in ${arr[@]}
do
  echo $item
done
echo "--------------------------"

for ((i=0; i<${#arr[*]}; i++))
do
  echo ${arr[i]}
done
echo "--------------------------"

for item in {1..5}
do
  echo $item
done
echo "--------------------------"

for item in $(seq 1 5)
do
  echo $item
done
echo "--------------------------"




