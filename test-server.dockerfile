# Using Docker image: Gradle 7.6.4 with JDK 17 on Ubuntu 20.04
FROM gradle:7.6.4-jdk17-focal

LABEL description="Image for Ezports backend server"


# Set timezone to KST
RUN ln -snf /usr/share/zoneinfo/Asia/Seoul /etc/localtime

# Set working directory
WORKDIR /root/ezports


# Copy files
COPY ./src ./src
COPY ./build.gradle ./build.gradle
COPY ./gradlew ./gradlew
COPY ./settings.gradle ./settings.gradle
COPY ./gradle ./gradle

# Copy scripts
COPY ./docker/cp-jar.sh ./cp-jar.sh

# Build applicaation without test
RUN chmod +x ./gradlew
RUN ./gradlew build -x test

# Get server jar
RUN chmod +x ./cp-jar.sh
RUN ./cp-jar.sh

# Run server
CMD ["java", "-jar", "./server.jar"]