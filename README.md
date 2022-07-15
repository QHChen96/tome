## 途觅项目
途觅，微服务架构商城，一个逐渐完善的整洁架构项目，实践ddd,tdd等设计理念


app层: 作为直接暴露出去的Rest或Rpc提供者, 可以直接使用domain和infra, 当时对外需提供DTO
domain层: 领域对象层, 只关注业务, 不依赖具体技术细节, 尽量使用JSR规范的东西来描述, 数据存取操作只依赖repo抽象, 具体实现细节由infra去实现, 也就是说不考虑它是数据库、远程调用之类的操作
facade层: 类似ddd的开放主机, 可以当做时跨服务通信的API, 只向外提供必要的接口, 理想情况下, 跨服务调用不会很多。引入外部的facade要装换成repo给domain使用(这里相当于与防腐层)
infra层: 基础设施层，实现具体的持久化操作, 事件