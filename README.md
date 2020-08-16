# Apache ZooKeeper [![Build Status](https://travis-ci.org/apache/zookeeper.svg?branch=master)](https://travis-ci.org/apache/zookeeper) [![Maven Central](https://img.shields.io/maven-central/v/org.apache.zookeeper/zookeeper)](https://zookeeper.apache.org/releases.html) [![License](https://img.shields.io/github/license/apache/zookeeper)](https://github.com/apache/zookeeper/blob/master/LICENSE.txt)
![alt text](https://zookeeper.apache.org/images/zookeeper_small.gif "ZooKeeper")

For the latest information about Apache ZooKeeper, please visit our website at:

   http://zookeeper.apache.org/

and our wiki, at:

   https://cwiki.apache.org/confluence/display/ZOOKEEPER

---------------------------
Packaging/release artifacts

Either downloaded from https://zookeeper.apache.org/releases.html or
found in zookeeper-assembly/target directory after building the project with maven.

    apache-zookeeper-[version].tar.gz

        Contains all the source files which can be built by running:
        mvn clean install

        To generate an aggregated apidocs for zookeeper-server and zookeeper-jute:
        mvn javadoc:aggregate
        (generated files will be at target/site/apidocs)

    apache-zookeeper-[version]-bin.tar.gz

        Contains all the jar files required to run ZooKeeper
        Full documentation can also be found in the docs folder

As of version 3.5.5, the parent, zookeeper and zookeeper-jute artifacts
are deployed to the central repository after the release
is voted on and approved by the Apache ZooKeeper PMC:

  https://repo1.maven.org/maven2/org/apache/zookeeper/zookeeper/

## Java 8

If you are going to compile with Java 1.8, you should use a
recent release at u211 or above.

# Contributing
We always welcome new contributors to the project! See [How to Contribute](https://cwiki.apache.org/confluence/display/ZOOKEEPER/HowToContribute) for details on how to submit patch through pull request and our contribution workflow.

# 源码阅读

## 源码编译运行过程记录:
1. git clone 源码
2. open 到idea的工作空间
3. mvn clean package jute模块,会生成缺少的data,txn等模块的源码,从target目录拷贝到源码目录
4. org.apache.zookeeper.version.util.Vergen生成版本类信息
5. 尝试启动服务类org.apache.zookeeper.server.quorum.QuorumPeerMain
   并且在启动参数中添加配置文件参数,选择模块等
6. 拷贝conf中的日志文件到Server模块的target模块下的classes下,然后启动
   就能看到启动日志了
   
   
## 客户端连接服务端:
1. ZooKeeperMain客户端启动类,可以直接看ZooKeeper类
2. ClientCnxn对象的创建
   命令--Request--Packet--Outgoingqueue
3. start方法得调用

   ClientCnxn对象的创建
      参数的配置
      EventThread的创建
      SendThread的创建(读和写)
    start
      while(){
        1. 如果socket没有连接,就去连接
        2. 如果socker连接成功,客户端就会发送一个ConnectRequest
           接受服务端返回的ConnectResponse(Evemt.none)
        3. 从Outgoingqueue获取Packet,通过Socket发送,
           同时,放到penddingqueue中等待响应结果
      }
## 服务端的处理
1. org.apache.zookeeper.server.quorum.QuorumPeerMain服务端启动类
2. QuorumPeerConfig 配置的解析
3. ZooKeeperServerMain 单机类
4. RequestProcessors 处理启动
5. NIOServerCnxnFactory线程
   PrepRequestProcessor.next = SyncRequestProcesspr.next = 
   FinalRequestProcessor
   client:Request->Packet->Outgoingqueue->socket
   Server:socket->packet->Request->submittedRequests->队列
   firstProcessor.run 从queue取出Request,请求处理器处理这个Request

服务端启动的时候:
    1. 从文件里边取数据加载内存Database
   
事务日志和快照
DataBase
  DateTree
    DateNode
服务端接受请求:
create /no
   1. 创建事务日志
   2. 快照 Database 文件
   3. 更新内存,操作DataTree
   4. 返回错误或者正确信息

