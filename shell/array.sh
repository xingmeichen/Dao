#!/bin/bash

arr=('Apple' 'Banana', "Cherry")
arr[3]='Dragon Fruit'

# The first item
echo $arr
echo ${arr[0]}

# The nth item
echo ${arr[2]}

# The whole array
echo ${arr[*]}

# Every array item
echo ${arr[@]}

# The array length
echo ${#arr[*]}
echo ${#arr[@]}
