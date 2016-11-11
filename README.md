#基于springboot+angular2技术和领域驱动设计思想的通用后台管理系统##


###交流群:245130488###


##专注Java技术研究的公众号:javajidi_com##

###目前已完成系统管理功能，并已整合spring-security,spring-session,spring-boot-admin监控。期待前端高手加入完善UI。

##预览

![输入图片说明](http://git.oschina.net/uploads/images/2016/1103/205721_4f3aaaab_20686.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/1103/205706_ab11364c_20686.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/1103/205739_2070e228_20686.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/1103/205756_fc8acce8_20686.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/1103/205810_a24ef95e_20686.png "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/1103/205903_f9cbaba5_20686.png "在这里输入图片标题")


##演示地址
[在线演示](http://bumishi.tech/)

账号密码：root/root，无任何权限限制

###开发阶段运行###

   1.参考angular2文档准备基本运行环境

   2.配置npm淘宝镜像
    ```npm config set registry https://registry.npm.taobao.org```

   3.进入源代码的public目录执行
    ```npm start```

   4.准备数据库环境，mysql脚本在源码的src/main/mysql.sql，修改spring配置文件application.yaml,将其中的数据库连接相关值改成自己机器的值

   5.启动后台应用，IDE中直接运行Application的main方法即可

   6.浏览器打开http://localhost:8080/index.html

   账号root,密码root


###支持前后分离部署，配置nginx代理即可

将public目录映射到nginx根目录，配置反向代理：

```
    root F:\\admin-manage\\src\\main\\resources\\public;
	index  index.html;	
    server {
        listen       80;
        server_name  localhost;

		location = / {    
			
		}  
			
		
		location / {    
			proxy_pass http://localhost:8080; #后台地址   
		}    
            
		location ~ \.(ico|html|js|css|png|gif|jpeg|font|svg|woff|woff2|jpg|\.map)$ {    
			
		}   
   }
```
