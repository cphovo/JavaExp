# 第一阶段：编译 Java 程序为二进制文件
FROM ghcr.io/graalvm/native-image:22.3.1 AS builder
COPY HelloWorld.java /app/
WORKDIR /app
RUN javac HelloWorld.java && \
    native-image --static HelloWorld -o hello-world

# 第二阶段：构建镜像
FROM alpine:latest
# 不使用 --static（静态链接）命令时，可以选用包含 glibc-2.34 库的基础镜像
# FROM frolvlad/alpine-glibc:glibc-2.34
COPY --from=builder /app/hello-world /app/
CMD ["/app/hello-world"]