### 项目说明

#### 本项目目的

    对一些使用过的或者有待验证的技术进行整合汇总，作为一个实验田和技术档案的存在

#### 本项目的结构：
 
 poseidon
 
 —poseidon-center:项目启动和基本配置模块

 —poseidon-common：common模块（通用模块）

 —poseidon-core: core模块(非通用)

 —poseidon-request: 请求模块

 —poseidon-parent: 存放父pom

 —poseidon-system: 组织架构及权限管控

 —poseidon-web: 业务模块
 
 
#### 设计方面

模块内分层为：service controller entity repos core manager

repos: 数据库操作层;

service : 供controller调用的业务逻辑层;

controller：与前端交互的控制层;

manager:供其他service调用的松耦合层;

core:配置类，切面类，拦截器等其他系统相关类。
 
 
#### 项目技术相关

##### 框架：

springboot 2.0.6

quartz

hibernate validate

logback

Spring Security

flowable(建设中)

spring data jpa

webflux(建设中)

guava

##### 中间件相关

redis

rabbitMQ

MySql

nginx

jenkins

docker

elk

#### 解决或验证的问题

日志模块：灵活配置输出源（MQ ELK MYSQL FILE ）降低对系统侵入程度

消息推送模块：实现客户端主动推送，并保证其稳定性

定时任务模块：创建与执行定时任务

异步模块：管理线程池，执行多线程异步任务

安全模块：多登陆方式，动态权限，自定义角色，token验证

数据校验模块：完成数据校验功能

工作流模块：工作流使用测试

库存模块：验证库存进销存，验证多线程理论，解决多线程相关问题

请求过滤模块：redis锁保证幂等性，拦截非法请求及黑名单用户。


