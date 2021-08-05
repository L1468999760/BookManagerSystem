# 图书管理系统

> 使用的技术：SpringBoot、SpringMVC、Mybatis、Mysql

### 数据库

sql文件中有两张表（user.sql、book.sql），在自己的电脑上建立，然后修改application.yml配置文件中的数据库名称、用户名、密码。

### 启动

在浏览器上输入localhost:8080/users/login进入登陆界面。

### 说明

这是一个简单的图书管理系统，主要用来熟悉SpringBoot的使用、理解SpringMVC，以及和数据库的连接。

实现的功能有

+ 用户注册
+ 用户登录
+ 图书列表展示
+ 借阅图书
+ 归还图书
+ 添加图书

每次仅允许一个用户登录。

### 页面展示

① 登录页面

localhost:8080/users/login

![](\pic\login.png)

② 图书列表页面

localhost:8080/index

![](\pic\book.png)



本项目参考了牛客网上的一个项目 https://git.nowcoder.com/11000160/BookManager。

