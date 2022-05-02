#!/bin/bash

mvn clean install

build_image() {
  cd $1
  docker build . -t $1
  cd ..
}

build_image config
build_image gateway
build_image base-service
build_image image-service
build_image monitoring
build_image registry

if [ $1 = "prune" ]; then
  docker image rm -f $(docker images -f dangling=true -q)
fi

if [ $1 = "start" ] | [ $2 = "start" ]; then
  docker-compose up -d
fi