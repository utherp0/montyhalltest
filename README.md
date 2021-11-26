# montyhalltest Project

Quick little experiment, hosted as a restful service using Quarkus, for testing the odd stats you get from the 'Monty Hall' problem.

As some in the UK who doesn't know who Monty Hall is, here's the problem stated in English:

It's a permutation of the 'three shells' trick. In this case there are three boxes, in one of which the person running the game has placed a prize.

You choose one box. The person running it then offers you one of the other boxes as a swap. They know which box it is in and will offer you that box IF you haven't chosen it. You then decide whether to stick with the box you have or take their offered one instead. You then open the box.

With this model you have a 50/50 chance of getting the prize, even though you start with a 1 in 3 chance. More interestingly is the statistical probability of winning depending on whether you choose the offered box or stick with the one you have. It comes out as 2/3 successful if you choose to take the offered box; in total it's 50:50 to win, 1/6 to win if you choose and then stick, 1/3 if you choose to take the box. 

Those stats feel wrong but the test proves it.

Follow the instructions below to run the test - the experiment is available at /experiment1 with an optional parameter of 'runs' (i.e. /experiment1?runs=2000000)

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/montyhalltest-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- RESTEasy JAX-RS ([guide](https://quarkus.io/guides/rest-json)): REST endpoint framework implementing JAX-RS and more

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)
