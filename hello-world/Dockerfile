# 第一阶段：编译 Java 程序为二进制文件
FROM ghcr.io/graalvm/native-image:22.3.1 AS builder
COPY HelloWorld.java /app/
WORKDIR /app
RUN javac HelloWorld.java && \
    native-image --static HelloWorld -o hello-world

# 第二阶段：构建镜像
FROM alpine:latest
COPY --from=builder /app/hello-world /app/
CMD ["/app/hello-world"]