# SpringBoot集成Dubbo分布式框架

> **接口工程**
>
>> 存放实体bean和业务接口
>>
>
> **服务提供者**
>
>> 业务接口的实现类并将服务暴露,且注册到注册中心,调用数据持久层
>>
>
> **服务消费者**
>
>> 处理浏览器客户端的请求,从注册中心调用服务
>>
>

---

#### ***1.添加依赖***

###### a.dubbo:

```xml
<dependency>
	<groupId>org.apache.dubbo </groupId>
	<artifactId>dubbo-spring-boot-starter </artifactId>
	<version>2.7.11 </version>
</dependency>
```

###### b.zookeeper注册中心:

```xml
<dependency>
	<groupId>org.apache.curator </groupId>
	<artifactId>curator-recipes </artifactId>
	<version>4.1.0 </version>
	<exclusions>
		<exclusion>
			<groupId>org.apache.zookeeper </groupId>
			<artifactId>zookeeper </artifactId>
		</exclusion>
	</exclusions>
</dependency>
<dependency>
	<groupId>org.apache.zookeeper </groupId>
	<artifactId>zookeeper </artifactId>
	<version>3.5.7 </version>
</dependency>
```

###### c.接口工程:

```xml
 <dependency>
 	<groupId>com.faustofan</groupId>
 	<artifactId>dubbo-interface</artifactId>
 	<version>1.0.0</version>
 </dependency>
```

---

#### ***2.配置核心配置文件***

###### a.服务提供者: {xml}

```xml
# 设置内嵌Tomcat端口号
server.port=8081

# 设置上下文根
server.servlet.context-path=/

# 配置dubbo

# 1.设置服务名称
dubbo.application.name=springboot-dubbo-provider
# 2. 声明当前工程是一个服务提供者
dubbo.server=true
# 3. 通信规则 (协议与接口)
dubbo.protocol.name=dubbo
dubbo.protocol.port=20880

# 3.设置注册中心
dubbo.registry.address=zookeeper://localhost:2181
```

###### b.消费者:

```xml
# 设置内嵌Tomcat端口号, 和上下文根
server.port=8080
server.servlet.context-path=/

#配置dubbo消费者
# 1.设置服务名称
dubbo.application.name=springboot-dubbo-consumer
# 2.指定注册中心
dubbo.registry.address=zookeeper://localhost:2181
```

---

#### ***3.添加注解***

###### a.服务提供者-服务接口实现类:

```java
@Component
@DubboService(interfaceClass = StudentService.class , version = 1.0.0 , tomeout = 15000)
```

###### b.消费者-控制类引用的服务对象:

```java
@DubboReference(interfaceClass = StudentService.class , version = 1.0.0 , checkout =false)
```

###### c.服务提供者和消费者Springboot启动类:

```java
@EnableDubbo
```

---
