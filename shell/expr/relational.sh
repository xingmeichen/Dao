#!/bin/bash

## Relational operation
a=1
b=2
echo "$a == $b ? $(($a == $b))"
echo "$a != $b ? $(($a != $b))"
echo "$a < $b ? $(($a < $b))"
echo "$a > $b ? $(($a > $b))"
echo "$a <= $b ? $(($a <= $b))"
echo "$a >= $b ? $(($a >= $b))"

a=1
b=1
echo 'Verify a == b'
if [ $a -eq $b -o $a == $b -o $a = $b ] # note: 3 ways to express if a equals to b
then
  echo "$a == $b"
fi

a=1
b=2
if [ $a -ne $b -o $a != $b ]
then
  echo "$a != $b"
fi

a=1
b=0
if [ $a -gt $b ]
then
  echo "$a > $b"
fi

a=1
b=2
if [ $a -lt $b ]
then
  echo "$a < $b"
fi

a=2
b=1
if [ $a -ge $b ]
then
  echo "$a >= $b"
fi

a=1
b=2
if [ $a -le $b ]
then
  echo "$a <= $b"
fi
echo '----------------------'