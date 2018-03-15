#!/bin/sh

##  Skin Service Bootstrap Script ##
MEM_MAX=1303m
MEM_MIN=1303m
active=pro


CRF_HOME=$(cd `dirname $0`;cd .. ;pwd)
pidcount=`ps -ef|grep java|grep ${CRF_HOME}|wc -l`
if [ "$pidcount" -le 0 ]; then
	nohup java -Xms${MEM_MAX} -Xmx${MEM_MIN} -Dspring.profiles.active=${active} -jar ${CRF_HOME}/phoenix-0.0.1.jar >/dev/null 2>&1 &
	sleep 2
	pid=`ps -ef|grep java|grep ${CRF_HOME}|awk '{print $2}'`
	if [ -z "$pid" ]; then
		echo "${CRF_HOME}-$1 (pid:$pid ) fails to bootstrap!"
	else
		echo "${CRF_HOME}-$1 (pid:$pid ) bootstrap successfully!"
	fi

else
	echo "${CRF_HOME} has already started!"
fi



