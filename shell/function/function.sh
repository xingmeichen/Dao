#!/bin/bash
## 1. Define function
## 2. Call function
## 3. Get the result of function
## 4. If no return statement in a function, the function will return 0 (0 means success)
## 5. The result of function must in [0, 255]
fun1() {
  echo "In fun1()"
}

fun2() {
  echo "In fun2()"
  return 0
}

fun1
result=$?
echo 'fun1() return: '$result
fun2
result=$?
echo 'fun2() return: '$result