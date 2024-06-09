#!/bin/bash

## logical operation

if [ !false ]
then
  echo "True"
fi

# Option 1 for or expression []
if [ 3 -lt 2 -o 3 -lt 4 ]
then
  echo '3 < 2 or 3 < 4'
fi

# Option 2 for or expression [[]]
if [[ 3 -lt 2 || 3 -lt 4 ]]
then
  echo '3 < 2 or 3 < 4'
fi

# Option 1 for and expression []
if [ 1 -lt 2 -a 3 -lt 4 ]
then
  echo '1 < 2 and 3 < 4'
fi

# Option 2 for and expression [[]]
if [[ 1 -lt 2 && 3 -lt 4 ]]
then
  echo '1 < 2 and 3 < 4'
fi

echo '------------------'


