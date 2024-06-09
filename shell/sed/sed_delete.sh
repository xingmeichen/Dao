#!/bin/bash

# Delete
## update file, delete some lines
## sed -i '{n}d' {the_file}  ## delete line n
sed -i '3d' ./input.txt

## update file, delete some lines
## sed -i '{m},{n}d' {the_file}  ## delete line m to n ($ means the last line)
sed -i '2,4d' ./input.txt
sed -i '2,$d' ./input.txt

## update file, delete some lines
## start from line m, delete one line every n line
## sed -i '{m}~{n}d' {the_file}
sed -i '2~4d' ./input.txt