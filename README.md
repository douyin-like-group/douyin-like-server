# douyin-like-server
## 项目评价要点：
- 用户注册限制邮箱，是否可以增加手机号验证码注册，以及邮箱验证码注册
- 用户密码进行加密后存储在数据库，有哪些方式，MD5，雪花算法，加盐，等等
- 用户是如何鉴权的，JWT, cookie, session, 分布式session, spring AOP 统一鉴权， incerptor统一鉴权

### 数据层部分
- 数据库的索引是否设置合理，比如 select where a = order by b 这种 查询语句如何设置索引
- 如何使用事务的，比如更新用户信息，防止脏读
- 如何防止SQL注入的
- 如何使用redis进行缓存加速的， 有哪些问题; 除了点赞的缓存加速，关注列表同样也需要缓存加速

### 消息队列如何选型
- kafka, rocketMQ, RabbitMQ

### 测试部分
- 是否有完整的单元测试
- 

push develop分支 测试
数据库：
- 使用BCryptPasswordEncoder进行加密存储到数据库

![image](https://user-images.githubusercontent.com/33627638/219956577-529e9c31-9823-466f-8eb1-0d07fa516fe6.png)




https://user-images.githubusercontent.com/33627638/219956603-bf0ea890-900e-4e74-b1f6-0972ad5b604e.mp4

