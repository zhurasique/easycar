#!/bin/bash

mvn clean install

cd base-service
docker build . -t base-service
cd ..

cd config
docker build . -t config
cd ..

cd gateway
docker build . -t gateway
cd ..

cd image-service
docker build . -t image-service
cd ..

cd monitoring
docker build . -t monitoring
cd ..

cd registry
docker build . -t registry
cd ..

if [ $1 = "prune" ]; then
  y | docker image prune
fi

if [ $1 = "start" ] | [ $2 = "start" ]; then
  docker-compose up -d
fi