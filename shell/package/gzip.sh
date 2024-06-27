#!/bin/bash

# Package file, the original will not keep
gzip ./a.txt

# force packaging file
gzip -f ./a.txt

# Package file, keep the original
gzip -c ./a.txt > ./a.txt.gz

# force packaging file, keep the original
gzip -cf ./a.txt > ./a.txt.gz

# Un-package file
gzip -d ./a.txt.gz

# force un-packaging file
gzip -df ./a.txt.gz
