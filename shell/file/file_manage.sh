#!/bin/bash

echo 'access permission, number of hard links, owner, group, size, date time last modified, file name' > ls_out.txt
ls -l . >> ls_out.txt
sed -i '' '2d' ls_out.txt
