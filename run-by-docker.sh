#!/bin/bash

chmod +x ./docker/clear-image.sh

echo Clear docker image before build...
./docker/clear-image.sh

echo Build and run Ezports backend server...
docker-compose -f test-server.compose.yml --env-file .env up -d