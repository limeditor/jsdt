## Features ##

  1. Javascript 语法着色

> ![http://jsdt.googlecode.com/svn/wiki/resource/picture/color.png](http://jsdt.googlecode.com/svn/wiki/resource/picture/color.png)

> 2. 在eclipse中调试javascript

> ![http://jsdt.googlecode.com/svn/wiki/resource/video/debug.gif](http://jsdt.googlecode.com/svn/wiki/resource/video/debug.gif)

> 3. 查看javascript表达式

> ![http://jsdt.googlecode.com/svn/wiki/resource/video/expression.gif](http://jsdt.googlecode.com/svn/wiki/resource/video/expression.gif)

> 4. 语法错误定位

> ![http://jsdt.googlecode.com/svn/wiki/resource/picture/error.png](http://jsdt.googlecode.com/svn/wiki/resource/picture/error.png)



# JSDT 1.0.2版本发布 #
> JSDT-1.0.2版本增加了Javascript Debug Toolkit 透视图
> 增加在ie和firefox下的错误定位功能
> 增加查看表达式的功能

# 1.	Javascript Debug Toolkit介绍 #
JSDT(Javascript Debug Toolkit)是一个用于javascript调试的eclipse 插件，用于调试javascript。JSDT可以跨浏览器调试，支持在IE,Firefox,Safari,Chrome等主流浏览器中调试javascript。JSDT支持设置断点，单步调试等调试工具的基本特性。
# 2.	如何安装 #
JSDT是基于eclipse3.2+,jdk1.5+基础开发的，因此安装JSDT前应当先安装jdk1.5+和eclipse3.2+。
JSDT下载地址：http://code.google.com/p/jsdt/downloads/list ,其中jsdt-1.0.**.zip是JSDT的安装包，下载把其中的三个jar包解压到eclipse的plugins目录下，重启eclipse即可。
目前版本解决的主要问题是编码，使用了自动探测编码的技术，解决编码问题。
jsdt-simple.swf是一段使用jsdt在chrome浏览器调试javascript的简单例子的录象。
jsdt-ext-desktop.swf是一段使用jsdt在safari浏览器调试javascript的录象。
# 3.如何使用 #
### 1.       在eclipse中打开调试对话框 ###
如下图所示：**

![http://ayound.javaeye.com/upload/attachment/47036/e618be29-d2d8-3c63-88ad-5f2dd8bec3c3.gif](http://ayound.javaeye.com/upload/attachment/47036/e618be29-d2d8-3c63-88ad-5f2dd8bec3c3.gif)
### 2.       新建一个Javascript Debug ###
如下图所示
![http://ayound.javaeye.com/upload/attachment/47038/489f59c8-964d-30f9-931c-27d0e671c15b.gif](http://ayound.javaeye.com/upload/attachment/47038/489f59c8-964d-30f9-931c-27d0e671c15b.gif)
在url中输入要调试的url--本地文件名或服务器上的文件名(只支持http类型的url)。在browser输入框中选择浏览器(ie,firefox,safari或chrome等)

点击调试后会打开浏览器，，eclipse也会转到调试视图，并打开所有用到的javascript文件。

如果没有打开javascript文件，请查看调试透视图中是否打开了Debug Scripts视图

![http://ayound.javaeye.com/upload/attachment/47040/46a80740-9004-3c4f-99e9-6e4cf2b31cc0.jpg](http://ayound.javaeye.com/upload/attachment/47040/46a80740-9004-3c4f-99e9-6e4cf2b31cc0.jpg)
如果没有打开该视图，请点击：window-show view-other->Debug Scripts打开Debug Scripts视图，再选择当前调试堆栈，即可看到Debug Scripts视图，双击Debug Scripts中的文件，即可打开script文件。

![http://ayound.javaeye.com/upload/attachment/47042/a7183053-703e-351c-a89f-38f3af60f47b.jpg](http://ayound.javaeye.com/upload/attachment/47042/a7183053-703e-351c-a89f-38f3af60f47b.jpg)
### 3.       设置断点 ###

在js文件中可以设置断点
![http://ayound.javaeye.com/upload/attachment/47044/84b54b22-337e-3175-ac55-50431c2e31c3.gif](http://ayound.javaeye.com/upload/attachment/47044/84b54b22-337e-3175-ac55-50431c2e31c3.gif)

浏览器中运行到该行js时会自动中断，eclipse也会停止在该断点，等待用户操作。
![http://ayound.javaeye.com/upload/attachment/47046/5211ab5e-f2e6-3471-9e44-4d104c7cb2a9.gif](http://ayound.javaeye.com/upload/attachment/47046/5211ab5e-f2e6-3471-9e44-4d104c7cb2a9.gif)

### 4.       其他操作 ###

因为其他操作和eclipse调试是一样的，这里不再多讲。