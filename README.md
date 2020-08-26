# JFaiss

Faiss bindings for Java **(linux only so far)**

## Requirement

- JDK v1.8
- Apache Maven v3.6.3
- Docker v19.03.12 (build 48a66213fe)
 
## Building JFaiss with docker and maven

### Step 1
Install faiss and generate required Java files
```
git clone https://github.com/RamanRajarathinam/JFaiss.git
cd JFaiss
git submodule update --init
docker build -t jfaiss-source .
```
This will generate `.java` files from `swigfaiss.swig`

### Step 2

Now copy the src files from docker to host
1. start the docker container `jfaiss-source`
2. copy the `cpu` folder to host by running
```
docker cp <containerId>:/opt/jfaiss/cpu .
```

*(Note: Current repo has all the files generated upto Step 2, hence user doesn't need to generate files again)*

### Step 3
1. Run test cases
```
mvn clean test
```
2. Package as JAR
```
mvn package
``` 


## To-do

* [ ] Native lib for MacOS
* [ ] GPU support

## Reference

- <https://github.com/gameofdimension/jni-faiss>
- <https://github.com/adamheinrich/native-utils>
- <https://github.com/thenetcircle/faiss4j>