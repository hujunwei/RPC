package com.msb;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * Created by IBM on 2020/9/14.
 */
public class ReciveContent {

    public static void main(String[] args) {

        /*
              创建zookeeper对象
         */
        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.93.10:2181", 100000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });

            //2. 从Zookeeper中 获取内容
            //2.1 获取节点
            List<String> list = zooKeeper.getChildren("/demo" , false);

            for(String child :list)
            {
                byte[] result = zooKeeper.getData("/demo/" + child , false , null);
                System.out.println(new String(result));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
