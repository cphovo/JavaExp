### QuickStart

该项目是一个简单的 Maven 项目。使用 GraalVM 的 `native-image` 将 Java 代码构建为二进制可执行文件，并分阶段构建 Docker 镜像。

#### 使用方式

1. 构建 builder 镜像
   
   使用 [Dockerfile](Dockerfile.graalvm-jdk17) 自行构建
   ```dockerfile
   docker image build -t cphovo/graalvm-jdk17:latest -f Dockerfile.graalvm-jdk17 .
   ```
   或者使用 Docker Hub 上已经构建好的镜像
   ```dockerfile
   docker pull cphovo/graalvm-jdk17:latest
   ```

2. 多阶段构建 [fortune:latest](Dockerfile)镜像
    ```shell
    docker image build -t fortune:latest .
    ```
3. 运行
    ```shell
    docker run --rm fortune:latest
    ```

#### 运行效果

随机一个字母一个字母的打印一句名言或诗词，如：
```
❯ docker run --rm fortune:latest
树深时见鹿，溪午不闻钟。  -- 李白
```
