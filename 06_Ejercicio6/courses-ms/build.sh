#!/usr/bin/env bash

rm -r build
mkdir build

cp docker/Dockerfile build
cp docker/docker-compose.yml build
cp target/courses-ms*.jar build/courses-ms.jar
cp scripts/courses.sql build

cd build || exit

docker compose build
