#!/bin/bash

## Print file
## print line n
## sed -n '{n}p' {the_file}
sed -n '2p' ./input.txt

## print line m to n
## sed -n '{m},{n}p' {the_file}
sed -n '2,6p' ./input.txt
sed -n '2,$p' ./input.txt

## start from line m, print every n line
## sed -n '{m}~{n}p' {the_file}
sed -n '3~2p' ./input.txt

## print the line which with "search"
## sed -n '/{search_content}/p' {the_file}
sed -n '/new/p' input.txt

