# Apache Kafka Learhing Project

This is my small project where I learn and test Apache Kafka.

## Project Idea

The project consists of three parts.

1. The first part is Producer. This part listens to a websocket channel provided by Coinbase, extracts data about latest sell / buy transactions performed on the platform. Then this data is sent over Kafka topic to consumers.
2. The second part is the first Consumer. This part simply receives data and write it down into the log file.
3. The third part is the second Consumer. This part receives data and saves it to a database storing and running in a container.

## Setup guide

1. Open your Docker Desktop and run the Docker Engine.
2. Start containers using "docker-compose up -d".
3. Launch each component of the app. 

## Techologies used

Kafka, Docker, Spring, WebSockets.
