压缩传输和IDL看下


https://github.com/apache/dubbo-samples/tree/master/dubbo-samples-protobuf


```sh
mkdir src/main/java/com/example/demo/gen/

protoc -I=src/main/java/com/example/demo/proto --java_out=src/main/java DemoService.proto
```
