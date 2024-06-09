#!/bin/bash

# The number of parameters passed in during script execution
param_count=$#
echo 'The number of parameters: '$param_count

whole_param=$*
echo $whole_param

every_param=$@
echo $every_param

current_pid=$$
echo $current_pid

last_current_pid=$!
echo $last_current_pid

last_execution_return=$?
echo $last_execution_return



