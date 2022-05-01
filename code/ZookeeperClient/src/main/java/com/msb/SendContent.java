package com.msb;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * Created by IBM on 2020/9/14.
 */
public class SendContent {

    public static void main(String[] args) {

        /*
            创建Zookeeper对象
            参数1：zookeeper ip + 端口号
            参数2：访问超时设置
            参数3：当连接成功后，编写成功信息
         */

        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.93.10:2181", 100000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            /*
                 发送内容 向zookeeper 服务器中
                 参数1：发送的文件
                 参数2：发送的内容
                 参数3：权限
                 参数4：内容的模式
             */
            String content = zooKeeper.create("/demo/rmi-address" ,
                    "rmi:localhost:8080/demoService".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);

            System.out.println("content = " + content);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
