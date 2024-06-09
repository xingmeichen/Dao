#!/bin/bash

a=1
b=1
if test $a = $b
then
  echo 'a == b'
fi

a=1
b=2
if test $a -lt $b
then
  echo 'a < b'
fi
echo '......'


