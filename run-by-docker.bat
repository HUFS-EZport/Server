@Echo off

echo Clear docker image before build...
./docker/clear-image.bat

echo Build and run Ezports backend server...
docker-compose up -d