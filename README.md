# JFaiss **(Linux only)**

Faiss bindings for Java

## Requirement

- JDK v1.8
- Apache Maven v3.6.3
- Docker v19.03.12

## Build JAR (maven)

Run the test cases
```
mvn clean test -Dtest=FaissTestRunner
```

Creating a JAR
```
mvn package
```

## Building from source (docker)

Install faiss and generate required Java files
```
git clone https://github.com/RamanRajarathinam/JFaiss.git
cd JFaiss
git submodule update --init
docker build -t jfaiss-source .
```
This will generate required `.java` files from `swigfaiss.swig`

## To-do

* [ ] Publish to mvn
* [ ] GPU support

## Reference

- <https://github.com/gameofdimension/jni-faiss>
- <https://github.com/adamheinrich/native-utils>
- <https://github.com/thenetcircle/faiss4j>
