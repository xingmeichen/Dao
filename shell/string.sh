#!/bin/bash

user_name='Javaer'
str='Hello '$user_name

echo "User name is: "$user_name
echo $str

str_length=${#user_name}
echo 'The length of user name: '$str_length

# get sub string, first number is the start index, the second number is sub string length
sub_str=${user_name:0:4}
echo ${sub_str}



