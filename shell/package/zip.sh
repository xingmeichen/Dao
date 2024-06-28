#!/bin/bash

## ZIP是一种流行的文件压缩和归档格式，通常用于将多个文件或者文件夹压缩成一个单一的文件以便于存储和传输
## 对应的压缩工具有7-zip, WinRAR, WinZip
## 下文中，zip_source_file, 或者 zip_target_file 都表示zip文件

## -r 表示递归压缩， zip_target_file 表示解压后zip文件的名称（或者是带路径的zip文件）
zip -r {zip_target_file} {source_file}
eg.
zip ./zip-out.zip test-zip.txt  ## test-zip.txt 是单个文件
zip -r ./zip-out.zip t1-zip  ## t1-zip 是一个目录

## 解压缩 zip_source_file 表示待解压的zip文件
### 解压缩到当前目录
unzip {zip_source_file}

### 解压缩到指定指定目录
unzip {zip_source-file} -d {target_dir}

### 解压缩安静模式，不显示任何提示信息
unzip -q {zip_source_file}

## 查看zip文件内容（不解压）
unzip -l {source_file}


