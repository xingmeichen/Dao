#!/bin/bash

# Append
## update file, add new_content after line n
## sed -i '{n}a {new_content}' {the_file} (n means line number, a means append?)
sed -i '2a insert new line before line 2' ./input.txt

## update file, start from line m to n, add new line after ($ means the last line)
## sed -i '{m},{n}a {new_content}' {the_file}
sed -i '3,7a abcdefg hijk' ./input.txt
sed -i '3,$a abcdefg hijk' ./input.txt

## update file, start from line m, add new line after every n line
## sed -i '{m}~{n}a {new_content}' {the_file}
sed -i '3~2a abcdefg hijk' ./input.txt

