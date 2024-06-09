#!/bin/bash

# Replace
## update file, replace old word with new word
## Note: -i means the file content will be changed !!
## sed -i 's/{old}/{new}/g' {the_file} ## replace every matching for the whole file, g: global
## sed -i 's/{old}/{new}/' {the_file}  ## replace the first matching for each line
sed -i 's/line_/line/g' ./input.txt
sed -i 's/line_/line/' ./input.txt

## update file, replace the whole line with new content
## sed -i '{n}c {new_content}' {the_file}
sed -i '2c abcd efg' ./input.txt

## update file, start from line m to n, replace all these lines with new content ($: the last line)
## sed -i '{m},{n}c {new_content}' {the_file}
sed -i '2,5c abcd efg' ./input.txt
sed -i '2,$c abcd efg' ./input.txt

## update file, start from line m, replace the whole line with new content every n line
## sed -i '{m}~{n}c {new_content}' {the_file}
sed -i '2~5c abcd efg' ./input.txt




