#!/bin/bash

## tar 只是文件打包的工具，它本身不具备压缩的功能，但是可以与不同的压缩工具一起使用，如gzip, bzip2

## -z: 调用gzip压缩命令进行压缩
## -c: 表示create, 意思是创建一个档案（archive）
## -x: extract, 从档案中提取文件
## -v: 显示运行过程
## -f: 指定文件名
## -C: 指定解包到目标路径

### 打包多个文件
tar -cf {tar_target_file} {source_file1} {source_file2} ...

### 打包并压缩文件
tar -czvf {tar_target_file} {source_file}

### 解包文件到当前目录
tar -xvf {tar_source_file}

### 解包到指定目录 (目标目录必须是已经创建的目录)
tar -xvf {tar_source_file} -C {target_dir}
## eg. tar -xvf ./a.sh -C ./ ## (注意这里的目标目录是./ 而不是 .)


