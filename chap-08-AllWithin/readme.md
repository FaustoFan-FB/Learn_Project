#Springboot集成多种服务
>  Dubbo , Redis , Mybatis , JSP

---

### 概览  

* 接口工程
> 普通maven工程,存放实体bean和业务接口的 

* 服务提供者
> *springboot框架web项目,集成mybatis,redis*
> 1. 添加依赖
> > mybatis依赖 , mysql驱动依赖 , dubbo依赖 , zookeeper依赖 , redis依赖 , 接口工程
> 2. 配置springbbot核心配置文件  
> > 连接数据库 , 连接redis , 配置dubbo

* 服务消费者
> *springboot框架web项目,集成JSP,dubbo*
> 1. 添加依赖
> > dubbo依赖 , zookeeper依赖 , JSP解析依赖 , 接口工程
> 2. 配置springbbot核心配置文件
> > 视图解析器 , 配置dubbo

---

### 详细配置

* ***接口工程***

1. 构建包结构  
> src  
> > main  
> > > java  
> > > > com.faustofan.interfaceDubbo
> > > > > model.Student | service.StudentService  

2. 实体类实现Serializable接口

3. 服务接口添加方法

---

* ***服务提供者***

1. 构建包结构
> src
> > main
> > > java
> > > > com.faustofan.provider
> > > > > mapper.StudentMapper
> > > >
> > > > > service.StudentServiceImpl
> >
> > > resources
> > > > mapper.StudentMapper.xml
> > >
> > > > static
> > > 
> > > > templates
> > >
> > > > application.properties

2. 构建maven工程并添加依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	
	<groupId>com.faustofan</groupId>
	<artifactId>provider</artifactId>
	<version>1.0.0</version>
	
	<name>provider</name>
	<description>Demo project for Spring Boot</description>
	
	<properties>
		<java.version>11</java.version>
	</properties>
	<dependencies>
		<!--springboot的web起步依赖-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		<!--mysql依赖-->
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>
		<!--mybatis整合springboot的起步依赖-->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.2.0</version>
		</dependency>
		
		<!--redis依赖-->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-redis</artifactId>
		</dependency>
		
		<!--dubbo依赖-->
		<dependency>
			<groupId>org.apache.dubbo</groupId>
			<artifactId>dubbo-spring-boot-starter</artifactId>
			<version>2.7.11</version>
		</dependency>
		<!--注册中心依赖-->
		<dependency>
			<groupId>org.apache.curator</groupId>
			<artifactId>curator-recipes</artifactId>
			<version>4.1.0</version>
			<exclusions>
				<exclusion>
					<groupId>org.apache.zookeeper</groupId>
					<artifactId>zookeeper</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.apache.zookeeper</groupId>
			<artifactId>zookeeper</artifactId>
			<version>3.5.7</version>
		</dependency>
		
		<!--接口工程-->
		<dependency>
			<groupId>com.faustofan</groupId>
			<artifactId>interface</artifactId>
			<version>1.0.0</version>
		</dependency>
	</dependencies>
	
	<build>
		<resources>
			<resource>
				<directory>src/main/java</directory>
				<includes>
					<include>**/*.xml</include>
				</includes>
			</resource>
		</resources>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>

```

3. 配置springboot核心配置文件

```properties
#设置内嵌Tomcat端口号
server.port=8081
#设置上下文根
server.servlet.context-path=/

#配置数据库连接信息

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/springboot?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2B8
spring.datasource.username=root
spring.datasource.password=1096249048
#指定mapper映射文件位置
mybatis.mapper-locations=classpath:mapper/*.xml

#redis配置信息
spring.redis.host=192.168.192.140
spring.redis.port=6379


# 配置dubbo

# 1.设置服务名称
dubbo.application.name=springboot-dubbo-provider
# 2. 声明当前工程是一个服务提供者
dubbo.server=true
# 3. 通信规则 (协议与接口)
dubbo.protocol.name=dubbo
dubbo.protocol.port=20880

# 设置注册中心
dubbo.registry.address=zookeeper://localhost:2181

```

4. 相关类与方法添加注解

* 服务实现类
```java.annotation
@Component
@DubboService(interfaceClass = StudentService.class , version = "1.0.0" , timeout = 15000)
```

* 启动类
```java.annotation
@EnableDubbo
@MapperScan(basePackages = "com.faustofan.provider.mapper")
```

---

* ***服务消费者***

1. 构建包结构
> src
> > main
> > > java
> > > > com.faustofan.consumer
> > > > > web.StudentController
> >
> > > resources
> > > > static
> > >
> > > > templates
> > >
> > > > application.properties
> >
> > > webapp
> > > > studentDetail.jsp

2. 构建maven工程并添加依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.5.1</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	
	<groupId>com.faustofan</groupId>
	<artifactId>consumer</artifactId>
	<version>1.0.0</version>
	
	<name>consumer</name>
	<description>Demo project for Spring Boot</description>
	
	<properties>
		<java.version>11</java.version>
	</properties>
	
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		
		<!--dubbo依赖-->
		<dependency>
			<groupId>org.apache.dubbo</groupId>
			<artifactId>dubbo-spring-boot-starter</artifactId>
			<version>2.7.11</version>
		</dependency>
		<!--注册中心依赖-->
		<dependency>
			<groupId>org.apache.curator</groupId>
			<artifactId>curator-recipes</artifactId>
			<version>4.1.0</version>
			<exclusions>
				<exclusion>
					<groupId>org.apache.zookeeper</groupId>
					<artifactId>zookeeper</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.apache.zookeeper</groupId>
			<artifactId>zookeeper</artifactId>
			<version>3.5.7</version>
		</dependency>
		
		<!--接口工程-->
		<dependency>
			<groupId>com.faustofan</groupId>
			<artifactId>interface</artifactId>
			<version>1.0.0</version>
		</dependency>
		
		<!--JSP依赖-->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
		</dependency>
	</dependencies>
	
	<build>
		<resources>
			<resource>
				<directory>src/main/webapp</directory>
				<targetPath>META-INF/resources</targetPath>
				<includes>
					<include>*.*</include>
				</includes>
			</resource>
		</resources>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

3. 配置springboot核心配置文件

```properties
#配置内嵌Tomcat端口号
server.port=8080
#设置上下文根
server.servlet.context-path=/

#配置视图解析器
spring.mvc.view.prefix=/
spring.mvc.view.suffix=.jsp

#配置dubbo消费者

# 1.设置服务名称
dubbo.application.name=springboot-dubbo-consumer
# 2.指定注册中心
dubbo.registry.address=zookeeper://localhost:2181

```

4. 相关类与方法添加注解

* 控制类引用的的服务实现类对象
```java.annotation
@DubboReference(interfaceClass = StudentService.class , version = "1.0.0" , check = false)
```

* 启动类
```java.annotation
@EnableDubbo
```