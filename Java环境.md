# java-
java开发环境
jdk:java develop kit(java开发包)，Java开发环境，对于开发者。
jre:java runtime environment(java运行环境)，对于java用户。

环境变量
path路径：系统默认识别路径，可以在任何位置操作次路径下的文件。（%JAVA_HOME%\bin；%JAVA_HOME%\jre\bin）

JAVA_HOME:自己添加的环境变量，方便修改jdk环境位置。（F:\jdk7.0）

CLASSPATH:它是javac编译器的一个环境变量。它的作用与import、package关键字有关。Sun让JAVA2的JDK更聪明一些。你会发现，在你安装之后，即使完全没有设定CLASSPATH，你仍然能够编译基本的JAVA程序，并且加以执行。 （.;%JAVA_HOME%lib.dt.jar;%JAVA_HOME%lib.tools.jar;）
