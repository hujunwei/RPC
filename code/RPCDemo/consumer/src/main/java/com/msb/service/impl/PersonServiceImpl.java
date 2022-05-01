package com.msb.service.impl;

import com.msb.pojo.Person;
import com.msb.service.MyPersonService;
import com.msb.service.PersonService;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.List;

/**
 * Created by IBM on 2020/9/14.
 */
@Service
public class PersonServiceImpl implements PersonService {

    public List<Person> show() {

        try {
            ZooKeeper zooKeeper = new ZooKeeper("192.168.93.10:2181", 100000, new Watcher() {
                public void process(WatchedEvent watchedEvent) {
                    System.out.println("连接成功! ");
                }
            });

            byte[] result = zooKeeper.getData("/rpc/provider", false, null);
            MyPersonService myPersonService = (MyPersonService) Naming.lookup(new String(result));

            return myPersonService.findAll();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        return null ;
    }
}
