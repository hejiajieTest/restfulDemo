本项目采用restful风格，主要用到@Path，@GET，@POST，@PUT，@DELETE，
@Prpduces(MediaType.APPLICATION_JSON),@Consumes(MediaType.APPLICATION_JSON)等等一些注解。
这些注解需要引用jar包是
<!-- https://mvnrepository.com/artifact/javax.ws.rs/jsr311-api -->
	<!-- restful风格jar包，spring无法识别这些注解，所以启动方式无法再用spring来启动 -->
	<dependency>
	    <groupId>javax.ws.rs</groupId>
	    <artifactId>jsr311-api</artifactId>
	    <version>1.1.1</version>
	</dependency>

<!--调用@Path注解，需要依赖jersey相关jar包，引入相关jar包-->
	<!--jersey-spring集成包--> 
	<dependency>
    	<groupId>org.glassfish.jersey.ext</groupId>
    	<artifactId>jersey-spring4</artifactId>
    	<version>2.26</version>
	</dependency>
	<!-- jersey启动包-->
	<dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-multipart</artifactId>
        <version>2.26</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.containers</groupId>
        <artifactId>jersey-container-servlet</artifactId>
        <version>2.26</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.media</groupId>
        <artifactId>jersey-media-json-jackson</artifactId>
        <version>2.26</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.ext</groupId>
        <artifactId>jersey-spring4</artifactId>
        <version>2.26</version>
    </dependency>
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>servlet-api</artifactId>
        <version>2.5</version>
        <scope>provided</scope>
    </dependency>  

 <!--spring相关注解需要依赖spring相关jar包-->
 	<!--Spring start -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>4.1.4.RELEASE</version>
    </dependency>
    
    <dependency>
	     <groupId>org.springframework</groupId>
	     <artifactId>spring-web</artifactId>    
	     <version>4.1.4.RELEASE</version>
	</dependency>
<!-- spring end -->
。
<!-- mybatis相关jar包-->

	 <!-- mybatis start -->
	<dependency>
         <groupId>org.mybatis</groupId>
         <artifactId>mybatis</artifactId>
         <version>3.2.8</version>
	</dependency>
	 <dependency>
         <groupId>org.mybatis</groupId>
         <artifactId>mybatis-spring</artifactId>
         <version>1.2.2</version>
     </dependency>
  	<!-- mybatis end -->
  	
 <!--jetty方式启动项目，需要依赖jar包-->
   <!-- jetty 需要的jar start -->
  	<dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-webapp</artifactId>
        <version>9.2.6.v20141205</version>
    </dependency>
	<dependency>
		<groupId>org.eclipse.jetty</groupId>
		<artifactId>jetty-server</artifactId>
		<version>9.2.6.v20141205</version>
		</dependency>
	<dependency>
        <groupId>org.eclipse.jetty</groupId>
        <artifactId>jetty-jsp</artifactId>
        <version>9.2.6.v20141205</version>
        <exclusions>
            <exclusion>
                <groupId>org.eclipse.jetty.orbit</groupId>
                <artifactId>org.eclipse.jdt.core</artifactId>
            </exclusion>
            <exclusion>
                <groupId>javax.servlet</groupId>
                <artifactId>javax.servlet-api</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
	<!-- jetty 需要的jar end -->

<!--web.xml中 启动类不在用spring的启动类dispatcherServlet-->
需要使用org.glassfish.jersey.servlet.ServletContainer容器启动

<!--其他配置与项目结构目录直接拷贝或者参考spring-mybatis-->


<!--用jetty启动-->
由于导入了
	<dependency>
	    <groupId>javax.ws</groupId>
	    <artifactId>rs-api</artifactId>
	    <version>2.0</version>
	</dependency>
导致启动报错
<!--删除该包后。启动没问题，但是找不到找不到service注解，用tomcat启动，可以正常找到spring注解-->
<!--给人感觉也是没有运行applicationContext.xml这个文件，于是，加一个监听器，去启动applicationContext.xml这个文件-->
	 <context-param>
	 	<param-name>contextConfigLocation</param-name>
	 	<param-value>classpath:applicationContext.xml</param-value>
 	</context-param>
  	<listener>
 		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
  	</listener>
<---空指针的问题完美解决--->
