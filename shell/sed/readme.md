## sed
1. Note: File line number start from 1
2. References: https://www.howtogeek.com/666395/how-to-use-the-sed-command-on-linux/
3. Pattern: {XXXXXX} means it needs to be replaced with your input
4. $ means the last line in a file
5. Note: some command not working on Mac, like ~.  eg. sed -n '3~9p' ./input.txt