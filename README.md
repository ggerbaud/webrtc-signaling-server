# WebRTC signaling server POC

This is my own signaling server implementation using Spring boot and WebSockets

## How-to

### Launch the server the Docker way

You can launch the server with this one-liner. The server will then listen to port 8080.

```
docker run -d \
--name server \
-v ~/.m2:/root/.m2 \
-v $(pwd)/server:/usr/src/app \
-w /usr/src/app \
-p 8080:8080 \
maven:3.3.3-jdk-8 \
mvn clean spring-boot:run
```

NB: this launch a maven image (building tool) with a maven plugin to launch the spring-boot standalone tomcat. This is obviously not production ready.

### Launch the server the maven way

The server will then listen to port 8080.

```
mvn -f server/pom.xml clean spring-boot:run
```

### Test with the client (the docker way)

First launch a small nginx server with client source
```
docker run -d \
--name client \
-v $PWD/client:/usr/share/nginx/html \
-p 8081:80 \
nginx
```

Then in a browser open 2 tabs to http://localhost:8081

In the Chrome console (ctrl+shift+I), in the second tab, type
```
connect("B");
```
It will register the client to the signal server, opening a websocket between them

In the Chrome console, in first tab, type
```
connect("A");
startRTC();
offer("B");
```
It will register A, initiate a RTCConnection and ask signal server to connect to B.

If you go to the second tab you should see 2 video stream, local below remote ("A"). Of course it's the same stream if you are on only one machine.


### Clean up

```
docker rm -vf server client
```
