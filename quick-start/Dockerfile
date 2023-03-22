# 第一阶段：编译 Java 程序为二进制文件
FROM cphovo/graalvm-jdk17:latest AS builder
ENV LANG C.UTF-8
COPY . /app/
WORKDIR /app
RUN mvn clean package && \
    mvn -Pnative -Dagent exec:exec@java-agent && \
    mvn -DskipTests=true -Pnative -Dagent package


# 第二阶段：构建镜像
FROM alpine:latest
COPY --from=builder /app/target/fortune /app/
ENV LANG C.UTF-8
CMD ["/app/fortune"]