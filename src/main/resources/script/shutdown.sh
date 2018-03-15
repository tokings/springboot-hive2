#!/bin/sh

CRF_HOME=$(cd `dirname $0`;cd .. ;pwd)
pidcount=`ps -ef|grep java|grep ${CRF_HOME}|wc -l`
if [ "$pidcount" -le 0 ]; then
	echo "${CRF_HOME} has not started!"
else
	pid=`ps -ef|grep java|grep ${CRF_HOME}|awk '{print $2}'`
	kill -9 pid
	echo "${CRF_HOME} has stopped."
fi
