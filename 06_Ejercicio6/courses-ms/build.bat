@ECHO OFF

RMDIR /S /Q build
MKDIR build

COPY /Y docker\Dockerfile build
COPY /Y docker\docker-compose.yml build
COPY /Y target\courses-ms*.jar build\courses-ms.jar
COPY /Y scripts\courses.sql build

CD build || EXIT /B

docker compose build
