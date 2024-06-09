#!/bin/bash

# Insert
## update file, add new_content before line n
## sed -i '{n}i {new_content}' {the_file} (n means line number, i means insert?)
sed -i '2i insert new line before line 2' ./input.txt

## update file, start from line m to n, add new line before
## sed -i '{m},{n}i {new_content}' {the_file}
sed -i '3,9i abcdefg hijk' ./input.txt
sed -i '3,$i abcdefg hijk' ./input.txt

## update file, start from line m, add new line before every n line
## sed -i '{m}~{n}i {new_content}' {the_file}
sed -i '3~2i abcdefg hijk' ./input.txt
