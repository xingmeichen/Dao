#!/bin/bash

## the operation of string
a='Apple'
b='Apple'
if [ $a = $b ]
then
  echo 'a equals to b'
fi

a='Apple'
b='App'
if [ $a != $b ]
then
  echo 'a not equals to b'
fi

c=
if [ -z $c ]
then
  echo 'the lenght of c is 0'
fi

d='App'
if [ -n $d ]
then
  echo 'the length of d is not 0'
fi

e='abc'
if [ $e ]
then
  echo 'e is not empty'
else
  echo 'e is empty'
fi

f=''
if [ !$f ]
then
  echo 'f is empty'
else
  echo 'f is not empty'
fi



