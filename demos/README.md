# demos

这里有些没有拆二方包，按照子目录的方式拆分的。

本应是：
* `sample-server`： 引入`sample-api`，然后实现接口
* `sample-api`： 只是定义接口、request、response
* `sample-client`： 引入`sample-api`，然后调用接口
