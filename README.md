# Simple_login_system
一个简单的用户登录与认证系统



<u>环境：</u>

**服务器系统：centos7**

**Mysql版本：5.7.28**

**tomcat版本：7.0.96**

**JDK环境：JDK8**



`src`:存储着后端代码

`WebComtentent`:存储着前端代码



## 后端采用Dao、Service、web三层架构

**Dao层**

用来数据处理，主要是对数据库进行操作。

其中封装了一个对数据库的连接的对象SQLManager,存放在`/src/util`文件夹中

设计了一个`UserDao`的类，存放在`/src/Dao`文件夹中，用来对数据库进行增删查改的操作

包括：

- **insert**（在数据库中增加一行）


- **del**（删除数据库中一行记录）

- **emailcorrect**（判断邮箱是否正确）

-  **UserExist**（判断用户名是否已经存在）


还设计了一个用户类`User`,用来定义一个个的操作对象，存放在`/src/entity`文件夹中



**service层：**

主要用来与前端的交互，等一下会详细介绍。主要提供三个API供前端调用:

- ​		change_pass(修改密码)

	 ​		SignIn(进行登陆)
	 ​		SihnUp(进行注册)

**调用完之后会提供反馈给前端，其中的结果编号如下：**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200408211634920.png)



**Web层：**

​	用来存在网页资源，将网页前端的东西部署在Web层，以便能够从浏览器通过互联网进行访问。里面包括html文件、jsp文件、css文件等,即`WebContent`中的内容









