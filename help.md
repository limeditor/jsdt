[中文](helpzhCN.md)


Javascript Debug Toolkit(JSDT) is a javascript debug tool. JSDT can
debug javascript in any browser support Ajax, like
> IE6
> IE7,
> IE8,
> Firefox1.5,
> Firefox2,
> Firefox3,
> Safari,
> Chrome,
> Opera,
> and some mobile browser.
JSDT can run in windows and linux OS.
JSDT is available under the LGPL license.


## How to Install and run JSDT? ##

Javascript Debug Toolkit requires JRE1.5+ ,Please install JRE1.5+ first


Javascript Debug Toolkit is a Green-free installation software. You only need to download and extract it.


Please run jsdt.bat in "bin" directory of windows OS(win2000,winXP,Vista...).


Please run "sh ./jsdt.sh" in terminal of linux OS.


## How to Debug Javascript? ##
Let's to with JSDT.
> ![http://jsdt.googlecode.com/svn/wiki/images/jsdt.png](http://jsdt.googlecode.com/svn/wiki/images/jsdt.png)
**First**,enter the url you want to debug,like c:/a.htm or http://localhost/test.jsp.
JSDT supports local file and URL of http protocol.

**Second**,enter the path of your browser,JSDT supports IE,Firefox,Safari,Chrome,Opera and so on.
Please notice that there must be a full path.


Then you can start debug. Please click the start debug button to start your debug

  * Reference of JSDT

|Input or Button|description|
|:--------------|:----------|
|url            |The file or url you want to debug,support local file and URL of http protocal,like c:/test.htm or http://localhost/a.jsp|
|port           |The port of JSDT's server listener when it is started.|
|browser        |The browser's file path,like C:\Program Files\Internet Explorer\iexplore.exe or /usr/bin/firefox|
|Debug Panel    |You can do resume,step into,step over,step return action here and see the stack of js debug.|
|Resources Panel|The resources of current debug like html and js files,you can open the file from here.|
|Variable Panel |Display the varialbe and value of current stack.|
|breakpoints Panel|Breakpoints manager where you can remove or disable breakpoints.|
|expressions Panel|The expression you watch in current stack.|


## How to watch Expression? ##
First,active the expressions Panel and click the add expression button.
> ![http://jsdt.googlecode.com/svn/wiki/images/expression.png](http://jsdt.googlecode.com/svn/wiki/images/expression.png)

Second,enter the expression to the dialog and click the ok button,then you can get the expression of current stack.
> ![http://jsdt.googlecode.com/svn/wiki/images/expressionAdd.png](http://jsdt.googlecode.com/svn/wiki/images/expressionAdd.png)

