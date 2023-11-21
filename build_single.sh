#!/bin/bash
set -e

cd $1
if [[ $2 == "skip-tests" ]]; then
  mvn clean install -Dmaven.test.skip=true
else
  mvn clean install
fi
docker build . -t $1
cd ..
docker-compose stop $1
docker-compose rm -f $1
docker-compose up -d $1