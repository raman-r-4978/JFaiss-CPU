FROM centos:7

RUN yum install -y lapack lapack-devel

# Install necessary build tools
RUN yum install -y gcc-c++ make swig3
RUN yum install -y java-1.8.0-openjdk java-1.8.0-openjdk-devel maven

COPY . /opt/JFaiss
WORKDIR /opt/JFaiss/faiss

# Install faiss
RUN ./configure --prefix=/usr --libdir=/usr/lib64 --without-cuda
RUN make -j $(nproc)
RUN make install

# Create source files
WORKDIR /opt/JFaiss/jni
RUN make