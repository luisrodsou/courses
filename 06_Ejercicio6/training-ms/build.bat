@ECHO OFF

RMDIR /S /Q build
MKDIR build

COPY /Y docker\Dockerfile build
COPY /Y docker\docker-compose.yml build
COPY /Y target\training-ms*.jar build\training-ms.jar
COPY /Y scripts\courses.sql build

CD build || EXIT /B

docker compose build
