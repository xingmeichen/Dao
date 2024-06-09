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
  echo 'a equals to b'
fi

c=
if [ -z $c ]
then
  echo 'c is empty'
fi

d='App'
if [ -n $c ]
then
  echo 'd is not empty'
fi

e=' '
if [ $c ]
then
  echo 'e is not blank'
else
  echo 'e is blank'
fi

e=' '
if [ !$c ]
then
  echo 'e is blank'
else
  echo 'e is not blank'
fi



