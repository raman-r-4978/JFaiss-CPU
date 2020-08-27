# JFaiss

Faiss bindings for Java **(linux only so far)**

## Requirement

- JDK v1.8
- Apache Maven v3.6.3
- Docker v19.03.12 (build 48a66213fe)

## Build JAR (maven)

Creating a JAR
```
mvn clean test package
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
