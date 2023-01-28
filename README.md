# dubbo demo

### deploy

.

### demos

* [基本调用](./demos/basic)： 默认使用二方包的形式
    * [注解](./demos/basic/annotation_config)
        * `@Autowired`
        * `@DubboReference`
    * [xml配置](./demos/basic/xml_config)
    * [spring @Autowired 使用](./demos/basic/spring_autowired)
* [-] 配置参数  --看下DubboReference和DubboService注解足够了
* [异步调用或执行](./demos/async_and_sync)
* [隐式参数传递 / 上下文信息](./demos/context)
* [later] 回调
    > https://github.com/apache/dubbo-samples/blob/master/2-advanced/dubbo-samples-callback
* [later] 调用链 chain
* [ ] [泛化调用](./demos/generic)
    > https://github.com/apache/dubbo-samples/tree/master/2-advanced/dubbo-samples-generic
* [cutoff] 限流 sentinel （一般微服务直接包掉了）
* [序列化和反序列化](./demos/serialization)
    * [ ] [protobuf](./demos/serialization/protobuf)
    * [kryo](./demos/serialization/kryo)
* [cutoff] [事务](./demos/transaction)
* [cutoff] 分组服务 （目前用不到）
* [参数效验](./demos/validation)

### ref

* https://dubbo.apache.org/zh/index.html
* https://github.com/apache/dubbo-samples
* https://github.com/AmosWang0626/docker-dubbo
