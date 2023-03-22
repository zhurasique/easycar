#!/bin/bash
set -e

if [[ $2 == "skip-tests" ]] | [[ $3 == "skip-tests" ]]; then
  mvn clean install -Dmaven.test.skip=true
else
  mvn clean install
fi

build_image() {
  cd $1
  docker build . -t $1
  cd ..
}

build_image auth
build_image config
build_image gateway
build_image monitoring
build_image registry
build_image base-service
build_image image-service
build_image location-service
build_image account-service
build_image advert-service

if [[ $1 == "prune" ]]; then
  docker image rm -f $(docker images -f dangling=true -q)
fi

if [[ $1 == "start" ]] | [[ $2 == "start" ]]; then
  docker-compose up -d
fi