#!/usr/bin/env bash

mvn clean package

echo 'Copy files'

scp /d/MyJavaLearnProject/livingapp/target/livingapp-1.0-SNAPSHOT.jar polyroot@172.17.18.135:/home/polyroot

echo 'Restart server...'

ssh polyroot@172.17.18.135 << EOF

    pgrep java | xargs kill -9
    nohup java -jar livingapp-1.0-SNAPSHOT.jar > log.txt &

EOF

echo 'Bye'
