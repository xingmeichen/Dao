#!/bin/bash

# $0 is the path of the execution script
echo $0
# set i as the first parameter of the execution script
i=$1
if [ z $i]
then
  echo 'i is empty'
elif [ $i == 0 ]
then
  echo 'i = 0'
elif [ $i -lt 0 ]
then
  echo 'i < 0'
elif [ $i -gt 0 ]
then
  echo 'i > 0'
fi
echo '----------------'

j=1
if [ $j -lt 0 ]
then
  echo 'j < 0'
elif [ $j -gt 0 ]
then
  echo 'j > 0'
else # note: then is not needed for else statement!!!
  echo 'j = 0'
fi
