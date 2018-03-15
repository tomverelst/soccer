# Demo Application

This is a sample application that is able to send messages to RabbitMQ,
and to send messages to RabbitMQ.

This application is about soccer and has a few components:

- **Football**: a  football that can have a direction and velocity. Resembles a message.
- **Forward**: a player that kicks balls towards the goal. This component is a message publisher and publishes messages to the goal (output channel).
- **Keeper**: a player that defends the goal and tries to catch the footballs. This component listens for messages on the goal (input channel).
- **Goal**: This component has input channels (for kicking footballs) and output channels (for catching footballs).

## Prerequisites

- Java 8
- Maven
- Docker

## Building the application

Run the following Maven command to build, test and package the application.

```
$ mvn clean package
```

If the build succeeds,
an artifact is created under the `target` folder.

## Packaging the application with Docker

After the application has successfully been built,
the application can be packaged with Docker.

```
$ docker build -t <imagename> .
```

## Running the application

Start rabbitmq and the application with Docker Compose:

```
$ docker-compose up -d
```

To stop everything, run the following command::

```
$ docker-compose down
```

## Endpoints

- `GET /`: Kick the ball
- `GET /results`: Returns the result as JSON  



