#!/bin/bash

## arithmetic operation
echo `expr 1 + 2`
echo `expr 1+2` # Note: wrong expression, it will print a string "1+2" but not 3
echo $((1 + 2))
echo $((1+2))
a=1
b=2
# echo `expr $a+$b` # wrong expression
echo "$a + $b = `expr $a + $b`"
echo "$a - $b = `expr $a - $b`"
echo "$a * $b = `expr $a \* $b`" # note: * must be translated here
echo "$a / $b = `expr $a / $b`"
echo "$a % $b = `expr $a % $b`"

echo "$a + $b = $(($a + $b))"
echo "$a - $b = $(($a - $b))"
echo "$a * $b = $(($a * $b))" # note: * must not be translated here
echo "$a / $b = $(($a / $b))"
echo "$a % $b = $(($a % $b))"

echo '----------------------'