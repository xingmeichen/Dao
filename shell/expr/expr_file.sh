#!/bin/bash

## expression for file verification
file=$(pwd)
echo $file

## if file exist
if [ -e $file ]
then
  echo 'file exists'
fi

## if file is readable
if [ -r $file ]
then
  echo 'file is readable'
fi

## if file is writable
if [ -w $file ]
then
  echo 'file is writable'
fi

## if file is executable
if [ -x $file ]
then
  echo 'file is executable'
fi

## if file is not empty
if [ -s $file ]
then
  echo 'file is not empty'
fi

## if the file is a ordinary file (neither device nor directory)
if [ -f $file ]
then
  echo 'file is an ordinary file'
else
  echo 'file is not an ordinary file'
fi

## if the file is a directory
if [ -d $file ]
then
  echo 'file is a directory'
else
  echo 'file is not a directory'
fi

## if the file is block device
if [ -b $file ]
then
  echo 'file is a block device'
else
  echo 'file is not a block device'
fi

## if the file is character device
if [ -c $file ]
then
  echo 'file is a character device'
else
  echo 'file is not a character device'
fi

echo '......'









