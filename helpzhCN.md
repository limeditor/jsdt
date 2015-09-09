[english](help.md)

Javascript Debug Toolkit(JSDT) 是一款免费绿色免安装的javascript调试工具，JSDT可以在任何支持ajax的浏览器上调试javascript，譬如:
> IE6

> IE7,

> IE8,

> Firefox1.5,

> Firefox2,

> Firefox3,

> Safari,

> Chrome,

> Opera,

> 和一些 mobile browser.
JSDT 可以运行在 windows 和 linux 操作系统上.
JSDT遵守GPL或LGPL开源协议.
## 如何安装和运行? ##
Javascript Debug Toolkit 运行在jre1.5+的环境上，请先安装jre1.5+

Javascript Debug Toolkit 是一款绿色免安装的程序，你只需要下载后解压就可以使用，注意：目录名中不能有中文.


在windows操作系统中请运行bin/jsdt.bat


在linux操作系统中请运行sh ./jsdt.sh命令

## 如何调试javascript? ##
> 下图是JSDT的主界面.
![http://jsdt.googlecode.com/svn/wiki/images/jsdt_zh_CN.png](http://jsdt.googlecode.com/svn/wiki/images/jsdt_zh_CN.png)
**首先**,输入要调试的url,譬如 c:/a.htm or http://localhost/test.jsp.
> > JSDT支持本地html文件和远程基于http协议的URL.


**其次**,输入浏览器的路径,JSDT 支持 IE,Firefox,Safari,Chrome,Opera 等等.

> 请注意：必须输入全路径.


点击开始调试按纽启动调试
**功能介绍**
|功能项|描述|
|:--|:-|
|地址 |本地文件或基于http协议的URL,譬如 c:/test.htm or http://localhost/a.jsp|
|端口 |JSDT调试时使用的端口.|
|浏览器|浏览器的全路径,譬如 C:\Program Files\Internet Explorer\iexplore.exe 或者 /usr/bin/firefox|
|调试面板|提供查看调试栈和执行，单步跳入，单步跳过，单步返回等功能|
|资源面板|显示本次调试用到的资源，你可以从这里打开文件|
|变量面板|显示当前调用栈的变量.|
|断点面板|提供删除，切换断点等功能|
|表达式面板|提供查看表达式的功能.|
> 
> > ## 如何查看表达式? ##

**首先**,激活表达式面板，点击添加表达式按纽.

![http://jsdt.googlecode.com/svn/wiki/images/expression_zh_CN.png](http://jsdt.googlecode.com/svn/wiki/images/expression_zh_CN.png)

**其次**,输入表达式并点击确定按纽,你可以查看当前栈的表达式.

![http://jsdt.googlecode.com/svn/wiki/images/expressionAdd_zh_CN.png](http://jsdt.googlecode.com/svn/wiki/images/expressionAdd_zh_CN.png)

