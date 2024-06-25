#!/bin/bash

## To find some specific files
find ./*.sh
find ./* -type f -name "input.txt"
echo '----------------------'

ls ./* | grep "input.txt"
