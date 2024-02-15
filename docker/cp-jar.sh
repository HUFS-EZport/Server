#!/bin/bash

echo "Getting server version..."
SERVER_VERSION=$(./gradlew properties -q | awk '/^version:/ {print $2}')
echo "Server version: ${SERVER_VERSION}"

echo "Getting server name..."
SERVER_NAME=$(./gradlew properties -q | awk '/^name:/ {print $2}')
echo "Server name: ${SERVER_NAME}"

FILE_PATH="./build/libs/${SERVER_NAME}-${SERVER_VERSION}.jar"
echo "Server jar path: ${FILE_PATH}"

cp $FILE_PATH ./server.jar
echo "${FILE_PATH} copied: ./server.jar"