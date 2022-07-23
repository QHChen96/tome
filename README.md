## 途觅项目
途觅，微服务架构商城，一个逐渐完善的整洁架构项目，实践ddd,tdd等设计理念。

以下是个大饼。
### 基础架构模块
#### tome-dependencies
预留着的依赖包, 后期可能会有更多的考虑，比如依赖管理之类的
#### tome-framework
底层技术的支撑层, 可以当做技术沉淀或者提高效率的工作
##### tome-framework-cache-starter
缓存技术
##### tome-framework-catchlog-starter
日志和异常捕获
##### tome-framework-coverage
覆盖率工具
##### tome-framework-ddd
ddd基础类库, 参考领域驱动设计模式
##### tome-framework-dto
数据传输对象基础类库
##### tome-framework-environment
环境, 考虑能管理各类环境的元数据
##### tome-framework-eventbus
消息总线, 考虑做事件驱动之类, 会接入消息中间件
##### tome-framework-exception
异常处理类库
##### tome-framework-extension-starter
扩展点, 做一些平台的扩展功能
##### tome-framework-metrics-starter
性能监控
##### tome-framework-openfeign
远程调用的个性化定制功能, 考虑实现对服务标签分组的调用, 解决不同服务版本之间的调用问题, 特别是在开发的时候, 可以自己控制调用链路, 全链路灰度
##### tome-framework-security
认证授权安全
##### tome-framework-tdd
测试工具套件, 可以考虑测试驱动开发的方式
##### tome-framework-threadpool
线程池管理工具, 避免对线程池的滥用, 系统中的线程池都要使用这个模块提供的工具, 可能会考虑接入动态线程池, 也可能自己研究开发一个
##### tome-framework-toolkit
各种工具套件, 考虑引入hutools。理想情况是自己实现，按需实现
##### tome-framework-tracing
链路追踪
##### tome-framework-web-starter
web
##### 更多规划
* 服务治理方向, 服务优雅下线, 异常摘除, 服务探针
* 异常排查工具
* 数据可视化
* 对spring扩展
* 数据脱敏
* 数据导入导出
* 文件服务

### 服务目录说明
#### 服务模块
* 各种核心业务服务, 尽量不分太细, 参考DDD的设计理念, 尽量依赖抽象, 保持服务内部边界清晰, 方便后续做更细粒度的拆分, 同时也不做教条化的DDD, 要有更多的思考。
* 考虑服务间依赖的强弱关系, 强依赖需要考虑高可用的问题,弱依赖对业务不会造成影响是可以支持降级的。
* 分布式事务该怎么处理
##### tome-gateway 网关
作为外部流量的入口
##### tome-service-marketing 营销服务
优惠券, 营销活动都会考虑放着这一层
##### tome-service-member 会员服务
维护会员的各种信息
##### tome-service-merchant 商家服务
视情况而定, 考虑做入驻型的商城
##### tome-service-payment 支付服务
聚合各类支付
##### tome-service-product 商品服务
商品相关的功能
##### tome-service-trade 交易服务
订单相关的功能
##### 更多服务在规划中...

##### 服务内部模块说明
* app层: 作为直接暴露出去的Rest或Rpc提供者, 可以直接使用domain和infra, 当时对外需提供DTO
* domain层: 领域对象层, 只关注业务, 不依赖具体技术细节, 尽量使用JSR规范的东西来描述, 数据存取操作只依赖repo抽象, 具体实现细节由infra去实现, 也就是说不考虑它是数据库、远程调用之类的操作
* facade层: 类似ddd的开放主机, 可以当做时跨服务通信的API, 只向外提供必要的接口, 理想情况下, 跨服务调用不会很多。引入外部的facade要装换成repo给domain使用(这里相当于与防腐层)
* infra层: 基础设施层，具体的技术实现细节, 比如使用mysql, 消息队列, 远程调用

### tome-java-agent
这是一个研究java-agent的模块, 考虑做一些无侵入的增强功能

💡 可以将循环依赖考虑用事件解耦