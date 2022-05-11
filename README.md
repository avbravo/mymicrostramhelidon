# Helidon Quickstart MP

Sample Helidon MP project that includes multiple REST operations.

## Build and run

With JDK11+
```bash
mvn package
java -jar target/mymicrostramhelidon.jar
```

## Exercise the application

```
curl -X GET http://localhost:8080/greet
{"message":"Hello World!"}

curl -X GET http://localhost:8080/greet/Joe
{"message":"Hello Joe!"}

curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting

curl -X GET http://localhost:8080/greet/Jose
{"message":"Hola Jose!"}
```

## Try health and metrics

```
curl -s -X GET http://localhost:8080/health
{"outcome":"UP",...
. . .

# Prometheus Format
curl -s -X GET http://localhost:8080/metrics
# TYPE base:gc_g1_young_generation_count gauge
. . .

# JSON Format
curl -H 'Accept: application/json' -X GET http://localhost:8080/metrics
{"base":...
. . .

```

## Build the Docker Image

```
docker build -t helidon-quickstart-mp .
```

## Start the application with Docker

```
docker run --rm -p 8080:8080 helidon-quickstart-mp:latest
```

Exercise the application as described above

## Deploy the application to Kubernetes

```
kubectl cluster-info                         # Verify which cluster
kubectl get pods                             # Verify connectivity to cluster
kubectl create -f app.yaml                   # Deploy application
kubectl get pods                             # Wait for quickstart pod to be RUNNING
kubectl get service helidon-quickstart-mp    # Verify deployed service
```

Note the PORTs. You can now exercise the application as you did before but use the second
port number (the NodePort) instead of 8080.

After you’re done, cleanup.

```
kubectl delete -f app.yaml
```

## Build a native image with GraalVM

GraalVM allows you to compile your programs ahead-of-time into a native
 executable. See https://www.graalvm.org/docs/reference-manual/aot-compilation/
 for more information.

You can build a native executable in 2 different ways:
* With a local installation of GraalVM
* Using Docker

### Local build

Download Graal VM at https://www.graalvm.org/downloads, the version
 currently supported for Helidon is `20.1.0`.

```
# Setup the environment
export GRAALVM_HOME=/path
# build the native executable
mvn package -Pnative-image
```

You can also put the Graal VM `bin` directory in your PATH, or pass
 `-DgraalVMHome=/path` to the Maven command.

See https://github.com/oracle/helidon-build-tools/tree/master/helidon-maven-plugin#goal-native-image
 for more information.

Start the application:

```
./target/helidon-quickstart-mp
```

### Multi-stage Docker build

Build the "native" Docker Image

```
docker build -t helidon-quickstart-mp-native -f Dockerfile.native .
```

Start the application:

```
docker run --rm -p 8080:8080 helidon-quickstart-mp-native:latest
```


## Build a Java Runtime Image using jlink

You can build a custom Java Runtime Image (JRI) containing the application jars and the JDK modules
on which they depend. This image also:

* Enables Class Data Sharing by default to reduce startup time.
* Contains a customized `start` script to simplify CDS usage and support debug and test modes.

You can build a custom JRI in two different ways:
* Local
* Using Docker


### Local build

```
# build the JRI
mvn package -Pjlink-image
```

See https://github.com/oracle/helidon-build-tools/tree/master/helidon-maven-plugin#goal-jlink-image
 for more information.

Start the application:

```
./target/helidon-quickstart-mp-jri/bin/start
```

### Multi-stage Docker build

Build the JRI as a Docker Image

```
docker build -t helidon-quickstart-mp-jri -f Dockerfile.jlink .
```

Start the application:

```
docker run --rm -p 8080:8080 helidon-quickstart-mp-jri:latest
```

See the start script help:

```
docker run --rm helidon-quickstart-mp-jri:latest --help
```

curl --location --request POST 'http://localhost:8080/personas/' \
--header 'Content-Type: application/json' \
--data-raw '{"id": 22, "name": "ana"}'


To launch the test page, open your browser at the following URL

```shell
http://localhost:8080/hello  
```
To execute the tests:


## Products
```shell
curl --location --request POST 'http://localhost:8080/products/' \
--header 'Content-Type: application/json' \
--data-raw '{"id": 1, "name": "banana", "description": "a fruit", "rating": 5}'

curl --location --request POST 'http://localhost:8080/products/' \
--header 'Content-Type: application/json' \
--data-raw '{"id": 2, "name": "watermelon", "description": "watermelon sugar ahh", "rating": 4}'

curl --location --request GET 'http://localhost:8080/products/'

curl --location --request GET 'http://localhost:8080/products/1'

```

## Personas
```
curl --location --request POST 'http://localhost:8080/personas/' --header 'Content-Type: application/json' --data-raw '{"id": 1, "name": "aris"}'

curl --location --request POST 'http://localhost:8080/personas/' --header 'Content-Type: application/json' --data-raw '{"id": 2, "name": "ana"}'

curl --location --request GET 'http://localhost:8080/personas/'

curl --location --request GET 'http://localhost:8080/personas/1'
```

## Provincias
```
curl --location --request POST 'http://localhost:8080/provincias/' --header 'Content-Type: application/json' --data-raw '{"id": 1, "name": "Los Santos"}'

curl --location --request POST 'http://localhost:8080/provincias/' --header 'Content-Type: application/json' --data-raw '{"id": 2, "name": "Herrera"}'

curl --location --request GET 'http://localhost:8080/provincias/'

curl --location --request GET 'http://localhost:8080/provincias/1'
```