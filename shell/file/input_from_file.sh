#!/bin/bash

echo 'Test starting'
cat < ./input.txt
echo 'Test done'

## << 表示结束的输入字符, 在终端上执行如下命令，将会提示用户从键盘输入，直到遇到 eof 结束
# << 'eof'
echo '------------'

## 下面的命令将会从键盘读取数据并写入 catfile.txt 文件中, 直到遇到 e 字符结束，
## 下面两个命令是等价的（不过我自己看不懂第二个命令，我觉得它的写法更难于理解）
# << 'e' cat > catfile.txt
# cat > catfile.txt << 'e'

