package com.msb;

import com.msb.service.MyPersonService;
import com.msb.service.impl.MyPersonServiceImpl;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by IBM on 2020/9/14.
 */
public class ProviderRun {

    public static void main(String[] args) {


        try {
            MyPersonService myPersonService = new MyPersonServiceImpl();
            LocateRegistry.createRegistry(8989);

            String url = "rmi://localhost:8989/myPersonService" ;
            Naming.bind(url ,myPersonService );

            System.out.println("RMI 服务启动成功！");

            // 创建zookeeper 并发布信息
            ZooKeeper zooKeeper = new ZooKeeper("192.168.93.10:2181", 100000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("获取连接");
                }
            });
            zooKeeper.create("/rpc/provider", url.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println("注册成功！");
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
