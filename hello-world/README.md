### HelloWorld

该项目是一个简单的 HelloWorld 项目。使用 GraalVM 的 `native-image` 将 Java 代码构建为二进制可执行文件，并分阶段构建 Docker 镜像。

#### 使用方式

1. 构建镜像
    ```shell
    docker image build -t hello-world:latest .
    ```
2. 运行
    ```shell
    docker run hello-world:latest
    ```
   
#### 运行效果

一个字母一个字母的打印：`Hello, world!`
