#!/bin/bash

str=$1
# if the input is empty, set default value as 'NULL'
if [ z $str ]; then str='NULL';fi
case $str in
'A')
  echo 'Your input is A'
  ;; # double; means break
'B')
  echo 'Your input is B'
  ;;
*) # default
  echo 'Your input is '$str
  ;;
esac # note: do not forget this line
